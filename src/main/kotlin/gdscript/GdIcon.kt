package gdscript

import com.intellij.openapi.util.IconLoader
import com.intellij.util.IconUtil
import javax.swing.Icon

object GdIcon {
    val FILE = IconLoader.getIcon("icons/file.png", GdIcon::class.java)

    // Godot editor icons
    @Deprecated("")
    val OBJECT = IconLoader.getIcon("icons/godot_editor/Object.svg", GdIcon::class.java)

    const val METHOD_MARKER = "Forward-sq"
    const val VAR_MARKER = "KeyBezierSelected"
    const val CONST_MARKER = "KeyXform"
    const val ENUM_MARKER = "Enum"
    const val SIGNAL_MARKER = "Signal"

    var editorIcons = HashMap<String, Icon>()

    fun getEditorIcon(className: String): Icon? {
        val icon = editorIcons[className]
        if (icon == null) {
            try {
                var loaded = IconLoader.getIcon(
                    String.format("icons/godot_editor/%s.svg", className),
                    GdIcon::class.java
                )
                if (loaded.iconHeight > 1) {
                    loaded = IconUtil.toSize(loaded, 16, 16)
                    editorIcons[className] = loaded
                } else {
                    editorIcons[className] = OBJECT
                }
            } catch (e: Exception) {
                editorIcons[className] = OBJECT
            }
        }
        return editorIcons[className]
    }
}