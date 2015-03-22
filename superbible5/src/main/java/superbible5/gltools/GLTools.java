package superbible5.gltools;

import static superbible5.gltools.Math3D.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class GLTools {

	private GLTools()
	{
	}


	public static void gltMakeTorus(GLTriangleBatch torusBatch, float majorRadius, float minorRadius,
			int numMajor, int numMinor)
	{
		double majorStep = 2D * Math.PI / numMajor;
		double minorStep = 2D * Math.PI / numMinor;
		int i, j;

		torusBatch.BeginMesh(numMajor * (numMinor + 1) * 6);

		for (i = 0; i < numMajor; ++i) {
			double a0 = i * majorStep;
			double a1 = a0 + majorStep;
			float x0 = (float) Math.cos(a0);
			float y0 = (float) Math.sin(a0);
			float x1 = (float) Math.cos(a1);
			float y1 = (float) Math.sin(a1);

			Vector3f[] vVertex = new Vector3f[4];
			Vector3f[] vNormal = new Vector3f[4];
			Vector2f[] vTexture = new Vector2f[4];

			for (j = 0; j <= numMinor; ++j) {
				double b = j * minorStep;
				float c = (float) Math.cos(b);
				float r = minorRadius * c + majorRadius;
				float z = minorRadius * (float) Math.sin(b);

				// First point
				vTexture[0].x = (float) (i) / (float) (numMajor);
				vTexture[0].y = (float) (j) / (float) (numMinor);
				vNormal[0].x = x0 * c;
				vNormal[0].y = y0 * c;
				vNormal[0].z = z / minorRadius;
				vNormal[0].normalise();
				vVertex[0].x = x0 * r;
				vVertex[0].y = y0 * r;
				vVertex[0].z = z;

				// Second point
				vTexture[1].x = (float) (i + 1) / (float) (numMajor);
				vTexture[1].y = (float) (j) / (float) (numMinor);
				vNormal[1].x = x1 * c;
				vNormal[1].y = y1 * c;
				vNormal[1].z = z / minorRadius;
				vNormal[1].normalise();
				vVertex[1].x = x1 * r;
				vVertex[1].y = y1 * r;
				vVertex[1].z = z;

				// Next one over
				b = (j + 1) * minorStep;
				c = (float) Math.cos(b);
				r = minorRadius * c + majorRadius;
				z = minorRadius * (float) Math.sin(b);

				// Third (based on first)
				vTexture[2].x = (float) (i) / (float) (numMajor);
				vTexture[2].y = (float) (j + 1) / (float) (numMinor);
				vNormal[2].x = x0 * c;
				vNormal[2].y = y0 * c;
				vNormal[2].z = z / minorRadius;
				vNormal[2].normalise();
				vVertex[2].x = x0 * r;
				vVertex[2].y = y0 * r;
				vVertex[2].z = z;

				// Fourth (based on second)
				vTexture[3].x = (float) (i + 1) / (float) (numMajor);
				vTexture[3].y = (float) (j + 1) / (float) (numMinor);
				vNormal[3].x = x1 * c;
				vNormal[3].y = y1 * c;
				vNormal[3].z = z / minorRadius;
				vNormal[3].normalise();
				vVertex[3].x = x1 * r;
				vVertex[3].y = y1 * r;
				vVertex[3].z = z;

				torusBatch.AddTriangle(vVertex, vNormal, vTexture);

				// Rearrange for next triangle
				memcpy(vVertex[0], vVertex[1], SIZE_OF_VEC3);
				memcpy(vNormal[0], vNormal[1], SIZE_OF_VEC3);
				memcpy(vTexture[0], vTexture[1], SIZE_OF_VEC2);

				memcpy(vVertex[1], vVertex[3], SIZE_OF_VEC3);
				memcpy(vNormal[1], vNormal[3], SIZE_OF_VEC3);
				memcpy(vTexture[1], vTexture[3], SIZE_OF_VEC2);

				torusBatch.AddTriangle(vVertex, vNormal, vTexture);
			}
		}
		torusBatch.End();
	}


	private static void memcpy(Vector3f dest, Vector3f src, int numBytes)
	{
		dest.x = src.x;
		dest.y = src.y;
		dest.z = src.z;
	}


	private static void memcpy(Vector2f dest, Vector2f src, int numBytes)
	{
		dest.x = src.x;
		dest.y = src.y;
	}


	/////////////////////////////////////////////////////////////////
	//Load a pair of shaders, compile, and link together. Specify the complete
	//source code text for each shader. Note, there is no support for
	//just loading say a vertex program... you have to do both.
	int gltLoadShaderPairSrcWithAttributes(String szVertexSrc, String szFragmentSrc, String... attrs)
	{
		// Temporary Shader objects
		int hVertexShader;
		int hFragmentShader;
		int hReturn = 0;

		// Create shader objects
		hVertexShader = glCreateShader(GL_VERTEX_SHADER);
		hFragmentShader = glCreateShader(GL_FRAGMENT_SHADER);

		// Load them. 
		gltLoadShaderSrc(szVertexSrc, hVertexShader);
		gltLoadShaderSrc(szFragmentSrc, hFragmentShader);

		// Compile them
		glCompileShader(hVertexShader);
		glCompileShader(hFragmentShader);

		// Check for errors
		int testVal = glGetShaderi(hVertexShader, GL_COMPILE_STATUS);
		if (testVal == GL_FALSE) {
			glDeleteShader(hVertexShader);
			glDeleteShader(hFragmentShader);
			return 0;
		}

		testVal = glGetShaderi(hFragmentShader, GL_COMPILE_STATUS);
		if (testVal == GL_FALSE) {
			glDeleteShader(hVertexShader);
			glDeleteShader(hFragmentShader);
			return 0;
		}

		// Link them - assuming it works...
		hReturn = glCreateProgram();
		glAttachShader(hReturn, hVertexShader);
		glAttachShader(hReturn, hFragmentShader);

		for (int i = 0; i < attrs.length; ++i) {
			int index = Integer.parseInt(attrs[i]);
			String szNextArg = attrs[i + 1];
			glBindAttribLocation(hReturn, index, szNextArg);
		}

		glLinkProgram(hReturn);

		// These are no longer needed
		glDeleteShader(hVertexShader);
		glDeleteShader(hFragmentShader);

		// Make sure link worked too
		testVal = glGetProgrami(hReturn, GL_LINK_STATUS);
		if (testVal == GL_FALSE) {
			glDeleteProgram(hReturn);
			return 0;
		}

		return hReturn;
	}

	private void gltLoadShaderSrc(String szVertexSrc, int hVertexShader)
	{
		// TODO Auto-generated method stub

	}
}
