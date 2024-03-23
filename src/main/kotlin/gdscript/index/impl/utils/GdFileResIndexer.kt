package gdscript.index.impl.utils

import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.FileContent
import gdscript.index.impl.model.FileResData
import gdscript.psi.utils.PsiGdResourceUtil
import java.io.File
import java.util.Collections

object GdFileResIndexer : DataIndexer<String, FileResData, FileContent> {

    val ICON_REGEX = Regex("@icon\\((.*?)\\)")

    override fun map(inputData: FileContent): MutableMap<String, FileResData> {
        val resource = PsiGdResourceUtil.resourcePath(inputData.file)
        var ico = ICON_REGEX.find(inputData.contentAsText)
            ?.groups?.get(1)?.value
            ?.trim('\'', '"')
            ?: ""

        if (ico.isNotBlank()) {
            ico = "${inputData.file.parent.path}${File.separator}$ico"
        }

        return Collections.singletonMap(resource, FileResData(ico))
    }

}
