package superbible5.gltools;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import static superbible5.gltools.C2J.*;
import static superbible5.gltools.GLShaderManager.*;
import static superbible5.gltools.Math3D.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;

public class GLTriangleBatch {

	private static final int VERTEX_DATA = 0;
	private static final int NORMAL_DATA = 1;
	private static final int TEXTURE_DATA = 2;
	private static final int INDEX_DATA = 3;

	private int[] pIndexes;
	// Array of vec3
	private float[][] pVerts;
	// Array of vec3
	private float[][] pNorms;
	// Array of vec2
	private float[][] pTexCoords;

	// LWJGL ultimately needs FloatBuffers rather than arrays ...
	private final IntBuffer pIndexesBuffer;
	private final FloatBuffer pVertsBuffer;
	private final FloatBuffer pNormsBuffer;
	private final FloatBuffer pTexCoordsBuffer;

	private int nMaxIndexes;
	private int nNumIndexes;
	private int nNumVerts;

	private final IntBuffer bufferObjects = BufferUtils.createIntBuffer(4);
	private int vertexArrayBufferObject;


	/**
	 * Constructor. In our Java adaptation it is the constructor that takes the
	 * {@code nMaxVerts} argument (the maximum number of vertices you expect the
	 * triangle batch to have), and not the {@link #BeginMesh(int)} method. This
	 * is because LWJGL ultimately wants {@code java.nio.Buffer} objects to pass
	 * on to OpenGL. We want those objects to be long-lived, rather than be
	 * destroyed and re-created by each call to {@code BeginMesh} .
	 * 
	 * @param nMaxVerts
	 */
	public GLTriangleBatch(int nMaxVerts)
	{
		nMaxIndexes = nMaxVerts;
		/*
		 * In reality, the other arrays will be much shorter than the index
		 * array
		 */
		pIndexes = new int[nMaxIndexes];
		pVerts = M3DVector3fArray(nMaxIndexes);
		pNorms = M3DVector3fArray(nMaxIndexes);
		pTexCoords = M3DVector2fArray(nMaxIndexes);
		pIndexesBuffer = BufferUtils.createIntBuffer(nMaxVerts);
		pVertsBuffer = BufferUtils.createFloatBuffer(nMaxVerts * 3);
		pNormsBuffer = BufferUtils.createFloatBuffer(nMaxVerts * 3);
		pTexCoordsBuffer = BufferUtils.createFloatBuffer(nMaxVerts * 2);
	}


	@Override
	protected void finalize()
	{
		glDeleteBuffers(bufferObjects);
		glDeleteVertexArrays(vertexArrayBufferObject);
	}


	/*
	 * Start assembling a mesh. You need to specify a maximum amount of indexes
	 * that you expect. The EndMesh will clean up any uneeded memory. This is
	 * far better than shreading your heap with STL containers... At least
	 * that's my humble opinion.
	 */
	public void BeginMesh(int maxVerts)
	{
		if (maxVerts > nMaxIndexes) {
			throw new RuntimeException("Too many vertices for this triangle batch");
		}
		nNumIndexes = 0;
		nNumVerts = 0;
		pIndexesBuffer.clear();
		pVertsBuffer.clear();
		pNormsBuffer.clear();
		pTexCoordsBuffer.clear();
	}


	// Add a triangle to the mesh. This searches the current list for identical
	// (well, almost identical - these are floats you know...) verts. If one is found, it
	// is added to the index array. If not, it is added to both the index array and the vertex
	// array grows by one as well.
	public void AddTriangle(float[][] verts, float[][] vNorms, float[][] vTexCoords)
	{
		float e = 0.00001f; // How small a difference to equate

		// First thing we do is make sure the normals are unit length!
		// It's almost always a good idea to work with pre-normalized normals
		m3dNormalizeVector3(vNorms[0]);
		m3dNormalizeVector3(vNorms[1]);
		m3dNormalizeVector3(vNorms[2]);

		// Search for match - triangle consists of three verts
		for (int iVertex = 0; iVertex < 3; iVertex++) {
			int iMatch = 0;
			for (iMatch = 0; iMatch < nNumVerts; iMatch++) {
				// If the vertex positions are the same
				if (m3dCloseEnough(pVerts[iMatch][0], verts[iVertex][0], e)
						&& m3dCloseEnough(pVerts[iMatch][1], verts[iVertex][1], e)
						&& m3dCloseEnough(pVerts[iMatch][2], verts[iVertex][2], e)
						&&

						// AND the Normal is the same...
						m3dCloseEnough(pNorms[iMatch][0], vNorms[iVertex][0], e)
						&& m3dCloseEnough(pNorms[iMatch][1], vNorms[iVertex][1], e)
						&& m3dCloseEnough(pNorms[iMatch][2], vNorms[iVertex][2], e)
						&&

						// And Texture is the same...
						m3dCloseEnough(pTexCoords[iMatch][0], vTexCoords[iVertex][0], e)
						&& m3dCloseEnough(pTexCoords[iMatch][1], vTexCoords[iVertex][1], e)) {
					// Then add the index only
					pIndexes[nNumIndexes] = iMatch;
					nNumIndexes++;
					break;
				}
			}

			// No match for this vertex, add to end of list
			if (iMatch == nNumVerts && nNumVerts < nMaxIndexes && nNumIndexes < nMaxIndexes) {
				memcpy3(pVerts[nNumVerts], verts[iVertex]);
				memcpy3(pNorms[nNumVerts], vNorms[iVertex]);
				memcpy2(pTexCoords[nNumVerts], vTexCoords[iVertex]);
				pIndexes[nNumIndexes] = nNumVerts;
				nNumIndexes++;
				nNumVerts++;
			}
		}
	}


	/**
	 * Compact the data. This is a nice utility, but you should really save the
	 * results of the indexing for future use if the model data is static
	 * (doesn't change).
	 * 
	 */
	public void End()
	{
		vertexArrayBufferObject = glGenVertexArrays();
		glBindVertexArray(vertexArrayBufferObject);

		// Create the buffer objects
		glGenBuffers(bufferObjects);

		// Copy data to video memory
		// Vertex data
		glBindBuffer(GL_ARRAY_BUFFER, bufferObjects.get(VERTEX_DATA));
		glEnableVertexAttribArray(GLT_ATTRIBUTE_VERTEX);
		bufferVectors3(pVertsBuffer, pVerts);
		glBufferData(GL_ARRAY_BUFFER, pVertsBuffer, GL_STATIC_DRAW);
		glVertexAttribPointer(GLT_ATTRIBUTE_VERTEX, 3, GL_FLOAT, false, 0, 0);

		// Normal data
		glBindBuffer(GL_ARRAY_BUFFER, bufferObjects.get(NORMAL_DATA));
		glEnableVertexAttribArray(GLT_ATTRIBUTE_NORMAL);
		bufferVectors3(pNormsBuffer, pNorms);
		glBufferData(GL_ARRAY_BUFFER, pNormsBuffer, GL_STATIC_DRAW);
		glVertexAttribPointer(GLT_ATTRIBUTE_NORMAL, 3, GL_FLOAT, false, 0, 0);

		// Texture coordinates
		glBindBuffer(GL_ARRAY_BUFFER, bufferObjects.get(TEXTURE_DATA));
		glEnableVertexAttribArray(GLT_ATTRIBUTE_TEXTURE0);
		bufferVec2Array(pTexCoordsBuffer, pTexCoords);
		glBufferData(GL_ARRAY_BUFFER, pTexCoordsBuffer, GL_STATIC_DRAW);
		glVertexAttribPointer(GLT_ATTRIBUTE_TEXTURE0, 2, GL_FLOAT, false, 0, 0);

		// Indexes
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, bufferObjects.get(INDEX_DATA));
		buffer(pIndexesBuffer, pIndexes);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, pIndexesBuffer, GL_STATIC_DRAW);

		glBindVertexArray(0);
		glBindVertexArray(0);
	}


	/**
	 * Draw. Make sure you call glEnableClientState for these arrays
	 */
	public void Draw()
	{
		glBindVertexArray(vertexArrayBufferObject);
		glDrawElements(GL_TRIANGLES, nNumIndexes, GL_UNSIGNED_SHORT, 0);
		glBindVertexArray(vertexArrayBufferObject);
	}
}
