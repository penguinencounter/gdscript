package gdscript.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.search.GlobalSearchScope
import gdscript.completion.util.GdClassNameCompletionUtil
import gdscript.index.impl.GdClassNamingIndex
import gdscript.psi.GdNamedElement
import gdscript.psi.GdTypeHintNm
import gdscript.psi.utils.PsiGdClassUtil
import org.jetbrains.annotations.NotNull

class GdTypeHintReference : PsiReferenceBase<GdNamedElement> {

    private var key: String = "";

    constructor(element: PsiElement, textRange: TextRange) : super(element as GdNamedElement, textRange) {
        key = element.text.substring(textRange.startOffset, textRange.endOffset)
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        myElement.setName(newElementName);

        return myElement;
    }

    override fun resolve(): PsiElement? {
        return GdClassNamingIndex
            .get(key, myElement.project, GlobalSearchScope.allScope(myElement.project))
            .firstOrNull()?.classNameNm;
    }

    override fun getVariants(): Array<Any> {
        val project = myElement.project;
        val classNames = PsiGdClassUtil.listClassNaming(project);

        return classNames.mapNotNull {
            if (it.classname !== "") {
                GdClassNameCompletionUtil.toLookup(it);
            } else {
                null
            }
        }.toTypedArray()
    }

}
