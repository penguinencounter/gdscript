package gdscript.refactoring

import com.intellij.lang.refactoring.InlineHandler
import com.intellij.lang.refactoring.InlineHandler.Inliner
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.TokenType
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.psi.util.prevLeaf
import com.intellij.refactoring.util.CommonRefactoringUtil
import com.intellij.usageView.UsageInfo
import com.intellij.util.containers.MultiMap
import gdscript.GdKeywords
import gdscript.psi.*
import gdscript.utils.PsiElementUtil.getEditor

class GdInlineHandler : InlineHandler {

    override fun prepareInlineElement(
        element: PsiElement,
        editor: Editor?,
        invokedOnReference: Boolean
    ): InlineHandler.Settings? {
        return null
    }

    override fun removeDefinition(element: PsiElement, settings: InlineHandler.Settings) {
        element.delete()
    }

    override fun createInliner(element: PsiElement, settings: InlineHandler.Settings): Inliner? {
        return object : Inliner {
            override fun getConflicts(reference: PsiReference, referenced: PsiElement): MultiMap<PsiElement, String>? {
                return null
            }

            override fun inlineUsage(usage: UsageInfo, referenced: PsiElement) {
                val ref = usage.element ?: return
                val callRef = PsiTreeUtil.getParentOfType(ref, GdCallEx::class.java) ?: return
                if (referenced !is GdMethodDeclTl || referenced.stmtOrSuite == null) return
                val content = referenced.stmtOrSuite ?: return

                val returns = PsiTreeUtil.findChildrenOfType(content, GdFlowSt::class.java)
                    .filter { it.type == GdKeywords.FLOW_RETURN }

                if (returns.size > 1) return tooManyReturns(ref)
                replaceParams(referenced, callRef)

                var before: PsiElement = PsiTreeUtil.getParentOfType(callRef, GdStmt::class.java) ?: return
//                before = before.prevLeaf { it.elementType == TokenType.WHITE_SPACE && it.text == "\n" } ?: return

                var indent = before.prevLeaf { it.elementType == TokenType.WHITE_SPACE }
                if (indent?.text == "\n") indent = null

                if (content.stmt != null) {
                    addStmt(content.stmt!!, indent, before)
                } else {
                    content.suiteList.forEach { suite ->
                        suite.stmtList.forEach { stmt ->
                            addStmt(stmt, indent, before)
                        }
                    }
                }

                if (returns.isNotEmpty()) {
                    val expr = returns[0].expr
                    if (expr != null) {
                        if (callRef.parent is GdExprSt) {
                            callRef.parent.replace(GdElementFactory.varStmt(element.project, referenced.name, expr))
                        } else {
                            callRef.replace(expr)
                        }
                    } else {
                        callRef.delete()
                    }
                } else {
                    callRef.delete()
                }
            }

            private fun tooManyReturns(element: PsiElement) {
                val editor = element.getEditor() ?: return
                CommonRefactoringUtil.showErrorHint(
                    element.project,
                    editor,
                    "Cannot inline method with multi return statements",
                    GdInlineActionHandler.NAME,
                    null,
                )
            }

            private fun replaceParams(declaration: GdMethodDeclTl, usage: GdCallEx) {
                val toReplace = hashMapOf<Int, PsiElement>()
                usage.argList?.argExprList?.forEachIndexed { i, it ->
                    if (it.expr is GdLiteralEx) {
                        toReplace[i] = it.expr
                    }
                }

                if (toReplace.isEmpty()) return
                val params = declaration.paramList?.paramList ?: return
                toReplace.forEach {
                    val declaredParam = params[it.key] ?: return@forEach
                    ReferencesSearch.search(declaredParam.varNmi).forEach { ref ->
                        ref.element.parent.replace(it.value)
                    }
                }
            }

            private fun addStmt(stmt: GdStmt, indent: PsiElement?, before: PsiElement) {
                if (stmt is GdFlowSt && stmt.type == GdKeywords.FLOW_RETURN) return
//                if (indent != null) stmt.addBefore(indent, stmt.firstChild)
                before.parent?.addBefore(stmt, before)
            }
        }
    }

}
