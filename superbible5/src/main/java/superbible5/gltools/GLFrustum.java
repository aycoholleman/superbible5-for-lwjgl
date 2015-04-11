package superbible5.gltools;

import static superbible5.gltools.C2J.*;
import static superbible5.gltools.Math3D.*;

/**
 * 
 * @author Ayco Holleman
 *
 */
public class GLFrustum {

	private float[] projMatrix;

	// Untransformed corners of the frustum
	private float[] nearUL, nearLL, nearUR, nearLR;
	private float[] farUL, farLL, farUR, farLR;

	// Transformed corners of Frustum
	private float[] nearULT, nearLLT, nearURT, nearLRT;
	private float[] farULT, farLLT, farURT, farLRT;

	// Base and Transformed plane equations
	private float[] nearPlane, farPlane, leftPlane, rightPlane;
	private float[] topPlane, bottomPlane;


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
