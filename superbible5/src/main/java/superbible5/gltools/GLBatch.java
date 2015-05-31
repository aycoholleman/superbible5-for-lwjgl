package superbible5.gltools;

import static org.lwjgl.opengl.GL12.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;
import static superbible5.gltools.Math3D.*;
import static superbible5.gltools.C2J.*;

public class GLBatch {

	int primitiveType; // What am I drawing....

	int uiVertexArray;
	int uiNormalArray;
	int uiColorArray;
	int[] uiTextureCoordArray;
	int vertexArrayObject;

	int nVertsBuilding; // Building up vertexes counter (immediate mode emulator)
	int nNumVerts; // Number of verticies in this batch
	int nNumTextureUnits; // Number of texture coordinate sets

	boolean bBatchDone; // Batch has been built

	float[] pVerts; /* vec3 */
	float[] pNormals; /* vec3 */
	float[] pColors; /* vec4 */
	float[][] pTexCoords; /* vec2 array */


	public GLBatch()
	{
	}


	void Begin(int primitive, int nVerts, int nTextureUnits)
	{
		primitiveType = primitive;
		nNumVerts = nVerts;
		if (nTextureUnits > 4) { // Limit to four texture units
			nTextureUnits = 4;
		}
		nNumTextureUnits = nTextureUnits;
		if (nNumTextureUnits != 0) {
			uiTextureCoordArray = new int[nNumTextureUnits];
			// An array of pointers to texture coordinate arrays
			pTexCoords = M3DVector2fArray(nNumTextureUnits);
			for (int i = 0; i < nNumTextureUnits; i++) {
				uiTextureCoordArray[i] = 0;
				pTexCoords[i] = null;
			}
		}
		vertexArrayObject = glGenVertexArrays();
		glBindVertexArray(vertexArrayObject);
	}


	void CopyVertexData3f(float[] vVerts)
	{
		// First time, create the buffer object, allocate the space
		if (uiVertexArray == 0) {
			uiVertexArray = glGenBuffers();
			glBindBuffer(GL_ARRAY_BUFFER, uiVertexArray);
			glBufferData(GL_ARRAY_BUFFER, buffer(vVerts), GL_DYNAMIC_DRAW);
		}
		else { // Just bind to existing object
			glBindBuffer(GL_ARRAY_BUFFER, uiVertexArray);
			// Copy the data in
			glBufferSubData(GL_ARRAY_BUFFER, 0, buffer(vVerts));
			pVerts = null;
		}
	}

}