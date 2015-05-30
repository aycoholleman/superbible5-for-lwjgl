package superbible5.gltools;

import static java.lang.Math.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static superbible5.gltools.C2J.*;
import static superbible5.gltools.Math3D.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GLTools {

	private static final String ERR_ERROR_IN_SHADER_FILE = "Error compiling shader file %s: %s";
	private static final String ERR_ERROR_CREATING_PROGRAM = "Error creating shader program: %s";


	private GLTools()
	{
	}


	/**
	 * Load a pair of shaders, compile, and link together. Specify the complete
	 * source code text for each shader. Note, there is no support for just
	 * loading say a vertex program... you have to do both.
	 * 
	 * @param szVertexSrc
	 * @param szFragmentSrc
	 * @param attrs
	 * @return
	 */
	public static int gltLoadShaderPairSrcWithAttributes(String szVertexSrc, String szFragmentSrc,
			Object... attrs)
	{

		System.out.println("Loading " + szVertexSrc + ", " + szFragmentSrc);
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
		if (glGetShaderi(hVertexShader, GL_COMPILE_STATUS) == GL_FALSE) {
			String fmt = ERR_ERROR_IN_SHADER_FILE;
			String msg = String.format(fmt, szVertexSrc, glGetShaderInfoLog(hVertexShader, 2048));
			glDeleteShader(hFragmentShader);
			throw new RuntimeException(msg);
		}

		glCompileShader(hFragmentShader);
		if (glGetShaderi(hFragmentShader, GL_COMPILE_STATUS) == GL_FALSE) {
			String fmt = ERR_ERROR_IN_SHADER_FILE;
			String msg = String.format(fmt, szFragmentSrc, glGetShaderInfoLog(hFragmentShader, 2048));
			glDeleteShader(hVertexShader);
			glDeleteShader(hFragmentShader);
			throw new RuntimeException(msg);
		}

		// Link them - assuming it works...
		hReturn = glCreateProgram();
		glAttachShader(hReturn, hVertexShader);
		glAttachShader(hReturn, hFragmentShader);

		for (int i = 0; i < attrs.length; i += 2) {
			int index = (Integer) attrs[i];
			String szNextArg = (String) attrs[i + 1];
			glBindAttribLocation(hReturn, index, szNextArg);
		}

		glLinkProgram(hReturn);

		// These are no longer needed
		glDeleteShader(hVertexShader);
		glDeleteShader(hFragmentShader);

		if (glGetProgrami(hReturn, GL_LINK_STATUS) == GL_FALSE) {
			String msg = String.format(ERR_ERROR_CREATING_PROGRAM, glGetShaderInfoLog(hReturn, 2048));
			glDeleteProgram(hReturn);
			throw new RuntimeException(msg);
		}
		glValidateProgram(hReturn);
		if (glGetProgrami(hReturn, GL_VALIDATE_STATUS) == GL_FALSE) {
			String msg = String.format(ERR_ERROR_CREATING_PROGRAM, glGetShaderInfoLog(hReturn));
			glDeleteProgram(hReturn);
			throw new RuntimeException(msg);
		}

		return hReturn;
	}


	public static void gltMakeTorus(GLTriangleBatch torusBatch, float majorRadius, float minorRadius,
			int numMajor, int numMinor)
	{
		double majorStep = 2.0f * M3D_PI / numMajor;
		double minorStep = 2.0f * M3D_PI / numMinor;
		int i, j;

		torusBatch.BeginMesh(numMajor * (numMinor + 1) * 6);
		for (i = 0; i < numMajor; ++i) {
			double a0 = i * majorStep;
			double a1 = a0 + majorStep;
			float x0 = (float) cos(a0);
			float y0 = (float) sin(a0);
			float x1 = (float) cos(a1);
			float y1 = (float) sin(a1);

			float[][] vVertex = M3DVector3fArray(4);
			float[][] vNormal = M3DVector3fArray(4);
			float[][] vTexture = M3DVector2fArray(4);

			for (j = 0; j <= numMinor; ++j) {
				double b = j * minorStep;
				float c = (float) cos(b);
				float r = minorRadius * c + majorRadius;
				float z = minorRadius * (float) sin(b);

				// First point
				vTexture[0][0] = (float) (i) / (float) (numMajor);
				vTexture[0][1] = (float) (j) / (float) (numMinor);
				vNormal[0][0] = x0 * c;
				vNormal[0][1] = y0 * c;
				vNormal[0][2] = z / minorRadius;
				m3dNormalizeVector3(vNormal[0]);
				vVertex[0][0] = x0 * r;
				vVertex[0][1] = y0 * r;
				vVertex[0][2] = z;

				// Second point
				vTexture[1][0] = (float) (i + 1) / (float) (numMajor);
				vTexture[1][1] = (float) (j) / (float) (numMinor);
				vNormal[1][0] = x1 * c;
				vNormal[1][1] = y1 * c;
				vNormal[1][2] = z / minorRadius;
				m3dNormalizeVector3(vNormal[1]);
				vVertex[1][0] = x1 * r;
				vVertex[1][1] = y1 * r;
				vVertex[1][2] = z;

				// Next one over
				b = (j + 1) * minorStep;
				c = (float) cos(b);
				r = minorRadius * c + majorRadius;
				z = minorRadius * (float) sin(b);

				// Third (based on first)
				vTexture[2][0] = (float) (i) / (float) (numMajor);
				vTexture[2][1] = (float) (j + 1) / (float) (numMinor);
				vNormal[2][0] = x0 * c;
				vNormal[2][1] = y0 * c;
				vNormal[2][2] = z / minorRadius;
				m3dNormalizeVector3(vNormal[2]);
				vVertex[2][0] = x0 * r;
				vVertex[2][1] = y0 * r;
				vVertex[2][2] = z;

				// Fourth (based on second)
				vTexture[3][0] = (float) (i + 1) / (float) (numMajor);
				vTexture[3][1] = (float) (j + 1) / (float) (numMinor);
				vNormal[3][0] = x1 * c;
				vNormal[3][1] = y1 * c;
				vNormal[3][2] = z / minorRadius;
				m3dNormalizeVector3(vNormal[3]);
				vVertex[3][0] = x1 * r;
				vVertex[3][1] = y1 * r;
				vVertex[3][2] = z;

				torusBatch.AddTriangle(vVertex, vNormal, vTexture);

				// Rearrange for next triangle
				memcpy3(vVertex[0], vVertex[1]);
				memcpy3(vNormal[0], vNormal[1]);
				memcpy2(vTexture[0], vTexture[1]);

				memcpy3(vVertex[1], vVertex[3]);
				memcpy3(vNormal[1], vNormal[3]);
				memcpy2(vTexture[1], vTexture[3]);

				torusBatch.AddTriangle(vVertex, vNormal, vTexture);
			}
		}
		torusBatch.End();
	}


	/*
	 * Load shader source from file. The one big diversion from the original C
	 * code, which stores all shader code as string constants within
	 * GLShaderManager.cpp
	 */
	private static void gltLoadShaderSrc(String shaderFile, int shader)
	{
		InputStream is = GLTools.class.getResourceAsStream("/shaders/" + shaderFile);
		String source = fromInputStream(is);
		glShaderSource(shader, source);
	}


	public static String fromInputStream(InputStream is)
	{
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int n;
		byte[] data = new byte[384];
		try {
			while ((n = is.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, n);
			}
			buffer.flush();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		return new String(buffer.toByteArray());
	}
}
