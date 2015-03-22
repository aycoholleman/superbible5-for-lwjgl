package superbible5.gltools;

import static superbible5.gltools.Math3D.*;

import org.lwjgl.util.vector.Vector3f;

public class GLFrame {

	private final Vector3f vOrigin; // Where am I?
	private final Vector3f vForward; // Where am I going?
	private final Vector3f vUp; // Which way is up?


	public GLFrame()
	{
		// At origin
		vOrigin = new Vector3f();
		// Forward is -Z (default OpenGL)
		vForward = new Vector3f(0, 0, -1f);
		// Up is up (+Y)
		vUp = new Vector3f(0, 1f, 0);
	}


	void SetOrigin(Vector3f vPoint)
	{
		m3dCopyVector3(vOrigin, vPoint);
	}


	void SetOrigin(float x, float y, float z)
	{
		vOrigin.x = x;
		vOrigin.y = y;
		vOrigin.z = z;
	}


	void GetOrigin(Vector3f vPoint)
	{
		m3dCopyVector3(vPoint, vOrigin);
	}


	float GetOriginX()
	{
		return vOrigin.x;
	}


	float GetOriginY()
	{
		return vOrigin.y;
	}


	float GetOriginZ()
	{
		return vOrigin.z;
	}


	/////////////////////////////////////////////////////////////
	// Set Forward Direction
	void SetForwardVector(Vector3f vDirection)
	{
		m3dCopyVector3(vForward, vDirection);
	}


	void SetForwardVector(float x, float y, float z)
	{
		vForward.x = x;
		vForward.y = y;
		vForward.z = z;
	}


	void GetForwardVector(Vector3f vVector)
	{
		m3dCopyVector3(vVector, vForward);
	}


	/////////////////////////////////////////////////////////////
	// Set Up Direction
	void SetUpVector(Vector3f vDirection)
	{
		m3dCopyVector3(vUp, vDirection);
	}


	void SetUpVector(float x, float y, float z)
	{
		vUp.x = x;
		vUp.y = y;
		vUp.z = z;
	}


	void GetUpVector(Vector3f vVector)
	{
		m3dCopyVector3(vVector, vUp);
	}
}
