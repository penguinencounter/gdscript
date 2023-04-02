<?php

$files  = scandir("./classes");
$target = "./src/main/kotlin/gdscript/GdOperand.kt";

$baseContent = "package gdscript

/**
 * Do not edit manually
 * Generated by operandParser.php
 */
object GdOperand {
    
    fun getReturnType(left: String, right: String, operator: String): String {
        return OPERANDS.get(left)?.get(operator)?.get(right) ?: \"\"
    }

    fun isAllowed(left: String, right: String, operator: String): Boolean {
        return OPERANDS[left]?.get(operator)?.containsKey(right) ?: return false
    }

    // Left -> Operand -> Right -> Result
    val OPERANDS = mapOf(
%s
    )

}
";

$operators      = [];
$operatorPrefix = strlen("operator ");
foreach ($files as $filename) {
    if ($filename == "." || $filename == "..") continue;

    $data       = "";
    $class_name = substr($filename, 0, strlen($filename) - 4);
    if (substr($class_name, 0, 1) == "@") continue;

    $content = file_get_contents(sprintf("./classes/%s", $filename));
    $xml     = (array)simplexml_load_string($content);

    foreach ($xml['operators'] ?? [] as $value) {
        $value = (array)$value;
        $att   = (array)$value['@attributes'];

        $operator = substr($att['name'], $operatorPrefix);
        if (strpos($operator, "unary") !== false) continue;
        if ($operator == '~') continue;

        $return     = ((array)((array)($value['return']))['@attributes'])['type'];
        $rightParam = ((array)((array)($value['param']))['@attributes'])['type'];

        $operators[$class_name][$operator][$rightParam] = $return;
    }

}

$parsed = "";
foreach ($operators as $left => $operator) {
    $parsed .= sprintf("        \"%s\" to mapOf(\n", $left);
    foreach ($operator as $operand => $operands) {
        $parsed .= sprintf("            \"%s\" to mapOf(", $operand);

        if (count($operands) > 1) {
            $parsed .= "\n";
            foreach ($operands as $right => $result) {
                $parsed .= sprintf("                \"%s\" to \"%s\",\n", $right, $result);
            }
            $parsed .= "            ";
        } else {
            foreach ($operands as $right => $result) {
                $parsed .= sprintf('"%s" to "%s"', $right, $result);
            }
        }

        $parsed .= "),\n";
    }
    $parsed .= "        ),\n";
}

file_put_contents($target, sprintf($baseContent, $parsed));
