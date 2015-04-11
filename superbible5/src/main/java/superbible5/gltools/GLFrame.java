package superbible5.gltools;

import static superbible5.gltools.C2J.*;
import static superbible5.gltools.Math3D.*;

public class GLFrame {

	/*
	 * Where am I?
	 */
	private final float[] vec3Origin;
	/*
	 * Where am I going?
	 */
	private final float[] vec3Forward;
	/*
	 * Which way is up?
	 */
	private final float[] vec3Up;


	public GLFrame()
	{
		// At origin
		vec3Origin = M3DVector3f();
		// Forward is -Z (default OpenGL)
		vec3Forward = M3DVector3f(0, 0, -1f);
		// Up is up (+Y)
		vec3Up = M3DVector3f(0, 1f, 0);
	}


	/**
	 * Set location
	 * 
	 * @param vec3
	 */
	void SetOrigin(float[] vec3)
	{
		m3dCopyVector3(vec3Origin, vec3);
	}


	void SetOrigin(float x, float y, float z)
	{
		vec3Origin[0] = x;
		vec3Origin[1] = y;
		vec3Origin[2] = z;
	}


	void GetOrigin(float[] vec3)
	{
		m3dCopyVector3(vec3, vec3Origin);
	}


	float GetOriginX()
	{
		return vec3Origin[0];
	}


	float GetOriginY()
	{
		return vec3Origin[1];
	}


	float GetOriginZ()
	{
		return vec3Origin[2];
	}


	/**
	 * Set Forward Direction.
	 * 
	 * @param vec3
	 */
	void SetForwardVector(float[] vec3)
	{
		m3dCopyVector3(vec3Forward, vec3);
	}


	void SetForwardVector(float x, float y, float z)
	{
		vec3Forward[0] = x;
		vec3Forward[1] = y;
		vec3Forward[2] = z;
	}


	void GetForwardVector(float[] vec3)
	{
		m3dCopyVector3(vec3, vec3Forward);
	}


	/**
	 * Set Up Direction
	 * 
	 * @param vec3
	 */
	void SetUpVector(float[] vec3)
	{
		m3dCopyVector3(vec3Up, vec3);
	}


	void SetUpVector(float x, float y, float z)
	{
		vec3Up[0] = x;
		vec3Up[1] = y;
		vec3Up[2] = z;
	}


	void GetUpVector(float[] vVector)
	{
		m3dCopyVector3(vVector, vec3Up);
	}


	void GetZAxis(float[] vec3)
	{
		GetForwardVector(vec3);
	}


	void GetYAxis(float[] vec3)
	{
		GetUpVector(vec3);
	}


	void GetXAxis(float[] vVector)
	{
		m3dCrossProduct3(vVector, vec3Up, vec3Forward);
	}


	/**
	 * Translate along orthonormal axis... world or local
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	void TranslateWorld(float x, float y, float z)
	{
		vec3Origin[0] += x;
		vec3Origin[1] += y;
		vec3Origin[2] += z;
	}


	void TranslateLocal(float x, float y, float z)
	{
		MoveForward(z);
		MoveUp(y);
		MoveRight(x);
	}


	/**
	 * Move along Z axis (forward is positive).
	 * 
	 * @param delta
	 */
	void MoveForward(float delta)
	{
		vec3Origin[0] += vec3Forward[0] * delta;
		vec3Origin[1] += vec3Forward[1] * delta;
		vec3Origin[2] += vec3Forward[2] * delta;
	}


	/**
	 * Move along Y axis.
	 * 
	 * @param delta
	 */
	void MoveUp(float delta)
	{
		vec3Origin[0] += vec3Up[0] * delta;
		vec3Origin[1] += vec3Up[1] * delta;
		vec3Origin[2] += vec3Up[2] * delta;
	}


	/**
	 * Move along X axis
	 * 
	 * @param delta
	 */
	void MoveRight(float delta)
	{
		float[] vCross = M3DVector3f();
		m3dCrossProduct3(vCross, vec3Up, vec3Forward);
		vec3Origin[0] += vCross[0] * delta;
		vec3Origin[1] += vCross[1] * delta;
		vec3Origin[2] += vCross[2] * delta;
	}


	/**
	 * Assemble the matrix
	 * 
	 * @param mat44
	 * @param bRotationOnly
	 */
	void GetMatrix(float[] mat44, boolean bRotationOnly)
	{
		// Calculate the right side (x) vector, drop it right into the matrix
		float[] vXAxis = M3DVector3f();
		m3dCrossProduct3(vXAxis, vec3Up, vec3Forward);

		// Set matrix column does not fill in the fourth value...
		m3dSetMatrixColumn44(mat44, vXAxis, 0);
		mat44[3] = 0.0f;

		// Y Column
		m3dSetMatrixColumn44(mat44, vec3Up, 1);
		mat44[7] = 0.0f;

		// Z Column
		m3dSetMatrixColumn44(mat44, vec3Forward, 2);
		mat44[11] = 0.0f;

		// Translation (already done)
		if (bRotationOnly == true) {
			mat44[12] = 0.0f;
			mat44[13] = 0.0f;
			mat44[14] = 0.0f;
		}
		else {
			m3dSetMatrixColumn44(mat44, vec3Origin, 3);
		}

		mat44[15] = 1.0f;
	}


	private static int M(int row, int col)
	{
		return col * 4 + row;
	}


	void GetCameraMatrix(float[] mat44, boolean bRotationOnly)
	{
		float[] x = M3DVector3f();
		float[] z = M3DVector3f();

		// Make rotation matrix
		// Z vector is reversed
		z[0] = -vec3Forward[0];
		z[1] = -vec3Forward[1];
		z[2] = -vec3Forward[2];

		// X vector = Y cross Z 
		m3dCrossProduct3(x, vec3Up, z);

		// Matrix has no translation information and is
		// transposed.... (rows instead of columns)
		mat44[M(0, 0)] = x[0];
		mat44[M(0, 1)] = x[1];
		mat44[M(0, 2)] = x[2];
		mat44[M(0, 3)] = 0.0f;
		mat44[M(1, 0)] = vec3Up[0];
		mat44[M(1, 1)] = vec3Up[1];
		mat44[M(1, 2)] = vec3Up[2];
		mat44[M(1, 3)] = 0.0f;
		mat44[M(2, 0)] = z[0];
		mat44[M(2, 1)] = z[1];
		mat44[M(2, 2)] = z[2];
		mat44[M(2, 3)] = 0.0f;
		mat44[M(3, 0)] = 0.0f;
		mat44[M(3, 1)] = 0.0f;
		mat44[M(3, 2)] = 0.0f;
		mat44[M(3, 3)] = 1.0f;

		if (bRotationOnly)
			return;

		// Apply translation too
		float[] mat44Translation = M3DMatrix44f();
		float[] M = M3DMatrix44f();
		m3dTranslationMatrix44(mat44Translation, -vec3Origin[0], -vec3Origin[1], -vec3Origin[2]);

		m3dMatrixMultiply44(M, mat44, mat44Translation);

		memcpy16(mat44, M);
	}


	/**
	 * Rotate around local Y
	 * 
	 * @param fAngle
	 */
	void RotateLocalY(float fAngle)
	{
		float[] rotMat = M3DMatrix44f();
		// Just Rotate around the up vector
		// Create a rotation matrix around my Up (Y) vector
		m3dRotationMatrix44(rotMat, fAngle, vec3Up[0], vec3Up[1], vec3Up[2]);
		float[] newVect = M3DVector3f();
		// Rotate forward pointing vector (inlined 3x3 transform)
		newVect[0] = rotMat[0] * vec3Forward[0] + rotMat[4] * vec3Forward[1] + rotMat[8] * vec3Forward[2];
		newVect[1] = rotMat[1] * vec3Forward[0] + rotMat[5] * vec3Forward[1] + rotMat[9] * vec3Forward[2];
		newVect[2] = rotMat[2] * vec3Forward[0] + rotMat[6] * vec3Forward[1] + rotMat[10] * vec3Forward[2];
		m3dCopyVector3(vec3Forward, newVect);
	}


	/**
	 * Rotate around local Z
	 * 
	 * @param fAngle
	 */
	void RotateLocalZ(float fAngle)
	{
		float[] rotMat = M3DMatrix44f();
		// Only the up vector needs to be rotated
		m3dRotationMatrix44(rotMat, fAngle, vec3Forward[0], vec3Forward[1], vec3Forward[2]);
		float[] newVect = M3DVector3f();
		newVect[0] = rotMat[0] * vec3Up[0] + rotMat[4] * vec3Up[1] + rotMat[8] * vec3Up[2];
		newVect[1] = rotMat[1] * vec3Up[0] + rotMat[5] * vec3Up[1] + rotMat[9] * vec3Up[2];
		newVect[2] = rotMat[2] * vec3Up[0] + rotMat[6] * vec3Up[1] + rotMat[10] * vec3Up[2];
		m3dCopyVector3(vec3Up, newVect);
	}


	/**
	 * Rotate around local X
	 * 
	 * @param fAngle
	 */
	void RotateLocalX(float fAngle)
	{
		float[] rotMat = M3DMatrix44f();
		float[] localX = M3DVector3f();
		float[] rotVec = M3DVector3f();
		// Get the local X axis
		m3dCrossProduct3(localX, vec3Up, vec3Forward);
		// Make a Rotation Matrix
		m3dRotationMatrix33(rotMat, fAngle, localX[0], localX[1], localX[2]);
		// Rotate Y, and Z
		m3dRotateVector(rotVec, vec3Up, rotMat);
		m3dCopyVector3(vec3Up, rotVec);
		m3dRotateVector(rotVec, vec3Forward, rotMat);
		m3dCopyVector3(vec3Forward, rotVec);
	}


	/**
	 * Reset axes to make sure they are orthonormal. This should be called on
	 * occasion if the matrix is long-lived and frequently transformed.
	 */
	void Normalize()
	{
		float[] vCross = M3DVector3f();
		// Calculate cross product of up and forward vectors
		m3dCrossProduct3(vCross, vec3Up, vec3Forward);
		// Use result to recalculate forward vector
		m3dCrossProduct3(vec3Forward, vCross, vec3Up);
		// Also check for unit length...
		m3dNormalizeVector3(vec3Up);
		m3dNormalizeVector3(vec3Forward);
	}


	// Rotate in world coordinates...
	void RotateWorld(float fAngle, float x, float y, float z)
	{
		float[] rotMat = M3DMatrix44f();

		// Create the Rotation matrix
		m3dRotationMatrix44(rotMat, fAngle, x, y, z);

		float[] newVect = M3DVector3f();

		// Transform the up axis (inlined 3x3 rotation)
		newVect[0] = rotMat[0] * vec3Up[0] + rotMat[4] * vec3Up[1] + rotMat[8] * vec3Up[2];
		newVect[1] = rotMat[1] * vec3Up[0] + rotMat[5] * vec3Up[1] + rotMat[9] * vec3Up[2];
		newVect[2] = rotMat[2] * vec3Up[0] + rotMat[6] * vec3Up[1] + rotMat[10] * vec3Up[2];
		m3dCopyVector3(vec3Up, newVect);

		// Transform the forward axis
		newVect[0] = rotMat[0] * vec3Forward[0] + rotMat[4] * vec3Forward[1] + rotMat[8] * vec3Forward[2];
		newVect[1] = rotMat[1] * vec3Forward[0] + rotMat[5] * vec3Forward[1] + rotMat[9] * vec3Forward[2];
		newVect[2] = rotMat[2] * vec3Forward[0] + rotMat[6] * vec3Forward[1] + rotMat[10] * vec3Forward[2];
		m3dCopyVector3(vec3Forward, newVect);
	}


	// Rotate around a local axis
	void RotateLocal(float fAngle, float x, float y, float z)
	{
		float[] vWorldVect = M3DVector3f();
		float[] vLocalVect = M3DVector3f();
		m3dLoadVector3(vLocalVect, x, y, z);

		LocalToWorld(vLocalVect, vWorldVect, true);
		RotateWorld(fAngle, vWorldVect[0], vWorldVect[1], vWorldVect[2]);
	}


	// Convert Coordinate Systems
	// This is pretty much, do the transformation represented by the rotation
	// and position on the point
	// Is it better to stick to the convention that the destination always comes
	// first, or use the conventions that "sounds" like the function...
	void LocalToWorld(float[] vLocal, float[] vWorld, boolean bRotOnly)
	{
		// Create the rotation matrix based on the vectors
		float[] rotMat = M3DMatrix44f();

		GetMatrix(rotMat, true);

		// Do the rotation (it, and remove 4th column...)
		vWorld[0] = rotMat[0] * vLocal[0] + rotMat[4] * vLocal[1] + rotMat[8] * vLocal[2];
		vWorld[1] = rotMat[1] * vLocal[0] + rotMat[5] * vLocal[1] + rotMat[9] * vLocal[2];
		vWorld[2] = rotMat[2] * vLocal[0] + rotMat[6] * vLocal[1] + rotMat[10] * vLocal[2];

		// Translate the point
		if (!bRotOnly) {
			vWorld[0] += vec3Origin[0];
			vWorld[1] += vec3Origin[1];
			vWorld[2] += vec3Origin[2];
		}
	}


	/**
	 * Change world coordinates into "local" coordinates
	 * 
	 * @param v3WorldIn
	 * @param v3LocalOut
	 */
	void WorldToLocal(float[] v3WorldIn, float[] v3LocalOut)
	{
		// Translate the origin
		float[] vNewWorld = M3DVector3f();
		vNewWorld[0] = v3WorldIn[0] - vec3Origin[0];
		vNewWorld[1] = v3WorldIn[1] - vec3Origin[1];
		vNewWorld[2] = v3WorldIn[2] - vec3Origin[2];

		// Create the rotation matrix based on the vectors
		float[] rotMat = M3DMatrix44f();
		float[] invMat = M3DMatrix44f();
		GetMatrix(rotMat, true);

		// Do the rotation based on inverted matrix
		m3dInvertMatrix44(invMat, rotMat);

		v3LocalOut[0] = invMat[0] * vNewWorld[0] + invMat[4] * vNewWorld[1] + invMat[8] * vNewWorld[2];
		v3LocalOut[1] = invMat[1] * vNewWorld[0] + invMat[5] * vNewWorld[1] + invMat[9] * vNewWorld[2];
		v3LocalOut[2] = invMat[2] * vNewWorld[0] + invMat[6] * vNewWorld[1] + invMat[10] * vNewWorld[2];
	}


	/**
	 * Transform a point by frame matrix.
	 * 
	 * @param v3In
	 * @param v3Out
	 */
	void TransformPoint(float[] v3In, float[] v3Out)
	{
		float[] mat44 = M3DMatrix44f();
		GetMatrix(mat44, false); // Rotate and translate
		v3Out[0] = mat44[0] * v3In[0] + mat44[4] * v3In[1] + mat44[8] * v3In[2] + mat44[12];
		v3Out[1] = mat44[1] * v3In[0] + mat44[5] * v3In[1] + mat44[9] * v3In[2] + mat44[13];
		v3Out[2] = mat44[2] * v3In[0] + mat44[6] * v3In[1] + mat44[10] * v3In[2] + mat44[14];
	}


	/**
	 * Rotate a vector by frame matrix.
	 * 
	 * @param vec3Src
	 * @param vec3Dst
	 */
	void RotateVector(float[] vec3Src, float[] vec3Dst)
	{
		float[] mat44 = M3DMatrix44f();
		GetMatrix(mat44, true); // Rotate only
		vec3Dst[0] = mat44[0] * vec3Src[0] + mat44[4] * vec3Src[1] + mat44[8] * vec3Src[2];
		vec3Dst[1] = mat44[1] * vec3Src[0] + mat44[5] * vec3Src[1] + mat44[9] * vec3Src[2];
		vec3Dst[2] = mat44[2] * vec3Src[0] + mat44[6] * vec3Src[1] + mat44[10] * vec3Src[2];
	}
};
