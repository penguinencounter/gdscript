package gdscript.refactoring

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.refactoring.BaseRefactoringProcessor
import com.intellij.usageView.UsageInfo
import com.intellij.usageView.UsageViewDescriptor

class GdInlineMethodProcessor : BaseRefactoringProcessor {

    constructor(project: Project) : super(project)

    override fun createUsageViewDescriptor(usages: Array<out UsageInfo>): UsageViewDescriptor {
        return object : UsageViewDescriptor {
            override fun getElements(): Array<PsiElement> {
                return arrayOf()
            }

            override fun getProcessedElementsHeader(): String {
                return "ele head"
            }

            override fun getCodeReferencesText(usagesCount: Int, filesCount: Int): String {
                return "code ref"
            }
        }
    }

    override fun findUsages(): Array<UsageInfo> {
        return arrayOf()
    }

    override fun performRefactoring(usages: Array<out UsageInfo>) {
    }

    override fun getCommandName(): String {
        return "GdScript Inline Method"
    }

}
