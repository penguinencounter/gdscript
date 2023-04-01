package gdscript.formatter.block

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.common.AbstractBlock
import com.intellij.psi.impl.source.tree.FileElement
import com.intellij.psi.util.PsiEditorUtil
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.refactoring.suggested.endOffset
import com.jetbrains.rd.util.forEachReversed
import gdscript.psi.GdElifSt
import gdscript.psi.GdElseSt
import gdscript.psi.GdForSt
import gdscript.psi.GdIfSt
import gdscript.psi.GdTopLevelDecl
import gdscript.psi.GdTypes
import gdscript.psi.GdWhileSt
import gdscript.utils.GdSettingsUtil.calculateSpaceIndents
import gdscript.utils.GdSettingsUtil.indentToSpaces
import gdscript.utils.PsiElementUtil.getCaretOffsetIfSingle
import gdscript.utils.PsiElementUtil.nextNonWhiteCommentToken
import gdscript.utils.PsiElementUtil.precedingNewLines

class GdBlock : AbstractBlock {

    val settings: CodeStyleSettings
    val myIndent: Indent
    val spacing: SpacingBuilder
    val alignments: Alignments
    var nextBlock: GdBlock? = null

    constructor(
        node: ASTNode,
        wrap: Wrap,
        alignment: Alignment?,
        settings: CodeStyleSettings,
        spacing: SpacingBuilder,
        indent: Indent,
        alignments: Alignments,
    ) : super(node, wrap, alignment) {
        this.settings = settings;
        this.spacing = spacing;
        this.myIndent = indent;
        this.alignments = alignments;
    }

    override fun buildChildren(): MutableList<Block> {
        val blocks = mutableListOf<Block>()
        val children: MutableList<ASTNode> = node.getChildren(null).toMutableList()

        var suited = false
        var indented = false
        var lastBlock: GdBlock? = null
        while (!children.isEmpty()) {
            val child = children.removeFirstOrNull()!!
            val type = child.elementType
            if (suited) {
                alignments.reset(type)
            }

            // Due to elif & else being siblings and not children
            if (GdBlocks.DEDENT_TOKENS.contains(type)) indented = false

            if (GdBlocks.EMPTY_TOKENS.contains(type)) {
                if (type == GdTypes.INDENT) {
                    indented = true
                }
            } else if (GdBlocks.SKIP_TOKENS.contains(type)) {
                if (type == GdTypes.SUITE) {
                    suited = true
                    alignments.initialize()
                }

                child.getChildren(null).forEachReversed { children.add(0, it) }
            } else {
                var toIndent = indented || GdBlocks.ALWAYS_INDENTED_TOKENS.contains(type)
                // Unique case of comment before Indentation
                if (!toIndent && type == GdTypes.COMMENT && child.psi.nextNonWhiteCommentToken().elementType == GdTypes.INDENT) {
                    toIndent = true
                }

                val currentBlock = GdBlock(
                    child,
                    Wrap.createWrap(WrapType.NONE, false),
                    alignments.getAlignment(type),
                    settings,
                    spacing,
                    if (toIndent) Indent.getNormalIndent() else Indent.getNoneIndent(),
                    alignments.clone(type),
                )
                if (lastBlock != null) {
                    lastBlock.nextBlock = currentBlock
                }

                blocks.add(currentBlock)
                lastBlock = currentBlock
            }
        }

        return blocks
    }

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        var index = newChildIndex - 1
        var previousBlock = if (index >= 0) this.subBlocks[index] else null
        val preceding = if (previousBlock is GdBlock) previousBlock.node.psi else null
        val atEndOfStmt = node is FileElement

        // Check is it is right after COLON
        if (previousBlock is GdBlock) {
            val lastNode = PsiTreeUtil.getDeepestVisibleLast(previousBlock.node.psi)
            if (lastNode?.elementType == GdTypes.COLON) {
                if (atEndOfStmt && preceding != null) {
                    return ChildAttributes(settings.calculateSpaceIndents(preceding, true), null)
                }
                return ChildAttributes(Indent.getNormalIndent(), null)
            }
        }

        if (previousBlock is GdBlock && preceding != null && previousBlock.node.lastChildNode?.elementType == GdTypes.STMT_OR_SUITE) {
            val caretOffset = preceding.getCaretOffsetIfSingle()
            if (caretOffset != null) {
                if (PsiTreeUtil.getDeepestLast(preceding).precedingNewLines(caretOffset) > 2) {
                    return ChildAttributes(Indent.getNormalIndent(true), null)
                }
            }

//                val lastVisible = PsiTreeUtil.getDeepestVisibleLast(preceding) ?: preceding
//                val document = PsiEditorUtil.findEditor(lastVisible)!!.document
//                val line = document.getLineNumber(lastVisible.endOffset)
//                val indentedLine =
//                    document.text.substring(document.getLineStartOffset(line), document.getLineEndOffset(line))
//
//                return ChildAttributes(settings.indentToSpaces(indentedLine), null)
            if (atEndOfStmt) {
                return ChildAttributes(settings.calculateSpaceIndents(preceding), null)
            }

            return ChildAttributes(Indent.getContinuationIndent(), null)
        }

        // Inside indented blocks directly
        if (GdBlocks.INDENT_CHILDREN_ATTRIBUTE.contains(node.elementType)) {
            return ChildAttributes(Indent.getNormalIndent(), null)
        }


        return ChildAttributes(Indent.getNoneIndent(), null)

//        var treeParent = this.node.treeParent
//        if (GdBlocks.DEDENT_TOKEN_PARENTS.contains(treeParent?.elementType)) {
//            treeParent = treeParent.treeParent
//        }
//
//        if (
//            GdBlocks.INDENT_CHILDREN_ATTRIBUTE.contains(node.elementType)
//            || treeParent?.elementType == GdTypes.SUITE
//        ) {
//            if (newChildIndex > 0) {
//                val previousBlock = this.subBlocks[newChildIndex - 1]
//                if (previousBlock is GdBlock && previousBlock.node.lastChildNode?.elementType == GdTypes.STMT_OR_SUITE) {
//                    val preceding = previousBlock.node.lastChildNode.psi
//                    val caretOffset = preceding.getCaretOffsetIfSingle()
//                    if (caretOffset != null) {
//                        if (PsiTreeUtil.getDeepestLast(preceding).precedingNewLines(caretOffset) > 2) {
//                            return ChildAttributes(Indent.getNormalIndent(true), null)
//                        }
//                    }
//
//                    val lastVisible = PsiTreeUtil.getDeepestVisibleLast(preceding) ?: preceding
//                    val document = PsiEditorUtil.findEditor(lastVisible)!!.document
//                    val line = document.getLineNumber(lastVisible.endOffset)
//                    val indentedLine =
//                        document.text.substring(document.getLineStartOffset(line), document.getLineEndOffset(line))
//
//                    return ChildAttributes(settings.indentToSpaces(indentedLine), null)
//                }
//
//            }
//
//            return ChildAttributes(Indent.getNormalIndent(true), null)
//        }
//
//        var index = newChildIndex - 1
//        while (index > 0) {
//            val previousBlock = this.subBlocks[index]
//            if (previousBlock is GdBlock) {
//                if (previousBlock.node.text == "\n") {
//                    index--
//                    continue
//                }
//
//                if (GdBlocks.INDENT_CHILDREN_ATTRIBUTE.contains((previousBlock).node.elementType)) {
//                    val lastNode = PsiTreeUtil.getDeepestVisibleLast(previousBlock.node.psi)
//
//                    if (lastNode?.elementType == GdTypes.COLON) {
//                        return ChildAttributes(Indent.getContinuationIndent(true), null)
//                    }
//
//                    val caretOffset = PsiTreeUtil.getDeepestVisibleLast(previousBlock.node.psi)?.getCaretOffsetIfSingle()
//                    if (caretOffset != null) {
//                        if (previousBlock.node.psi.precedingNewLines(caretOffset) > 2) {
//                            return ChildAttributes(Indent.getNoneIndent(), null)
//                        }
//                    }
//
//                    // TODO upravit a bvyhodit do objecktu GdBlcoks
//                    val lastNodeParent = PsiTreeUtil.getParentOfType(
//                        lastNode,
//                        GdIfSt::class.java,
//                        GdElifSt::class.java,
//                        GdElseSt::class.java,
//                        GdForSt::class.java,
//                        GdWhileSt::class.java,
//                        GdTopLevelDecl::class.java
//                    )
//                    if (lastNodeParent != null && lastNodeParent !is GdTopLevelDecl) {
//                        return ChildAttributes(Indent.getContinuationIndent(true), null)
//                    }
//
//                    return ChildAttributes(Indent.getNormalIndent(true), null)
//                }
//            }
//            break
//        }
//
//        return ChildAttributes(Indent.getNoneIndent(), null)
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        if (child1 == null || child1 !is GdBlock || child2 !is GdBlock) {
            return this.spacing.getSpacing(this, child1, child2);
        }

        if (child1.node.elementType == GdTypes.COMMENT) {
            return null;
        }

        var block2: GdBlock? = child2
        while (block2 != null && block2.node.elementType == GdTypes.COMMENT) {
            block2 = block2.nextBlock
        }
        if (block2 == null) return null

        return this.spacing.getSpacing(this, child1, block2);
    }

    override fun getIndent(): Indent {
        return myIndent;
    };

    override fun isLeaf(): Boolean {
        return myNode.firstChildNode == null;
    }

}
