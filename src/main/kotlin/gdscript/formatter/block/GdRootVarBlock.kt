package gdscript.formatter.block

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.common.AbstractBlock
import gdscript.formatter.GdCodeStyleSettings

class GdRootVarBlock : GdAbstractBlock {

    constructor(node: ASTNode, wrap: Wrap, alignment: Alignment, settings: GdCodeStyleSettings, spacing: SpacingBuilder) :
            super(node, wrap, alignment, settings, spacing);

    override fun isLeaf(): Boolean = true;

    override fun buildChildren(): MutableList<Block> = ArrayList();

}
