package superbible5.gltools;

import static superbible5.gltools.GLMatrixStack.GLT_STACK_ERROR.*;
import static superbible5.gltools.Math3D.*;

public class GLMatrixStack {

	public static enum GLT_STACK_ERROR
	{
		GLT_STACK_NOERROR, GLT_STACK_OVERFLOW, GLT_STACK_UNDERFLOW
	}

	private final int stackDepth;
	private final float[][] pStack;

	private int stackPointer = 0;
	private GLT_STACK_ERROR lastError;


	public GLMatrixStack()
	{
		this(64);
	}


	public GLMatrixStack(int stackDepth)
	{
		this.stackDepth = stackDepth;
		this.pStack = M3DMatrix44fArray(stackDepth);
		m3dLoadIdentity44(pStack[0]);
	}


	public void LoadIdentity()
	{
		m3dLoadIdentity44(pStack[stackPointer]);
	}


	public void LoadMatrix(float[] mat4)
	{
		m3dCopyMatrix44(pStack[stackPointer], mat4);
	}


	public void LoadMatrix(GLFrame frame)
	{
		float[] m = M3DMatrix44f();
		frame.GetMatrix(m);
		LoadMatrix(m);
	}


	public void MultMatrix(float[] mMatrix)
	{
		float[] mTemp = M3DMatrix44f();
		m3dCopyMatrix44(mTemp, pStack[stackPointer]);
		m3dMatrixMultiply44(pStack[stackPointer], mTemp, mMatrix);
	}


	public void MultMatrix(GLFrame frame)
	{
		float[] m = M3DMatrix44f();
		frame.GetMatrix(m);
		MultMatrix(m);
	}


	public void PushMatrix()
	{
		if (stackPointer < stackDepth) {
			stackPointer++;
			m3dCopyMatrix44(pStack[stackPointer], pStack[stackPointer - 1]);
		}
		else {
			lastError = GLT_STACK_OVERFLOW;
		}
	}


	public void PopMatrix()
	{
		if (stackPointer > 0) {
			stackPointer--;
		}
		else {
			lastError = GLT_STACK_UNDERFLOW;
		}
	}


	public void Scale(float x, float y, float z)
	{
		float[] mTemp = M3DMatrix44f();
		float[] mScale = M3DMatrix44f();
		m3dScaleMatrix44(mScale, x, y, z);
		m3dCopyMatrix44(mTemp, pStack[stackPointer]);
		m3dMatrixMultiply44(pStack[stackPointer], mTemp, mScale);
	}


	public void Translate(float x, float y, float z)
	{
		float[] mTemp = M3DMatrix44f();
		float[] mScale = M3DMatrix44f();
		m3dTranslationMatrix44(mScale, x, y, z);
		m3dCopyMatrix44(mTemp, pStack[stackPointer]);
		m3dMatrixMultiply44(pStack[stackPointer], mTemp, mScale);
	}


	public void Rotate(float angle, float x, float y, float z)
	{
		float[] mTemp = M3DMatrix44f();
		float[] mRotate = M3DMatrix44f();
		m3dRotationMatrix44(mRotate, m3dDegToRad(angle), x, y, z);
		m3dCopyMatrix44(mTemp, pStack[stackPointer]);
		m3dMatrixMultiply44(pStack[stackPointer], mTemp, mRotate);
	}


	public void Scalev(float[] vec3Scale)
	{
		float[] mTemp = M3DMatrix44f();
		float[] mScale = M3DMatrix44f();
		m3dScaleMatrix44(mScale, vec3Scale);
		m3dCopyMatrix44(mTemp, pStack[stackPointer]);
		m3dMatrixMultiply44(pStack[stackPointer], mTemp, mScale);
	}


	public void Translatev(float[] vev3Translate)
	{
		float[] mTemp = M3DMatrix44f();
		float[] mTranslate = M3DMatrix44f();
		m3dLoadIdentity44(mTranslate);
		m3dSetMatrixColumn44(mTranslate, vev3Translate, 3);
		m3dCopyMatrix44(mTemp, pStack[stackPointer]);
		m3dMatrixMultiply44(pStack[stackPointer], mTemp, mTranslate);
	}


	public void Rotatev(float angle, float[] vec3Axis)
	{
		float[] mTemp = M3DMatrix44f();
		float[] mRotation = M3DMatrix44f();
		m3dRotationMatrix44(mRotation, m3dDegToRad(angle), vec3Axis[0], vec3Axis[1], vec3Axis[2]);
		m3dCopyMatrix44(mTemp, pStack[stackPointer]);
		m3dMatrixMultiply44(pStack[stackPointer], mTemp, mRotation);
	}


	public void PushMatrix(float[] mMatrix)
	{
		if (stackPointer < stackDepth) {
			stackPointer++;
			m3dCopyMatrix44(pStack[stackPointer], mMatrix);
		}
		else {
			lastError = GLT_STACK_OVERFLOW;
		}
	}


	public void PushMatrix(GLFrame frame)
	{
		float[] m = M3DMatrix44f();
		frame.GetMatrix(m);
		PushMatrix(m);
	}


	public float[] GetMatrix()
	{
		return pStack[stackPointer];
	}


	public void GetMatrix(float[] mMatrix)
	{
		m3dCopyMatrix44(mMatrix, pStack[stackPointer]);
	}


	public GLT_STACK_ERROR GetLastError()
	{
		GLT_STACK_ERROR retval = lastError;
		lastError = GLT_STACK_NOERROR;
		return retval;
	}
}
