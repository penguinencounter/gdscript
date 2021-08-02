package gdscript.index

import com.intellij.psi.stubs.StubIndexKey
import gdscript.psi.*

object Indices {

    val CLASS_NAMING_INDEX = StubIndexKey.createIndexKey<String, GdClassNaming>("gdscript.classNaming")
    val INHERITANCE_INDEX = StubIndexKey.createIndexKey<String, GdInheritance>("gdscript.inheritance")
    val CONST_DECL_INDEX = StubIndexKey.createIndexKey<String, GdConstDeclTl>("gdscript.constDecl")
    val CLASS_VAR_INDEX = StubIndexKey.createIndexKey<String, GdClassVarDeclTl>("gdscript.classVarDecl")
    val METHOD_DECL = StubIndexKey.createIndexKey<String, GdMethodDeclTl>("gdscript.methodDecl")
    val SIGNAL_DECL = StubIndexKey.createIndexKey<String, GdSignalDeclTl>("gdscript.signal")

}