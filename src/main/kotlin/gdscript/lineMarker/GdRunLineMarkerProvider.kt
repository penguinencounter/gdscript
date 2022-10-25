package gdscript.lineMarker

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.psi.PsiElement
import gdscript.action.GdRunAction
import gdscript.psi.GdInheritanceIdNm

class GdRunLineMarkerProvider : RunLineMarkerContributor() {

    override fun getInfo(element: PsiElement): Info? {
        if (element.parent !is GdInheritanceIdNm) {
            return null;
        }

        return Info(GdRunAction(element.parent as GdInheritanceIdNm));
    }

}
