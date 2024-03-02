package gdscript.refactoring

import ai.grazie.utils.toDistinctTypedArray
import com.intellij.lang.Language
import com.intellij.lang.refactoring.InlineHandler.Inliner
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.refactoring.BaseRefactoringProcessor
import com.intellij.refactoring.inline.GenericInlineHandler
import com.intellij.usageView.UsageInfo
import com.intellij.usageView.UsageViewBundle
import com.intellij.usageView.UsageViewDescriptor
import com.intellij.util.containers.MultiMap
import gdscript.GdLanguage
import gdscript.psi.GdMethodDeclTl
import gdscript.psi.GdMethodIdNmi

class GdInlineMethodProcessor : BaseRefactoringProcessor {

    private val declaration: GdMethodIdNmi
    private val inlineThisOnly: Boolean
    private val reference: PsiReference?
    private val deleteAfter: Boolean
    private lateinit var inliners: Map<Language, Inliner>

    constructor(
        project: Project,
        declaration: GdMethodIdNmi,
        inlineThisOnly: Boolean,
        reference: PsiReference?,
        deleteAfter: Boolean,
    ) : super(project) {
        this.declaration = declaration
        this.inlineThisOnly = inlineThisOnly
        this.reference = reference
        this.deleteAfter = deleteAfter
    }

    override fun createUsageViewDescriptor(usages: Array<out UsageInfo>): UsageViewDescriptor {
        return object : UsageViewDescriptor {
            override fun getElements(): Array<PsiElement> {
                return arrayOf(declaration.parent)
            }

            override fun getProcessedElementsHeader(): String {
                return "Method"
            }

            override fun getCodeReferencesText(usagesCount: Int, filesCount: Int): String {
                return UsageViewBundle.getReferencesString(usagesCount, filesCount)
            }
        }
    }

    override fun findUsages(): Array<UsageInfo> {
        if (inlineThisOnly && reference != null) return arrayOf(UsageInfo(reference))

        return ReferencesSearch
            .search(declaration, myRefactoringScope)
            .map { UsageInfo(it) }
            .toDistinctTypedArray()
    }

    override fun preprocessUsages(refUsages: Ref<Array<UsageInfo>>): Boolean {
        inliners = GenericInlineHandler.initInliners(
            declaration.parent,
            refUsages.get(),
            { inlineThisOnly },
            MultiMap.create(),
            GdLanguage,
        )

        return super.preprocessUsages(refUsages)
    }

    override fun performRefactoring(usages: Array<out UsageInfo>) {
        usages.forEach {
            GenericInlineHandler.inlineReference(it, declaration.parent, inliners)
        }

        postActions()
    }

    override fun getCommandName(): String {
        return "GdScript Inline Method"
    }

    override fun getElementsToWrite(descriptor: UsageViewDescriptor): Collection<PsiElement> {
        return when {
            inlineThisOnly -> listOfNotNull(reference?.element)
            declaration.isWritable -> listOfNotNull(reference?.element, declaration)
            else -> emptyList()
        }
    }

    private fun postActions() {
        if (deleteAfter) {
            this.declaration.parent.delete()
        }
    }

}
