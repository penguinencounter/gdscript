package gdscript

import com.intellij.openapi.fileTypes.LanguageFileType
import gdscript.GdIcon.FILE
import javax.swing.Icon

class GdFileType private constructor() : LanguageFileType(GdLanguage.INSTANCE) {

    override fun getName(): String {
        return "GdScript File"
    }

    override fun getDescription(): String {
        return "GdScript language file"
    }

    override fun getDefaultExtension(): String {
        return "gd"
    }

    override fun getIcon(): Icon {
        return FILE
    }

    companion object {
        val INSTANCE = GdFileType()
    }

}
