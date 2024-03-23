package common.index

import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.indexing.FileBasedIndex
import com.intellij.util.indexing.FileBasedIndexExtension
import com.intellij.util.indexing.ID

abstract class FileBasedIndexExtensionExt<K: Any, V : Any> : FileBasedIndexExtension<K, V>() {

    // Cannot use directly getName due to OverrideOnly annotation api violation
    abstract val id: ID<K, V>

    fun getFiles(key: K, project: Project): Collection<VirtualFile> {
        if (DumbService.isDumb(project)) return emptyList()
        return FileBasedIndex.getInstance().getContainingFiles(id, key, GlobalSearchScope.allScope(project))
    }

    fun getFiles(key: K, element: PsiElement): Collection<VirtualFile> {
        return getFiles(key, element.project)
    }

    fun getNonEmptyKeys(element: PsiElement): List<K> {
        return getNonEmptyKeys(element.project)
    }

    fun getNonEmptyKeys(project: Project): List<K> {
        val inst = FileBasedIndex.getInstance()
        val scope = GlobalSearchScope.allScope(project)

        return inst.getAllKeys(id, project).mapNotNull {
            if (inst.getContainingFiles(id, it, scope).isNotEmpty()) it
            else null
        }
    }

    fun getValues(key: K, project: Project): Collection<V> {
        if (DumbService.isDumb(project)) return emptyList()
        return FileBasedIndex.getInstance().getValues(id, key, GlobalSearchScope.allScope(project))
    }

    fun getValue(key: K, project: Project): V? {
        if (DumbService.isDumb(project)) return null
        return FileBasedIndex.getInstance().getValues(id, key, GlobalSearchScope.allScope(project)).firstOrNull()
    }

    override fun getName(): ID<K, V> {
        return id
    }

}
