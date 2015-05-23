package superbible5.gltools;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;


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

		for (int i = 0; i < attrs.length; ++i) {
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


	/*
	 * Load shader source from file. The one big diversion from the original C
	 * code! There all stock shader are stored as string constants within
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
