package superbible5.gltools;

import static superbible5.gltools.Math3D.*;
import static superbible5.gltools.C2J.*;

import org.lwjgl.util.vector.Vector3f;

public class GLFrame {

	private final float[] vOrigin; // Where am I?
	private final float[] vForward; // Where am I going?
	private final float[] vUp; // Which way is up?


	public GLFrame()
	{
		// At origin
		vOrigin = new float[3];
		// Forward is -Z (default OpenGL)
		vForward = new float[] { 0, 0, -1f };
		// Up is up (+Y)
		vUp = new float[] { 0, 1f, 0 };
	}


	/////////////////////////////////////////////////////////////
	// Set Location
	void SetOrigin(float[] vPoint)
	{
		m3dCopyVector3(vOrigin, vPoint);
	}


	void SetOrigin(float x, float y, float z)
	{
		vOrigin[0] = x;
		vOrigin[1] = y;
		vOrigin[2] = z;
	}


	void GetOrigin(float[] vPoint)
	{
		m3dCopyVector3(vPoint, vOrigin);
	}


	float GetOriginX()
	{
		return vOrigin[0];
	}


	float GetOriginY()
	{
		return vOrigin[1];
	}


	float GetOriginZ()
	{
		return vOrigin[2];
	}


	/////////////////////////////////////////////////////////////
	// Set Forward Direction
	void SetForwardVector(float[] vDirection)
	{
		m3dCopyVector3(vForward, vDirection);
	}


	void SetForwardVector(float x, float y, float z)
	{
		vForward[0] = x;
		vForward[1] = y;
		vForward[2] = z;
	}


	void GetForwardVector(float[] vVector)
	{
		m3dCopyVector3(vVector, vForward);
	}


	/////////////////////////////////////////////////////////////
	// Set Up Direction
	void SetUpVector(float[] vDirection)
	{
		m3dCopyVector3(vUp, vDirection);
	}


	void SetUpVector(float x, float y, float z)
	{
		vUp[0] = x;
		vUp[1] = y;
		vUp[2] = z;
	}


	void GetUpVector(float[] vVector)
	{
		m3dCopyVector3(vVector, vUp);
	}


	/////////////////////////////////////////////////////////////
	// Get Axes
	void GetZAxis(float[] vVector)
	{
		GetForwardVector(vVector);
	}


	void GetYAxis(float[] vVector)
	{
		GetUpVector(vVector);
	}


	void GetXAxis(float[] vVector)
	{
		m3dCrossProduct3(vVector, vUp, vForward);
	}


	/////////////////////////////////////////////////////////////
	// Translate along orthonormal axis... world or local
	void TranslateWorld(float x, float y, float z)
	{
		vOrigin[0] += x;
		vOrigin[1] += y;
		vOrigin[2] += z;
	}


	void TranslateLocal(float x, float y, float z)
	{
		MoveForward(z);
		MoveUp(y);
		MoveRight(x);
	}


	/////////////////////////////////////////////////////////////
	// Move Forward (along Z axis)
	void MoveForward(float fDelta)
	{
		// Move along direction of front direction
		vOrigin[0] += vForward[0] * fDelta;
		vOrigin[1] += vForward[1] * fDelta;
		vOrigin[2] += vForward[2] * fDelta;
	}


	// Move along Y axis
	void MoveUp(float fDelta)
	{
		// Move along direction of up direction
		vOrigin[0] += vUp[0] * fDelta;
		vOrigin[1] += vUp[1] * fDelta;
		vOrigin[2] += vUp[2] * fDelta;
	}


	// Move along X axis
	void MoveRight(float fDelta)
	{
		// Move along direction of right vector
		float[] vCross = new float[3];
		m3dCrossProduct3(vCross, vUp, vForward);

		vOrigin[0] += vCross[0] * fDelta;
		vOrigin[1] += vCross[1] * fDelta;
		vOrigin[2] += vCross[2] * fDelta;
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
		float[] vXAxis = new float[3];
		m3dCrossProduct3(vXAxis, vUp, vForward);

		// Set matrix column does not fill in the fourth value...
		m3dSetMatrixColumn44(mat44, vXAxis, 0);
		mat44[3] = 0.0f;

		// Y Column
		m3dSetMatrixColumn44(mat44, vUp, 1);
		mat44[7] = 0.0f;

		// Z Column
		m3dSetMatrixColumn44(mat44, vForward, 2);
		mat44[11] = 0.0f;

		// Translation (already done)
		if (bRotationOnly == true) {
			mat44[12] = 0.0f;
			mat44[13] = 0.0f;
			mat44[14] = 0.0f;
		}
		else
			m3dSetMatrixColumn44(mat44, vOrigin, 3);

		mat44[15] = 1.0f;
	}


	private static int M(int row, int col)
	{
		return col * 4 + row;
	}


	////////////////////////////////////////////////////////////////////////
	// Assemble the camera matrix
	void GetCameraMatrix(float[] m, boolean bRotationOnly)
	{
		float[] x = new float[3];
		float[] z = new float[3];

		// Make rotation matrix
		// Z vector is reversed
		z[0] = -vForward[0];
		z[1] = -vForward[1];
		z[2] = -vForward[2];

		// X vector = Y cross Z 
		m3dCrossProduct3(x, vUp, z);

		// Matrix has no translation information and is
		// transposed.... (rows instead of columns)
		m[M(0, 0)] = x[0];
		m[M(0, 1)] = x[1];
		m[M(0, 2)] = x[2];
		m[M(0, 3)] = 0.0f;
		m[M(1, 0)] = vUp[0];
		m[M(1, 1)] = vUp[1];
		m[M(1, 2)] = vUp[2];
		m[M(1, 3)] = 0.0f;
		m[M(2, 0)] = z[0];
		m[M(2, 1)] = z[1];
		m[M(2, 2)] = z[2];
		m[M(2, 3)] = 0.0f;
		m[M(3, 0)] = 0.0f;
		m[M(3, 1)] = 0.0f;
		m[M(3, 2)] = 0.0f;
		m[M(3, 3)] = 1.0f;

		if (bRotationOnly)
			return;

		// Apply translation too
		float[] trans = new float[4];
		float[] M = new float[4];
		m3dTranslationMatrix44(trans, -vOrigin[0], -vOrigin[1], -vOrigin[2]);

		m3dMatrixMultiply44(M, m, trans);

		// Copy result back into m
		memcpy16(m, M);
	}


	/**
	 * Rotate around local Y
	 * 
	 * @param fAngle
	 */
	void RotateLocalY(float fAngle)
	{
		float[] rotMat = new float[16];
		// Just Rotate around the up vector
		// Create a rotation matrix around my Up (Y) vector
		m3dRotationMatrix44(rotMat, fAngle, vUp[0], vUp[1], vUp[2]);
		float[] newVect = new float[3];
		// Rotate forward pointing vector (inlined 3x3 transform)
		newVect[0] = rotMat[0] * vForward[0] + rotMat[4] * vForward[1] + rotMat[8] * vForward[2];
		newVect[1] = rotMat[1] * vForward[0] + rotMat[5] * vForward[1] + rotMat[9] * vForward[2];
		newVect[2] = rotMat[2] * vForward[0] + rotMat[6] * vForward[1] + rotMat[10] * vForward[2];
		m3dCopyVector3(vForward, newVect);
	}


	/**
	 * Rotate around local Z
	 * 
	 * @param fAngle
	 */
	void RotateLocalZ(float fAngle)
	{
		float[] rotMat = new float[16];
		// Only the up vector needs to be rotated
		m3dRotationMatrix44(rotMat, fAngle, vForward[0], vForward[1], vForward[2]);
		float[] newVect = new float[3];
		newVect[0] = rotMat[0] * vUp[0] + rotMat[4] * vUp[1] + rotMat[8] * vUp[2];
		newVect[1] = rotMat[1] * vUp[0] + rotMat[5] * vUp[1] + rotMat[9] * vUp[2];
		newVect[2] = rotMat[2] * vUp[0] + rotMat[6] * vUp[1] + rotMat[10] * vUp[2];
		m3dCopyVector3(vUp, newVect);
	}


	/**
	 * Rotate around local X
	 * 
	 * @param fAngle
	 */
	void RotateLocalX(float fAngle)
	{
		float[] rotMat = new float[16];
		float[] localX = new float[3];
		float[] rotVec = new float[3];
		// Get the local X axis
		m3dCrossProduct3(localX, vUp, vForward);
		// Make a Rotation Matrix
		m3dRotationMatrix33(rotMat, fAngle, localX[0], localX[1], localX[2]);
		// Rotate Y, and Z
		m3dRotateVector(rotVec, vUp, rotMat);
		m3dCopyVector3(vUp, rotVec);
		m3dRotateVector(rotVec, vForward, rotMat);
		m3dCopyVector3(vForward, rotVec);
	}


	/**
	 * Reset axes to make sure they are orthonormal. This should be called on
	 * occasion if the matrix is long-lived and frequently transformed.
	 */
	void Normalize()
	{
		float[] vCross = new float[3];
		// Calculate cross product of up and forward vectors
		m3dCrossProduct3(vCross, vUp, vForward);
		// Use result to recalculate forward vector
		m3dCrossProduct3(vForward, vCross, vUp);
		// Also check for unit length...
		m3dNormalizeVector3(vUp);
		m3dNormalizeVector3(vForward);
	}


	// Rotate in world coordinates...
	void RotateWorld(float fAngle, float x, float y, float z)
	{
		float[] rotMat = new float[16];

		// Create the Rotation matrix
		m3dRotationMatrix44(rotMat, fAngle, x, y, z);

		float[] newVect = new float[3];

		// Transform the up axis (inlined 3x3 rotation)
		newVect[0] = rotMat[0] * vUp[0] + rotMat[4] * vUp[1] + rotMat[8] * vUp[2];
		newVect[1] = rotMat[1] * vUp[0] + rotMat[5] * vUp[1] + rotMat[9] * vUp[2];
		newVect[2] = rotMat[2] * vUp[0] + rotMat[6] * vUp[1] + rotMat[10] * vUp[2];
		m3dCopyVector3(vUp, newVect);

		// Transform the forward axis
		newVect[0] = rotMat[0] * vForward[0] + rotMat[4] * vForward[1] + rotMat[8] * vForward[2];
		newVect[1] = rotMat[1] * vForward[0] + rotMat[5] * vForward[1] + rotMat[9] * vForward[2];
		newVect[2] = rotMat[2] * vForward[0] + rotMat[6] * vForward[1] + rotMat[10] * vForward[2];
		m3dCopyVector3(vForward, newVect);
	}


	// Rotate around a local axis
	void RotateLocal(float fAngle, float x, float y, float z)
	{
		float[] vWorldVect = new float[3];
		float[] vLocalVect = new float[3];
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
		float[] rotMat = new float[16];

		GetMatrix(rotMat, true);

		// Do the rotation (it, and remove 4th column...)
		vWorld[0] = rotMat[0] * vLocal[0] + rotMat[4] * vLocal[1] + rotMat[8] * vLocal[2];
		vWorld[1] = rotMat[1] * vLocal[0] + rotMat[5] * vLocal[1] + rotMat[9] * vLocal[2];
		vWorld[2] = rotMat[2] * vLocal[0] + rotMat[6] * vLocal[1] + rotMat[10] * vLocal[2];

		// Translate the point
		if (!bRotOnly) {
			vWorld[0] += vOrigin[0];
			vWorld[1] += vOrigin[1];
			vWorld[2] += vOrigin[2];
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
		float[] vNewWorld = new float[3];
		vNewWorld[0] = v3WorldIn[0] - vOrigin[0];
		vNewWorld[1] = v3WorldIn[1] - vOrigin[1];
		vNewWorld[2] = v3WorldIn[2] - vOrigin[2];

		// Create the rotation matrix based on the vectors
		float[] rotMat = new float[16];
		float[] invMat = new float[16];
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
	 * @param v3PointSrc
	 * @param v3PointDst
	 */
	void TransformPoint(float[] v3PointSrc, float[] v3PointDst)
	{
		float[] mat44 = new float[16];
		GetMatrix(mat44, false); // Rotate and translate
		v3PointDst[0] = mat44[0] * v3PointSrc[0] + mat44[4] * v3PointSrc[1] + mat44[8] * v3PointSrc[2]
				+ mat44[12];// * v[3];	 
		v3PointDst[1] = mat44[1] * v3PointSrc[0] + mat44[5] * v3PointSrc[1] + mat44[9] * v3PointSrc[2]
				+ mat44[13];// * v[3];	
		v3PointDst[2] = mat44[2] * v3PointSrc[0] + mat44[6] * v3PointSrc[1] + mat44[10] * v3PointSrc[2]
				+ mat44[14];// * v[3];	
	}


	/**
	 * Rotate a vector by frame matrix.
	 * 
	 * @param v3VectorSrc
	 * @param v3VectorDst
	 */
	void RotateVector(float[] v3VectorSrc, float[] v3VectorDst)
	{
		float[] mat44 = new float[16];
		GetMatrix(mat44, true); // Rotate only
		v3VectorDst[0] = mat44[0] * v3VectorSrc[0] + mat44[4] * v3VectorSrc[1] + mat44[8] * v3VectorSrc[2];
		v3VectorDst[1] = mat44[1] * v3VectorSrc[0] + mat44[5] * v3VectorSrc[1] + mat44[9] * v3VectorSrc[2];
		v3VectorDst[2] = mat44[2] * v3VectorSrc[0] + mat44[6] * v3VectorSrc[1] + mat44[10] * v3VectorSrc[2];
	}
};
