package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.patterns.PsiJavaPatterns.psiElement
import com.intellij.psi.search.FilenameIndex
import gdscript.completion.util.GdFileVisitor
import gdscript.completion.util.GdResourceCompletionUtil
import gdscript.psi.GdRefIdNm
import gdscript.psi.GdTypes
import java.io.File
import java.nio.file.FileVisitOption
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.function.Consumer
import java.util.stream.Collectors

class GdResourceCompletionContributor : CompletionContributor() {

    val REF_ID = psiElement().withParent(GdRefIdNm::class.java)
    val NODE_PATH = psiElement(GdTypes.NODE_PATH_LEX);
    val RESOURCE_STRING = psiElement(GdTypes.STRING);

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (REF_ID.accepts(parameters.position)) {
            GdResourceCompletionUtil.resources(parameters.position.originalElement, result);
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