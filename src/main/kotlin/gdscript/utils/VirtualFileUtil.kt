package gdscript.utils

import com.intellij.history.core.Paths
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectLocator
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import gdscript.psi.utils.PsiGdResourceUtil

object VirtualFileUtil {

    fun VirtualFile.localPath(): String {
        val project = ProjectLocator.getInstance().guessProjectForFile(this) ?: return ""
        val path = this.path.removePrefix("file://") // TODO vyhazuje se to někde?

        // TODO tohle vyvolá greeze - nemohu se ptát na Fileindex, když indexuji... jak ale mít více projektů?
        //val projectRoot = ProjectRootFileIndex.getProjectRoot(path, project)
        return Paths.relativeIfUnder(path, project.basePath) ?: ""
    }

    fun VirtualFile.localParentPath(): String {
        val project = ProjectLocator.getInstance().guessProjectForFile(this) ?: return ""
        val path = "${project.name}/${localPath()}"

        return path.substringBeforeLast('/')
    }

    fun VirtualFile.resourcePath(withPrefix: Boolean = true): String {
        return PsiGdResourceUtil.resourcePath(this, withPrefix)
    }

    fun VirtualFile.getPsiFile(element: PsiElement): PsiFile? {
        return this.getPsiFile(element.project)
    }

    fun VirtualFile.getPsiFile(project: Project): PsiFile? {
        return PsiManager.getInstance(project).findFile(this)
    }

}
