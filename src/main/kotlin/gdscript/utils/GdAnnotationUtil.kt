package gdscript.utils

import gdscript.model.GdAnnotation

/**
 * Do not edit manually
 * Generated by annotationParser.php
 */
object GdAnnotationUtil {

    fun get(name: String): GdAnnotation? {
        return ANNOTATIONS[name]
    }

    // Name -> GdAnnotation
    val ANNOTATIONS = mapOf(
        "export" to GdAnnotation(false, linkedMapOf()),
        "export_category" to GdAnnotation(false, linkedMapOf()),
        "export_color_no_alpha" to GdAnnotation(false, linkedMapOf()),
        "export_dir" to GdAnnotation(false, linkedMapOf()),
        "export_enum" to GdAnnotation(true, linkedMapOf()),
        "export_exp_easing" to GdAnnotation(true, linkedMapOf()),
        "export_file" to GdAnnotation(true, linkedMapOf()),
        "export_flags" to GdAnnotation(true, linkedMapOf()),
        "export_flags_2d_navigation" to GdAnnotation(false, linkedMapOf()),
        "export_flags_2d_physics" to GdAnnotation(false, linkedMapOf()),
        "export_flags_2d_render" to GdAnnotation(false, linkedMapOf()),
        "export_flags_3d_navigation" to GdAnnotation(false, linkedMapOf()),
        "export_flags_3d_physics" to GdAnnotation(false, linkedMapOf()),
        "export_flags_3d_render" to GdAnnotation(false, linkedMapOf()),
        "export_global_dir" to GdAnnotation(false, linkedMapOf()),
        "export_global_file" to GdAnnotation(true, linkedMapOf()),
        "export_group" to GdAnnotation(false, linkedMapOf(
            "name" to "String",
            "prefix" to "String",
        )),
        "export_multiline" to GdAnnotation(false, linkedMapOf()),
        "export_node_path" to GdAnnotation(true, linkedMapOf()),
        "export_placeholder" to GdAnnotation(false, linkedMapOf()),
        "export_range" to GdAnnotation(true, linkedMapOf(
            "min" to "float",
            "max" to "float",
            "step" to "float",
            "extra_hints" to "String",
        )),
        "export_subgroup" to GdAnnotation(false, linkedMapOf(
            "name" to "String",
            "prefix" to "String",
        )),
        "icon" to GdAnnotation(false, linkedMapOf()),
        "onready" to GdAnnotation(false, linkedMapOf()),
        "rpc" to GdAnnotation(true, linkedMapOf(
            "mode" to "String",
            "sync" to "String",
            "transfer_mode" to "String",
            "transfer_channel" to "int",
        )),
        "tool" to GdAnnotation(false, linkedMapOf()),
        "warning_ignore" to GdAnnotation(true, linkedMapOf()),

    )

}
