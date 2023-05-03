package gdscript.psi.utils

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import gdscript.GdKeywords
import gdscript.psi.*
import gdscript.utils.GdOperand

/**
 * Shared utils among Named and other elements
 */
object GdCommonUtil {

    fun getName(element: GdNamedElement): String {
        return element.text;
    }

    fun getNameIdentifier(element: GdNamedIdElement): PsiElement {
        return element.firstChild
    }

    fun setName(element: PsiNamedElement, newName: String): PsiElement {
        val keyNode = element.node.firstChildNode
        if (keyNode != null) {
            val id = when(element) {
                is GdClassNameNmi -> GdElementFactory.classNameNmi(element.project, newName)
                is GdEnumDeclNmi -> GdElementFactory.enumDeclNmi(element.project, newName)
                is GdEnumValueNmi -> GdElementFactory.enumValueNmi(element.project, newName)
                is GdFuncDeclIdNmi -> GdElementFactory.funcDeclIdNmi(element.project, newName)
                is GdGetMethodIdNm -> GdElementFactory.getMethodIdNm(element.project, newName)
                is GdInheritanceIdNm -> GdElementFactory.inheritanceIdNm(element.project, newName)
                is GdInheritanceSubIdNm -> GdElementFactory.inheritanceSubIdNm(element.project, newName)
                is GdMethodIdNmi -> GdElementFactory.methodIdNmi(element.project, newName)
                is GdRefIdNm -> GdElementFactory.refIdNm(element.project, newName)
                is GdSetMethodIdNm -> GdElementFactory.setMethodIdNm(element.project, newName)
                is GdSignalIdNmi -> GdElementFactory.signalIdNmi(element.project, newName)
                is GdTypeHintNm -> GdElementFactory.typeHintNm(element.project, newName)
                is GdVarNmi -> GdElementFactory.varNmi(element.project, newName)
                else -> return element
            }
            element.node.replaceChild(keyNode, id.node)
        }

        return element
    }

    fun returnType(element: PsiElement?): String {
        return when(element) {
            is GdConstDeclTl -> element.returnType
            is GdClassVarDeclTl -> element.returnType
            is GdMethodDeclTl -> element.returnType
            is GdParam -> element.returnType
            is GdArgExpr -> element.returnType
            is GdVarDeclSt -> element.returnType
            is GdConstDeclSt -> element.returnType
            is GdExpr -> element.returnType
            is GdTypedVal -> element.returnType
            is GdForSt -> GdOperand.getReturnType(element.expr?.returnType ?: "", GdKeywords.INT, "[]")
            else -> ""
        }
    }

    fun typed(element: PsiElement?): GdTyped? {
        return when(element) {
            is GdConstDeclTl -> element.typed
            is GdClassVarDeclTl -> element.typed
            is GdSetDecl -> element.typed
            is GdParam -> element.typed
            is GdVarDeclSt -> element.typed
            is GdConstDeclSt -> element.typed
            else -> null
        }
    }

}
