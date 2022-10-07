package gdscript.psi.impl

import com.intellij.psi.stubs.*
import com.intellij.psi.util.elementType
import gdscript.GdLanguage
import gdscript.index.Indices
import gdscript.index.stub.GdMethodDeclStub
import gdscript.index.stub.GdMethodDeclStubImpl
import gdscript.psi.GdMethodDeclTl
import gdscript.psi.GdTypes
import gdscript.psi.utils.PsiGdClassUtil
import gdscript.psi.utils.PsiGdParameterUtil

object GdMethodDeclElementType : IStubElementType<GdMethodDeclStub, GdMethodDeclTl>("methodDecl", GdLanguage) {

    @JvmStatic
    fun getInstance(debugName: String): GdMethodDeclElementType {
        return GdMethodDeclElementType;
    }

    override fun getExternalId(): String = "GdScript.methodDecl";

    override fun serialize(stub: GdMethodDeclStub, dataStream: StubOutputStream) {
        dataStream.writeBoolean(stub.isStatic());
        dataStream.writeBoolean(stub.isVariadic());
        dataStream.writeBoolean(stub.isConstructor());
        dataStream.writeName(stub.name());
        dataStream.writeName(stub.returnType());
        dataStream.writeName(stub.parameters().toString());
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): GdMethodDeclStub =
        GdMethodDeclStubImpl(
            parentStub,
            dataStream.readBoolean(),
            dataStream.readBoolean(),
            dataStream.readBoolean(),
            dataStream.readNameString(),
            dataStream.readNameString() ?: "",
            PsiGdParameterUtil.fromString(dataStream.readNameString()),
        );

    override fun indexStub(stub: GdMethodDeclStub, sink: IndexSink) {
        sink.occurrence(Indices.METHOD_DECL, stub.name());
    }

    override fun createPsi(stub: GdMethodDeclStub): GdMethodDeclTl =
        GdMethodDeclTlImpl(stub, stub.stubType);

    override fun createStub(psi: GdMethodDeclTl, parentStub: StubElement<*>?): GdMethodDeclStub {
        val className = PsiGdClassUtil.getClassName(psi) ?: "";
        var isStatic = false;
        var isVariadic = false;
        psi.children.forEach {
            when (it.elementType) {
                GdTypes.STATIC -> isStatic = true;
                GdTypes.VARARG -> isVariadic = true;
            }
        }

        return GdMethodDeclStubImpl(parentStub,
            isStatic,
            isVariadic,
            psi.name == className || psi.name == "_init",
            psi.name,
            psi.returnType,
            psi.parameters);
    }

}
