package gdscript.refactoring

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiReference
import com.intellij.refactoring.inline.InlineOptionsDialog
import gdscript.completion.utils.GdMethodCompletionUtil.shortMethodHeader
import gdscript.psi.GdMethodDeclTl
import gdscript.psi.GdMethodIdNmi
import gdscript.settings.GdProjectSettingsState

class GdInlineOptionsDialog : InlineOptionsDialog {

    val declaration: GdMethodIdNmi
    val reference: PsiReference?

    constructor(project: Project, declaration: GdMethodIdNmi, reference: PsiReference?) : super(
        project,
        false,
        declaration
    ) {
        this.declaration = declaration
        this.reference = reference
        this.myInvokedOnReference = reference != null
        init()
    }

    override fun doAction() {
        GdProjectSettingsState.getInstance(project).state.inlineKeepDeclaration = isInlineThisOnly
        invokeRefactoring(
            GdInlineMethodProcessor(
                project,
                declaration,
                isInlineThisOnly,
                reference,
                !isInlineThisOnly,
            )
        )
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
        return GdProjectSettingsState.getInstance(project).state.inlineKeepDeclaration
    }

}
