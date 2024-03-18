package gdscript.annotator

import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.lang.annotation.AnnotationBuilder
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import gdscript.utils.isGodotSupportPluginForRiderInstalled
import org.jetbrains.annotations.NotNull

private val isGodotSupportInstalled = PluginManagerCore.isGodotSupportPluginForRiderInstalled()
fun AnnotationHolder.newAnnotationGd(
        @NotNull severity: HighlightSeverity,
        @NotNull message: String
): AnnotationBuilder {
    if (severity == HighlightSeverity.ERROR && isGodotSupportInstalled)
        return this.newSilentAnnotation(HighlightSeverity.INFORMATION)
    return this.newAnnotation(severity, message)
}
