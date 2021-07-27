package gdscript.psi

import com.intellij.psi.PsiElement
import gdscript.psi.impl.*
import gdscript.psi.utils.PsiGdConstDeclUtil
import gdscript.psi.utils.PsiGdInheritanceUtil

object GdPsiUtils {

    /** ClassName  */
    @JvmStatic
    fun getName(element: GdClassNameNm?): String? {
        return GdPsiClassNameUtil.getName(element)
    }
    @JvmStatic
    fun setName(element: GdClassNameNm?, newName: String?): PsiElement? {
        return GdPsiClassNameUtil.setName(element, newName)
    }

    @JvmStatic
    fun getInheritanceName(element: GdInheritance?): String? {
        return GdPsiClassNameUtil.getInheritanceName(element)
    }

    @JvmStatic
    fun getClassname(element: GdClassNamingImpl?): String {
        return GdClassNamingElementType.getClassname(element);
    }

    /** Inheritance  */
    @JvmStatic
    fun getName(element: GdInheritanceIdNmi): String {
        return PsiGdInheritanceUtil.getName(element)
    }
    @JvmStatic
    fun setName(element: GdInheritanceIdNmi, newName: String?): PsiElement {
        return PsiGdInheritanceUtil.setName(element, newName)
    }
    @JvmStatic
    fun getNameIdentifier(element: GdInheritanceIdNmi): PsiElement? {
        return PsiGdInheritanceUtil.getNameIdentifier(element)
    }

    /** Const   */
    @JvmStatic
    fun getName(element: GdConstIdNmiImpl): String {
        return PsiGdConstDeclUtil.getName(element)
    }
    @JvmStatic
    fun setName(element: GdConstIdNmiImpl, newName: String?): PsiElement {
        return PsiGdConstDeclUtil.setName(element, newName)
    }
    @JvmStatic
    fun getNameIdentifier(element: GdConstIdNmiImpl): PsiElement? {
        return PsiGdConstDeclUtil.getNameIdentifier(element)
    }

    /** Method  */
//    @JvmStatic
//    fun getMethodName(element: GdMethodDeclTl?): String? {
//        return GdPsiMethodUtil.getMethodName(element)
//    }

}
