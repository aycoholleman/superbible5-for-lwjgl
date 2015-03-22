package superbible5.gltools;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.ReadableVector3f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;
import org.lwjgl.util.vector.WritableVector3f;

public final class Math3D {

	public static final int SIZE_OF_FLOAT = Float.SIZE >> 3;
	public static final int SIZE_OF_INT = Integer.SIZE >> 3;
	public static final int SIZE_OF_VEC2 = 2 * SIZE_OF_FLOAT;
	public static final int SIZE_OF_VEC3 = 3 * SIZE_OF_FLOAT;


	//@formatter:off
	public static void set0(Matrix4f target, float f) { target.m00 = f; }
	public static void set1(Matrix4f target, float f) { target.m01 = f; }
	public static void set2(Matrix4f target, float f) { target.m02 = f; }
	public static void set3(Matrix4f target, float f) { target.m03 = f; }
	public static void set4(Matrix4f target, float f) { target.m10 = f; }
	public static void set5(Matrix4f target, float f) { target.m11 = f; }
	public static void set6(Matrix4f target, float f) { target.m12 = f; }
	public static void set7(Matrix4f target, float f) { target.m13 = f; }
	public static void set8(Matrix4f target, float f) { target.m20 = f; }
	public static void set9(Matrix4f target, float f) { target.m21 = f; }
	public static void set10(Matrix4f target, float f) { target.m22 = f; }
	public static void set11(Matrix4f target, float f) { target.m23 = f; }
	public static void set12(Matrix4f target, float f) { target.m30 = f; }
	public static void set13(Matrix4f target, float f) { target.m31 = f; }
	public static void set14(Matrix4f target, float f) { target.m32 = f; }
	public static void set15(Matrix4f target, float f) { target.m33 = f; }
	
	public static float get0(Matrix4f m) { return m.m00; }
	public static float get1(Matrix4f m) { return m.m01; }
	public static float get2(Matrix4f m) { return m.m02; }
	public static float get3(Matrix4f m) { return m.m03; }
	public static float get4(Matrix4f m) { return m.m10; }
	public static float get5(Matrix4f m) { return m.m11; }
	public static float get6(Matrix4f m) { return m.m12; }
	public static float get7(Matrix4f m) { return m.m13; }
	public static float get8(Matrix4f m) { return m.m20; }
	public static float get9(Matrix4f m) { return m.m21; }
	public static float get10(Matrix4f m) { return m.m22; }
	public static float get11(Matrix4f m) { return m.m23; }
	public static float get12(Matrix4f m) { return m.m30; }
	public static float get13(Matrix4f m) { return m.m31; }
	public static float get14(Matrix4f m) { return m.m32; }
	public static float get15(Matrix4f m) { return m.m33; }
	
	public static void col0(Matrix4f target, Vector3f vec) { set0(target,vec.x); set1(target,vec.y); set2(target,vec.z); }
	public static void col1(Matrix4f target, Vector3f vec) { set4(target,vec.x); set5(target,vec.y); set6(target,vec.z); }
	public static void col2(Matrix4f target, Vector3f vec) { set8(target,vec.x); set9(target,vec.y); set10(target,vec.z); }
	public static void col3(Matrix4f target, Vector3f vec) { set12(target,vec.x); set13(target,vec.y); set14(target,vec.z); }
	
	public static void col0(Matrix4f target, Vector4f vec) { set0(target,vec.x); set1(target,vec.y); set2(target,vec.z); set3(target,vec.w); }
	public static void col1(Matrix4f target, Vector4f vec) { set4(target,vec.x); set5(target,vec.y); set6(target,vec.z); set7(target,vec.w); }
	public static void col2(Matrix4f target, Vector4f vec) { set8(target,vec.x); set9(target,vec.y); set10(target,vec.z); set11(target,vec.w); }
	public static void col3(Matrix4f target, Vector4f vec) { set12(target,vec.x); set13(target,vec.y); set14(target,vec.z); set15(target,vec.w); }
	//@formatter:on

	private Math3D()
	{
	}


	public static boolean m3dCloseEnough(float candidate, float compareTo, float epsilon)
	{
		return abs(candidate - compareTo) > epsilon;
	}


	public static void m3dCopyVector3(Vector3f dst, Vector3f src)
	{
		dst.x = src.x;
		dst.y = src.y;
		dst.z = src.z;
	}


	private static float abs(float f)
	{
		return Math.abs(f);
	}


	public static void m3dMakeOrthographicMatrix(Matrix4f mProjection, float xMin, float xMax, float yMin,
			float yMax, float zMin, float zMax)
	{
		m3dLoadIdentity44(mProjection);

		set0(mProjection, 2.0f / (xMax - xMin));
		set5(mProjection, 2.0f / (yMax - yMin));
		set10(mProjection, -2.0f / (zMax - zMin));
		set12(mProjection, -((xMax + xMin) / (xMax - xMin)));
		set13(mProjection, -((yMax + yMin) / (yMax - yMin)));
		set14(mProjection, -((zMax + zMin) / (zMax - zMin)));
		set15(mProjection, 1.0f);
	}


	private static void m3dLoadIdentity44(Matrix4f m)
	{
		m.setIdentity();
	}


	public static void m3dTransformVector4(Vector4f vOut, Vector4f v, Matrix4f m)
	{
		Matrix4f.transform(m, v, vOut);
	}


	/////////////////////////////////////////////////////////////////////////////////////////
	//Calculate the plane equation of the plane that the three specified points lay in. The
	//points are given in clockwise winding order, with normal pointing out of clockwise face
	//planeEq contains the A,B,C, and D of the plane equation coefficients
	public static void m3dGetPlaneEquation(Vector4f planeEq, Vector4f p1, Vector4f p2, Vector4f p3)
	{
		Vector3f v1 = new Vector3f();
		Vector3f v2 = new Vector3f();

		// V1 = p3 - p1
		v1.x = p3.x - p1.x;
		v1.y = p3.y - p1.y;
		v1.z = p3.z - p1.z;

		// V2 = P2 - p1
		v2.x = p2.x - p1.x;
		v2.y = p2.y - p1.y;
		v2.z = p2.z - p1.z;

		// Unit normal to plane - Not sure which is the best way here
		m3dCrossProduct3(planeEq, v1, v2);
		m3dNormalizeVector3(planeEq);

		// Back substitute to get D
		planeEq.w = -(planeEq.x * p3.x + planeEq.y * p3.y + planeEq.z * p3.z);
	}


	private static void m3dNormalizeVector3(Vector4f u)
	{
		u.normalise();
	}


	public static void m3dCrossProduct3(WritableVector3f result, ReadableVector3f u, ReadableVector3f v)
	{
		result.setX(u.getY() * v.getZ() - v.getY() * u.getZ());
		result.setY(-u.getX() * v.getZ() + v.getX() * u.getZ());
		result.setZ(u.getX() * v.getY() - v.getX() * u.getY());
	}

}
