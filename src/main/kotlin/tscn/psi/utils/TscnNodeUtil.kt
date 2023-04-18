package tscn.psi.utils

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import tscn.index.impl.TscnNodeIndex
import tscn.psi.TscnDataLine
import tscn.psi.TscnNodeHeader
import tscn.psi.TscnParagraph
import tscn.psi.TscnResourceHeader

/**
 * Node line utils
 * [node name="Outer" type="Node3D" parent="."]
 */
object TscnNodeUtil {

    val META_PREFIX = "metadata/"

    /** Header lines */

    fun getName(element: TscnNodeHeader): String {
        val stub = element.stub;
        if (stub != null) return stub.getName();

        return TscnHeaderUtils.getValue(element.headerValueList, TscnHeaderUtils.HL_NAME);
    }

    fun getType(element: TscnNodeHeader): String {
        val stub = element.stub
        if (stub != null) return stub.getType()

        return TscnHeaderUtils.getValue(element.headerValueList, TscnHeaderUtils.HL_TYPE)
    }

    fun getParentPath(element: TscnNodeHeader): String {
        val stub = element.stub;
        if (stub != null) return stub.getParentPath();

        return TscnHeaderUtils.getValue(element.headerValueList, TscnHeaderUtils.HL_PARENT);
    }

    fun getGroups(element: TscnNodeHeader): Array<String> {
        val stub = element.stub
        if (stub != null) return stub.getGroups()

        return TscnHeaderUtils.getValue(element.headerValueList, TscnHeaderUtils.HL_GROUPS)
            .trim('[', ']')
            .split(",")
            .map { it.trim(' ', '"') }
            .toTypedArray()
    }

    fun getInstanceResource(element: TscnNodeHeader): String {
        val stub = element.stub;
        if (stub != null) return stub.getScriptResource()

        // ExtResource("1"), ExtResource( 1 )
        var id = TscnHeaderUtils.getValue(element.headerValueList, TscnHeaderUtils.HL_INSTANCE)
        if (id.isBlank()) return ""
        id = parseResourceId(id)

        val resources = PsiTreeUtil.findChildrenOfType(element.containingFile, TscnResourceHeader::class.java)

        return resources.find { it.id == id }?.path ?: ""
    }

    /** Data lines */

    fun isUniqueNameOwner(element: TscnNodeHeader): Boolean {
        val stub = element.stub;
        if (stub != null) return stub.isUniqueNameOwner();

        return TscnHeaderUtils.getDataValue(element.parent as TscnParagraph, TscnHeaderUtils.DL_UNIQUE) == "true"
    }

    fun getScriptResource(element: TscnNodeHeader): String {
        val stub = element.stub;
        if (stub != null) return stub.getScriptResource()

        // ExtResource("2_s5kgd"), ExtResource( 1 )
        var id = TscnHeaderUtils.getDataValue(element.parent as TscnParagraph, TscnHeaderUtils.DL_SCRIPT)
        if (id.isBlank()) return ""
        id = parseResourceId(id)

        val scripts = PsiTreeUtil.findChildrenOfType(element.containingFile, TscnResourceHeader::class.java)

        return scripts.find { it.id == id }?.path ?: ""
    }

    /** Other */

    fun getNodePath(element: TscnNodeHeader): String {
        val stub = element.stub
        if (stub != null) return stub.getNodePath()

        val parentPath = element.parentPath

//        val rootName = PsiTreeUtil
//            .findChildrenOfType(element.containingFile, TscnNodeHeader::class.java)
//            .find { it.parentPath == "" }?.name ?: ""

        return when(parentPath) {
            "" -> ".."
            "." -> "../${element.name}"
            else -> "../$parentPath/${element.name}"
//            "" -> rootName
//            "." -> "$rootName/${element.name}"
//            else -> "$rootName/$parentPath/${element.name}"
        }
    }

    @Deprecated("is it needed after Node rework?")
    fun getDirectParentPath(element: TscnNodeHeader): String {
        return when(val parentPath = element.parentPath) {
            "" -> "."
            "." -> element.name
            else -> "$parentPath/${element.name}"
        }
    }

    fun hasScript(element: TscnNodeHeader): Boolean {
        val stub = element.stub;
        if (stub != null) return stub.hasScript();

        return getScriptResource(element).isNotBlank();
    }

    fun listAllGroups(element: PsiElement): Array<String> {
        return listAllGroups(element.project)
    }

    fun listAllGroups(project: Project): Array<String> {
        return TscnNodeIndex.getAllValues(project).flatMap {
            it.groups.toList()
        }.toTypedArray()
    }

    fun listAllMetas(element: PsiElement): Array<String> {
        val tscnFile = TscnResourceUtil.findTscnByResource(element) ?: return emptyArray()
        val node = PsiTreeUtil.findChildOfType(tscnFile.containingFile, TscnNodeHeader::class.java)
            ?: return emptyArray()
        val datas = PsiTreeUtil.getChildrenOfTypeAsList(node.parent, TscnDataLine::class.java)

        return datas.mapNotNull {
            val name = it.dataLineNm.text
            if (name.startsWith(META_PREFIX)) name.substring(META_PREFIX.length)
            else null
        }.toTypedArray()
    }

    private fun parseResourceId(resource: String): String {
        return resource.removePrefix("ExtResource(").trim().removeSuffix(")").trim('"')
    }

}
