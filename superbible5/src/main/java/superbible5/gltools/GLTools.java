package superbible5.gltools;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class GLTools {

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
			int index = (Integer) attrs[i];
			String szNextArg = (String) attrs[i + 1];
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


	/*
	 * Load shader source from file. The one big diversion from the original C
	 * code!!! There all stock shader stored as strings within the
	 * GLShaderManager.cpp
	 */
	private static void gltLoadShaderSrc(String shaderFile, int shader)
	{
		byte[] bytes;
		try {
			bytes = Files.readAllBytes(FileSystems.getDefault().getPath(shaderFile));
			String source = new String(bytes, Charset.forName("UTF-8"));
			glShaderSource(shader, source);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
