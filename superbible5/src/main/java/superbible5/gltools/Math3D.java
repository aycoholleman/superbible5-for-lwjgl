package superbible5.gltools;

import static superbible5.gltools.C2J.*;

public final class Math3D {

	public static final double M3D_PI = Math.PI;
	public static final double M3D_2PI = 2D * M3D_PI;
	public static final double M3D_PI_DIV_180 = M3D_PI / 180D;
	public static final double M3D_INV_PI_DIV_180 = 180D / M3D_PI;


	private Math3D()
	{
	}


	public static float m3dDegToRad(float x)
	{
		return (float) (x * M3D_PI_DIV_180);
	}


	public static double m3dDegToRad(double x)
	{
		return x * M3D_PI_DIV_180;
	}


	public static float m3dRadToDeg(float x)
	{
		return (float) (x * M3D_INV_PI_DIV_180);
	}


	public static double m3dRadToDeg(double x)
	{
		return x * M3D_INV_PI_DIV_180;
	}


	public static float m3dHrToDeg(float x)
	{
		return (float) (x * (1F / 15F));
	}


	public static double m3dHrToDeg(double x)
	{
		return x * (1D / 15D);
	}


	public static float m3dHrToRad(float x)
	{
		return m3dDegToRad(m3dHrToDeg(x));
	}


	public static double m3dHrToRad(double x)
	{
		return m3dDegToRad(m3dHrToDeg(x));
	}


	public static float m3dDegToHr(float x)
	{
		return x * 15F;
	}


	public static double m3dDegToHr(double x)
	{
		return x * 15D;
	}


	public static float m3dRadToHr(float x)
	{
		return m3dDegToHr(m3dRadToDeg(x));
	}


	public static double m3dRadToHr(double x)
	{
		return m3dDegToHr(m3dRadToDeg(x));
	}


	public static int m3dIsPOW2(int iValue)
	{
		int nPow2 = 1;
		while (iValue > nPow2) {
			nPow2 = (nPow2 << 1);
		}
		return nPow2;
	}


	public static void m3dLoadVector2(float[] v, float x, float y)
	{
		v[0] = x;
		v[1] = y;
	}


	public static void m3dLoadVector3(float[] v, float x, float y, float z)
	{
		v[0] = x;
		v[1] = y;
		v[2] = z;
	}


	public static void m3dLoadVector4(float[] v, float x, float y, float z, float w)
	{
		v[0] = x;
		v[1] = y;
		v[2] = z;
		v[3] = w;
	}


	public static void m3dLoadVector2(double[] v, double x, double y)
	{
		v[0] = x;
		v[1] = y;
	}


	public static void m3dLoadVector3(double[] v, double x, double y, double z)
	{
		v[0] = x;
		v[1] = y;
		v[2] = z;
	}


	public static void m3dLoadVector4(double[] v, double x, double y, double z, double w)
	{
		v[0] = x;
		v[1] = y;
		v[2] = z;
		v[3] = w;
	}


	public static void m3dCopyVector2(float[] dst, float[] src)
	{
		memcpy2(dst, src);
	}


	public static void m3dCopyVector2(double[] dst, double[] src)
	{
		memcpy2(dst, src);
	}


	public static void m3dCopyVector3(float[] dst, float[] src)
	{
		memcpy3(dst, src);
	}


	public static void m3dCopyVector3(double[] dst, double[] src)
	{
		memcpy3(dst, src);
	}


	public static void m3dCopyVector4(float[] dst, float[] src)
	{
		memcpy4(dst, src);
	}


	public static void m3dCopyVector4(double[] dst, double[] src)
	{
		memcpy4(dst, src);
	}


	public static void m3dAddVectors2(float[] r, float[] a, float[] b)
	{
		r[0] = a[0] + b[0];
		r[1] = a[1] + b[1];
	}


	public static void m3dAddVectors2(double[] r, double[] a, double[] b)
	{
		r[0] = a[0] + b[0];
		r[1] = a[1] + b[1];
	}


	public static void m3dAddVectors3(float[] r, float[] a, float[] b)
	{
		r[0] = a[0] + b[0];
		r[1] = a[1] + b[1];
		r[2] = a[2] + b[2];
	}


	public static void m3dAddVectors3(double[] r, double[] a, double[] b)
	{
		r[0] = a[0] + b[0];
		r[1] = a[1] + b[1];
		r[2] = a[2] + b[2];
	}


	public static void m3dAddVectors4(float[] r, float[] a, float[] b)
	{
		r[0] = a[0] + b[0];
		r[1] = a[1] + b[1];
		r[2] = a[2] + b[2];
		r[3] = a[3] + b[3];
	}


	public static void m3dAddVectors4(double[] r, double[] a, double[] b)
	{
		r[0] = a[0] + b[0];
		r[1] = a[1] + b[1];
		r[2] = a[2] + b[2];
		r[3] = a[3] + b[3];
	}


	public static void m3dSubtractVectors2(float[] r, float[] a, float[] b)
	{
		r[0] = a[0] - b[0];
		r[1] = a[1] - b[1];
	}


	public static void m3dSubtractVectors2(double[] r, double[] a, double[] b)
	{
		r[0] = a[0] - b[0];
		r[1] = a[1] - b[1];
	}


	public static void m3dSubtractVectors3(float[] r, float[] a, float[] b)
	{
		r[0] = a[0] - b[0];
		r[1] = a[1] - b[1];
		r[2] = a[2] - b[2];
	}


	public static void m3dSubtractVectors3(double[] r, double[] a, double[] b)
	{
		r[0] = a[0] - b[0];
		r[1] = a[1] - b[1];
		r[2] = a[2] - b[2];
	}


	public static void m3dSubtractVectors4(float[] r, float[] a, float[] b)
	{
		r[0] = a[0] - b[0];
		r[1] = a[1] - b[1];
		r[2] = a[2] - b[2];
		r[3] = a[3] - b[3];
	}


	public static void m3dSubtractVectors4(double[] r, double[] a, double[] b)
	{
		r[0] = a[0] - b[0];
		r[1] = a[1] - b[1];
		r[2] = a[2] - b[2];
		r[3] = a[3] - b[3];
	}


	public static void m3dScaleVector2(float[] v, float scale)
	{
		v[0] *= scale;
		v[1] *= scale;
	}


	public static void m3dScaleVector2(double[] v, double scale)
	{
		v[0] *= scale;
		v[1] *= scale;
	}


	public static void m3dScaleVector3(float[] v, float scale)
	{
		v[0] *= scale;
		v[1] *= scale;
		v[2] *= scale;
	}


	public static void m3dScaleVector3(double[] v, double scale)
	{
		v[0] *= scale;
		v[1] *= scale;
		v[2] *= scale;
	}


	public static void m3dScaleVector4(float[] v, float scale)
	{
		v[0] *= scale;
		v[1] *= scale;
		v[2] *= scale;
		v[3] *= scale;
	}


	public static void m3dScaleVector4(double[] v, double scale)
	{
		v[0] *= scale;
		v[1] *= scale;
		v[2] *= scale;
		v[3] *= scale;
	}


	public static void m3dCrossProduct3(float[] result, float[] u, float[] v)
	{
		result[0] = u[1] * v[2] - v[1] * u[2];
		result[1] = -u[0] * v[2] + v[0] * u[2];
		result[2] = u[0] * v[1] - v[0] * u[1];
	}


	public static void m3dCrossProduct3(double[] result, double[] u, double[] v)
	{
		result[0] = u[1] * v[2] - v[1] * u[2];
		result[1] = -u[0] * v[2] + v[0] * u[2];
		result[2] = u[0] * v[1] - v[0] * u[1];
	}


	public static float m3dDotProduct3(float[] u, float[] v)
	{
		return u[0] * v[0] + u[1] * v[1] + u[2] * v[2];
	}


	public static double m3dDotProduct3(double[] u, double[] v)
	{
		return u[0] * v[0] + u[1] * v[1] + u[2] * v[2];
	}


	public static float m3dGetAngleBetweenVectors3(float[] u, float[] v)
	{
		float dTemp = m3dDotProduct3(u, v);
		return (float) (Math.acos(dTemp));
	}


	public static double m3dGetAngleBetweenVectors3(double[] u, double[] v)
	{
		double dTemp = m3dDotProduct3(u, v);
		return Math.acos(dTemp);
	}


	public static float m3dGetVectorLengthSquared3(float[] u)
	{
		return (u[0] * u[0]) + (u[1] * u[1]) + (u[2] * u[2]);
	}


	public static double m3dGetVectorLengthSquared3(double[] u)
	{
		return (u[0] * u[0]) + (u[1] * u[1]) + (u[2] * u[2]);
	}


	public static float m3dGetVectorLength3(float[] u)
	{
		return sqrtf(m3dGetVectorLengthSquared3(u));
	}


	public static double m3dGetVectorLength3(double[] u)
	{
		return sqrt(m3dGetVectorLengthSquared3(u));
	}


	public static void m3dNormalizeVector3(float[] u)
	{
		m3dScaleVector3(u, 1.0f / m3dGetVectorLength3(u));
	}


	public static void m3dNormalizeVector3(double[] u)
	{
		m3dScaleVector3(u, 1.0 / m3dGetVectorLength3(u));
	}


	public static double m3dGetDistanceSquared3(double[] u, double[] v)
	{
		// TODO Auto-generated method stub
		return 0;
	}


	public static float m3dGetDistanceSquared3(float[] u, float[] v)
	{
		// TODO Auto-generated method stub
		return 0;
	}


	public static double m3dGetDistance3(double[] u, double[] v)
	{
		return sqrt(m3dGetDistanceSquared3(u, v));
	}


	public static float m3dGetDistance3(float[] u, float[] v)
	{
		return sqrtf(m3dGetDistanceSquared3(u, v));
	}


	public static float m3dGetMagnitudeSquared3(float[] u)
	{
		return u[0] * u[0] + u[1] * u[1] + u[2] * u[2];
	}


	public static double m3dGetMagnitudeSquared3(double[] u)
	{
		return u[0] * u[0] + u[1] * u[1] + u[2] * u[2];
	}


	public static float m3dGetMagnitude3(float[] u)
	{
		return sqrtf(m3dGetMagnitudeSquared3(u));
	}


	public static double m3dGetMagnitude3(double[] u)
	{
		return sqrt(m3dGetMagnitudeSquared3(u));
	}


	////////////////////////////////////////////////////////////////////////////
	// Matrix functions
	////////////////////////////////////////////////////////////////////////////

	public static void m3dCopyMatrix33(float[] dst, float[] src)
	{
		memcpy9(dst, src);
	}


	public static void m3dCopyMatrix33(double[] dst, double[] src)
	{
		memcpy9(dst, src);
	}


	public static void m3dCopyMatrix44(float[] dst, float[] src)
	{
		memcpy16(dst, src);
	}


	public static void m3dCopyMatrix44(double[] dst, double[] src)
	{
		memcpy16(dst, src);
	}


	public static void m3dGetMatrixColumn33(float[] vec3, float[] mat33, int column)
	{
		memcpy3(vec3, 0, mat33, (3 * column));
	}


	public static void m3dGetMatrixColumn33(double[] vec3, double[] mat33, int column)
	{
		memcpy3(vec3, 0, mat33, (3 * column));
	}


	public static void m3dSetMatrixColumn33(float[] mat33, float[] vec3, int column)
	{
		memcpy3(mat33, (3 * column), vec3, 0);
	}


	public static void m3dSetMatrixColumn33(double[] mat33, double[] vec3, int column)
	{
		memcpy3(mat33, (3 * column), vec3, 0);
	}


	public static void m3dGetMatrixColumn44(float[] vec4, float[] mat44, int column)
	{
		memcpy4(vec4, 0, mat44, (4 * column));
	}


	public static void m3dGetMatrixColumn44(double[] vec4, double[] mat44, int column)
	{
		memcpy4(vec4, 0, mat44, (4 * column));
	}


	public static void m3dSetMatrixColumn44(float[] mat44, float[] vec4, int column)
	{
		memcpy4(mat44, (4 * column), vec4, 0);
	}


	public static void m3dSetMatrixColumn44(double[] mat44, double[] vec4, int column)
	{
		memcpy4(mat44, (4 * column), vec4, 0);
	}


	public static void m3dExtractRotationMatrix33(float[] mat33, float[] mat44)
	{
		memcpy3(mat33, mat44); // X column
		memcpy3(mat33, 3, mat44, 4); // Y column
		memcpy3(mat33, 6, mat44, 8); // Z column
	}


	public static void m3dExtractRotationMatrix33(double[] mat33, double[] mat44)
	{
		memcpy3(mat33, mat44); // X column
		memcpy3(mat33, 3, mat44, 4); // Y column
		memcpy3(mat33, 6, mat44, 8); // Z column
	}


	public static void m3dInjectRotationMatrix44(float[] mat44, float[] mat33)
	{
		memcpy4(mat44, mat33);
		memcpy4(mat44, 4, mat33, 4);
		memcpy4(mat44, 8, mat33, 8);
	}


	public static void m3dInjectRotationMatrix44(double[] mat44, double[] mat33)
	{
		memcpy4(mat44, mat33);
		memcpy4(mat44, 4, mat33, 4);
		memcpy4(mat44, 8, mat33, 8);
	}


	public static void m3dTransformVector3(float[] vec3Out, float[] vec3In, float[] mat44)
	{
		vec3Out[0] = mat44[0] * vec3In[0] + mat44[4] * vec3In[1] + mat44[8] * vec3In[2] + mat44[12];
		vec3Out[1] = mat44[1] * vec3In[0] + mat44[5] * vec3In[1] + mat44[9] * vec3In[2] + mat44[13];
		vec3Out[2] = mat44[2] * vec3In[0] + mat44[6] * vec3In[1] + mat44[10] * vec3In[2] + mat44[14];
	}


	public static void m3dTransformVector3(double[] vec3Out, double[] vec3In, double[] mat44)
	{
		vec3Out[0] = mat44[0] * vec3In[0] + mat44[4] * vec3In[1] + mat44[8] * vec3In[2] + mat44[12];
		vec3Out[1] = mat44[1] * vec3In[0] + mat44[5] * vec3In[1] + mat44[9] * vec3In[2] + mat44[13];
		vec3Out[2] = mat44[2] * vec3In[0] + mat44[6] * vec3In[1] + mat44[10] * vec3In[2] + mat44[14];
	}


	public static void m3dTransformVector4(float[] vec4Out, float[] vec4In, float[] mat44)
	{
		vec4Out[0] = mat44[0] * vec4In[0] + mat44[4] * vec4In[1] + mat44[8] * vec4In[2] + mat44[12]
				* vec4In[3];
		vec4Out[1] = mat44[1] * vec4In[0] + mat44[5] * vec4In[1] + mat44[9] * vec4In[2] + mat44[13]
				* vec4In[3];
		vec4Out[2] = mat44[2] * vec4In[0] + mat44[6] * vec4In[1] + mat44[10] * vec4In[2] + mat44[14]
				* vec4In[3];
		vec4Out[3] = mat44[3] * vec4In[0] + mat44[7] * vec4In[1] + mat44[11] * vec4In[2] + mat44[15]
				* vec4In[3];
	}


	public static void m3dTransformVector4(double[] vec4Out, double[] vec4In, double[] mat44)
	{
		vec4Out[0] = mat44[0] * vec4In[0] + mat44[4] * vec4In[1] + mat44[8] * vec4In[2] + mat44[12]
				* vec4In[3];
		vec4Out[1] = mat44[1] * vec4In[0] + mat44[5] * vec4In[1] + mat44[9] * vec4In[2] + mat44[13]
				* vec4In[3];
		vec4Out[2] = mat44[2] * vec4In[0] + mat44[6] * vec4In[1] + mat44[10] * vec4In[2] + mat44[14]
				* vec4In[3];
		vec4Out[3] = mat44[3] * vec4In[0] + mat44[7] * vec4In[1] + mat44[11] * vec4In[2] + mat44[15]
				* vec4In[3];
	}


	public static double[] m3dTransformVector4(double[] vec4In, double[] mat44)
	{
		double[] vec4Out = new double[4];
		m3dTransformVector4(vec4Out, vec4In, mat44);
		return vec4Out;
	}


	public static void m3dRotateVector(float[] vec3Out, float[] vec3In, float[] mat33)
	{
		vec3Out[0] = mat33[0] * vec3In[0] + mat33[3] * vec3In[1] + mat33[6] * vec3In[2];
		vec3Out[1] = mat33[1] * vec3In[0] + mat33[4] * vec3In[1] + mat33[7] * vec3In[2];
		vec3Out[2] = mat33[2] * vec3In[0] + mat33[5] * vec3In[1] + mat33[8] * vec3In[2];
	}


	public static float[] m3dRotateVector(float[] vec3In, float[] mat33)
	{
		float[] vec3Out = new float[3];
		m3dRotateVector(vec3Out, vec3In, mat33);
		return vec3Out;
	}


	public static void m3dRotateVector(double[] vec3Out, double[] vec3In, double[] mat33)
	{
		vec3Out[0] = mat33[0] * vec3In[0] + mat33[3] * vec3In[1] + mat33[6] * vec3In[2];
		vec3Out[1] = mat33[1] * vec3In[0] + mat33[4] * vec3In[1] + mat33[7] * vec3In[2];
		vec3Out[2] = mat33[2] * vec3In[0] + mat33[5] * vec3In[1] + mat33[8] * vec3In[2];
	}


	public static void m3dScaleMatrix33(float[] mat33, float xScale, float yScale, float zScale)
	{
		m3dLoadIdentity33(mat33);
		mat33[0] = xScale;
		mat33[4] = yScale;
		mat33[8] = zScale;
	}


	public static void m3dScaleMatrix33(float[] mat33, float[] vec3)
	{
		m3dLoadIdentity33(mat33);
		mat33[0] = vec3[0];
		mat33[4] = vec3[1];
		mat33[8] = vec3[2];
	}


	public static void m3dScaleMatrix33(double[] mat33, double xScale, double yScale, double zScale)
	{
		m3dLoadIdentity33(mat33);
		mat33[0] = xScale;
		mat33[4] = yScale;
		mat33[8] = zScale;
	}


	public static void m3dScaleMatrix33(double[] mat33, double[] vec3)
	{
		m3dLoadIdentity33(mat33);
		mat33[0] = vec3[0];
		mat33[4] = vec3[1];
		mat33[8] = vec3[2];
	}


	public static void m3dScaleMatrix44(float[] mat44, float xScale, float yScale, float zScale)
	{
		m3dLoadIdentity44(mat44);
		mat44[0] = xScale;
		mat44[5] = yScale;
		mat44[10] = zScale;
	}


	public static void m3dScaleMatrix44(float[] mat44, float[] vec3)
	{
		m3dLoadIdentity44(mat44);
		mat44[0] = vec3[0];
		mat44[5] = vec3[1];
		mat44[10] = vec3[2];
	}


	public static void m3dScaleMatrix44(double[] mat44, double xScale, double yScale, double zScale)
	{
		m3dLoadIdentity44(mat44);
		mat44[0] = xScale;
		mat44[5] = yScale;
		mat44[10] = zScale;
	}


	public static void m3dScaleMatrix44(double[] mat44, double[] vec3)
	{
		m3dLoadIdentity44(mat44);
		mat44[0] = vec3[0];
		mat44[5] = vec3[1];
		mat44[10] = vec3[2];
	}


	public static void m3dLoadIdentity33(float[] m)
	{
		// TODO Auto-generated method stub
	}


	public static void m3dLoadIdentity33(double[] m)
	{
		// TODO Auto-generated method stub
	}


	public static void m3dLoadIdentity44(float[] m)
	{
		// TODO Auto-generated method stub
	}


	public static void m3dLoadIdentity44(double[] m)
	{
		// TODO Auto-generated method stub
	}


	public static void m3dMakePerspectiveMatrix(float[] mProjection, float fFov, float fAspect, float zMin,
			float zMax)
	{
		// TODO
	}


	public static void m3dMakeOrthographicMatrix(float[] mProjection, float xMin, float xMax, float yMin,
			float yMax, float zMin, float zMax)
	{
		// TODO
	}


	public static void m3dRotationMatrix33(float[] mat33, float angle, float x, float y, float z)
	{
		// TODO
	}


	public static void m3dRotationMatrix33(double[] mat33, double angle, double x, double y, double z)
	{
		// TODO
	}


	public static void m3dRotationMatrix44(float[] mat44, float angle, float x, float y, float z)
	{
		// TODO
	}


	public static void m3dRotationMatrix44(double[] mat44, double angle, double x, double y, double z)
	{
		// TODO
	}


	public static void m3dTranslationMatrix44(float[] mat44, float x, float y, float z)
	{
		m3dLoadIdentity44(mat44);
		mat44[12] = x;
		mat44[13] = y;
		mat44[14] = z;
	}


	public static void m3dTranslationMatrix44(double[] mat44, double x, double y, double z)
	{
		m3dLoadIdentity44(mat44);
		mat44[12] = x;
		mat44[13] = y;
		mat44[14] = z;
	}


	public static void m3dInvertMatrix44(float[] mInverse, float[] m)
	{
		// TODO
	}


	public static void m3dInvertMatrix44(double[] mInverse, double[] m)
	{
		// TODO
	}

}
