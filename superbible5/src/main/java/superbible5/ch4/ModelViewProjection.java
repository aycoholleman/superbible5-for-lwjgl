package superbible5.ch4;

import static org.lwjgl.opengl.GL11.*;
import static superbible5.gltools.GLShaderManager.*;
import static superbible5.gltools.GLTools.*;
import static superbible5.gltools.Math3D.*;
//import static org.lwjgl.opengl.GL13.*;
//import static org.lwjgl.opengl.GL15.*;
//import static org.lwjgl.opengl.GL20.*;
//import static org.lwjgl.opengl.GL30.*;
import superbible5.gltools.GLFrustum;
import superbible5.gltools.GLShaderManager;
import superbible5.gltools.GLTriangleBatch;

public class ModelViewProjection {

	// Global view frustum class
	GLFrustum viewFrustum = new GLFrustum();

	// The shader manager
	GLShaderManager shaderManager = new GLShaderManager();

	// The torus
	GLTriangleBatch torusBatch = new GLTriangleBatch(10000);


	// Set up the viewport and the projection matrix
	void ChangeSize(int w, int h)
	{
		// Prevent a divide by zero
		if (h == 0)
			h = 1;
		// Set Viewport to window dimensions
		glViewport(0, 0, w, h);
		viewFrustum.SetPerspective(35.0f, (float) w / (float) h, 1.0f, 1000.0f);
	}


	// Called to draw scene
	void RenderScene(float yRot)
	{
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		float[] mTranslate = M3DMatrix44f();
		float[] mRotate = M3DMatrix44f();
		float[] mModelview = M3DMatrix44f();
		float[] mModelViewProjection = M3DMatrix44f();

		// Create a translation matrix to move the torus back and into sight
		m3dTranslationMatrix44(mTranslate, 0.0f, 0.0f, -2.5f);

		// Create a rotation matrix based on the current value of yRot
		m3dRotationMatrix44(mRotate, m3dDegToRad(yRot), 0.0f, 1.0f, 0.0f);

		// Add the rotation to the translation, store the result in mModelView
		m3dMatrixMultiply44(mModelview, mTranslate, mRotate);

		// Add the modelview matrix to the projection matrix, 
		// the final matrix is the ModelViewProjection matrix.
		m3dMatrixMultiply44(mModelViewProjection, viewFrustum.GetProjectionMatrix(), mModelview);

		// Pass this completed matrix to the shader, and render the torus
		float vBlack[] = { 0.0f, 0.0f, 0.0f, 1.0f };
		shaderManager.UseStockShader(GLT_SHADER_FLAT, mModelViewProjection, vBlack);
		torusBatch.Draw();

	}


	void SetupRC()
	{
		// Black background
		glClearColor(0.8f, 0.6f, 0.8f, 1.0f);
		glEnable(GL_DEPTH_TEST);
		shaderManager.InitializeStockShaders();
		// This makes a torus
		gltMakeTorus(torusBatch, 0.4f, 0.15f, 30, 30);
		glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
	}
}
