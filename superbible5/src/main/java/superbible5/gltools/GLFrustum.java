package superbible5.gltools;

import static superbible5.gltools.Math3D.*;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

/**
 * 
 * @author ayco
 *
 */
public class GLFrustum {

	// The projection matrix for this frustum
	private Matrix4f projMatrix;

	// Untransformed corners of the frustum
	private Vector4f nearUL, nearLL, nearUR, nearLR;
	private Vector4f farUL, farLL, farUR, farLR;

	// Transformed corners of Frustum
	private Vector4f nearULT, nearLLT, nearURT, nearLRT;
	private Vector4f farULT, farLLT, farURT, farLRT;

	// Base and Transformed plane equations
	private Vector4f nearPlane, farPlane, leftPlane, rightPlane;
	private Vector4f topPlane, bottomPlane;


	public GLFrustum()
	{
		SetOrthographic(-1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f);
	}


	public Matrix4f GetProjectionMatrix()
	{
		return projMatrix;
	}


	// Calculates the corners of the Frustum and sets the projection matrix.
	// Orthographics Matrix Projection    
	public void SetOrthographic(float xMin, float xMax, float yMin, float yMax, float zMin, float zMax)
	{
		Math3D.m3dMakeOrthographicMatrix(projMatrix, xMin, xMax, yMin, yMax, zMin, zMax);
		set15(projMatrix, 1.0f);

		// Fill in values for untransformed Frustum corners
		// Near Upper Left
		nearUL.x = xMin;
		nearUL.y = yMax;
		nearUL.z = zMin;
		nearUL.w = 1.0f;

		// Near Lower Left
		nearLL.x = xMin;
		nearLL.y = yMin;
		nearLL.z = zMin;
		nearLL.w = 1.0f;

		// Near Upper Right
		nearUR.x = xMax;
		nearUR.y = yMax;
		nearUR.z = zMin;
		nearUR.w = 1.0f;

		// Near Lower Right
		nearLR.x = xMax;
		nearLR.y = yMin;
		nearLR.z = zMin;
		nearLR.w = 1.0f;

		// Far Upper Left
		farUL.x = xMin;
		farUL.y = yMax;
		farUL.z = zMax;
		farUL.w = 1.0f;

		// Far Lower Left
		farLL.x = xMin;
		farLL.y = yMin;
		farLL.z = zMax;
		farLL.w = 1.0f;

		// Far Upper Right
		farUR.x = xMax;
		farUR.y = yMax;
		farUR.z = zMax;
		farUR.w = 1.0f;

		// Far Lower Right
		farLR.x = xMax;
		farLR.y = yMin;
		farLR.z = zMax;
		farLR.w = 1.0f;
	}


	// Calculates the corners of the Frustum and sets the projection matrix.
	// Perspective Matrix Projection
	public void SetPerspective(float fFov, float fAspect, float fNear, float fFar)
	{
		float xmin, xmax, ymin, ymax; // Dimensions of near clipping plane
		float xFmin, xFmax, yFmin, yFmax; // Dimensions of far clipping plane

		// Do the Math for the near clipping plane
		ymax = fNear * (float) (Math.tan(fFov * Math.PI / 360.0));
		ymin = -ymax;
		xmin = ymin * fAspect;
		xmax = -xmin;

		// Construct the projection matrix
		projMatrix.setIdentity();
		set0(projMatrix, (2.0f * fNear) / (xmax - xmin));
		set5(projMatrix, (2.0f * fNear) / (ymax - ymin));
		set8(projMatrix, (xmax + xmin) / (xmax - xmin));
		set9(projMatrix, (ymax + ymin) / (ymax - ymin));
		set10(projMatrix, -((fFar + fNear) / (fFar - fNear)));
		set11(projMatrix, -1.0f);
		set14(projMatrix, -((2.0f * fFar * fNear) / (fFar - fNear)));
		set15(projMatrix, 0.0f);

		// Do the Math for the far clipping plane
		yFmax = fFar * (float) (Math.tan(fFov * Math.PI / 360.0));
		yFmin = -yFmax;
		xFmin = yFmin * fAspect;
		xFmax = -xFmin;

		// Fill in values for untransformed Frustum corners
		// Near Upper Left
		nearUL.x = xmin;
		nearUL.y = ymax;
		nearUL.z = -fNear;
		nearUL.w = 1.0f;

		// Near Lower Left
		nearLL.x = xmin;
		nearLL.y = ymin;
		nearLL.z = -fNear;
		nearLL.w = 1.0f;

		// Near Upper Right
		nearUR.x = xmax;
		nearUR.y = ymax;
		nearUR.z = -fNear;
		nearUR.w = 1.0f;

		// Near Lower Right
		nearLR.x = xmax;
		nearLR.y = ymin;
		nearLR.z = -fNear;
		nearLR.w = 1.0f;

		// Far Upper Left
		farUL.x = xFmin;
		farUL.y = yFmax;
		farUL.z = -fFar;
		farUL.w = 1.0f;

		// Far Lower Left
		farLL.x = xFmin;
		farLL.y = yFmin;
		farLL.z = -fFar;
		farLL.w = 1.0f;

		// Far Upper Right
		farUR.x = xFmax;
		farUR.y = yFmax;
		farUR.z = -fFar;
		farUR.w = 1.0f;

		// Far Lower Right
		farLR.x = xFmax;
		farLR.y = yFmin;
		farLR.z = -fFar;
		farLR.w = 1.0f;
	}


	// Builds a transformation matrix and transforms the corners of the Frustum,
	// then derives the plane equations
	void Transform(GLFrame Camera)
	{
		// Workspace
		Matrix4f rotMat = new Matrix4f();
		Vector3f vForward = new Vector3f();
		Vector3f vUp = new Vector3f();
		Vector3f vCross = new Vector3f();
		Vector3f vOrigin = new Vector3f();

		///////////////////////////////////////////////////////////////////
		// Create the transformation matrix. This was the trickiest part
		// for me. The default view from OpenGL is down the negative Z
		// axis. However, building a transformation axis from these 
		// directional vectors points the frustum the wrong direction. So
		// You must reverse them here, or build the initial frustum
		// backwards - which to do is purely a matter of taste. I chose to
		// compensate here to allow better operability with some of my other
		// legacy code and projects. RSW
		Camera.GetForwardVector(vForward);
		vForward.x = -vForward.x;
		vForward.y = -vForward.y;
		vForward.z = -vForward.z;

		Camera.GetUpVector(vUp);
		Camera.GetOrigin(vOrigin);

		// Calculate the right side (x) vector
		m3dCrossProduct3(vCross, vUp, vForward);

		// The Matrix
		// X Column
		col0(rotMat, vCross);
		set3(rotMat, 0.0f);

		// Y Column
		col1(rotMat, vUp);
		set7(rotMat, 0.0f);

		// Z Column
		col2(rotMat, vForward);
		set11(rotMat, 0.0f);

		// Translation
		set12(rotMat, vOrigin.x);
		set13(rotMat, vOrigin.y);
		set14(rotMat, vOrigin.z);
		set15(rotMat, 1.0f);

		////////////////////////////////////////////////////
		// Transform the frustum corners
		m3dTransformVector4(nearULT, nearUL, rotMat);
		m3dTransformVector4(nearLLT, nearLL, rotMat);
		m3dTransformVector4(nearURT, nearUR, rotMat);
		m3dTransformVector4(nearLRT, nearLR, rotMat);
		m3dTransformVector4(farULT, farUL, rotMat);
		m3dTransformVector4(farLLT, farLL, rotMat);
		m3dTransformVector4(farURT, farUR, rotMat);
		m3dTransformVector4(farLRT, farLR, rotMat);

		////////////////////////////////////////////////////
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
}
