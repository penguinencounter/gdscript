package gdscript

/**
 * Do not edit manually
 * Generated by operandParser.php
 */
object GdOperand {

    // Left -> Operand -> Right -> Result
    val OPERANDS = mapOf(
        "AABB" to mapOf(
            "!=" to mapOf("AABB" to "bool"),
            "*" to mapOf("Transform3D" to "AABB"),
            "==" to mapOf("AABB" to "bool"),
        ),
        "Array" to mapOf(
            "!=" to mapOf("Array" to "bool"),
            "+" to mapOf("Array" to "Array"),
            "<" to mapOf("Array" to "bool"),
            "<=" to mapOf("Array" to "bool"),
            "==" to mapOf("Array" to "bool"),
            ">" to mapOf("Array" to "bool"),
            ">=" to mapOf("Array" to "bool"),
            "[]" to mapOf("int" to "Variant"),
        ),
        "Basis" to mapOf(
            "!=" to mapOf("Basis" to "bool"),
            "*" to mapOf(
                "Basis" to "Basis",
                "Vector3" to "Vector3",
                "float" to "Basis",
                "int" to "Basis",
            ),
            "==" to mapOf("Basis" to "bool"),
            "[]" to mapOf("int" to "Vector3"),
        ),
        "Callable" to mapOf(
            "!=" to mapOf("Callable" to "bool"),
            "==" to mapOf("Callable" to "bool"),
        ),
        "Color" to mapOf(
            "!=" to mapOf("Color" to "bool"),
            "*" to mapOf(
                "Color" to "Color",
                "float" to "Color",
                "int" to "Color",
            ),
            "+" to mapOf("Color" to "Color"),
            "-" to mapOf("Color" to "Color"),
            "/" to mapOf(
                "Color" to "Color",
                "float" to "Color",
                "int" to "Color",
            ),
            "==" to mapOf("Color" to "bool"),
            "[]" to mapOf("int" to "float"),
        ),
        "Dictionary" to mapOf(
            "!=" to mapOf("Dictionary" to "bool"),
            "==" to mapOf("Dictionary" to "bool"),
            "[]" to mapOf("Variant" to "Variant"),
        ),
        "NodePath" to mapOf(
            "!=" to mapOf("NodePath" to "bool"),
            "==" to mapOf("NodePath" to "bool"),
        ),
        "PackedByteArray" to mapOf(
            "!=" to mapOf("PackedByteArray" to "bool"),
            "+" to mapOf("PackedByteArray" to "PackedByteArray"),
            "==" to mapOf("PackedByteArray" to "bool"),
            "[]" to mapOf("int" to "int"),
        ),
        "PackedColorArray" to mapOf(
            "!=" to mapOf("PackedColorArray" to "bool"),
            "+" to mapOf("PackedColorArray" to "PackedColorArray"),
            "==" to mapOf("PackedColorArray" to "bool"),
            "[]" to mapOf("int" to "Color"),
        ),
        "PackedFloat32Array" to mapOf(
            "!=" to mapOf("PackedFloat32Array" to "bool"),
            "+" to mapOf("PackedFloat32Array" to "PackedFloat32Array"),
            "==" to mapOf("PackedFloat32Array" to "bool"),
            "[]" to mapOf("int" to "float"),
        ),
        "PackedFloat64Array" to mapOf(
            "!=" to mapOf("PackedFloat64Array" to "bool"),
            "+" to mapOf("PackedFloat64Array" to "PackedFloat64Array"),
            "==" to mapOf("PackedFloat64Array" to "bool"),
            "[]" to mapOf("int" to "float"),
        ),
        "PackedInt32Array" to mapOf(
            "!=" to mapOf("PackedInt32Array" to "bool"),
            "+" to mapOf("PackedInt32Array" to "PackedInt32Array"),
            "==" to mapOf("PackedInt32Array" to "bool"),
            "[]" to mapOf("int" to "int"),
        ),
        "PackedInt64Array" to mapOf(
            "!=" to mapOf("PackedInt64Array" to "bool"),
            "+" to mapOf("PackedInt64Array" to "PackedInt64Array"),
            "==" to mapOf("PackedInt64Array" to "bool"),
            "[]" to mapOf("int" to "int"),
        ),
        "PackedStringArray" to mapOf(
            "!=" to mapOf("PackedStringArray" to "bool"),
            "+" to mapOf("PackedStringArray" to "PackedStringArray"),
            "==" to mapOf("PackedStringArray" to "bool"),
            "[]" to mapOf("int" to "String"),
        ),
        "PackedVector2Array" to mapOf(
            "!=" to mapOf("PackedVector2Array" to "bool"),
            "*" to mapOf("Transform2D" to "PackedVector2Array"),
            "+" to mapOf("PackedVector2Array" to "PackedVector2Array"),
            "==" to mapOf("PackedVector2Array" to "bool"),
            "[]" to mapOf("int" to "Vector2"),
        ),
        "PackedVector3Array" to mapOf(
            "!=" to mapOf("PackedVector3Array" to "bool"),
            "*" to mapOf("Transform3D" to "PackedVector3Array"),
            "+" to mapOf("PackedVector3Array" to "PackedVector3Array"),
            "==" to mapOf("PackedVector3Array" to "bool"),
            "[]" to mapOf("int" to "Vector3"),
        ),
        "Plane" to mapOf(
            "!=" to mapOf("Plane" to "bool"),
            "*" to mapOf("Transform3D" to "Plane"),
            "==" to mapOf("Plane" to "bool"),
        ),
        "Projection" to mapOf(
            "!=" to mapOf("Projection" to "bool"),
            "*" to mapOf(
                "Projection" to "Projection",
                "Vector4" to "Vector4",
            ),
            "==" to mapOf("Projection" to "bool"),
            "[]" to mapOf("int" to "Vector4"),
        ),
        "Quaternion" to mapOf(
            "!=" to mapOf("Quaternion" to "bool"),
            "*" to mapOf(
                "Quaternion" to "Quaternion",
                "Vector3" to "Vector3",
                "float" to "Quaternion",
                "int" to "Quaternion",
            ),
            "+" to mapOf("Quaternion" to "Quaternion"),
            "-" to mapOf("Quaternion" to "Quaternion"),
            "/" to mapOf(
                "float" to "Quaternion",
                "int" to "Quaternion",
            ),
            "==" to mapOf("Quaternion" to "bool"),
            "[]" to mapOf("int" to "float"),
        ),
        "RID" to mapOf(
            "!=" to mapOf("RID" to "bool"),
            "<" to mapOf("RID" to "bool"),
            "<=" to mapOf("RID" to "bool"),
            "==" to mapOf("RID" to "bool"),
            ">" to mapOf("RID" to "bool"),
            ">=" to mapOf("RID" to "bool"),
        ),
        "Rect2" to mapOf(
            "!=" to mapOf("Rect2" to "bool"),
            "*" to mapOf("Transform2D" to "Rect2"),
            "==" to mapOf("Rect2" to "bool"),
        ),
        "Rect2i" to mapOf(
            "!=" to mapOf("Rect2i" to "bool"),
            "==" to mapOf("Rect2i" to "bool"),
        ),
        "Signal" to mapOf(
            "!=" to mapOf("Signal" to "bool"),
            "==" to mapOf("Signal" to "bool"),
        ),
        "String" to mapOf(
            "!=" to mapOf(
                "String" to "bool",
                "StringName" to "bool",
            ),
            "%" to mapOf("Variant" to "String"),
            "+" to mapOf(
                "String" to "String",
                "StringName" to "String",
            ),
            "<" to mapOf("String" to "bool"),
            "<=" to mapOf("String" to "bool"),
            "==" to mapOf(
                "String" to "bool",
                "StringName" to "bool",
            ),
            ">" to mapOf("String" to "bool"),
            ">=" to mapOf("String" to "bool"),
            "[]" to mapOf("int" to "String"),
        ),
        "StringName" to mapOf(
            "!=" to mapOf(
                "String" to "bool",
                "StringName" to "bool",
            ),
            "%" to mapOf("Variant" to "String"),
            "+" to mapOf(
                "String" to "String",
                "StringName" to "String",
            ),
            "<" to mapOf("StringName" to "bool"),
            "<=" to mapOf("StringName" to "bool"),
            "==" to mapOf(
                "String" to "bool",
                "StringName" to "bool",
            ),
            ">" to mapOf("StringName" to "bool"),
            ">=" to mapOf("StringName" to "bool"),
        ),
        "Transform2D" to mapOf(
            "!=" to mapOf("Transform2D" to "bool"),
            "*" to mapOf(
                "PackedVector2Array" to "PackedVector2Array",
                "Rect2" to "Rect2",
                "Transform2D" to "Transform2D",
                "Vector2" to "Vector2",
                "float" to "Transform2D",
                "int" to "Transform2D",
            ),
            "==" to mapOf("Transform2D" to "bool"),
            "[]" to mapOf("int" to "Vector2"),
        ),
        "Transform3D" to mapOf(
            "!=" to mapOf("Transform3D" to "bool"),
            "*" to mapOf(
                "AABB" to "AABB",
                "PackedVector3Array" to "PackedVector3Array",
                "Plane" to "Plane",
                "Transform3D" to "Transform3D",
                "Vector3" to "Vector3",
                "float" to "Transform3D",
                "int" to "Transform3D",
            ),
            "==" to mapOf("Transform3D" to "bool"),
        ),
        "Vector2" to mapOf(
            "!=" to mapOf("Vector2" to "bool"),
            "*" to mapOf(
                "Transform2D" to "Vector2",
                "Vector2" to "Vector2",
                "float" to "Vector2",
                "int" to "Vector2",
            ),
            "+" to mapOf("Vector2" to "Vector2"),
            "-" to mapOf("Vector2" to "Vector2"),
            "/" to mapOf(
                "Vector2" to "Vector2",
                "float" to "Vector2",
                "int" to "Vector2",
            ),
            "<" to mapOf("Vector2" to "bool"),
            "<=" to mapOf("Vector2" to "bool"),
            "==" to mapOf("Vector2" to "bool"),
            ">" to mapOf("Vector2" to "bool"),
            ">=" to mapOf("Vector2" to "bool"),
            "[]" to mapOf("int" to "float"),
        ),
        "Vector2i" to mapOf(
            "!=" to mapOf("Vector2i" to "bool"),
            "%" to mapOf(
                "Vector2i" to "Vector2i",
                "int" to "Vector2i",
            ),
            "*" to mapOf(
                "Vector2i" to "Vector2i",
                "float" to "Vector2",
                "int" to "Vector2i",
            ),
            "+" to mapOf("Vector2i" to "Vector2i"),
            "-" to mapOf("Vector2i" to "Vector2i"),
            "/" to mapOf(
                "Vector2i" to "Vector2i",
                "float" to "Vector2",
                "int" to "Vector2i",
            ),
            "<" to mapOf("Vector2i" to "bool"),
            "<=" to mapOf("Vector2i" to "bool"),
            "==" to mapOf("Vector2i" to "bool"),
            ">" to mapOf("Vector2i" to "bool"),
            ">=" to mapOf("Vector2i" to "bool"),
            "[]" to mapOf("int" to "int"),
        ),
        "Vector3" to mapOf(
            "!=" to mapOf("Vector3" to "bool"),
            "*" to mapOf(
                "Basis" to "Vector3",
                "Quaternion" to "Vector3",
                "Transform3D" to "Vector3",
                "Vector3" to "Vector3",
                "float" to "Vector3",
                "int" to "Vector3",
            ),
            "+" to mapOf("Vector3" to "Vector3"),
            "-" to mapOf("Vector3" to "Vector3"),
            "/" to mapOf(
                "Vector3" to "Vector3",
                "float" to "Vector3",
                "int" to "Vector3",
            ),
            "<" to mapOf("Vector3" to "bool"),
            "<=" to mapOf("Vector3" to "bool"),
            "==" to mapOf("Vector3" to "bool"),
            ">" to mapOf("Vector3" to "bool"),
            ">=" to mapOf("Vector3" to "bool"),
            "[]" to mapOf("int" to "float"),
        ),
        "Vector3i" to mapOf(
            "!=" to mapOf("Vector3i" to "bool"),
            "%" to mapOf(
                "Vector3i" to "Vector3i",
                "int" to "Vector3i",
            ),
            "*" to mapOf(
                "Vector3i" to "Vector3i",
                "float" to "Vector3",
                "int" to "Vector3i",
            ),
            "+" to mapOf("Vector3i" to "Vector3i"),
            "-" to mapOf("Vector3i" to "Vector3i"),
            "/" to mapOf(
                "Vector3i" to "Vector3i",
                "float" to "Vector3",
                "int" to "Vector3i",
            ),
            "<" to mapOf("Vector3i" to "bool"),
            "<=" to mapOf("Vector3i" to "bool"),
            "==" to mapOf("Vector3i" to "bool"),
            ">" to mapOf("Vector3i" to "bool"),
            ">=" to mapOf("Vector3i" to "bool"),
            "[]" to mapOf("int" to "int"),
        ),
        "Vector4" to mapOf(
            "!=" to mapOf("Vector4" to "bool"),
            "*" to mapOf(
                "Projection" to "Vector4",
                "Vector4" to "Vector4",
                "float" to "Vector4",
                "int" to "Vector4",
            ),
            "+" to mapOf("Vector4" to "Vector4"),
            "-" to mapOf("Vector4" to "Vector4"),
            "/" to mapOf(
                "Vector4" to "Vector4",
                "float" to "Vector4",
                "int" to "Vector4",
            ),
            "<" to mapOf("Vector4" to "bool"),
            "<=" to mapOf("Vector4" to "bool"),
            "==" to mapOf("Vector4" to "bool"),
            ">" to mapOf("Vector4" to "bool"),
            ">=" to mapOf("Vector4" to "bool"),
            "[]" to mapOf("int" to "float"),
        ),
        "Vector4i" to mapOf(
            "!=" to mapOf("Vector4i" to "bool"),
            "%" to mapOf(
                "Vector4i" to "Vector4i",
                "int" to "Vector4i",
            ),
            "*" to mapOf(
                "Vector4i" to "Vector4i",
                "float" to "Vector4",
                "int" to "Vector4i",
            ),
            "+" to mapOf("Vector4i" to "Vector4i"),
            "-" to mapOf("Vector4i" to "Vector4i"),
            "/" to mapOf(
                "Vector4i" to "Vector4i",
                "float" to "Vector4",
                "int" to "Vector4i",
            ),
            "<" to mapOf("Vector4i" to "bool"),
            "<=" to mapOf("Vector4i" to "bool"),
            "==" to mapOf("Vector4i" to "bool"),
            ">" to mapOf("Vector4i" to "bool"),
            ">=" to mapOf("Vector4i" to "bool"),
            "[]" to mapOf("int" to "int"),
        ),
        "bool" to mapOf(
            "!=" to mapOf("bool" to "bool"),
            "<" to mapOf("bool" to "bool"),
            "==" to mapOf("bool" to "bool"),
            ">" to mapOf("bool" to "bool"),
        ),
        "float" to mapOf(
            "!=" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
            "*" to mapOf(
                "Color" to "Color",
                "Quaternion" to "Quaternion",
                "Vector2" to "Vector2",
                "Vector2i" to "Vector2",
                "Vector3" to "Vector3",
                "Vector3i" to "Vector3",
                "Vector4" to "Vector4",
                "Vector4i" to "Vector4",
                "float" to "float",
                "int" to "float",
            ),
            "**" to mapOf(
                "float" to "float",
                "int" to "float",
            ),
            "+" to mapOf(
                "float" to "float",
                "int" to "float",
            ),
            "-" to mapOf(
                "float" to "float",
                "int" to "float",
            ),
            "/" to mapOf(
                "float" to "float",
                "int" to "float",
            ),
            "<" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
            "<=" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
            "==" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
            ">" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
            ">=" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
        ),
        "int" to mapOf(
            "!=" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
            "%" to mapOf("int" to "int"),
            "&" to mapOf("int" to "int"),
            "*" to mapOf(
                "Color" to "Color",
                "Quaternion" to "Quaternion",
                "Vector2" to "Vector2",
                "Vector2i" to "Vector2i",
                "Vector3" to "Vector3",
                "Vector3i" to "Vector3i",
                "Vector4" to "Vector4",
                "Vector4i" to "Vector4i",
                "float" to "float",
                "int" to "int",
            ),
            "**" to mapOf(
                "float" to "float",
                "int" to "int",
            ),
            "+" to mapOf(
                "float" to "float",
                "int" to "int",
            ),
            "-" to mapOf(
                "float" to "float",
                "int" to "int",
            ),
            "/" to mapOf(
                "float" to "float",
                "int" to "int",
            ),
            "<" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
            "<<" to mapOf("int" to "int"),
            "<=" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
            "==" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
            ">" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
            ">=" to mapOf(
                "float" to "bool",
                "int" to "bool",
            ),
            ">>" to mapOf("int" to "int"),
            "^" to mapOf("int" to "int"),
            "|" to mapOf("int" to "int"),
        ),

    )

}
