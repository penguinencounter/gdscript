package gdscript.codeInsight.documentation

import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.openapi.util.text.HtmlChunk
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import gdscript.completion.utils.GdMethodCompletionUtil.methodHeader
import gdscript.psi.GdFuncDeclEx
import gdscript.psi.GdMethodDeclTl
import gdscript.psi.GdMethodIdNmi
import gdscript.psi.utils.GdClassUtil

class GdDocBuilder {

    private var owner: HtmlChunk? = null
    private var packaged: HtmlChunk? = null
    private var preview: HtmlChunk? = null
    private var body: MutableList<HtmlChunk> = mutableListOf(HtmlChunk.text("Losos"))
    private var separate = false

    /**
     * @param element GdClassDecl|GdFile from getOwningClassElement
     */
    fun withOwner(element: PsiElement): GdDocBuilder {
        val body = GdDocUtil.iconed("AllIcons.Nodes.Class")
        val link = GdClassUtil.getFullClassId(element)
        body.add(GdDocUtil.elementLink(link))
        owner = HtmlChunk.div()
            .children(body)
        return this
    }

    fun withPackage(path: String): GdDocBuilder {
        val body = GdDocUtil.iconed("AllIcons.Nodes.Package")

        var currentPath = ""
        path.split("/").forEachIndexed { index, s ->
            currentPath += "/$s"
            if (index == 0) {
                currentPath = currentPath.trimStart('/')
            } else {
                body.add(HtmlChunk.text("/"))
            }

            body.add(GdDocUtil.packageLink(currentPath.trimStart('/'), s))
        }
        packaged = HtmlChunk.div().children(body)
        return this
    }

    fun withPreview(element: PsiElement): GdDocBuilder {
        // TODO syntax highlight
        // https://github.com/JetBrains/intellij-community/blob/idea/231.8109.175/platform/lang-impl/src/com/intellij/openapi/editor/richcopy/HtmlSyntaxInfoUtil.java
        val code = when (element) {
            is GdMethodIdNmi -> {
                val declaration =
                    PsiTreeUtil.getParentOfType(element, GdMethodDeclTl::class.java, GdFuncDeclEx::class.java)
                        ?: return this

                when (declaration) {
                    is GdMethodDeclTl -> declaration.methodHeader()
                    is GdFuncDeclEx -> declaration.methodHeader()
                    else -> return this
                }
            }

            else -> return this
        }
        preview = HtmlChunk.tag("code").child(HtmlChunk.text(code))
        return this
    }

    override fun toString(): String {
        val sb = StringBuilder()
        line(sb, owner)
//        sb.append(DocumentationMarkup.SECTIONS_START)
        line(sb, preview)
        sb.append(HtmlChunk.div().style("""
          display: block;
          height: 1px;
          border: 0;
          border-top: 1px solid #666;
          margin: 10px 0;
        """.trimMargin()))
        line(sb, body)
//        sb.append(DocumentationMarkup.SECTIONS_END)
        line(sb, packaged)

        return sb.toString()
    }

    private fun line(sb: StringBuilder, element: Any?) {
        if (element == null) return
        sb.append(DocumentationMarkup.CONTENT_START)
        sb.append(element)
        sb.append(DocumentationMarkup.CONTENT_END)
    }

    private fun section(sb: StringBuilder, element: Any?) {
        if (element == null) return
        if (element is List<*> && element.isEmpty()) return
        if (separate) {
            sb.append(DocumentationMarkup.SECTION_SEPARATOR)
            separate = false
        }

        sb.append(DocumentationMarkup.SECTION_START)
        if (element is List<*>) {
            element.forEach { sb.append(it) }
        } else {
            sb.append(element)
        }
        sb.append(DocumentationMarkup.SECTION_END)
        separate = true
    }

}