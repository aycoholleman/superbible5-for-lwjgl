package superbible5.gltools;

import static superbible5.gltools.Math3D.*;

public class GLGeometryTransform {

	private float[] _mModelViewProjection = M3DMatrix44f();
	private float[] _mNormalMatrix = M3DMatrix33f();

	private GLMatrixStack _mModelView;
	private GLMatrixStack _mProjection;


	public GLGeometryTransform()
	{
	}


	void SetModelViewMatrixStack(GLMatrixStack mModelView)
	{
		_mModelView = mModelView;
	}


	void SetProjectionMatrixStack(GLMatrixStack mProjection)
	{
		_mProjection = mProjection;
	}


	void SetMatrixStacks(GLMatrixStack mModelView, GLMatrixStack mProjection)
	{
		_mModelView = mModelView;
		_mProjection = mProjection;
	}


	float[] /* mat4 */GetModelViewProjectionMatrix()
	{
		m3dMatrixMultiply44(_mModelViewProjection, _mProjection.GetMatrix(), _mModelView.GetMatrix());
		return _mModelViewProjection;
	}


	float[] /* mat4 */GetModelViewMatrix()
	{
		return _mModelView.GetMatrix();
	}


	float[] /* mat3 */GetNormalMatrix(boolean bNormalize)
	{
		m3dExtractRotationMatrix33(_mNormalMatrix, GetModelViewMatrix());
		if (bNormalize) {
			m3dNormalizeVector3(_mNormalMatrix, 0);
			m3dNormalizeVector3(_mNormalMatrix, 3);
			m3dNormalizeVector3(_mNormalMatrix, 6);
		}
		return _mNormalMatrix;
	}
}
