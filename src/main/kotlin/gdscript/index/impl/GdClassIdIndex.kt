package gdscript.index.impl

import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndexKey
import common.index.StringStubIndexExtensionExt
import gdscript.index.Indices
import gdscript.psi.GdClassNameNmi
import gdscript.psi.utils.PsiGdResourceUtil
import gdscript.utils.GdVirtualFileUtil.localPath

object GdClassIdIndex : StringStubIndexExtensionExt<GdClassNameNmi>() {

    override fun getKey(): StubIndexKey<String, GdClassNameNmi> = Indices.CLASS_NAME_ID;

    override fun getVersion(): Int = Indices.VERSION;

    fun getGloballyResolved(name: String, project: Project): Collection<GdClassNameNmi> {
        val fqn = get(name, project, GlobalSearchScope.allScope(project));
        if (fqn.isNotEmpty()) return fqn;

        var modified: String;
        if (name.startsWith('"')) {
            // Try resource to class_name
            val endIndex = name.indexOf('"', 1);
            val resource = name.substring(1, endIndex);
            modified = GdFileResIndex.getValues(resource, project).firstOrNull() ?: return emptyList();

            if (name.length > endIndex + 1) {
                modified = "$modified${name.substring(endIndex + 1)}";
            }
        } else {
            // Try class_name to resource
            val classes = name.split('.').toMutableList();
            val rootClass = classes.firstOrNull() ?: return emptyList();
            val cln = GdClassNamingIndex.getGlobally(rootClass, project).firstOrNull() ?: return emptyList();

            val resource = PsiGdResourceUtil.resourcePath(cln.containingFile.virtualFile.localPath());
            classes[0] = "\"$resource\"";

            modified = classes.joinToString(".");
        }

        return get(modified, project, GlobalSearchScope.allScope(project));
    }

}