package gdscript.index.impl

import com.intellij.util.indexing.*
import com.intellij.util.io.DataExternalizer
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor
import common.index.FileBasedIndexExtensionExt
import gdscript.index.Indices
import gdscript.index.impl.model.FileResData
import gdscript.index.impl.utils.GdFileResIndexer
import gdscript.index.impl.utils.GdFileResInputFilter
import java.io.DataInput
import java.io.DataOutput

class GdFileResIndex : FileBasedIndexExtensionExt<String, FileResData>() {

    companion object {
        val INSTANCE = GdFileResIndex()
    }

    override val id: ID<String, FileResData> = Indices.FILE_RES

    override fun getIndexer(): DataIndexer<String, FileResData, FileContent> {
        return GdFileResIndexer
    }

    override fun getValueExternalizer(): DataExternalizer<FileResData> {
        return object : DataExternalizer<FileResData> {
            override fun save(out: DataOutput, value: FileResData) {
                out.writeUTF(value.icon ?: "")
            }

            override fun read(`in`: DataInput): FileResData {
                return FileResData(
                    `in`.readUTF(),
                )
            }
        }
    }

    override fun getKeyDescriptor(): KeyDescriptor<String> {
        return EnumeratorStringDescriptor.INSTANCE
    }

    override fun getVersion(): Int {
        return Indices.VERSION
    }

    override fun getInputFilter(): FileBasedIndex.InputFilter {
        return GdFileResInputFilter
    }

    override fun dependsOnFileContent(): Boolean {
        return true
    }

}
