package superbible5.gltools;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import static superbible5.gltools.GLShaderManager.GLT_SHADER_ATTRIBUTE.*;
import static superbible5.gltools.Math3D.*;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public final class GLTriangleBatch {

	private static final int VERTEX_DATA = 0;
	private static final int NORMAL_DATA = 1;
	private static final int TEXTURE_DATA = 2;
	private static final int INDEX_DATA = 3;

	private int[] pIndexes;
	private Vector3f[] pVerts;
	private Vector3f[] pNorms;
	private Vector2f[] pTexCoords;

	private int nMaxIndexes;
	private int nNumIndexes;
	private int nNumVerts;

	private final IntBuffer bufferObjects = BufferUtils.createIntBuffer(4);
	private int vertexArrayBufferObject;


	public void BeginMesh(int nMaxVerts)
	{
		nMaxIndexes = nMaxVerts;
		nNumIndexes = 0;
		nNumVerts = 0;

		pIndexes = new int[nMaxVerts];
		pVerts = new Vector3f[nMaxIndexes];
		pNorms = new Vector3f[nMaxIndexes];
		pTexCoords = new Vector2f[nMaxIndexes];
	}


	public void AddTriangle(Vector3f[] verts, Vector3f[] vNorms, Vector2f[] vTexCoords)
	{

		float e = 0.00001f;

		vNorms[0].normalise();
		vNorms[1].normalise();
		vNorms[2].normalise();
		
		for (int iVertex = 0; iVertex < 3; iVertex++) {
			int iMatch = 0;
			for (iMatch = 0; iMatch < nNumVerts; ++iMatch) {
				if (
//@formatter:off
					m3dCloseEnough(pVerts[iMatch].x, verts[iVertex].x, e)
					&& m3dCloseEnough(pVerts[iMatch].y, verts[iVertex].y, e)
					&& m3dCloseEnough(pVerts[iMatch].z, verts[iVertex].z, e)
					&& m3dCloseEnough(pNorms[iMatch].x, vNorms[iVertex].x, e)
					&& m3dCloseEnough(pNorms[iMatch].y, vNorms[iVertex].y, e)
					&& m3dCloseEnough(pNorms[iMatch].z, vNorms[iVertex].z, e)
					&& m3dCloseEnough(pTexCoords[iMatch].x, vTexCoords[iVertex].x, e)
					&& m3dCloseEnough(pTexCoords[iMatch].y, vTexCoords[iVertex].y, e))
//@formatter:on
				{
					pIndexes[nNumIndexes] = iMatch;
					nNumIndexes++;
					break;
				}
			}
			if (iMatch == nNumVerts && nNumVerts < nMaxIndexes && nNumIndexes < nMaxIndexes) {
				pVerts[nNumVerts] = verts[iVertex];
				pNorms[nNumVerts] = vNorms[iVertex];
				pTexCoords[nNumVerts] = vTexCoords[iVertex];
				pIndexes[nNumIndexes] = nNumVerts;
				nNumIndexes++;
				nNumVerts++;
			}
		}
	}


	public void End()
	{
		vertexArrayBufferObject = glGenVertexArrays();
		glBindVertexArray(vertexArrayBufferObject);

		// Create the buffer objects
		glGenBuffers(bufferObjects);

		// Copy data to video memory

		// Vertex data
		glBindBuffer(GL_ARRAY_BUFFER, bufferObjects.get(VERTEX_DATA));
		glEnableVertexAttribArray(GLT_ATTRIBUTE_VERTEX.ordinal());
		buffer(pVerts);
		glVertexAttribPointer(GLT_ATTRIBUTE_VERTEX.ordinal(), 3, GL_FLOAT, false, 0, 0);

		// Normal data
		glBindBuffer(GL_ARRAY_BUFFER, bufferObjects.get(NORMAL_DATA));
		glEnableVertexAttribArray(GLT_ATTRIBUTE_NORMAL.ordinal());
		buffer(pNorms);
		glVertexAttribPointer(GLT_ATTRIBUTE_NORMAL.ordinal(), 3, GL_FLOAT, false, 0, 0);

		// Texture coordinates
		glBindBuffer(GL_ARRAY_BUFFER, bufferObjects.get(TEXTURE_DATA));
		glEnableVertexAttribArray(GLT_ATTRIBUTE_TEXTURE0.ordinal());
		buffer(pTexCoords);
		glVertexAttribPointer(GLT_ATTRIBUTE_TEXTURE0.ordinal(), 2, GL_FLOAT, false, 0, 0);

		// Indexes
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, bufferObjects.get(INDEX_DATA));
		buffer(pIndexes);

		glBindVertexArray(0);

		pIndexes = null;
		pVerts = null;
		pNorms = null;
		pTexCoords = null;

	}


	public void Draw()
	{
		glBindVertexArray(vertexArrayBufferObject);
		glDrawElements(GL_TRIANGLES, nNumIndexes, GL_UNSIGNED_INT, 0);
		glBindVertexArray(vertexArrayBufferObject);
	}


	@Override
	protected void finalize() throws Throwable
	{
		glDeleteBuffers(bufferObjects);
		glDeleteVertexArrays(vertexArrayBufferObject);
	}


	private static void buffer(Vector3f[] vec3Array)
	{
		int size = SIZE_OF_FLOAT * vec3Array.length * 3;
		ByteBuffer buf = BufferUtils.createByteBuffer(size);
		FloatBuffer fbuf = buf.asFloatBuffer();
		for (Vector3f vec3 : vec3Array) {
			fbuf.put(vec3.x);
			fbuf.put(vec3.y);
			fbuf.put(vec3.z);
		}
		glBufferData(GL_ARRAY_BUFFER, size, buf, GL_STATIC_DRAW);
	}


	private static void buffer(Vector2f[] vec2Array)
	{
		int size = SIZE_OF_FLOAT * vec2Array.length * 2;
		ByteBuffer buf = BufferUtils.createByteBuffer(size);
		FloatBuffer fbuf = buf.asFloatBuffer();
		for (Vector2f vec2 : vec2Array) {
			fbuf.put(vec2.x);
			fbuf.put(vec2.y);
		}
		glBufferData(GL_ARRAY_BUFFER, size, buf, GL_STATIC_DRAW);
	}


	private static void buffer(int[] intArray)
	{
		int size = SIZE_OF_INT * intArray.length;
		ByteBuffer buf = BufferUtils.createByteBuffer(size);
		IntBuffer fbuf = buf.asIntBuffer();
		for (int i : intArray) {
			fbuf.put(i);
		}
		glBufferData(GL_ARRAY_BUFFER, size, buf, GL_STATIC_DRAW);
	}
}
