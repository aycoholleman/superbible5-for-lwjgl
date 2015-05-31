package superbible5.ch4;

import superbible5.gltools.GLFrame;
import superbible5.gltools.GLFrustum;
import superbible5.gltools.GLGeometryTransform;
import superbible5.gltools.GLMatrixStack;
import superbible5.gltools.GLShaderManager;

public class Perspective {
	
	GLFrame             viewFrame;
	GLFrustum           viewFrustum;
	//GLBatch             tubeBatch;
	//GLBatch             innerBatch;
	GLMatrixStack       modelViewMatix;
	GLMatrixStack       projectionMatrix;
	GLGeometryTransform transformPipeline;
	GLShaderManager     shaderManager;


	public Perspective()
	{
		// TODO Auto-generated constructor stub
	}

}
