package gdscript.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.search.GlobalSearchScope
import gdscript.GdIcon
import gdscript.completion.GdLookup
import gdscript.completion.util.GdClassNameCompletionUtil
import gdscript.index.impl.GdClassNamingIndex
import gdscript.psi.GdTypeHintNm
import gdscript.psi.utils.PsiGdClassNamingUtil

class GdTypeHintReference : PsiReferenceBase<GdTypeHintNm> {

    private var key: String = "";

    constructor(element: PsiElement, textRange: TextRange) : super(element as GdTypeHintNm, textRange) {
        key = element.text.substring(textRange.startOffset, textRange.endOffset)
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        myElement.name = newElementName;

        return myElement;
    }

    override fun resolve(): PsiElement? {
        return GdClassNamingIndex
            .get(key, myElement.project, GlobalSearchScope.allScope(myElement.project))
            .firstOrNull()?.classNameNm;
    }

    override fun getVariants(): Array<Any> {
        val project = myElement.project;
        val classNames = PsiGdClassNamingUtil.listClassNaming(project);

        return classNames.mapNotNull {
            if (it.classname !== "") {
                GdClassNameCompletionUtil.toLookup(it);
            } else {
                null
            }
        }.toTypedArray()
    }

}
