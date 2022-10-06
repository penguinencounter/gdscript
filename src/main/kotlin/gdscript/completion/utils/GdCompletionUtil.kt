package gdscript.completion.utils

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiJavaPatterns.psiElement
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiWhiteSpace
import gdscript.GdIcon
import gdscript.completion.GdLookup
import gdscript.psi.*
import gdscript.utils.StringUtils.parseFromSquare

object GdCompletionUtil {

    val WHITE_OR_ERROR = PlatformPatterns.or(
        psiElement(PsiErrorElement::class.java),
        psiElement(PsiWhiteSpace::class.java),
        psiElement(PsiComment::class.java)
    );

    fun lookups(element: PsiElement): Array<LookupElement> {
        return when (element) {
            is GdClassNaming -> arrayOf(lookup(element));
            is GdClassVarDeclTl -> arrayOf(lookup(element));
            is GdVarDeclSt -> arrayOf(lookup(element));
            is GdConstDeclTl -> arrayOf(lookup(element));
            is GdConstDeclSt -> arrayOf(lookup(element));
            is GdEnumDeclTl -> lookup(element);
            is GdMethodDeclTl -> arrayOf(lookup(element));
            is GdForSt -> arrayOf(lookup(element));
            is GdParam -> arrayOf(lookup(element));
            is GdSetDecl -> arrayOf(lookup(element));
            else -> emptyArray();
        }
    }

    fun lookup(className: GdClassNaming): LookupElement =
        GdLookup.create(
            className.classname,
            priority = GdLookup.USER_DEFINED,
            icon = GdIcon.getEditorIcon(className.classname),
        )

    fun lookup(variable: GdClassVarDeclTl): LookupElement =
        GdLookup.create(
            variable.name.orEmpty(),
            icon = GdIcon.getEditorIcon(GdIcon.VAR_MARKER),
            typed = variable.returnType,
            priority = GdLookup.USER_DEFINED,
        )

    fun lookup(variable: GdVarDeclSt): LookupElement =
        GdLookup.create(
            variable.name,
            icon = GdIcon.getEditorIcon(GdIcon.VAR_MARKER),
            typed = variable.returnType,
            priority = GdLookup.LOCAL_USER_DEFINED,
        )

    fun lookup(constant: GdConstDeclTl): LookupElement =
        GdLookup.create(
            constant.constName.orEmpty(),
            icon = GdIcon.getEditorIcon(GdIcon.CONST_MARKER),
            typed = constant.returnType,
            priority = GdLookup.USER_DEFINED,
        )

    fun lookup(constant: GdConstDeclSt): LookupElement =
        GdLookup.create(
            constant.name,
            icon = GdIcon.getEditorIcon(GdIcon.CONST_MARKER),
            typed = constant.returnType,
            priority = GdLookup.LOCAL_USER_DEFINED,
        )

    fun lookup(enum: GdEnumDeclTl): Array<LookupElement> {
        val name = enum.enumDeclNmi;

        return if (name != null) {
            arrayOf(GdEnumCompletionUtil.createElement(name.name));
        } else {
            enum.values.map {
                GdEnumCompletionUtil.createElement(it.key, it.value)
            }.toTypedArray();
        }
    }

    fun lookup(method: GdMethodDeclTl): LookupElement =
        GdLookup.create(
            method.name.orEmpty(),
            lookup = "()${if (method.paramList?.paramList?.isNotEmpty() == true) "_" else ""}",
            presentable = method.name.orEmpty(),
            typed = method.returnType,
            icon = GdIcon.getEditorIcon(GdIcon.METHOD_MARKER),
            priority = GdLookup.USER_DEFINED,
        )

    fun lookup(loop: GdForSt): LookupElement =
        GdLookup.create(
            loop.varNmi.name,
            icon = GdIcon.getEditorIcon(GdIcon.VAR_MARKER),
            typed = loop.expr?.returnType?.parseFromSquare() ?: "",
            priority = GdLookup.LOCAL_USER_DEFINED,
        )

    fun lookup(param: GdParam): LookupElement =
        GdLookup.create(
            param.varNmi.name,
            typed = param.returnType,
            icon = GdIcon.getEditorIcon(GdIcon.VAR_MARKER),
            priority = GdLookup.LOCAL_USER_DEFINED,
        )

    fun lookup(decl: GdSetDecl): LookupElement =
        GdLookup.create(
            decl.varNmi?.name ?: "",
            typed = decl.typed?.text ?: "",
            icon = GdIcon.getEditorIcon(GdIcon.VAR_MARKER),
            priority = GdLookup.LOCAL_USER_DEFINED,
        )

}