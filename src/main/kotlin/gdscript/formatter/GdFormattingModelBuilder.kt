package gdscript.formatter

import com.intellij.formatting.*
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.tree.TokenSet
import gdscript.GdFileType
import gdscript.GdLanguage
import gdscript.formatter.block.GdBlock
import gdscript.psi.GdFile
import gdscript.psi.GdTypes

class GdFormattingModelBuilder : FormattingModelBuilder {

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val settings = formattingContext.codeStyleSettings;
        // TODO tohle je pro bloky
        val customSettings = settings.getCustomSettings(GdCodeStyleSettings::class.java);

        return FormattingModelProvider
            .createFormattingModelForPsiFile(formattingContext.containingFile,
                GdBlock(formattingContext.node,
                    Wrap.createWrap(WrapType.NONE, false),
                    Alignment.createAlignment(),
                    customSettings,
                    createSpaceBuilder(settings)
                ),
                settings)
    }

    private fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder {
        val custom = settings.getCustomSettings(GdCodeStyleSettings::class.java);
        INDENT_SIZE = settings.getIndentSize(GdFileType);

        // TODO grouping
        return SpacingBuilder(settings, GdLanguage)
            /** Root lines */
            .before(NAMINGS).spacing(0, 0, 1, false, 0)
            .before(TokenSet.create(GdTypes.INHERITANCE_ID_NM, GdTypes.CLASS_NAME_NMI)).spaces(1)
            .beforeInside(GdTypes.DEDENT, GdTypes.SUITE).spacing(0, Int.MAX_VALUE, 1, false, 0)
            .between(NAMINGS, ROOTS).spacing(0, 0, 1, false, 1)

            .between(GdTypes.ENUM_DECL_TL, GdTypes.ENUM_DECL_TL).spacing(0, Int.MAX_VALUE, 1, false, 0)
            .between(GdTypes.CONST_DECL_TL, GdTypes.CONST_DECL_TL).spacing(0, Int.MAX_VALUE, 1, false, 0)
            .between(GdTypes.CLASS_VAR_DECL_TL, GdTypes.CLASS_VAR_DECL_TL).spacing(0, Int.MAX_VALUE, 1, false, 1)
            .between(GdTypes.CONST_DECL_TL, GdTypes.CLASS_VAR_DECL_TL).spacing(0, Int.MAX_VALUE, 2, false, 1)
            .between(GdTypes.CONST_DECL_TL, GdTypes.ENUM_DECL_TL).spacing(0, Int.MAX_VALUE, 2, false, 1)
            .between(GdTypes.CLASS_VAR_DECL_TL, GdTypes.CONST_DECL_TL).spacing(0, Int.MAX_VALUE, 2, false, 1)
            .between(GdTypes.CLASS_VAR_DECL_TL, GdTypes.ENUM_DECL_TL).spacing(0, Int.MAX_VALUE, 2, false, 1)
            .between(GdTypes.ENUM_DECL_TL, GdTypes.CONST_DECL_TL).spacing(0, Int.MAX_VALUE, 2, false, 1)
            .between(GdTypes.ENUM_DECL_TL, GdTypes.CLASS_VAR_DECL_TL).spacing(0, Int.MAX_VALUE, 2, false, 1)

            .before(GdTypes.METHOD_DECL_TL).spacing(0, Int.MAX_VALUE, custom.LINES_BEFORE_FUNC + 1, false, custom.LINES_BEFORE_FUNC)

            /** Operators */
//            .around(TokenSet.create(GdTypes.TEST_OPERATOR, GdTypes.ASSIGN, GdTypes.EQ, GdTypes.ASSIGN_TYPED)).spacing(1, Int.MAX_VALUE, 0, false, 1)
    }

    companion object {
        val NAMINGS = TokenSet.create(GdTypes.INHERITANCE, GdTypes.CLASS_NAMING)
        val ROOTS = TokenSet.create(GdTypes.CONST_DECL_TL, GdTypes.CLASS_VAR_DECL_TL)
        var INDENT_SIZE = 4;
    }

}
