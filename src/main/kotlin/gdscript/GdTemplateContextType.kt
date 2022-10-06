package gdscript

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

class GdTemplateContextType : TemplateContextType("GDSCRIPT", "GdScript") {

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean =
        templateActionContext.file.name.endsWith(".gd");

}