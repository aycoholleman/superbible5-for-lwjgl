package superbible5.gltools;

import static superbible5.gltools.C2J.*;
import static superbible5.gltools.Math3D.*;

/**
 * 
 * @author Ayco Holleman
 *
 */
public class GLFrustum {

	private final float[] projMatrix = M3DMatrix44f();;

	// Untransformed corners of the frustum
	private final float[] nearUL = M3DVector4f();
	private final float[] nearLL = M3DVector4f();
	private final float[] nearUR = M3DVector4f();
	private final float[] nearLR = M3DVector4f();
	private final float[] farUL = M3DVector4f();
	private final float[] farLL = M3DVector4f();
	private final float[] farUR = M3DVector4f();
	private final float[] farLR = M3DVector4f();

	// Transformed corners of Frustum
	private final float[] nearULT = M3DVector4f();
	private final float[] nearLLT = M3DVector4f();
	private final float[] nearURT = M3DVector4f();
	private final float[] nearLRT = M3DVector4f();
	private final float[] farULT = M3DVector4f();
	private final float[] farLLT = M3DVector4f();
	private final float[] farURT = M3DVector4f();
	private final float[] farLRT = M3DVector4f();

	// Base and Transformed plane equations
	private final float[] nearPlane = M3DVector4f();
	private final float[] farPlane = M3DVector4f();
	private final float[] leftPlane = M3DVector4f();
	private final float[] rightPlane = M3DVector4f();
	private final float[] topPlane = M3DVector4f();
	private final float[] bottomPlane = M3DVector4f();


	public GLFrustum()
	{
		SetOrthographic(-1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f);
	}


	public GLFrustum(float fFov, float fAspect, float fNear, float fFar)
	{
		SetPerspective(fFov, fAspect, fNear, fFar);
	}


	public GLFrustum(float xMin, float xMax, float yMin, float yMax, float zMin, float zMax)
	{
		SetOrthographic(xMin, xMax, yMin, yMax, zMin, zMax);
	}


	public float[] GetProjectionMatrix()
	{
		return projMatrix;
	}


	public void SetOrthographic(float xMin, float xMax, float yMin, float yMax, float zMin, float zMax)
	{
		m3dMakeOrthographicMatrix(projMatrix, xMin, xMax, yMin, yMax, zMin, zMax);
		projMatrix[15] = 1.0f;

		// Fill in values for untransformed Frustum corners
		// Near Upper Left
		nearUL[0] = xMin;
		nearUL[1] = yMax;
		nearUL[2] = zMin;
		nearUL[3] = 1.0f;

		// Near Lower Left
		nearLL[0] = xMin;
		nearLL[1] = yMin;
		nearLL[2] = zMin;
		nearLL[3] = 1.0f;

		// Near Upper Right
		nearUR[0] = xMax;
		nearUR[1] = yMax;
		nearUR[2] = zMin;
		nearUR[3] = 1.0f;

		// Near Lower Right
		nearLR[0] = xMax;
		nearLR[1] = yMin;
		nearLR[2] = zMin;
		nearLR[3] = 1.0f;

		// Far Upper Left
		farUL[0] = xMin;
		farUL[1] = yMax;
		farUL[2] = zMax;
		farUL[3] = 1.0f;

		// Far Lower Left
		farLL[0] = xMin;
		farLL[1] = yMin;
		farLL[2] = zMax;
		farLL[3] = 1.0f;

		// Far Upper Right
		farUR[0] = xMax;
		farUR[1] = yMax;
		farUR[2] = zMax;
		farUR[3] = 1.0f;

		// Far Lower Right
		farLR[0] = xMax;
		farLR[1] = yMin;
		farLR[2] = zMax;
		farLR[3] = 1.0f;
	}


	/**
	 * Calculates the corners of the Frustum and sets the projection matrix.
	 * Perspective Matrix Projection
	 * 
	 * @param fFov
	 * @param fAspect
	 * @param fNear
	 * @param fFar
	 */
	public void SetPerspective(float fFov, float fAspect, float fNear, float fFar)
	{
		float xmin, xmax, ymin, ymax; // Dimensions of near clipping plane
		float xFmin, xFmax, yFmin, yFmax; // Dimensions of far clipping plane

		// Do the Math for the near clipping plane
		ymax = fNear * (float) Math.tan(fFov * M3D_PI / 360.0);
		ymin = -ymax;
		xmin = ymin * fAspect;
		xmax = -xmin;

		// Construct the projection matrix
		m3dLoadIdentity44(projMatrix);
		projMatrix[0] = (2.0f * fNear) / (xmax - xmin);
		projMatrix[5] = (2.0f * fNear) / (ymax - ymin);
		projMatrix[8] = (xmax + xmin) / (xmax - xmin);
		projMatrix[9] = (ymax + ymin) / (ymax - ymin);
		projMatrix[10] = -((fFar + fNear) / (fFar - fNear));
		projMatrix[11] = -1.0f;
		projMatrix[14] = -((2.0f * fFar * fNear) / (fFar - fNear));
		projMatrix[15] = 0.0f;

		// Do the Math for the far clipping plane
		yFmax = fFar * (float) Math.tan(fFov * M3D_PI / 360.0);
		yFmin = -yFmax;
		xFmin = yFmin * fAspect;
		xFmax = -xFmin;

		// Fill in values for untransformed Frustum corners
		// Near Upper Left
		nearUL[0] = xmin;
		nearUL[1] = ymax;
		nearUL[2] = -fNear;
		nearUL[3] = 1.0f;

		// Near Lower Left
		nearLL[0] = xmin;
		nearLL[1] = ymin;
		nearLL[2] = -fNear;
		nearLL[3] = 1.0f;

		// Near Upper Right
		nearUR[0] = xmax;
		nearUR[1] = ymax;
		nearUR[2] = -fNear;
		nearUR[3] = 1.0f;

		// Near Lower Right
		nearLR[0] = xmax;
		nearLR[1] = ymin;
		nearLR[2] = -fNear;
		nearLR[3] = 1.0f;

		// Far Upper Left
		farUL[0] = xFmin;
		farUL[1] = yFmax;
		farUL[2] = -fFar;
		farUL[3] = 1.0f;

		// Far Lower Left
		farLL[0] = xFmin;
		farLL[1] = yFmin;
		farLL[2] = -fFar;
		farLL[3] = 1.0f;

		// Far Upper Right
		farUR[0] = xFmax;
		farUR[1] = yFmax;
		farUR[2] = -fFar;
		farUR[3] = 1.0f;

		// Far Lower Right
		farLR[0] = xFmax;
		farLR[1] = yFmin;
		farLR[2] = -fFar;
		farLR[3] = 1.0f;
	}


	/**
	 * Builds a transformation matrix and transforms the corners of the Frustum,
	 * then derives the plane equations
	 * 
	 * @param Camera
	 */
	public void Transform(GLFrame Camera)
	{
		// Workspace
		float[] rotMat44 = M3DMatrix44f();
		float[] vec3Forward = M3DVector3f();
		float[] vec3Up = M3DVector3f();
		float[] vec3Cross = M3DVector3f();
		float[] vec3Origin = M3DVector3f();

		// Create the transformation matrix. This was the trickiest part
		// for me. The default view from OpenGL is down the negative Z
		// axis. However, building a transformation axis from these 
		// directional vectors points the frustum the wrong direction. So
		// You must reverse them here, or build the initial frustum
		// backwards - which to do is purely a matter of taste. I chose to
		// compensate here to allow better operability with some of my other
		// legacy code and projects. RSW
		Camera.GetForwardVector(vec3Forward);
		vec3Forward[0] = -vec3Forward[0];
		vec3Forward[1] = -vec3Forward[1];
		vec3Forward[2] = -vec3Forward[2];

		Camera.GetUpVector(vec3Up);
		Camera.GetOrigin(vec3Origin);

		// Calculate the right side (x) vector
		m3dCrossProduct3(vec3Cross, vec3Up, vec3Forward);

		// The Matrix
		// X Column
		memcpy3(rotMat44, vec3Cross);
		rotMat44[3] = 0.0f;

		// Y Column
		memcpy3(rotMat44, 4, vec3Up, 0);
		rotMat44[7] = 0.0f;

		// Z Column
		memcpy3(rotMat44, 8, vec3Forward, 0);
		rotMat44[11] = 0.0f;

		// Translation
		rotMat44[12] = vec3Origin[0];
		rotMat44[13] = vec3Origin[1];
		rotMat44[14] = vec3Origin[2];
		rotMat44[15] = 1.0f;

		// Transform the frustum corners
		m3dTransformVector4(nearULT, nearUL, rotMat44);
		m3dTransformVector4(nearLLT, nearLL, rotMat44);
		m3dTransformVector4(nearURT, nearUR, rotMat44);
		m3dTransformVector4(nearLRT, nearLR, rotMat44);
		m3dTransformVector4(farULT, farUL, rotMat44);
		m3dTransformVector4(farLLT, farLL, rotMat44);
		m3dTransformVector4(farURT, farUR, rotMat44);
		m3dTransformVector4(farLRT, farLR, rotMat44);

		// Derive Plane Equations from points... Points given in
		// counter clockwise order to make normals point inside 
		// the Frustum
		// Near and Far Planes
		m3dGetPlaneEquation(nearPlane, nearULT, nearLLT, nearLRT);
		m3dGetPlaneEquation(farPlane, farULT, farURT, farLRT);

		// Top and Bottom Planes
		m3dGetPlaneEquation(topPlane, nearULT, nearURT, farURT);
		m3dGetPlaneEquation(bottomPlane, nearLLT, farLLT, farLRT);

		// Left and right planes
		m3dGetPlaneEquation(leftPlane, nearLLT, nearULT, farULT);
		m3dGetPlaneEquation(rightPlane, nearLRT, farLRT, farURT);
	}


	public boolean TestSphere(float x, float y, float z, float fRadius)
	{
		return TestSphere(M3DVector3f(x, y, z), fRadius);
	}


	/**
	 * Test a point against all frustum planes. A negative distance for any
	 * single plane means it is outside the frustum. The radius value allows to
	 * test for a point (radius = 0), or a sphere. Possibly there might be some
	 * gain in an alternative function that saves the addition of zero in this
	 * case. Returns false if it is not in the frustum, true if it intersects.
	 * 
	 * @param vec3Point
	 * @param fRadius
	 * @return
	 */
	public boolean TestSphere(float[] vec3Point, float fRadius)
	{
		float fDist;

		// Near Plane - See if it is behind me
		fDist = m3dGetDistanceToPlane(vec3Point, nearPlane);
		if (fDist + fRadius <= 0.0)
			return false;

		// Distance to far plane
		fDist = m3dGetDistanceToPlane(vec3Point, farPlane);
		if (fDist + fRadius <= 0.0)
			return false;

		fDist = m3dGetDistanceToPlane(vec3Point, leftPlane);
		if (fDist + fRadius <= 0.0)
			return false;

		fDist = m3dGetDistanceToPlane(vec3Point, rightPlane);
		if (fDist + fRadius <= 0.0)
			return false;

		fDist = m3dGetDistanceToPlane(vec3Point, bottomPlane);
		if (fDist + fRadius <= 0.0)
			return false;

		fDist = m3dGetDistanceToPlane(vec3Point, topPlane);
		if (fDist + fRadius <= 0.0)
			return false;

		return true;
	}
}
