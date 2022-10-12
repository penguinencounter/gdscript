package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.patterns.PlatformPatterns.psiElement
import gdscript.completion.utils.GdFileVisitor
import gdscript.completion.utils.GdRefIdCompletionUtil
import gdscript.completion.utils.GdResourceCompletionUtil
import gdscript.psi.GdFile
import gdscript.psi.GdTypes
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class GdResourceCompletionContributor : CompletionContributor() {

    val NODE_PATH = psiElement(GdTypes.NODE_PATH_LEX);
    val NODE_PATH_ROOT = NODE_PATH.withSuperParent(3, psiElement(GdFile::class.java));
    val RESOURCE_STRING = psiElement(GdTypes.STRING);

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (GdRefIdCompletionUtil.DIRECT_REF.accepts(parameters.position)) {
            GdResourceCompletionUtil.resources(parameters.position.originalElement, result);
        } else if (NODE_PATH_ROOT.accepts(parameters.position)) {
            GdResourceCompletionUtil.fullVarResources(parameters.position.originalElement, result);
        } else if (NODE_PATH.accepts(parameters.position)) {
            GdResourceCompletionUtil.resources(parameters.position.originalElement, result);
        } else if (RESOURCE_STRING.accepts(parameters.position)) {
            val base = parameters.position.project.basePath ?: return;
            val v = GdFileVisitor(base);
            Files.walkFileTree(Paths.get(base), v);
            v.files.forEach {
                result.addElement(
                    GdLookup.create(
                        "res://${it.trimStart(File.separatorChar).split(File.separatorChar).joinToString("/")}",
                    )
                )
            }
        }
    }

}