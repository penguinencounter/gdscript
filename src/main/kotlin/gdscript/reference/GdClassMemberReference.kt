package gdscript.reference

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.search.GlobalSearchScope
import gdscript.completion.utils.*
import gdscript.index.impl.GdClassNamingIndex
import gdscript.psi.*
import gdscript.psi.utils.*
import gdscript.settings.GdSettingsState
import gdscript.utils.PsiElementUtil.psi

/**
 * RefId reference to ClassNames, Variables, Constants, etc...
 */
class GdClassMemberReference : PsiReferenceBase<GdNamedElement> {

    private var key: String = ""

    constructor(element: PsiElement) : super(element as GdNamedElement, TextRange(0, element.textLength)) {
        key = element.text
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        myElement.setName(newElementName)

        return myElement;
    }

    fun resolveDeclaration(): PsiElement? {
        return GdClassMemberUtil.findDeclaration(element)?.psi()
    }

    override fun resolve(): PsiElement? {
        val direct =
            when (val element = resolveDeclaration()) {
                is GdClassVarDeclTl -> element.classVarIdNmi
                is GdClassDeclTl -> element.classNameNmi
                is GdVarDeclSt -> element.varNmi
                is GdConstDeclSt -> element.varNmi
                is GdConstDeclTl -> element.constIdNmi
                is GdEnumDeclTl -> element.enumDeclNmi
                is GdEnumValue -> element.enumValueNmi
                is GdMethodDeclTl -> element.methodIdNmi
                is GdSignalDeclTl -> element.signalIdNmi
                is GdForSt -> element.varNmi
                is GdParam -> element.varNmi
                is GdVarNmi -> element
                is PsiFile -> element
                else -> null
            }
        if (direct != null) return direct

        return GdClassNamingIndex
            .get(element.text, element.project, GlobalSearchScope.allScope(element.project))
            .firstOrNull()?.containingFile
    }

    override fun getVariants(): Array<LookupElement> {
        val members = GdClassMemberUtil.listDeclarations(element)
        val hidePrivate = GdSettingsState.getInstance().state.hidePrivate
                && GdClassMemberUtil.calledUpon(element) != null

        return members.flatMap {
            GdCompletionUtil.lookups(it).mapNotNull { lookup ->
                if (!hidePrivate || !lookup.lookupString.startsWith("_")) lookup
                else null
            }
        }.toTypedArray()
    }

}
