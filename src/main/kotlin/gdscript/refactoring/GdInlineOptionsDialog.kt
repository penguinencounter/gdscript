package gdscript.refactoring

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiReference
import com.intellij.refactoring.inline.InlineOptionsDialog
import gdscript.completion.utils.GdMethodCompletionUtil.shortMethodHeader
import gdscript.psi.GdMethodDeclTl
import gdscript.psi.GdMethodIdNmi

class GdInlineOptionsDialog : InlineOptionsDialog {

    val declaration: GdMethodIdNmi
    val reference: PsiReference?

    constructor(project: Project, declaration: GdMethodIdNmi, reference: PsiReference?) : super(project, false, declaration) {
        this.declaration = declaration
        this.reference = reference
        this.myInvokedOnReference = reference != null
        init()
    }

    override fun doAction() {
        val asd = 0
    }

    override fun getNameLabelText(): String {
        return "func ${(declaration.parent as GdMethodDeclTl).shortMethodHeader()}"
    }

    override fun getBorderTitle(): String {
        return "Inline Method"
    }

    override fun getInlineAllText(): String {
        return "All references and remove method"
    }

    override fun getInlineThisText(): String {
        return "This one and keep the method"
    }

    override fun isInlineThis(): Boolean {
        return false
    }

    // TODO settings - uložit výběr, který byl při akci

    override fun isKeepTheDeclarationByDefault(): Boolean {
        return super.isKeepTheDeclarationByDefault()
    }

}
