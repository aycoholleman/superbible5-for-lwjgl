package superbible5.gltools;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static superbible5.gltools.C2J.*;
import static superbible5.gltools.GLTools.*;

import java.util.HashMap;

public class GLShaderManager {

	public static final int GLT_SHADER_IDENTITY = 0;
	public static final int GLT_SHADER_FLAT = 1;
	public static final int GLT_SHADER_SHADED = 2;
	public static final int GLT_SHADER_DEFAULT_LIGHT = 3;
	public static final int GLT_SHADER_POINT_LIGHT_DIFF = 4;
	public static final int GLT_SHADER_TEXTURE_REPLACE = 5;
	public static final int GLT_SHADER_TEXTURE_MODULATE = 6;
	public static final int GLT_SHADER_TEXTURE_POINT_LIGHT_DIFF = 7;
	public static final int GLT_SHADER_TEXTURE_RECT_REPLACE = 8;
	public static final int GLT_SHADER_LAST = 9;

	public static final int GLT_ATTRIBUTE_VERTEX = 0;
	public static final int GLT_ATTRIBUTE_COLOR = 1;
	public static final int GLT_ATTRIBUTE_NORMAL = 2;
	public static final int GLT_ATTRIBUTE_TEXTURE0 = 3;
	public static final int GLT_ATTRIBUTE_TEXTURE1 = 4;
	public static final int GLT_ATTRIBUTE_TEXTURE2 = 5;
	public static final int GLT_ATTRIBUTE_TEXTURE3 = 6;
	public static final int GLT_ATTRIBUTE_LAST = 7;

	public static class ShaderLookupEntry {
		String szVertexShaderName;
		String szFragShaderName;
		int uiShaderID;
	}

	private final HashMap<String, ShaderLookupEntry> programs = new HashMap<>();
	private final int[] uiStockShaders = new int[GLT_SHADER_LAST];

	private String szIdentityShaderVP = "identity.vertex.glsl";
	private String szIdentityShaderFP = "identity.fragment.glsl";
	private String szFlatShaderVP = "flat.vertex.glsl";
	private String szFlatShaderFP = "flat.fragment.glsl";
	private String szShadedVP = "shaded.vertex.glsl";
	private String szShadedFP = "shaded.fragment.glsl";
	private String szDefaultLightVP = "default-light.vertex.glsl";
	private String szDefaultLightFP = "default-light.fragment.glsl";
	private String szPointLightDiffVP = "point-light.vertex.glsl";
	private String szPointLightDiffFP = "point-light.fragment.glsl";
	private String szTextureReplaceVP = "texture-replace.vertex.glsl";
	private String szTextureReplaceFP = "texture-replace.fragment.glsl";
	private String szTextureModulateVP = "texture-modulate.vertex.glsl";
	private String szTextureModulateFP = "texture-modulate.fragment.glsl";
	private String szTexturePointLightDiffVP = "texture-point-light.vertex.glsl";
	private String szTexturePointLightDiffFP = "texture-point-light.fragment.glsl";
	private String szTextureRectReplaceVP = "texture-rect-replace.vertex.glsl";
	private String szTextureRectReplaceFP = "texture-rect-replace.fragment.glsl";


	public GLShaderManager()
	{
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void finalize()
	{
		if (uiStockShaders[0] != 0) {
			for (int i = 0; i < GLT_SHADER_LAST; ++i) {
				glDeleteProgram(uiStockShaders[i]);
			}
		}
	}


	///////////////////////////////////////////////////////////////////////
	//Use a specific stock shader, and set the appropriate uniforms
	public int UseStockShader(final int nShaderID, Object... uniforms)
	{
		// Check for out of bounds
		if (nShaderID >= GLT_SHADER_LAST)
			return -1;

		// Bind to the correct shader
		glUseProgram(uiStockShaders[nShaderID]);

		// Set up the uniforms
		int iTransform, iModelMatrix, iProjMatrix, iColor, iLight, iTextureUnit;
		int iInteger;

		float[] mvpMatrix; //mat4x4
		float[] pMatrix; //mat4x4
		float[] mvMatrix; //mat4x4
		float[] vColor; //vec4
		float[] vLightPos; //vec3

		switch (nShaderID) {

			case GLT_SHADER_FLAT: // Just the modelview projection matrix and the color
				iTransform = glGetUniformLocation(uiStockShaders[nShaderID], "mvpMatrix");
				mvpMatrix = (float[]) uniforms[0];
				glUniformMatrix4(iTransform, false, buffer(mvpMatrix));

				iColor = glGetUniformLocation(uiStockShaders[nShaderID], "vColor");
				vColor = (float[]) uniforms[1];
				glUniform4(iColor, buffer(vColor));
				break;

			case GLT_SHADER_TEXTURE_RECT_REPLACE:
			case GLT_SHADER_TEXTURE_REPLACE: // Just the texture place
				iTransform = glGetUniformLocation(uiStockShaders[nShaderID], "mvpMatrix");
				mvpMatrix = (float[]) uniforms[0];
				glUniformMatrix4(iTransform, false, buffer(mvpMatrix));

				iTextureUnit = glGetUniformLocation(uiStockShaders[nShaderID], "textureUnit0");
				iInteger = (int) uniforms[1];
				glUniform1i(iTextureUnit, iInteger);
				break;

			case GLT_SHADER_TEXTURE_MODULATE: // Multiply the texture by the geometry color
				iTransform = glGetUniformLocation(uiStockShaders[nShaderID], "mvpMatrix");
				mvpMatrix = (float[]) uniforms[0];
				glUniformMatrix4(iTransform, false, buffer(mvpMatrix));

				iColor = glGetUniformLocation(uiStockShaders[nShaderID], "vColor");
				vColor = (float[]) uniforms[1];
				glUniform4(iColor, buffer(vColor));

				iTextureUnit = glGetUniformLocation(uiStockShaders[nShaderID], "textureUnit0");
				iInteger = (int) uniforms[2];
				glUniform1i(iTextureUnit, iInteger);
				break;

			case GLT_SHADER_DEFAULT_LIGHT:
				iModelMatrix = glGetUniformLocation(uiStockShaders[nShaderID], "mvMatrix");
				mvMatrix = (float[]) uniforms[0];
				glUniformMatrix4(iModelMatrix, false, buffer(mvMatrix));

				iProjMatrix = glGetUniformLocation(uiStockShaders[nShaderID], "pMatrix");
				pMatrix = (float[]) uniforms[1];
				glUniformMatrix4(iProjMatrix, false, buffer(pMatrix));

				iColor = glGetUniformLocation(uiStockShaders[nShaderID], "vColor");
				vColor = (float[]) uniforms[2];
				glUniform4(iColor, buffer(vColor));
				break;

			case GLT_SHADER_POINT_LIGHT_DIFF:
				iModelMatrix = glGetUniformLocation(uiStockShaders[nShaderID], "mvMatrix");
				mvMatrix = (float[]) uniforms[0];
				glUniformMatrix4(iModelMatrix, false, buffer(mvMatrix));

				iProjMatrix = glGetUniformLocation(uiStockShaders[nShaderID], "pMatrix");
				pMatrix = (float[]) uniforms[1];
				glUniformMatrix4(iProjMatrix, false, buffer(pMatrix));

				iLight = glGetUniformLocation(uiStockShaders[nShaderID], "vLightPos");
				vLightPos = (float[]) uniforms[2];
				glUniform3(iLight, buffer(vLightPos));

				iColor = glGetUniformLocation(uiStockShaders[nShaderID], "vColor");
				vColor = (float[]) uniforms[3];
				glUniform4(iColor, buffer(vColor));
				break;

			case GLT_SHADER_TEXTURE_POINT_LIGHT_DIFF:
				iModelMatrix = glGetUniformLocation(uiStockShaders[nShaderID], "mvMatrix");
				mvMatrix = (float[]) uniforms[0];
				glUniformMatrix4(iModelMatrix, false, buffer(mvMatrix));

				iProjMatrix = glGetUniformLocation(uiStockShaders[nShaderID], "pMatrix");
				pMatrix = (float[]) uniforms[1];
				glUniformMatrix4(iProjMatrix, false, buffer(pMatrix));

				iLight = glGetUniformLocation(uiStockShaders[nShaderID], "vLightPos");
				vLightPos = (float[]) uniforms[2];
				glUniform3(iLight, buffer(vLightPos));

				iColor = glGetUniformLocation(uiStockShaders[nShaderID], "vColor");
				vColor = (float[]) uniforms[3];
				glUniform4(iColor, buffer(vColor));

				iTextureUnit = glGetUniformLocation(uiStockShaders[nShaderID], "textureUnit0");
				iInteger = (int) uniforms[4];
				glUniform1i(iTextureUnit, iInteger);
				break;

			case GLT_SHADER_SHADED: // Just the modelview projection matrix. Color is an attribute
				iTransform = glGetUniformLocation(uiStockShaders[nShaderID], "mvpMatrix");
				pMatrix = (float[]) uniforms[0];
				glUniformMatrix4(iTransform, false, buffer(pMatrix));
				break;

			case GLT_SHADER_IDENTITY: // Just the Color
				iColor = glGetUniformLocation(uiStockShaders[nShaderID], "vColor");
				vColor = (float[]) uniforms[3];
				glUniform4(iColor, buffer(vColor));
				break;
		}

		return uiStockShaders[nShaderID];
	}


	public boolean InitializeStockShaders()
	{
		// Be warned, going over 128 shaders may cause a
		// hickup for a reallocation.
		//	shaderTable.reserve(128);

		uiStockShaders[GLT_SHADER_IDENTITY] = gltLoadShaderPairSrcWithAttributes(szIdentityShaderVP,
				szIdentityShaderFP, GLT_ATTRIBUTE_VERTEX, "vVertex");

		uiStockShaders[GLT_SHADER_FLAT] = gltLoadShaderPairSrcWithAttributes(szFlatShaderVP, szFlatShaderFP,
				GLT_ATTRIBUTE_VERTEX, "vVertex");
		uiStockShaders[GLT_SHADER_SHADED] = gltLoadShaderPairSrcWithAttributes(szShadedVP, szShadedFP,
				GLT_ATTRIBUTE_VERTEX, "vVertex", GLT_ATTRIBUTE_COLOR, "vColor");

		uiStockShaders[GLT_SHADER_DEFAULT_LIGHT] = gltLoadShaderPairSrcWithAttributes(szDefaultLightVP,
				szDefaultLightFP, GLT_ATTRIBUTE_VERTEX, "vVertex", GLT_ATTRIBUTE_NORMAL, "vNormal");

		uiStockShaders[GLT_SHADER_POINT_LIGHT_DIFF] = gltLoadShaderPairSrcWithAttributes(szPointLightDiffVP,
				szPointLightDiffFP, GLT_ATTRIBUTE_VERTEX, "vVertex", GLT_ATTRIBUTE_NORMAL, "vNormal");

		uiStockShaders[GLT_SHADER_TEXTURE_REPLACE] = gltLoadShaderPairSrcWithAttributes(szTextureReplaceVP,
				szTextureReplaceFP, GLT_ATTRIBUTE_VERTEX, "vVertex", GLT_ATTRIBUTE_TEXTURE0, "vTexCoord0");

		uiStockShaders[GLT_SHADER_TEXTURE_MODULATE] = gltLoadShaderPairSrcWithAttributes(szTextureModulateVP,
				szTextureModulateFP, GLT_ATTRIBUTE_VERTEX, "vVertex", GLT_ATTRIBUTE_TEXTURE0, "vTexCoord0");

		uiStockShaders[GLT_SHADER_TEXTURE_POINT_LIGHT_DIFF] = gltLoadShaderPairSrcWithAttributes(
				szTexturePointLightDiffVP, szTexturePointLightDiffFP, GLT_ATTRIBUTE_VERTEX, "vVertex",
				GLT_ATTRIBUTE_NORMAL, "vNormal", GLT_ATTRIBUTE_TEXTURE0, "vTexCoord0");

		uiStockShaders[GLT_SHADER_TEXTURE_RECT_REPLACE] = gltLoadShaderPairSrcWithAttributes(
				szTextureRectReplaceVP, szTextureRectReplaceFP, GLT_ATTRIBUTE_VERTEX, "vVertex",
				GLT_ATTRIBUTE_TEXTURE0, "vTexCoord0");

		if (uiStockShaders[0] != 0)
			return true;

		return false;
	}


	public int GetStockShader(int nShaderID)
	{
		if (nShaderID >= GLT_SHADER_LAST)
			return 0;

		return uiStockShaders[nShaderID];
	}

}
