package gdscript.formatter

import com.intellij.formatting.*
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.tree.TokenSet
import gdscript.GdFileType
import gdscript.GdLanguage
import gdscript.formatter.block.Alignments
import gdscript.formatter.block.GdBlock
import gdscript.formatter.settings.GdSpacingUtil.forcedLines
import gdscript.psi.GdTypes

class GdFormattingModelBuilder : FormattingModelBuilder {

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val settings = formattingContext.codeStyleSettings;
        val customSettings = settings.getCustomSettings(GdCodeStyleSettings::class.java);
        val initialBlock = GdBlock(
            formattingContext.node,
            Wrap.createWrap(WrapType.NONE, false),
            Alignment.createAlignment(),
            customSettings,
            createSpaceBuilder(settings),
            Indent.getNoneIndent(),
            Alignments(customSettings),
        )

        return FormattingModelProvider
            .createFormattingModelForPsiFile(
                formattingContext.containingFile,
                initialBlock,
                settings
            )
    }

    private fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder {
        val custom = settings.getCustomSettings(GdCodeStyleSettings::class.java);
        INDENT_SIZE =
            settings.getIndentSize(GdFileType); // TODO u tabů se to posere, když je za stmt volné odsazení tak se převede na mezery a konec

        val builder = SpacingBuilder(settings, GdLanguage)
            /* Spacings */
            .before(GdTypes.COMMA).spaceIf(custom.SPACE_BEFORE_COMMA)
            .after(GdTypes.COMMA).spaceIf(custom.SPACE_AFTER_COMMA)
            .before(GdTypes.COLON).spaceIf(custom.SPACE_BEFORE_COLON)
            .before(GdTypes.TYPED).spaceIf(custom.SPACE_BEFORE_COLON)
            .after(GdTypes.COLON).spaceIf(custom.SPACE_AFTER_COLON)
            .after(GdTypes.ANNOTATION_TL).spaces(1)

            /* Extends & ClassName */
            .before(NAMINGS).forcedLines(0)
            .after(NAMINGS).forcedLines(custom.LINES_AFTER_HEADER)

            /* Method & Classes */
            .between(GdTypes.ANNOTATION_TL, GdTypes.CLASS_VAR_DECL_TL).forcedLines(0, 1)
            .between(GdTypes.CLASS_VAR_DECL_TL, GdTypes.ANNOTATION_TL)
            .forcedLines(custom.LINES_IN_BETWEEN_VARIABLE_GROUP)

//            .between(GdTypes.COMMENT, ROOT_BLOCKS).forcedLines(0) // TODO
            .before(ROOT_BLOCKS).forcedLines(custom.LINES_BEFORE_FUNC)

        // Separate groups
        ROOT_VARIABLES.types.forEachIndexed { iLeft, left ->
            ROOT_VARIABLES.types.forEachIndexed { iRight, right ->
                if (iLeft != iRight) {
                    builder.between(left, right).forcedLines(custom.LINES_AFTER_VARIABLE_GROUP)
                }
            }
//            builder.between(left, GdTypes.COMMENT).forcedLines(custom.LINES_AFTER_VARIABLE_GROUP) // TODO
        }

        // Then within group
        builder.between(ROOT_VARIABLES, ROOT_VARIABLES).forcedLines(custom.LINES_IN_BETWEEN_VARIABLE_GROUP)

//        builder.after(ROOT_VARIABLES).forcedLines(custom.LINES_AFTER_VARIABLE_GROUP);

        // operators
        builder.around(TokenSet.create(GdTypes.TEST_OPERATOR, GdTypes.ASSIGN, GdTypes.EQ, GdTypes.ASSIGN_TYPED))
            .spaces(1)

        return builder;
    }

    companion object {
        val NAMINGS = TokenSet.create(GdTypes.INHERITANCE, GdTypes.CLASS_NAMING)
        val ROOT_VARIABLES = TokenSet.create(
            GdTypes.CONST_DECL_TL,
            GdTypes.CLASS_VAR_DECL_TL,
            GdTypes.SIGNAL_DECL_TL,
            GdTypes.ANNOTATION_TL,
            GdTypes.ENUM_DECL_TL,
        )
        val ROOT_BLOCKS = TokenSet.create(GdTypes.METHOD_DECL_TL, GdTypes.CLASS_DECL_TL)
        var INDENT_SIZE = 4;
    }

}
