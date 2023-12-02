package gdscript.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.jupiter.api.Test

class GdParserTest : ParsingTestCase {

    // https://docs.godotengine.org/en/stable/tutorials/scripting/gdscript/gdscript_basics.html

    constructor(): super("", "gd", gdscript.GdNewParserDefinition())
    //    constructor(): super("", "gd", gdscript.GdParserDefinition())

    @Test fun testExtension() = doTest(true)
    @Test fun testExtensionExt() = doTest(true)
    @Test fun testClassName() = doTest(true)
    @Test fun testAnnotation() = doTest(true)
    @Test fun testAnnotationParam() = doTest(true)
    @Test fun testClassConst() = doTest(true)
    @Test fun testClassVar() = doTest(true)
    @Test fun testClassVarAs() = doTest(true)
    @Test fun testClassVarSetGet() = doTest(true)
    @Test fun testClassVarSetGetMethod() = doTest(true)
    @Test fun testClassVarSetGetMethodMultiline() = doTest(true)
    @Test fun testSignal() = doTest(true)
    @Test fun testEnumAnonymous() = doTest(true)
    @Test fun testEnumNamed() = doTest(true)
    @Test fun testFunctionSimple() = doTest(true)
    @Test fun testMethodArrayReturnType() = doTest(true)
    @Test fun testClass() = doTest(true)
    @Test fun testCommentWithinCode() = doTest(true)

    // Stmts
    @Test fun testAnnotationInner() = doTest(true)
    @Test fun testAssignStmt() = doTest(true)
    @Test fun testVarConstStmt() = doTest(true)
    @Test fun testVarConstWithEmptyStmt() = doTest(true)
    @Test fun testIfStmt() = doTest(true)
    @Test fun testWhileStmt() = doTest(true)
    @Test fun testForStmt() = doTest(true)
    @Test fun testMatchStmt() = doTest(true)

    // Exprs
    @Test fun testFuncDeclExpr() = doTest(true)
    @Test fun testFuncDeclExprExt() = doTest(true)
    @Test fun testFuncDeclExprParam() = doTest(true)
    @Test fun testLambdaCallExpr() = doTest(true)
    @Test fun testNestedCallExpr() = doTest(true)
    @Test fun testArrayExpr() = doTest(true)
    @Test fun testPrimaryBracketExpr() = doTest(true)
    @Test fun testDictDeclExpr() = doTest(true)
    @Test fun testAwaitExpr() = doTest(true)
    @Test fun testCastExpr() = doTest(true)
    @Test fun testTernaryExpr() = doTest(true)
    @Test fun testLogicExpr() = doTest(true)
    @Test fun testNegateExpr() = doTest(true)
    @Test fun testInExpr() = doTest(true)
    @Test fun testComparisonExpr() = doTest(true)
    @Test fun testBitExpr() = doTest(true)
    @Test fun testShiftExpr() = doTest(true)
    @Test fun testPlusExpr() = doTest(true)
    @Test fun testFactorExpr() = doTest(true)
    @Test fun testSignExpr() = doTest(true)
    @Test fun testBitNotExpr() = doTest(true)
    @Test fun testIsExpr() = doTest(true)
    @Test fun testAttributeExpr() = doTest(true)

    override fun getTestDataPath(): String {
        return "src/test/kotlin/gdscript/parser/data"
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }

}
