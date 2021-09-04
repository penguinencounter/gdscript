package gdscript.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReferenceBase
import gdscript.completion.util.GdClassVarCompletionUtil
import gdscript.completion.util.GdConstCompletionUtil
import gdscript.psi.GdClassVarDeclTl
import gdscript.psi.GdConstDeclTl
import gdscript.psi.GdNamedElement
import gdscript.psi.utils.PsiGdFileUtil
import gdscript.psi.utils.PsiGdNamedUtil

// TODO Enums, Signals, ...?
// Variables, Constants,
class GdClassMemberReference : PsiReferenceBase<GdNamedElement> {

    private var key: String = "";

    constructor(element: PsiElement, textRange: TextRange) : super(element as GdNamedElement, textRange) {
        key = element.text.substring(textRange.startOffset, textRange.endOffset)
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        myElement.setName(newElementName);

        return myElement;
    }

    override fun resolve(): PsiElement? {
        val element = PsiGdNamedUtil.findInParent(myElement, includingSelf = true);
        return when (element) {
            is GdClassVarDeclTl -> element.classVarIdNmi
            is GdConstDeclTl -> element.constIdNmi
            else -> null
        }
    }

    override fun getVariants(): Array<Any> {
        val files: ArrayList<PsiFile> = ArrayList();
        files.add(myElement.containingFile);
        files.addAll(PsiGdNamedUtil.listParents(myElement).map { it.containingFile });

        val members = files.flatMap { PsiGdFileUtil.listMembers(it) }

        return members.mapNotNull {
            when (it) {
                is GdClassVarDeclTl -> GdClassVarCompletionUtil.lookup(it)
                is GdConstDeclTl -> GdConstCompletionUtil.lookup(it)
                else -> null
            }
        }.toTypedArray();
    }

}