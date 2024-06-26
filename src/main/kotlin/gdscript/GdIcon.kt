package gdscript

import com.intellij.openapi.util.IconLoader
import com.intellij.util.IconUtil
import javax.swing.Icon

object GdIcon {
    val FILE = IconLoader.getIcon("icons/file.png", GdIcon::class.java)

    // Godot editor icons
    const val METHOD_MARKER = "MemberMethod"
    const val VAR_MARKER = "MemberProperty"
    const val CONST_MARKER = "MemberConstant"
    const val ENUM_MARKER = "Enum"
    const val SIGNAL_MARKER = "MemberSignal"

    const val OBJECT = "Object"
    const val SIGNAL = "Signal"
    const val SLOT = "Slot"
    const val LINK = "LinkButton"
    const val ERROR = "StatusError"
    const val RESOURCE = "Mesh"
    const val STRING = "String"
    const val OVERRIDE = "MethodOverride"
    const val ANIMATION = "Animation"
    const val NODE = "Node"

    private var editorIcons = HashMap<String, Icon>()

    fun getEditorIcon(className: String): Icon {
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
                    editorIcons[className] = backupIcon()
                }
            } catch (e: Exception) {
                editorIcons[className] = backupIcon()
            }
        }

        return editorIcons[className]!!
    }

    private fun backupIcon(): Icon {
        return try {
            IconLoader.getIcon("icons/godot_editor/Object.svg", GdIcon::class.java)
        } catch (e: Exception) {
            FILE
        }
    }
}
