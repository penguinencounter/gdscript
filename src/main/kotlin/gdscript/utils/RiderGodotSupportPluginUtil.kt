package gdscript.utils

import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.project.Project
import com.intellij.platform.lsp.api.LspServerManager
import com.intellij.platform.lsp.api.LspServerState
import com.intellij.platform.lsp.api.LspServerSupportProvider

class RiderGodotSupportPluginUtil {
    companion object {
        private const val GODOT_LSP_PRESENTABLE_NAME = "Godot"

        fun isGodotSupportLSPRunning(project: Project): Boolean {
            val manager = LspServerManager.getInstance(project)
            val provider = LspServerSupportProvider.EP_NAME.findFirstSafe { provider ->
                manager.getServersForProvider(provider::class.java).any { it.state == LspServerState.Running && it.descriptor.presentableName == GODOT_LSP_PRESENTABLE_NAME }
            }
            return provider != null
        }
    }
}

private const val RIDER_GODOT_PLUGIN_ID = "com.intellij.rider.godot"
fun PluginManagerCore.isRiderGodotSupportPluginInstalled(): Boolean {
    return this.plugins.any { it.pluginId.idString == RIDER_GODOT_PLUGIN_ID }
}