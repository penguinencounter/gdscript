package gdscript.codeInsight

import com.intellij.codeInsight.hints.HintInfo
import com.intellij.codeInsight.hints.HintInfo.MethodInfo
import com.intellij.codeInsight.hints.InlayInfo
import com.intellij.codeInsight.hints.InlayParameterHintsProvider
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.refactoring.suggested.startOffset
import com.intellij.util.containers.toArray
import gdscript.psi.*
import gdscript.psi.utils.PsiGdSignalUtil
import gdscript.reference.GdClassMemberReference

class GdInlayParameterHintProvider : InlayParameterHintsProvider {

    override fun getHintInfo(element: PsiElement): HintInfo? {
        if (element !is GdCallEx) return null

        val id = PsiTreeUtil.findChildOfType(element, GdRefIdNm::class.java) ?: return null
        val declaration = GdClassMemberReference(id).resolveDeclaration() ?: return null

        if (declaration is GdMethodDeclTl) {
            val name = declaration.name
            if (name == "emit") {
                val signal = PsiGdSignalUtil.getDeclaration(element)
                if (signal != null) {
                    return MethodInfo(name, signal.parameters.keys.toList())
                }
            }

            return MethodInfo(name, declaration.parameters.keys.toList());
        } else if (declaration is GdVarDeclSt && declaration.expr is GdFuncDeclEx) {
            val lambda = declaration.expr as GdFuncDeclEx;
            return MethodInfo(lambda.funcDeclIdNmi?.text.orEmpty(), lambda.parameters.keys.toList())
        }

        return null
    }

    override fun getParameterHints(element: PsiElement): List<InlayInfo> {
        if (element !is GdCallEx) return emptyList()

        val id = PsiTreeUtil.findChildOfType(element, GdRefIdNm::class.java) ?: return emptyList();
        val method = GdClassMemberReference(id).resolveDeclaration()

        var params: Array<String> = emptyArray();
        when (method) {
            is GdMethodDeclTl -> {
                params = method.parameters.keys.toArray(emptyArray());

                if (method.name == "emit") {
                    val signal = PsiGdSignalUtil.getDeclaration(element);
                    if (signal != null) {
                        params = signal.parameters.keys.toArray(emptyArray());
                    }
                }
            }
            is GdVarDeclSt -> {
                if (method.expr is GdFuncDeclEx) {
                    val lambda = method.expr as GdFuncDeclEx;
                    params = lambda.parameters.keys.toArray(emptyArray())
                } else {
                    return emptyList();
                }
            }
            else -> {
                val file = GdClassMemberReference(id).resolve()
                if (file !is GdFile) {
                    return emptyList()
                }

                val methods = PsiTreeUtil.getStubChildrenOfTypeAsList(file, GdMethodDeclTl::class.java)
                val usedParams = element.argList?.argExprList

                for (hint in methods) {
                    if (!hint.isConstructor) continue
                    val hints = hint.paramList?.paramList
                    if (hints == null || usedParams == null || hints.size != usedParams.size) continue
                    var ok = true;
                    for (i in 0 until hints.size) {
                        val t1 = usedParams[i].expr.returnType
                        val t2 = hints[i].returnType
                        ok = ok && (t1.isBlank() || t2.isBlank() || t1 == t2);
                    }

                    if (ok) {
                        params = hints.map { it.varNmi.name }.toTypedArray();
                        break
                    }
                }
            }
        }
        if (params.isEmpty()) return emptyList()

        val args = element.argList?.argExprList
        return params.mapIndexedNotNull { i, it ->
            val param = args?.get(i) ?: return@mapIndexedNotNull null
            InlayInfo(
                it,
                param.startOffset,
                false,
            )
        }
    }

    override fun canShowHintsWhenDisabled(): Boolean {
        return true
    }

    override fun getDefaultBlackList(): MutableSet<String> {
        return mutableSetOf();
    }

}
