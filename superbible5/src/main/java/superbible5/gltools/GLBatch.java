package superbible5.gltools;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL14.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import static superbible5.gltools.Math3D.*;
import static superbible5.gltools.C2J.*;
import static superbible5.gltools.GLTools.*;
import static superbible5.gltools.GLShaderManager.*;

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
			/*
			 * Just really unnecessary in Java: for (int i = 0; i <
			 * nNumTextureUnits; i++) { uiTextureCoordArray[i] = 0;
			 * pTexCoords[i] = null; }
			 */
		}
		vertexArrayObject = glGenVertexArrays();
		glBindVertexArray(vertexArrayObject);
	}


	/**
	 * Block Copy in vertex data
	 * 
	 * @param vVerts
	 *            {@code nNumVerts} of vec3, squashed into a one-dimensional
	 *            array
	 */
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


	/**
	 * Block copy in normal data
	 * 
	 * @param vNorms
	 *            {@code nNumVerts} of vec3, squashed into a one-dimensional
	 *            array
	 */
	void CopyNormalDataf(float[] vNorms)
	{
		// First time, create the buffer object, allocate the space
		if (uiNormalArray == 0) {
			uiNormalArray = glGenBuffers();
			glBindBuffer(GL_ARRAY_BUFFER, uiNormalArray);
			glBufferData(GL_ARRAY_BUFFER, buffer(vNorms), GL_DYNAMIC_DRAW);
		}
		else { // Just bind to existing object
			glBindBuffer(GL_ARRAY_BUFFER, uiNormalArray);
			// Copy the data in
			glBufferSubData(GL_ARRAY_BUFFER, 0, buffer(vNorms));
			pNormals = null;
		}
	}


	/**
	 * Block copy in color data
	 * 
	 * @param vColors
	 *            {@code nNumVerts} of vec4, squashed into a one-dimensional
	 *            array
	 */
	void CopyColorData4f(float[] vColors)
	{
		// First time, create the buffer object, allocate the space
		if (uiColorArray == 0) {
			uiColorArray = glGenBuffers();
			glBindBuffer(GL_ARRAY_BUFFER, uiColorArray);
			glBufferData(GL_ARRAY_BUFFER, buffer(vColors), GL_DYNAMIC_DRAW);
		}
		else { // Just bind to existing object
			glBindBuffer(GL_ARRAY_BUFFER, uiColorArray);
			// Copy the data in
			glBufferSubData(GL_ARRAY_BUFFER, 0, buffer(vColors));
			pColors = null;
		}
	}


	/**
	 * 
	 * @param vTexCoords
	 *            {@code nNumVerts} of vec2, squashed into a one-dimensional
	 *            array
	 * @param uiTextureLayer
	 */
	void CopyTexCoordData2f(float[] vTexCoords, int uiTextureLayer)
	{
		// First time, create the buffer object, allocate the space
		if (uiTextureCoordArray[uiTextureLayer] == 0) {
			uiTextureCoordArray[uiTextureLayer] = glGenBuffers();
			glBindBuffer(GL_ARRAY_BUFFER, uiTextureCoordArray[uiTextureLayer]);
			glBufferData(GL_ARRAY_BUFFER, buffer(vTexCoords), GL_DYNAMIC_DRAW);
		}
		else { // Just bind to existing object
			glBindBuffer(GL_ARRAY_BUFFER, uiTextureCoordArray[uiTextureLayer]);
			// Copy the data in
			glBufferSubData(GL_ARRAY_BUFFER, 0, buffer(vTexCoords));
			pTexCoords[uiTextureLayer] = null;
		}
	}


	// Bind everything up in a little package
	void End()
	{
		// Check to see if items have been added one at a time
		if (pVerts != null) {
			glBindBuffer(GL_ARRAY_BUFFER, uiVertexArray);
			glUnmapBuffer(GL_ARRAY_BUFFER);
			pVerts = null;
		}

		if (pColors != null) {
			glBindBuffer(GL_ARRAY_BUFFER, uiColorArray);
			glUnmapBuffer(GL_ARRAY_BUFFER);
			pColors = null;
		}

		if (pNormals != null) {
			glBindBuffer(GL_ARRAY_BUFFER, uiNormalArray);
			glUnmapBuffer(GL_ARRAY_BUFFER);
			pNormals = null;
		}

		for (int i = 0; i < nNumTextureUnits; i++)
			if (pTexCoords[i] != null) {
				glBindBuffer(GL_ARRAY_BUFFER, uiTextureCoordArray[i]);
				glUnmapBuffer(GL_ARRAY_BUFFER);
				pTexCoords[i] = null;
			}

		// Set up the vertex array object
		glBindVertexArray(vertexArrayObject);

		if (uiVertexArray != 0) {
			glEnableVertexAttribArray(GLT_ATTRIBUTE_VERTEX);
			glBindBuffer(GL_ARRAY_BUFFER, uiVertexArray);
			glVertexAttribPointer(GLT_ATTRIBUTE_VERTEX, 3, GL_FLOAT, false, 0, 0);
		}

		if (uiColorArray != 0) {
			glEnableVertexAttribArray(GLT_ATTRIBUTE_COLOR);
			glBindBuffer(GL_ARRAY_BUFFER, uiColorArray);
			glVertexAttribPointer(GLT_ATTRIBUTE_COLOR, 4, GL_FLOAT, false, 0, 0);
		}

		if (uiNormalArray != 0) {
			glEnableVertexAttribArray(GLT_ATTRIBUTE_NORMAL);
			glBindBuffer(GL_ARRAY_BUFFER, uiNormalArray);
			glVertexAttribPointer(GLT_ATTRIBUTE_NORMAL, 3, GL_FLOAT, false, 0, 0);
		}

		// How many texture units
		for (int i = 0; i < nNumTextureUnits; i++) {
			if (uiTextureCoordArray[i] != 0) {
				glEnableVertexAttribArray(GLT_ATTRIBUTE_TEXTURE0 + i);
				glBindBuffer(GL_ARRAY_BUFFER, uiTextureCoordArray[i]);
				glVertexAttribPointer(GLT_ATTRIBUTE_TEXTURE0 + i, 2, GL_FLOAT, false, 0, 0);
			}
		}

		bBatchDone = true;
		glBindVertexArray(0);
	}

}