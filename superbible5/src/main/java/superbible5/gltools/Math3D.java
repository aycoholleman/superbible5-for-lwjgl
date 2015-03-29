package superbible5.gltools;

import static superbible5.gltools.C2J.*;

/**
 * @author Ayco Holleman
 *
 */
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


	public static float m3dGetDistanceSquared3(float[] vec3a, float[] vec3b)
	{
		float x = vec3a[0] - vec3b[0];
		x = x * x;
		float y = vec3a[1] - vec3b[1];
		y = y * y;
		float z = vec3a[2] - vec3b[2];
		z = z * z;
		return (x + y + z);
	}


	public static double m3dGetDistanceSquared3(double[] vec3a, double[] vec3b)
	{
		double x = vec3a[0] - vec3b[0];
		x = x * x;
		double y = vec3a[1] - vec3b[1];
		y = y * y;
		double z = vec3a[2] - vec3b[2];
		z = z * z;
		return (x + y + z);
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


	// Get index of element in a 4 x 4 matrix
	private static int E(int row, int col)
	{
		return (col << 2) + row;
	}


	// Get index of element in a 3 x 3 matrix
	private static int F(int row, int col)
	{
		return (col * 3) + row;
	}


	public static void m3dMatrixMultiply44(float[] mat44Out, float[] a, float[] b)
	{
		for (int i = 0; i < 4; i++) {
			float ai0 = a[E(i, 0)], ai1 = a[E(i, 1)], ai2 = a[E(i, 2)], ai3 = a[E(i, 3)];
			mat44Out[E(i, 0)] = ai0 * b[E(0, 0)] + ai1 * b[E(1, 0)] + ai2 * b[E(2, 0)] + ai3 * b[E(3, 0)];
			mat44Out[E(i, 1)] = ai0 * b[E(0, 1)] + ai1 * b[E(1, 1)] + ai2 * b[E(2, 1)] + ai3 * b[E(3, 1)];
			mat44Out[E(i, 2)] = ai0 * b[E(0, 2)] + ai1 * b[E(1, 2)] + ai2 * b[E(2, 2)] + ai3 * b[E(3, 2)];
			mat44Out[E(i, 3)] = ai0 * b[E(0, 3)] + ai1 * b[E(1, 3)] + ai2 * b[E(2, 3)] + ai3 * b[E(3, 3)];
		}
	}


	public static void m3dMatrixMultiply44(double[] mat44Out, double[] a, double[] b)
	{
		for (int i = 0; i < 4; i++) {
			double ai0 = a[E(i, 0)], ai1 = a[E(i, 1)], ai2 = a[E(i, 2)], ai3 = a[E(i, 3)];
			mat44Out[E(i, 0)] = ai0 * b[E(0, 0)] + ai1 * b[E(1, 0)] + ai2 * b[E(2, 0)] + ai3 * b[E(3, 0)];
			mat44Out[E(i, 1)] = ai0 * b[E(0, 1)] + ai1 * b[E(1, 1)] + ai2 * b[E(2, 1)] + ai3 * b[E(3, 1)];
			mat44Out[E(i, 2)] = ai0 * b[E(0, 2)] + ai1 * b[E(1, 2)] + ai2 * b[E(2, 2)] + ai3 * b[E(3, 2)];
			mat44Out[E(i, 3)] = ai0 * b[E(0, 3)] + ai1 * b[E(1, 3)] + ai2 * b[E(2, 3)] + ai3 * b[E(3, 3)];
		}
	}


	public static void m3dMatrixMultiply33(float[] mat44Out, float[] a, float[] b)
	{
		for (int i = 0; i < 3; i++) {
			float ai0 = a[F(i, 0)], ai1 = a[F(i, 1)], ai2 = a[F(i, 2)];
			mat44Out[F(i, 0)] = ai0 * b[F(0, 0)] + ai1 * b[F(1, 0)] + ai2 * b[F(2, 0)];
			mat44Out[F(i, 1)] = ai0 * b[F(0, 1)] + ai1 * b[F(1, 1)] + ai2 * b[F(2, 1)];
			mat44Out[F(i, 2)] = ai0 * b[F(0, 2)] + ai1 * b[F(1, 2)] + ai2 * b[F(2, 2)];
		}
	}


	public static void m3dMatrixMultiply33(double[] mat44Out, double[] a, double[] b)
	{
		for (int i = 0; i < 3; i++) {
			double ai0 = a[F(i, 0)], ai1 = a[F(i, 1)], ai2 = a[F(i, 2)];
			mat44Out[F(i, 0)] = ai0 * b[F(0, 0)] + ai1 * b[F(1, 0)] + ai2 * b[F(2, 0)];
			mat44Out[F(i, 1)] = ai0 * b[F(0, 1)] + ai1 * b[F(1, 1)] + ai2 * b[F(2, 1)];
			mat44Out[F(i, 2)] = ai0 * b[F(0, 2)] + ai1 * b[F(1, 2)] + ai2 * b[F(2, 2)];
		}
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


	public static void m3dTransformVector4(float[] v4Out, float[] v4In, float[] m44)
	{
		v4Out[0] = m44[0] * v4In[0] + m44[4] * v4In[1] + m44[8] * v4In[2] + m44[12] * v4In[3];
		v4Out[1] = m44[1] * v4In[0] + m44[5] * v4In[1] + m44[9] * v4In[2] + m44[13] * v4In[3];
		v4Out[2] = m44[2] * v4In[0] + m44[6] * v4In[1] + m44[10] * v4In[2] + m44[14] * v4In[3];
		v4Out[3] = m44[3] * v4In[0] + m44[7] * v4In[1] + m44[11] * v4In[2] + m44[15] * v4In[3];
	}


	public static void m3dTransformVector4(double[] v4Out, double[] v4In, double[] m44)
	{
		v4Out[0] = m44[0] * v4In[0] + m44[4] * v4In[1] + m44[8] * v4In[2] + m44[12] * v4In[3];
		v4Out[1] = m44[1] * v4In[0] + m44[5] * v4In[1] + m44[9] * v4In[2] + m44[13] * v4In[3];
		v4Out[2] = m44[2] * v4In[0] + m44[6] * v4In[1] + m44[10] * v4In[2] + m44[14] * v4In[3];
		v4Out[3] = m44[3] * v4In[0] + m44[7] * v4In[1] + m44[11] * v4In[2] + m44[15] * v4In[3];
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


	public static void m3dLoadIdentity33(float[] mat33)
	{
		float[] identity = new float[] { 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f };
		memcpy9(mat33, identity);
	}


	public static void m3dLoadIdentity33(double[] mat33)
	{
		double[] identity = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0 };
		memcpy9(mat33, identity);
	}


	public static void m3dLoadIdentity44(float[] mat44)
	{
		float[] identity = new float[] { 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f,
				0.0f, 0.0f, 0.0f, 0.0f, 1.0f };
		memcpy16(mat44, identity);
	}


	public static void m3dLoadIdentity44(double[] mat44)
	{
		double[] identity = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 1.0 };
		memcpy16(mat44, identity);
	}


	public static void m3dMakePerspectiveMatrix(float[] m44Projection, float fFov, float fAspect, float zMin,
			float zMax)
	{
		m3dLoadIdentity44(m44Projection);
		float yMax = zMin * (float) Math.tan(fFov * 0.5f);
		float yMin = -yMax;
		float xMin = yMin * fAspect;
		float xMax = -xMin;
		m44Projection[0] = (2.0f * zMin) / (xMax - xMin);
		m44Projection[5] = (2.0f * zMin) / (yMax - yMin);
		m44Projection[8] = (xMax + xMin) / (xMax - xMin);
		m44Projection[9] = (yMax + yMin) / (yMax - yMin);
		m44Projection[10] = -((zMax + zMin) / (zMax - zMin));
		m44Projection[11] = -1.0f;
		m44Projection[14] = -((2.0f * (zMax * zMin)) / (zMax - zMin));
		m44Projection[15] = 0.0f;
	}


	public static void m3dMakeOrthographicMatrix(float[] m44Projection, float xMin, float xMax, float yMin,
			float yMax, float zMin, float zMax)
	{
		m3dLoadIdentity44(m44Projection);
		m44Projection[0] = 2.0f / (xMax - xMin);
		m44Projection[5] = 2.0f / (yMax - yMin);
		m44Projection[10] = -2.0f / (zMax - zMin);
		m44Projection[12] = -((xMax + xMin) / (xMax - xMin));
		m44Projection[13] = -((yMax + yMin) / (yMax - yMin));
		m44Projection[14] = -((zMax + zMin) / (zMax - zMin));
		m44Projection[15] = 1.0f;
	}


	/**
	 * Create a 3x3 rotation matrix. Takes radians NOT degrees.
	 * 
	 * @param mat33
	 * @param angle
	 * @param x
	 * @param y
	 * @param z
	 */
	public static void m3dRotationMatrix33(float[] mat33, float angle, float x, float y, float z)
	{

		float mag, s, c;
		float xx, yy, zz, xy, yz, zx, xs, ys, zs, one_c;

		s = (float) Math.sin(angle);
		c = (float) Math.cos(angle);

		mag = (float) sqrt(x * x + y * y + z * z);

		// Identity matrix
		if (mag == 0.0f) {
			m3dLoadIdentity33(mat33);
			return;
		}

		// Rotation matrix is normalized
		x /= mag;
		y /= mag;
		z /= mag;

		xx = x * x;
		yy = y * y;
		zz = z * z;
		xy = x * y;
		yz = y * z;
		zx = z * x;
		xs = x * s;
		ys = y * s;
		zs = z * s;
		one_c = 1.0f - c;

		mat33[F(0, 0)] = (one_c * xx) + c;
		mat33[F(0, 1)] = (one_c * xy) - zs;
		mat33[F(0, 2)] = (one_c * zx) + ys;

		mat33[F(1, 0)] = (one_c * xy) + zs;
		mat33[F(1, 1)] = (one_c * yy) + c;
		mat33[F(1, 2)] = (one_c * yz) - xs;

		mat33[F(2, 0)] = (one_c * zx) - ys;
		mat33[F(2, 1)] = (one_c * yz) + xs;
		mat33[F(2, 2)] = (one_c * zz) + c;
	}


	/**
	 * Create a 3x3 rotation matrix. Takes radians NOT degrees.
	 * 
	 * @param mat33
	 * @param angle
	 * @param x
	 * @param y
	 * @param z
	 */
	public static void m3dRotationMatrix33(double[] mat33, double angle, double x, double y, double z)
	{
		double mag, s, c;
		double xx, yy, zz, xy, yz, zx, xs, ys, zs, one_c;

		s = Math.sin(angle);
		c = Math.cos(angle);

		mag = sqrt(x * x + y * y + z * z);

		// Identity matrix
		if (mag == 0.0f) {
			m3dLoadIdentity33(mat33);
			return;
		}

		// Rotation matrix is normalized
		x /= mag;
		y /= mag;
		z /= mag;

		xx = x * x;
		yy = y * y;
		zz = z * z;
		xy = x * y;
		yz = y * z;
		zx = z * x;
		xs = x * s;
		ys = y * s;
		zs = z * s;
		one_c = 1.0f - c;

		mat33[F(0, 0)] = (one_c * xx) + c;
		mat33[F(0, 1)] = (one_c * xy) - zs;
		mat33[F(0, 2)] = (one_c * zx) + ys;

		mat33[F(1, 0)] = (one_c * xy) + zs;
		mat33[F(1, 1)] = (one_c * yy) + c;
		mat33[F(1, 2)] = (one_c * yz) - xs;

		mat33[F(2, 0)] = (one_c * zx) - ys;
		mat33[F(2, 1)] = (one_c * yz) + xs;
		mat33[F(2, 2)] = (one_c * zz) + c;
	}


	/**
	 * Create a 4x4 rotation matrix. Takes radians NOT degrees.
	 * 
	 * @param mat33
	 * @param angle
	 * @param x
	 * @param y
	 * @param z
	 */
	public static void m3dRotationMatrix44(float[] mat44, float angle, float x, float y, float z)
	{
		float mag, s, c;
		float xx, yy, zz, xy, yz, zx, xs, ys, zs, one_c;

		s = (float) Math.sin(angle);
		c = (float) Math.cos(angle);

		mag = (float) Math.sqrt(x * x + y * y + z * z);

		// Identity matrix
		if (mag == 0.0f) {
			m3dLoadIdentity44(mat44);
			return;
		}

		// Rotation matrix is normalized
		x /= mag;
		y /= mag;
		z /= mag;

		xx = x * x;
		yy = y * y;
		zz = z * z;
		xy = x * y;
		yz = y * z;
		zx = z * x;
		xs = x * s;
		ys = y * s;
		zs = z * s;
		one_c = 1.0f - c;

		mat44[E(0, 0)] = (one_c * xx) + c;
		mat44[E(0, 1)] = (one_c * xy) - zs;
		mat44[E(0, 2)] = (one_c * zx) + ys;
		mat44[E(0, 3)] = 0.0f;

		mat44[E(1, 0)] = (one_c * xy) + zs;
		mat44[E(1, 1)] = (one_c * yy) + c;
		mat44[E(1, 2)] = (one_c * yz) - xs;
		mat44[E(1, 3)] = 0.0f;

		mat44[E(2, 0)] = (one_c * zx) - ys;
		mat44[E(2, 1)] = (one_c * yz) + xs;
		mat44[E(2, 2)] = (one_c * zz) + c;
		mat44[E(2, 3)] = 0.0f;

		mat44[E(3, 0)] = 0.0f;
		mat44[E(3, 1)] = 0.0f;
		mat44[E(3, 2)] = 0.0f;
		mat44[E(3, 3)] = 1.0f;
	}


	/**
	 * Create a 4x4 rotation matrix. Takes radians NOT degrees.
	 * 
	 * @param mat33
	 * @param angle
	 * @param x
	 * @param y
	 * @param z
	 */
	public static void m3dRotationMatrix44(double[] mat44, double angle, double x, double y, double z)
	{
		double mag, s, c;
		double xx, yy, zz, xy, yz, zx, xs, ys, zs, one_c;

		s = Math.sin(angle);
		c = Math.cos(angle);

		mag = Math.sqrt(x * x + y * y + z * z);

		// Identity matrix
		if (mag == 0.0f) {
			m3dLoadIdentity44(mat44);
			return;
		}

		// Rotation matrix is normalized
		x /= mag;
		y /= mag;
		z /= mag;

		xx = x * x;
		yy = y * y;
		zz = z * z;
		xy = x * y;
		yz = y * z;
		zx = z * x;
		xs = x * s;
		ys = y * s;
		zs = z * s;
		one_c = 1.0f - c;

		mat44[E(0, 0)] = (one_c * xx) + c;
		mat44[E(0, 1)] = (one_c * xy) - zs;
		mat44[E(0, 2)] = (one_c * zx) + ys;
		mat44[E(0, 3)] = 0.0f;

		mat44[E(1, 0)] = (one_c * xy) + zs;
		mat44[E(1, 1)] = (one_c * yy) + c;
		mat44[E(1, 2)] = (one_c * yz) - xs;
		mat44[E(1, 3)] = 0.0f;

		mat44[E(2, 0)] = (one_c * zx) - ys;
		mat44[E(2, 1)] = (one_c * yz) + xs;
		mat44[E(2, 2)] = (one_c * zz) + c;
		mat44[E(2, 3)] = 0.0f;

		mat44[E(3, 0)] = 0.0f;
		mat44[E(3, 1)] = 0.0f;
		mat44[E(3, 2)] = 0.0f;
		mat44[E(3, 3)] = 1.0f;
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


	private static float DetIJ(float[] mat44, int i, int j)
	{
		int x, y, ii, jj;
		float ret;
		float[][] mat = new float[3][3];
		x = 0;
		for (ii = 0; ii < 4; ii++) {
			if (ii == i) {
				continue;
			}
			y = 0;
			for (jj = 0; jj < 4; jj++) {
				if (jj == j) {
					continue;
				}
				mat[x][y] = mat44[(ii * 4) + jj];
				y++;
			}
			x++;
		}
		ret = mat[0][0] * (mat[1][1] * mat[2][2] - mat[2][1] * mat[1][2]);
		ret -= mat[0][1] * (mat[1][0] * mat[2][2] - mat[2][0] * mat[1][2]);
		ret += mat[0][2] * (mat[1][0] * mat[2][1] - mat[2][0] * mat[1][1]);
		return ret;
	}


	private static double DetIJ(double[] mat44, int i, int j)
	{
		int x, y, ii, jj;
		double ret;
		double[][] mat = new double[3][3];
		x = 0;
		for (ii = 0; ii < 4; ii++) {
			if (ii == i) {
				continue;
			}
			y = 0;
			for (jj = 0; jj < 4; jj++) {
				if (jj == j) {
					continue;
				}
				mat[x][y] = mat44[(ii * 4) + jj];
				y++;
			}
			x++;
		}
		ret = mat[0][0] * (mat[1][1] * mat[2][2] - mat[2][1] * mat[1][2]);
		ret -= mat[0][1] * (mat[1][0] * mat[2][2] - mat[2][0] * mat[1][2]);
		ret += mat[0][2] * (mat[1][0] * mat[2][1] - mat[2][0] * mat[1][1]);
		return ret;
	}


	public static void m3dInvertMatrix44(float[] mInverse, float[] m)
	{
		int i, j;
		float det, detij;
		// calculate 4x4 determinant
		det = 0.0f;
		for (i = 0; i < 4; i++) {
			det += ((i & 0x1) == 1) ? (-m[i] * DetIJ(m, 0, i)) : (m[i] * DetIJ(m, 0, i));
		}
		det = 1.0f / det;
		// calculate inverse
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				detij = DetIJ(m, j, i);
				mInverse[(i * 4) + j] = (((i + j) & 0x1) == 1) ? (-detij * det) : (detij * det);
			}
		}
	}


	public static void m3dInvertMatrix44(double[] mInverse, double[] m)
	{
		int i, j;
		double det, detij;
		// calculate 4x4 determinant
		det = 0.0;
		for (i = 0; i < 4; i++) {
			det += ((i & 0x1) == 1) ? (-m[i] * DetIJ(m, 0, i)) : (m[i] * DetIJ(m, 0, i));
		}
		det = 1.0 / det;
		// calculate inverse
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				detij = DetIJ(m, j, i);
				mInverse[(i * 4) + j] = (((i + j) & 0x1) == 1) ? (-detij * det) : (detij * det);
			}
		}
	}


	/**
	 * Find a normal from three points.
	 * 
	 * @param result
	 * @param point1
	 * @param point2
	 * @param point3
	 */
	void m3dFindNormal(float[] vec3Result, float[] vec3a, float[] vec3b, float[] vec3c)
	{
		// TODO
	}


	void m3dFindNormal(double[] vec3Result, double[] vec3a, double[] vec3b, double[] vec3c)
	{
		// TODO
	}


	/**
	 * Calculate the signed distance of a point to a plane
	 * 
	 * @param v3Point
	 * @param v4Plane
	 * @return
	 */
	public static float m3dGetDistanceToPlane(float[] v3Point, float[] v4Plane)
	{
		return v3Point[0] * v4Plane[0] + v3Point[1] * v4Plane[1] + v3Point[2] * v4Plane[2] + v4Plane[3];
	}


	public static double m3dGetDistanceToPlane(double[] v3Point, double[] v4Plane)
	{
		return v3Point[0] * v4Plane[0] + v3Point[1] * v4Plane[1] + v3Point[2] * v4Plane[2] + v4Plane[3];
	}


	/**
	 * Get plane equation from three points
	 * 
	 * @param planeEq
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public static void m3dGetPlaneEquation(float[] planeEq, float[] p1, float[] p2, float[] p3)
	{
		// TODO
	}


	public static void m3dGetPlaneEquation(double[] planeEq, double[] p1, double[] p2, double[] p3)
	{
		// TODO
	}


	/**
	 * Determine if a ray intersects a sphere. Return value is < 0 if the ray
	 * does not intersect. Return value is 0.0 if ray is tangent Positive value
	 * is distance to the intersection point.
	 */
	public static double m3dRaySphereTest(double[] point, double[] ray, double[] sphereCenter,
			double sphereRadius)
	{
		// TODO
		return 0;
	}


	public static float m3dRaySphereTest(float[] point, float[] ray, float[] sphereCenter, float sphereRadius)
	{
		// TODO
		return 0;
	}


	public static void m3dProjectXY(float[] vPointOut, float[] mModelView, float[] mProjection,
			int[] iViewPort, float[] vPointIn)
	{
		// TODO
	}


	public static void m3dProjectXYZ(float[] vPointOut, float[] mModelView, float[] mProjection,
			int[] iViewPort, float[] vPointIn)
	{
		// TODO
	}


	/**
	 * Do a three dimensional Catmull-Rom "spline" interpolation between p1 and
	 * p2
	 * 
	 * @param vOut
	 * @param vP0
	 * @param vP1
	 * @param vP2
	 * @param vP3
	 * @param t
	 */
	public static void m3dCatmullRom(float[] vOut, float[] vP0, float[] vP1, float[] vP2, float[] vP3, float t)
	{
		// TODO
	}


	public static void m3dCatmullRom(double[] vOut, double[] vP0, double[] vP1, double[] vP2, double[] vP3,
			double t)
	{
		// TODO
	}


	public static boolean m3dCloseEnough(float fCandidate, float fCompare, float fEpsilon)
	{
		return (Math.abs(fCandidate - fCompare) < fEpsilon);
	}


	public static boolean m3dCloseEnough(double dCandidate, double dCompare, double dEpsilon)
	{
		return (Math.abs(dCandidate - dCompare) < dEpsilon);
	}


	void m3dCalculateTangentBasis(float[] vTangent, float[][] pvTriangle, float[][] pvTexCoords, float[] N)
	{
		// TODO
	}


	/**
	 * Smoothly step between 0 and 1 between edge1 and edge 2
	 * 
	 * @param edge1
	 * @param edge2
	 * @param x
	 * @return
	 */
	public static double m3dSmoothStep(double edge1, double edge2, double x)
	{
		// TODO
		return 0;
	}


	public static float m3dSmoothStep(float edge1, float edge2, float x)
	{
		// TODO
		return 0;
	}


	public static void m3dMakePlanarShadowMatrix(double[] proj, double[] planeEq, double[] vLightPos)
	{
		// TODO
	}


	public static void m3dMakePlanarShadowMatrix(float[] proj, float[] planeEq, float[] vLightPos)
	{
		// TODO
	}


	/**
	 * Closest point on a ray to another point in space
	 * 
	 * @param vPointOnRay
	 * @param vRayOrigin
	 * @param vUnitRayDir
	 * @param vPointInSpace
	 * @return
	 */
	public static double m3dClosestPointOnRay(double[] vPointOnRay, double[] vRayOrigin,
			double[] vUnitRayDir, double[] vPointInSpace)
	{
		// TODO
		return 0;
	}


	public static float m3dClosestPointOnRay(float[] vPointOnRay, float[] vRayOrigin, float[] vUnitRayDir,
			float[] vPointInSpace)
	{
		// TODO
		return 0;
	}

}
