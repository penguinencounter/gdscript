package gdscript.utils

import com.intellij.ide.plugins.PluginManagerCore

fun PluginManagerCore.isGodotSupportPluginForRiderInstalled(): Boolean {
    return this.plugins.any { it.pluginId.idString == "com.intellij.rider.godot" }
}