package superbible5.gltools;

import static superbible5.gltools.C2J.*;

/**
 * @author Ayco Holleman
 *
 */
public class Math3D {

	public static final double M3D_PI = Math.PI;
	public static final double M3D_2PI = 2D * M3D_PI;
	public static final double M3D_PI_DIV_180 = M3D_PI / 180D;
	public static final double M3D_INV_PI_DIV_180 = 180D / M3D_PI;

	//@formatter:off
	
	/*
	 * 3x3 identify matrix (float)
	 */
	private static final float[] IDENTITY_MAT33F = new float[] {
		1.0f, 0.0f, 0.0f,
		0.0f, 1.0f, 0.0f,
		0.0f, 0.0f, 1.0f
	};

	/*
	 * 3x3 identify matrix (double)
	 */
	private static final double[] IDENTITY_MAT33D = new double[] {
		1.0, 0.0, 0.0,
		0.0, 1.0, 0.0,
		0.0, 0.0, 1.0
	};

	/*
	 * 4x4 identify matrix (float)
	 */
	private static final float[] IDENTITY_MAT44F = new float[] {
		1.0f, 0.0f, 0.0f, 0.0f,
		0.0f, 1.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 1.0f, 0.0f,
		0.0f, 0.0f, 0.0f, 1.0f
	};

	/*
	 * 4x4 identify matrix (double)
	 */
	private static final double[] IDENTITY_MAT44D = new double[] {
		1.0, 0.0, 0.0, 0.0,
		0.0, 1.0, 0.0, 0.0,
		0.0, 0.0, 1.0, 0.0,
		0.0, 0.0, 0.0, 1.0
	};

	//@formatter:on

	/*
	 * Only static methods in this class. Do not instantiate.
	 */
	private Math3D()
	{
	}


	/**
	 * Returns a 3-element float array. Syntactic sugar compensating for the
	 * fact that Java does not have typedefs. This method is not in the original
	 * C library.
	 * 
	 * @return
	 */
	public static float[] M3DVector3f()
	{
		return new float[3];
	}


	/**
	 * Returns a 3-element float array containing the specified values.
	 * Syntactic sugar compensating for the fact that Java does not have
	 * typedefs. This method is not in the original C library.
	 * 
	 * @return
	 */
	public static float[] M3DVector3f(float x, float y, float z)
	{
		return new float[] { x, y, z };
	}


	/**
	 * Returns a 3-element double array. Syntactic sugar compensating for the
	 * fact that Java does not have typedefs. This method is not in the original
	 * C library.
	 * 
	 * @return
	 */
	public static double[] M3DVector3d()
	{
		return new double[3];
	}


	/**
	 * Returns a 3-element double array containing the specified values.
	 * Syntactic sugar compensating for the fact that Java does not have
	 * typedefs. This method is not in the original C library.
	 * 
	 * @return
	 */
	public static double[] M3DVector3d(double x, double y, double z)
	{
		return new double[] { x, y, z };
	}


	/**
	 * Returns a 4-element float array. Syntactic sugar compensating for the
	 * fact that Java does not have typedefs. This method is not in the original
	 * C library.
	 * 
	 * @return
	 */
	public static float[] M3DVector4f()
	{
		return new float[4];
	}


	/**
	 * Returns a 4-element double array. Syntactic sugar compensating for the
	 * fact that Java does not have typedefs. This method is not in the original
	 * C library.
	 * 
	 * @return
	 */
	public static double[] M3DVector4d()
	{
		return new double[4];
	}


	/**
	 * Returns a 9-element float array. Syntactic sugar compensating for the
	 * fact that Java does not have typedefs. This method is not in the original
	 * C library.
	 * 
	 * @return
	 */
	public static float[] M3DMatrix33f()
	{
		return new float[9];
	}


	/**
	 * Returns a 9-element double array. Syntactic sugar compensating for the
	 * fact that Java does not have typedefs. This method is not in the original
	 * C library.
	 * 
	 * @return
	 */
	public static double[] M3DMatrix33d()
	{
		return new double[9];
	}


	/**
	 * Returns a 16-element float array. Syntactic sugar compensating for the
	 * fact that Java does not have typedefs. This method is not in the original
	 * C library.
	 * 
	 * @return
	 */
	public static float[] M3DMatrix44f()
	{
		return new float[16];
	}


	/**
	 * Returns a 16-element double array. Syntactic sugar compensating for the
	 * fact that Java does not have typedefs. This method is not in the original
	 * C library.
	 * 
	 * @return
	 */
	public static double[] M3DMatrix44d()
	{
		return new double[16];
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


	public static void m3dLoadVector2(float[] vec2, float x, float y)
	{
		vec2[0] = x;
		vec2[1] = y;
	}


	public static void m3dLoadVector2(double[] vec2, double x, double y)
	{
		vec2[0] = x;
		vec2[1] = y;
	}


	public static void m3dLoadVector3(float[] vec3, float x, float y, float z)
	{
		vec3[0] = x;
		vec3[1] = y;
		vec3[2] = z;
	}


	public static void m3dLoadVector3(double[] vec3, double x, double y, double z)
	{
		vec3[0] = x;
		vec3[1] = y;
		vec3[2] = z;
	}


	public static void m3dLoadVector4(float[] vec4, float x, float y, float z, float w)
	{
		vec4[0] = x;
		vec4[1] = y;
		vec4[2] = z;
		vec4[3] = w;
	}


	public static void m3dLoadVector4(double[] vec4, double x, double y, double z, double w)
	{
		vec4[0] = x;
		vec4[1] = y;
		vec4[2] = z;
		vec4[3] = w;
	}


	public static void m3dCopyVector2(float[] vec2Out, float[] vec2In)
	{
		memcpy2(vec2Out, vec2In);
	}


	public static void m3dCopyVector2(double[] vec2Out, double[] vec2In)
	{
		memcpy2(vec2Out, vec2In);
	}


	public static void m3dCopyVector3(float[] vec3Out, float[] vec3In)
	{
		memcpy3(vec3Out, vec3In);
	}


	public static void m3dCopyVector3(double[] vec3Out, double[] vec3In)
	{
		memcpy3(vec3Out, vec3In);
	}


	public static void m3dCopyVector4(float[] vec4Out, float[] vec4In)
	{
		memcpy4(vec4Out, vec4In);
	}


	public static void m3dCopyVector4(double[] vec4Out, double[] vec4In)
	{
		memcpy4(vec4Out, vec4In);
	}


	public static void m3dAddVectors2(float[] vec2Out, float[] vec2a, float[] vec2b)
	{
		vec2Out[0] = vec2a[0] + vec2b[0];
		vec2Out[1] = vec2a[1] + vec2b[1];
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


	public static void m3dScaleVector4(double[] vec4Out, double scale)
	{
		vec4Out[0] *= scale;
		vec4Out[1] *= scale;
		vec4Out[2] *= scale;
		vec4Out[3] *= scale;
	}


	public static void m3dCrossProduct3(float[] vec3Out, float[] vec3a, float[] vec3b)
	{
		vec3Out[0] = vec3a[1] * vec3b[2] - vec3b[1] * vec3a[2];
		vec3Out[1] = -vec3a[0] * vec3b[2] + vec3b[0] * vec3a[2];
		vec3Out[2] = vec3a[0] * vec3b[1] - vec3b[0] * vec3a[1];
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


	public static float m3dGetDistance3(float[] u, float[] v)
	{
		return sqrtf(m3dGetDistanceSquared3(u, v));
	}


	public static double m3dGetDistance3(double[] u, double[] v)
	{
		return sqrt(m3dGetDistanceSquared3(u, v));
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


	public static void m3dRotateVector(float[] vec3Out, float[] vec3In, float[] mat33)
	{
		vec3Out[0] = mat33[0] * vec3In[0] + mat33[3] * vec3In[1] + mat33[6] * vec3In[2];
		vec3Out[1] = mat33[1] * vec3In[0] + mat33[4] * vec3In[1] + mat33[7] * vec3In[2];
		vec3Out[2] = mat33[2] * vec3In[0] + mat33[5] * vec3In[1] + mat33[8] * vec3In[2];
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
		memcpy9(mat33, IDENTITY_MAT33F);
	}


	public static void m3dLoadIdentity33(double[] mat33)
	{
		memcpy9(mat33, IDENTITY_MAT33D);
	}


	public static void m3dLoadIdentity44(float[] mat44)
	{

		memcpy16(mat44, IDENTITY_MAT44F);
	}


	public static void m3dLoadIdentity44(double[] mat44)
	{
		memcpy16(mat44, IDENTITY_MAT44D);
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
	 * @param vec3Out
	 * @param vec3a
	 * @param vec3b
	 * @param vec3c
	 */
	public static void m3dFindNormal(float[] vec3Out, float[] vec3a, float[] vec3b, float[] vec3c)
	{
		float[] vec3Tmp0 = M3DVector3f();
		float[] vec3Tmp1 = M3DVector3f();

		// Calculate two vectors from the three points. Assumes counter clockwise
		// winding!
		vec3Tmp0[0] = vec3a[0] - vec3b[0];
		vec3Tmp0[1] = vec3a[1] - vec3b[1];
		vec3Tmp0[2] = vec3a[2] - vec3b[2];

		vec3Tmp1[0] = vec3b[0] - vec3c[0];
		vec3Tmp1[1] = vec3b[1] - vec3c[1];
		vec3Tmp1[2] = vec3b[2] - vec3c[2];

		// Take the cross product of the two vectors to get
		// the normal vector.
		m3dCrossProduct3(vec3Out, vec3Tmp0, vec3Tmp1);
	}


	public static void m3dFindNormal(double[] vec3Out, double[] vec3a, double[] vec3b, double[] vec3c)
	{
		double[] vec3Tmp0 = M3DVector3d();
		double[] vec3Tmp1 = M3DVector3d();

		vec3Tmp0[0] = vec3a[0] - vec3b[0];
		vec3Tmp0[1] = vec3a[1] - vec3b[1];
		vec3Tmp0[2] = vec3a[2] - vec3b[2];

		vec3Tmp1[0] = vec3b[0] - vec3c[0];
		vec3Tmp1[1] = vec3b[1] - vec3c[1];
		vec3Tmp1[2] = vec3b[2] - vec3c[2];

		m3dCrossProduct3(vec3Out, vec3Tmp0, vec3Tmp1);
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
	 * @param vec3a
	 * @param vec3b
	 * @param vec3c
	 */
	public static void m3dGetPlaneEquation(float[] planeEq, float[] vec3a, float[] vec3b, float[] vec3c)
	{
		float[] v1 = M3DVector3f();
		float[] v2 = M3DVector3f();

		// V1 = p3 - p1
		v1[0] = vec3c[0] - vec3a[0];
		v1[1] = vec3c[1] - vec3a[1];
		v1[2] = vec3c[2] - vec3a[2];

		// V2 = P2 - p1
		v2[0] = vec3b[0] - vec3a[0];
		v2[1] = vec3b[1] - vec3a[1];
		v2[2] = vec3b[2] - vec3a[2];

		// Unit normal to plane - Not sure which is the best way here
		m3dCrossProduct3(planeEq, v1, v2);
		m3dNormalizeVector3(planeEq);
		// Back substitute to get D
		planeEq[3] = -(planeEq[0] * vec3c[0] + planeEq[1] * vec3c[1] + planeEq[2] * vec3c[2]);
	}


	public static void m3dGetPlaneEquation(double[] planeEq, double[] vec3a, double[] vec3b, double[] vec3c)
	{
		double[] v1 = M3DVector3d();
		double[] v2 = M3DVector3d();

		v1[0] = vec3c[0] - vec3a[0];
		v1[1] = vec3c[1] - vec3a[1];
		v1[2] = vec3c[2] - vec3a[2];

		v2[0] = vec3b[0] - vec3a[0];
		v2[1] = vec3b[1] - vec3a[1];
		v2[2] = vec3b[2] - vec3a[2];

		m3dCrossProduct3(planeEq, v1, v2);
		m3dNormalizeVector3(planeEq);

		planeEq[3] = -(planeEq[0] * vec3c[0] + planeEq[1] * vec3c[1] + planeEq[2] * vec3c[2]);
	}


	/**
	 * Determine if a ray intersects a sphere. Return value is < 0 if the ray
	 * does not intersect. Return value is 0.0 if ray is tangent Positive value
	 * is distance to the intersection point.
	 */
	public static float m3dRaySphereTest(float[] v3Point, float[] v3Ray, float[] v3SphereCenter,
			float sphereRadius)
	{
		//m3dNormalizeVector(ray);	// Make sure ray is unit length

		float[] rayToCenter = M3DVector3f(); // Ray to center of sphere
		rayToCenter[0] = v3SphereCenter[0] - v3Point[0];
		rayToCenter[1] = v3SphereCenter[1] - v3Point[1];
		rayToCenter[2] = v3SphereCenter[2] - v3Point[2];

		// Project rayToCenter on ray to test
		float a = m3dDotProduct3(rayToCenter, v3Ray);

		// Distance to center of sphere
		float distance2 = m3dDotProduct3(rayToCenter, rayToCenter); // Or length

		float dRet = (sphereRadius * sphereRadius) - distance2 + (a * a);

		if (dRet > 0.0) {
			// Return distance to intersection
			dRet = (float) (a - sqrt(dRet));
		}

		return dRet;
	}


	/**
	 * Determine if a ray intersects a sphere. Return value is < 0 if the ray
	 * does not intersect. Return value is 0.0 if ray is tangent Positive value
	 * is distance to the intersection point.
	 */
	public static double m3dRaySphereTest(double[] v3Point, double[] v3Ray, double[] v3SphereCenter,
			double sphereRadius)
	{
		//m3dNormalizeVector(ray);	// Make sure ray is unit length

		double[] rayToCenter = M3DVector3d(); // Ray to center of sphere
		rayToCenter[0] = v3SphereCenter[0] - v3Point[0];
		rayToCenter[1] = v3SphereCenter[1] - v3Point[1];
		rayToCenter[2] = v3SphereCenter[2] - v3Point[2];

		// Project rayToCenter on ray to test
		double a = m3dDotProduct3(rayToCenter, v3Ray);

		// Distance to center of sphere
		double distance2 = m3dDotProduct3(rayToCenter, rayToCenter); // Or length

		double dRet = (sphereRadius * sphereRadius) - distance2 + (a * a);

		if (dRet > 0.0) {
			// Return distance to intersection
			dRet = a - sqrt(dRet);
		}

		return dRet;
	}


	/**
	 * Get Window coordinates, discard Z...
	 * 
	 * @param vec2Out
	 * @param m44ModelView
	 * @param m44Projection
	 * @param iViewPort
	 * @param vec3In
	 */
	public static void m3dProjectXY(float[] vec2Out, float[] m44ModelView, float[] m44Projection,
			int[] iViewPort, float[] vec3In)
	{
		float[] v4Back = M3DVector4f();
		float[] v4Forth = M3DVector4f();

		memcpy3(v4Back, vec3In);
		v4Back[3] = 1.0f;

		m3dTransformVector4(v4Forth, v4Back, m44ModelView);
		m3dTransformVector4(v4Back, v4Forth, m44Projection);

		if (!m3dCloseEnough(v4Back[3], 0.0f, 0.000001f)) {
			float div = 1.0f / v4Back[3];
			v4Back[0] *= div;
			v4Back[1] *= div;
		}

		vec2Out[0] = iViewPort[0] + (1.0f + v4Back[0]) * iViewPort[2] / 2.0f;
		vec2Out[1] = iViewPort[1] + (1.0f + v4Back[1]) * iViewPort[3] / 2.0f;

		if (iViewPort[0] != 0) {
			vec2Out[0] -= iViewPort[0];
		}

		if (iViewPort[1] != 0) {
			vec2Out[1] -= iViewPort[1];
		}
	}


	/**
	 * Get Window coordinates, discard Z.
	 * 
	 * @param vec2Out
	 * @param m44ModelView
	 * @param m44Projection
	 * @param iViewPort
	 * @param vec3In
	 */
	public static void m3dProjectXY(double[] vec2Out, double[] m44ModelView, double[] m44Projection,
			int[] iViewPort, double[] vec3In)
	{
		double[] v4Back = M3DVector4d();
		double[] v4Forth = M3DVector4d();

		memcpy3(v4Back, vec3In);
		v4Back[3] = 1.0;

		m3dTransformVector4(v4Forth, v4Back, m44ModelView);
		m3dTransformVector4(v4Back, v4Forth, m44Projection);

		if (!m3dCloseEnough(v4Back[3], 0.0f, 0.000001f)) {
			double div = 1.0 / v4Back[3];
			v4Back[0] *= div;
			v4Back[1] *= div;
		}

		vec2Out[0] = iViewPort[0] + (1.0 + v4Back[0]) * iViewPort[2] / 2.0;
		vec2Out[1] = iViewPort[1] + (1.0 + v4Back[1]) * iViewPort[3] / 2.0;

		if (iViewPort[0] != 0) {
			vec2Out[0] -= iViewPort[0];
		}

		if (iViewPort[1] != 0) {
			vec2Out[1] -= iViewPort[1];
		}
	}


	/**
	 * Get window coordinates, we also want Z.
	 * 
	 * @param v2PointOut
	 * @param m44ModelView
	 * @param m44Projection
	 * @param iViewPort
	 * @param v2PointIn
	 */
	public static void m3dProjectXYZ(float[] v2PointOut, float[] m44ModelView, float[] m44Projection,
			int[] iViewPort, float[] v2PointIn)
	{
		float[] vBack = M3DVector4f();
		float[] vForth = M3DVector4f();

		memcpy3(vBack, v2PointIn);
		vBack[3] = 1.0f;

		m3dTransformVector4(vForth, vBack, m44ModelView);
		m3dTransformVector4(vBack, vForth, m44Projection);

		if (!m3dCloseEnough(vBack[3], 0.0f, 0.000001f)) {
			float div = 1.0f / vBack[3];
			vBack[0] *= div;
			vBack[1] *= div;
			vBack[2] *= div;
		}

		v2PointOut[0] = iViewPort[0] + (1.0f + vBack[0]) * iViewPort[2] / 2.0f;
		v2PointOut[1] = iViewPort[1] + (1.0f + vBack[1]) * iViewPort[3] / 2.0f;

		if (iViewPort[0] != 0)
			v2PointOut[0] -= iViewPort[0];

		if (iViewPort[1] != 0)
			v2PointOut[1] -= iViewPort[1];

		v2PointOut[2] = vBack[2];
	}


	/**
	 * Get window coordinates, we also want Z.
	 * 
	 * @param v2PointOut
	 * @param m44ModelView
	 * @param m44Projection
	 * @param iViewPort
	 * @param v2PointIn
	 */
	public static void m3dProjectXYZ(double[] v2PointOut, double[] m44ModelView, double[] m44Projection,
			int[] iViewPort, double[] v2PointIn)
	{
		double[] vBack = M3DVector4d();
		double[] vForth = M3DVector4d();

		memcpy3(vBack, v2PointIn);
		vBack[3] = 1.0;

		m3dTransformVector4(vForth, vBack, m44ModelView);
		m3dTransformVector4(vBack, vForth, m44Projection);

		if (!m3dCloseEnough(vBack[3], 0.0, 0.000001)) {
			double div = 1.0f / vBack[3];
			vBack[0] *= div;
			vBack[1] *= div;
			vBack[2] *= div;
		}

		v2PointOut[0] = iViewPort[0] + (1.0 + vBack[0]) * iViewPort[2] / 2.0;
		v2PointOut[1] = iViewPort[1] + (1.0 + vBack[1]) * iViewPort[3] / 2.0;

		if (iViewPort[0] != 0)
			v2PointOut[0] -= iViewPort[0];

		if (iViewPort[1] != 0)
			v2PointOut[1] -= iViewPort[1];

		v2PointOut[2] = vBack[2];
	}


	/**
	 * This function does a three dimensional Catmull-Rom curve interpolation.
	 * Pass four points, and a floating point number between 0.0 and 1.0. The
	 * curve is interpolated between the middle two points.
	 * 
	 * @param vec3Out
	 * @param v3P0
	 * @param v3P1
	 * @param v3P2
	 * @param v3P3
	 * @param t
	 */
	public static void m3dCatmullRom(float[] vec3Out, float[] v3P0, float[] v3P1, float[] v3P2, float[] v3P3,
			float t)
	{
		float t2 = t * t;
		float t3 = t2 * t;

		//@formatter:off

	    // X    
	    vec3Out[0] = 0.5f * ( ( 2.0f * v3P1[0]) +
	                       (-v3P0[0] + v3P2[0]) * t +
	                       (2.0f * v3P0[0] - 5.0f *v3P1[0] + 4.0f * v3P2[0] - v3P3[0]) * t2 +
	                       (-v3P0[0] + 3.0f*v3P1[0] - 3.0f *v3P2[0] + v3P3[0]) * t3);
	    // Y
	    vec3Out[1] = 0.5f * ( ( 2.0f * v3P1[1]) +
	                       (-v3P0[1] + v3P2[1]) * t +
	                       (2.0f * v3P0[1] - 5.0f *v3P1[1] + 4.0f * v3P2[1] - v3P3[1]) * t2 +
	                       (-v3P0[1] + 3.0f*v3P1[1] - 3.0f *v3P2[1] + v3P3[1]) * t3);

	    // Z
	    vec3Out[2] = 0.5f * ( ( 2.0f * v3P1[2]) +
	                       (-v3P0[2] + v3P2[2]) * t +
	                       (2.0f * v3P0[2] - 5.0f *v3P1[2] + 4.0f * v3P2[2] - v3P3[2]) * t2 +
	                       (-v3P0[2] + 3.0f*v3P1[2] - 3.0f *v3P2[2] + v3P3[2]) * t3);
	    //@formatter:on

	}


	/**
	 * This function does a three dimensional Catmull-Rom curve interpolation.
	 * Pass four points, and a floating point number between 0.0 and 1.0. The
	 * curve is interpolated between the middle two points.
	 * 
	 * @param vec3Out
	 * @param v3P0
	 * @param v3P1
	 * @param v3P2
	 * @param v3P3
	 * @param t
	 */
	public static void m3dCatmullRom(double[] vec3Out, double[] v3P0, double[] v3P1, double[] v3P2,
			double[] v3P3, double t)
	{
		double t2 = t * t;
		double t3 = t2 * t;

		//@formatter:off

	    // X    
	    vec3Out[0] = 0.5f * ( ( 2.0f * v3P1[0]) +
	                       (-v3P0[0] + v3P2[0]) * t +
	                       (2.0f * v3P0[0] - 5.0f *v3P1[0] + 4.0f * v3P2[0] - v3P3[0]) * t2 +
	                       (-v3P0[0] + 3.0f*v3P1[0] - 3.0f *v3P2[0] + v3P3[0]) * t3);
	    // Y
	    vec3Out[1] = 0.5f * ( ( 2.0f * v3P1[1]) +
	                       (-v3P0[1] + v3P2[1]) * t +
	                       (2.0f * v3P0[1] - 5.0f *v3P1[1] + 4.0f * v3P2[1] - v3P3[1]) * t2 +
	                       (-v3P0[1] + 3.0f*v3P1[1] - 3.0f *v3P2[1] + v3P3[1]) * t3);

	    // Z
	    vec3Out[2] = 0.5f * ( ( 2.0f * v3P1[2]) +
	                       (-v3P0[2] + v3P2[2]) * t +
	                       (2.0f * v3P0[2] - 5.0f *v3P1[2] + 4.0f * v3P2[2] - v3P3[2]) * t2 +
	                       (-v3P0[2] + 3.0f*v3P1[2] - 3.0f *v3P2[2] + v3P3[2]) * t3);
	    //@formatter:on

	}


	public static boolean m3dCloseEnough(float fCandidate, float fCompare, float fEpsilon)
	{
		return (Math.abs(fCandidate - fCompare) < fEpsilon);
	}


	public static boolean m3dCloseEnough(double dCandidate, double dCompare, double dEpsilon)
	{
		return (Math.abs(dCandidate - dCompare) < dEpsilon);
	}


	/**
	 * Calculate the tangent basis for a triangle on the surface of a model.
	 * This vector is needed for most normal mapping shaders.
	 * 
	 * @param vec3Tangent
	 * @param v3x3Triangle
	 * @param v2x3TexCoords
	 * @param N
	 */
	public static void m3dCalculateTangentBasis(float[] vec3Tangent, float[][] v3x3Triangle,
			float[][] v2x3TexCoords, float[] N)
	{
		float[] dv2v1 = M3DVector3f();
		float[] dv3v1 = M3DVector3f();
		float dc2c1t, dc2c1b, dc3c1t, dc3c1b;
		float M;

		m3dSubtractVectors3(dv2v1, v3x3Triangle[1], v3x3Triangle[0]);
		m3dSubtractVectors3(dv3v1, v3x3Triangle[2], v3x3Triangle[0]);

		dc2c1t = v2x3TexCoords[1][0] - v2x3TexCoords[0][0];
		dc2c1b = v2x3TexCoords[1][1] - v2x3TexCoords[0][1];
		dc3c1t = v2x3TexCoords[2][0] - v2x3TexCoords[0][0];
		dc3c1b = v2x3TexCoords[2][1] - v2x3TexCoords[0][1];

		M = (dc2c1t * dc3c1b) - (dc3c1t * dc2c1b);
		M = 1.0f / M;

		m3dScaleVector3(dv2v1, dc3c1b);
		m3dScaleVector3(dv3v1, dc2c1b);

		m3dSubtractVectors3(vec3Tangent, dv2v1, dv3v1);
		m3dScaleVector3(vec3Tangent, M); // This potentially changes the direction of the vector
		m3dNormalizeVector3(vec3Tangent);

		float[] B = M3DVector3f();
		m3dCrossProduct3(B, N, vec3Tangent);
		m3dCrossProduct3(vec3Tangent, B, N);
		m3dNormalizeVector3(vec3Tangent);
	}


	/**
	 * Calculate the tangent basis for a triangle on the surface of a model.
	 * This vector is needed for most normal mapping shaders.
	 * 
	 * @param vec3Tangent
	 * @param v3x3Triangle
	 * @param v2x3TexCoords
	 * @param N
	 */
	public static void m3dCalculateTangentBasis(double[] vec3Tangent, double[][] v3x3Triangle,
			double[][] v2x3TexCoords, double[] N)
	{
		double[] dv2v1 = M3DVector3d();
		double[] dv3v1 = M3DVector3d();
		double dc2c1t, dc2c1b, dc3c1t, dc3c1b;
		double M;

		m3dSubtractVectors3(dv2v1, v3x3Triangle[1], v3x3Triangle[0]);
		m3dSubtractVectors3(dv3v1, v3x3Triangle[2], v3x3Triangle[0]);

		dc2c1t = v2x3TexCoords[1][0] - v2x3TexCoords[0][0];
		dc2c1b = v2x3TexCoords[1][1] - v2x3TexCoords[0][1];
		dc3c1t = v2x3TexCoords[2][0] - v2x3TexCoords[0][0];
		dc3c1b = v2x3TexCoords[2][1] - v2x3TexCoords[0][1];

		M = (dc2c1t * dc3c1b) - (dc3c1t * dc2c1b);
		M = 1.0f / M;

		m3dScaleVector3(dv2v1, dc3c1b);
		m3dScaleVector3(dv3v1, dc2c1b);

		m3dSubtractVectors3(vec3Tangent, dv2v1, dv3v1);
		m3dScaleVector3(vec3Tangent, M); // This potentially changes the direction of the vector
		m3dNormalizeVector3(vec3Tangent);

		double[] B = M3DVector3d();
		m3dCrossProduct3(B, N, vec3Tangent);
		m3dCrossProduct3(vec3Tangent, B, N);
		m3dNormalizeVector3(vec3Tangent);
	}


	/**
	 * Smoothly step between 0 and 1 between edge1 and edge 2
	 * 
	 * @param edge1
	 * @param edge2
	 * @param x
	 * @return
	 */
	public static float m3dSmoothStep(float edge1, float edge2, float x)
	{
		float t;
		t = (x - edge1) / (edge2 - edge1);
		if (t > 1.0f) {
			t = 1.0f;
		}
		if (t < 0.0f) {
			t = 0.0f;
		}
		return t * t * (3.0f - (2.0f * t));
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
		double t;
		t = (x - edge1) / (edge2 - edge1);
		if (t > 1.0) {
			t = 1.0;
		}
		if (t < 0.0) {
			t = 0.0;
		}
		return t * t * (3.0 - (2.0 * t));
	}


	/**
	 * Create a projection to "squish" an object into the plane. Use
	 * m3dGetPlaneEquationf(planeEq, point1, point2, point3) to get a plane
	 * equation.
	 * 
	 * @param mat44Proj
	 * @param vec4PlaneEq
	 * @param vec3LightPos
	 */
	public static void m3dMakePlanarShadowMatrix(float[] mat44Proj, float[] vec4PlaneEq, float[] vec3LightPos)
	{
		float a = vec4PlaneEq[0];
		float b = vec4PlaneEq[1];
		float c = vec4PlaneEq[2];
		float d = vec4PlaneEq[3];

		float dx = -vec3LightPos[0];
		float dy = -vec3LightPos[1];
		float dz = -vec3LightPos[2];

		mat44Proj[0] = b * dy + c * dz;
		mat44Proj[1] = -a * dy;
		mat44Proj[2] = -a * dz;
		mat44Proj[3] = 0.0f;

		mat44Proj[4] = -b * dx;
		mat44Proj[5] = a * dx + c * dz;
		mat44Proj[6] = -b * dz;
		mat44Proj[7] = 0.0f;

		mat44Proj[8] = -c * dx;
		mat44Proj[9] = -c * dy;
		mat44Proj[10] = a * dx + b * dy;
		mat44Proj[11] = 0.0f;

		mat44Proj[12] = -d * dx;
		mat44Proj[13] = -d * dy;
		mat44Proj[14] = -d * dz;
		mat44Proj[15] = a * dx + b * dy + c * dz;
	}


	/**
	 * Create a projection to "squish" an object into the plane. Use
	 * m3dGetPlaneEquationf(planeEq, point1, point2, point3) to get a plane
	 * equation.
	 * 
	 * @param mat44Proj
	 * @param vec4PlaneEq
	 * @param vec3LightPos
	 */
	public static void m3dMakePlanarShadowMatrix(double[] mat44Proj, double[] vec4PlaneEq,
			double[] vec3LightPos)
	{
		double a = vec4PlaneEq[0];
		double b = vec4PlaneEq[1];
		double c = vec4PlaneEq[2];
		double d = vec4PlaneEq[3];

		double dx = -vec3LightPos[0];
		double dy = -vec3LightPos[1];
		double dz = -vec3LightPos[2];

		mat44Proj[0] = b * dy + c * dz;
		mat44Proj[1] = -a * dy;
		mat44Proj[2] = -a * dz;
		mat44Proj[3] = 0.0;

		mat44Proj[4] = -b * dx;
		mat44Proj[5] = a * dx + c * dz;
		mat44Proj[6] = -b * dz;
		mat44Proj[7] = 0.0;

		mat44Proj[8] = -c * dx;
		mat44Proj[9] = -c * dy;
		mat44Proj[10] = a * dx + b * dy;
		mat44Proj[11] = 0.0;

		mat44Proj[12] = -d * dx;
		mat44Proj[13] = -d * dy;
		mat44Proj[14] = -d * dz;
		mat44Proj[15] = a * dx + b * dy + c * dz;
	}


	/**
	 * Closest point on a ray to another given point in space. As a bonus,
	 * return the distance squared of the two points.
	 * 
	 * @param vPointOnRay
	 *            Out: vPointOnRay is the poing on the ray closest to
	 *            vPointInSpace
	 * @param vRayOrigin
	 *            In: vRayOrigin is the origin of the ray
	 * @param vUnitRayDir
	 *            In: vUnitRayDir is the unit vector of the ray
	 * @param vPointInSpace
	 *            In: vPointInSpace is the point in space
	 * @return The distance squared of the two points
	 */
	public static float m3dClosestPointOnRay(float[] v3PointOnRay, float[] v3RayOrigin, float[] v3UnitRayDir,
			float[] v3PointInSpace)
	{
		float[] vec3 = M3DVector3f();
		m3dSubtractVectors3(vec3, v3PointInSpace, v3RayOrigin);
		float t = m3dDotProduct3(v3UnitRayDir, vec3);
		v3PointOnRay[0] = v3RayOrigin[0] + (t * v3UnitRayDir[0]);
		v3PointOnRay[1] = v3RayOrigin[1] + (t * v3UnitRayDir[1]);
		v3PointOnRay[2] = v3RayOrigin[2] + (t * v3UnitRayDir[2]);
		return m3dGetDistanceSquared3(v3PointOnRay, v3PointInSpace);
	}


	/**
	 * Closest point on a ray to another given point in space. As a bonus,
	 * return the distance squared of the two points.
	 * 
	 * @param vPointOnRay
	 *            Out: vPointOnRay is the poing on the ray closest to
	 *            vPointInSpace
	 * @param vRayOrigin
	 *            In: vRayOrigin is the origin of the ray
	 * @param vUnitRayDir
	 *            In: vUnitRayDir is the unit vector of the ray
	 * @param vPointInSpace
	 *            In: vPointInSpace is the point in space
	 * @return The distance squared of the two points
	 */
	public static double m3dClosestPointOnRay(double[] v3PointOnRay, double[] v3RayOrigin,
			double[] v3UnitRayDir, double[] v3PointInSpace)
	{
		double[] vec3 = M3DVector3d();
		m3dSubtractVectors3(vec3, v3PointInSpace, v3RayOrigin);
		double t = m3dDotProduct3(v3UnitRayDir, vec3);
		v3PointOnRay[0] = v3RayOrigin[0] + (t * v3UnitRayDir[0]);
		v3PointOnRay[1] = v3RayOrigin[1] + (t * v3UnitRayDir[1]);
		v3PointOnRay[2] = v3RayOrigin[2] + (t * v3UnitRayDir[2]);
		return m3dGetDistanceSquared3(v3PointOnRay, v3PointInSpace);
	}

}
