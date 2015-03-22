package superbible5.ch4;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import superbible5.gltools.GLFrustum;
import superbible5.gltools.GLShaderManager;
import superbible5.gltools.GLTriangleBatch;

public class ModelViewProjection {

	// Global view frustum class
	GLFrustum viewFrustum;

	// The shader manager
	GLShaderManager shaderManager;

	// The torus
	GLTriangleBatch torusBatch;


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

}
