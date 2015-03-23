package superbible5.gltools;

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


	public static void m3dGetMatrixColumn33(float[] dst, float[] src, int column)
	{
	}


	//	public static void m3dGetMatrixColumn33(double[] dst, M3DMatrix33d src, int column)
	//	{ memcpy(dst, src + (3 * column), sizeof(double) * 3); }
	//
	//
	//	public static void m3dSetMatrixColumn33(float[] dst, float[] src, int column)
	//	{ memcpy(dst + (3 * column), src, sizeof(float) * 3); }
	//
	//
	//	public static void m3dSetMatrixColumn33(M3DMatrix33d dst, double[] src, int column)
	//	{ memcpy(dst + (3 * column), src, sizeof(double) * 3); }
	//
	//
	//	public static void m3dGetMatrixColumn44(float[] dst, double[] src, int column)
	//	{ memcpy(dst, src + (4 * column), sizeof(float) * 4); }
	//
	//
	//	public static void m3dGetMatrixColumn44(double[] dst, M3DMatrix44d src, int column)
	//	{ memcpy(dst, src + (4 * column), sizeof(double) * 4); }
	//
	//
	//	public static void m3dSetMatrixColumn44(double[] dst, float[] src, int column)
	//	{ memcpy(dst + (4 * column), src, sizeof(float) * 4); }
	//
	//
	//	public static void m3dSetMatrixColumn44(M3DMatrix44d dst, double[] src, int column)
	//	{ memcpy(dst + (4 * column), src, sizeof(double) * 4); }

	////////////////////////////////////////////////////////////////////////////
	// Helper functions (not within math3d.h or math3d.cpp)
	////////////////////////////////////////////////////////////////////////////

	public static void memcpy2(float[] dst, float[] src)
	{
		dst[0] = src[0];
		dst[1] = src[1];
	}


	public static void memcpy2(double[] dst, double[] src)
	{
		dst[0] = src[0];
		dst[1] = src[1];
	}


	/**
	 * Equivalent to System.arraycopy with length parameter set to 3 (i.e. three
	 * elements will be copied from src to dest).
	 * 
	 * @param dst
	 *            Destination (write-to) array
	 * @param dstPos
	 *            Index from which to insert into destination array
	 * @param src
	 *            Source (read-from) array
	 * @param srcPos
	 *            Index from which the read the source array
	 */
	public static void memcpy3(float[] dst, int dstPos, float[] src, int srcPos)
	{
		// Actually we don't use System.arraycopy because for small arrays
		// a manual copy is significantly faster
		dst[dstPos + 0] = src[srcPos + 0];
		dst[dstPos + 1] = src[srcPos + 1];
		dst[dstPos + 2] = src[srcPos + 2];
	}


	public static void memcpy3(float[] dst, float[] src)
	{
		memcpy3(dst, 0, src, 0);
	}


	/**
	 * Equivalent to System.arraycopy with length parameter set to 3 (i.e. three
	 * elements will be copied from src to dest).
	 * 
	 * @param dst
	 *            Destination (write-to) array
	 * @param dstPos
	 *            Index from which to insert into destination array
	 * @param src
	 *            Source (read-from) array
	 * @param srcPos
	 *            Index from which the read the source array
	 */
	public static void memcpy3(double[] dst, int dstPos, double[] src, int srcPos)
	{
		dst[dstPos + 0] = src[srcPos + 0];
		dst[dstPos + 1] = src[srcPos + 1];
		dst[dstPos + 2] = src[srcPos + 2];
	}


	public static void memcpy3(double[] dst, double[] src)
	{
		memcpy3(dst, 0, src, 0);
	}


	/**
	 * Equivalent to System.arraycopy with length parameter set to 4 (i.e. four
	 * elements will be copied from src to dest).
	 * 
	 * @param dst
	 *            Destination (write-to) array
	 * @param dstPos
	 *            Index from which to insert into destination array
	 * @param src
	 *            Source (read-from) array
	 * @param srcPos
	 *            Index from which the read the source array
	 */
	public static void memcpy4(float[] dst, int dstPos, float[] src, int srcPos)
	{
		dst[dstPos + 0] = src[srcPos + 0];
		dst[dstPos + 1] = src[srcPos + 1];
		dst[dstPos + 2] = src[srcPos + 2];
		dst[dstPos + 3] = src[srcPos + 3];
	}


	public static void memcpy4(float[] dst, float[] src)
	{
		memcpy4(dst, 0, src, 0);
	}


	/**
	 * Equivalent to System.arraycopy with length parameter set to 4 (i.e. four
	 * elements will be copied from src to dest).
	 * 
	 * @param dst
	 *            Destination (write-to) array
	 * @param dstPos
	 *            Index from which to insert into destination array
	 * @param src
	 *            Source (read-from) array
	 * @param srcPos
	 *            Index from which the read the source array
	 */
	public static void memcpy4(double[] dst, int dstPos, double[] src, int srcPos)
	{
		dst[dstPos + 0] = src[srcPos + 0];
		dst[dstPos + 1] = src[srcPos + 1];
		dst[dstPos + 2] = src[srcPos + 2];
		dst[dstPos + 3] = src[srcPos + 3];
	}


	public static void memcpy4(double[] dst, double[] src)
	{
		memcpy4(dst, 0, src, 0);
	}


	/**
	 * Equivalent to System.arraycopy with length parameter set to 9 (i.e. nine
	 * elements will be copied from src to dest).
	 * 
	 * @param dst
	 *            Destination (write-to) array
	 * @param dstPos
	 *            Index from which to insert into destination array
	 * @param src
	 *            Source (read-from) array
	 * @param srcPos
	 *            Index from which the read the source array
	 */
	public static void memcpy9(float[] dst, int dstPos, float[] src, int srcPos)
	{
		dst[dstPos + 0] = src[srcPos + 0];
		dst[dstPos + 1] = src[srcPos + 1];
		dst[dstPos + 2] = src[srcPos + 2];
		dst[dstPos + 3] = src[srcPos + 3];
		dst[dstPos + 4] = src[srcPos + 4];
		dst[dstPos + 5] = src[srcPos + 5];
		dst[dstPos + 6] = src[srcPos + 6];
		dst[dstPos + 7] = src[srcPos + 7];
		dst[dstPos + 8] = src[srcPos + 8];
	}


	public static void memcpy9(float[] dst, float[] src)
	{
		memcpy9(dst, 0, src, 0);
	}


	/**
	 * Equivalent to System.arraycopy with length parameter set to 9 (i.e. nine
	 * elements will be copied from src to dest).
	 * 
	 * @param dst
	 *            Destination (write-to) array
	 * @param dstPos
	 *            Index from which to insert into destination array
	 * @param src
	 *            Source (read-from) array
	 * @param srcPos
	 *            Index from which the read the source array
	 */
	public static void memcpy9(double[] dst, int dstPos, double[] src, int srcPos)
	{
		dst[dstPos + 0] = src[srcPos + 0];
		dst[dstPos + 1] = src[srcPos + 1];
		dst[dstPos + 2] = src[srcPos + 2];
		dst[dstPos + 3] = src[srcPos + 3];
		dst[dstPos + 4] = src[srcPos + 4];
		dst[dstPos + 5] = src[srcPos + 5];
		dst[dstPos + 6] = src[srcPos + 6];
		dst[dstPos + 7] = src[srcPos + 7];
		dst[dstPos + 8] = src[srcPos + 8];
	}


	public static void memcpy9(double[] dst, double[] src)
	{
		memcpy9(dst, 0, src, 0);
	}


	/**
	 * Equivalent to System.arraycopy with length parameter set to 16 (i.e. 16
	 * elements will be copied from src to dest).
	 * 
	 * @param dst
	 *            Destination (write-to) array
	 * @param dstPos
	 *            Index from which to insert into destination array
	 * @param src
	 *            Source (read-from) array
	 * @param srcPos
	 *            Index from which the read the source array
	 */
	public static void memcpy16(float[] dst, int dstPos, float[] src, int srcPos)
	{
		dst[dstPos + 0] = src[srcPos + 0];
		dst[dstPos + 1] = src[srcPos + 1];
		dst[dstPos + 2] = src[srcPos + 2];
		dst[dstPos + 3] = src[srcPos + 3];
		dst[dstPos + 4] = src[srcPos + 4];
		dst[dstPos + 5] = src[srcPos + 5];
		dst[dstPos + 6] = src[srcPos + 6];
		dst[dstPos + 7] = src[srcPos + 7];
		dst[dstPos + 8] = src[srcPos + 8];
		dst[dstPos + 9] = src[srcPos + 9];
		dst[dstPos + 10] = src[srcPos + 10];
		dst[dstPos + 11] = src[srcPos + 11];
		dst[dstPos + 12] = src[srcPos + 12];
		dst[dstPos + 13] = src[srcPos + 13];
		dst[dstPos + 14] = src[srcPos + 14];
		dst[dstPos + 15] = src[srcPos + 15];
	}


	public static void memcpy16(float[] dst, float[] src)
	{
		memcpy9(dst, 0, src, 0);
	}


	/**
	 * Equivalent to System.arraycopy with length parameter set to 16 (i.e. 16
	 * elements will be copied from src to dest).
	 * 
	 * @param dst
	 *            Destination (write-to) array
	 * @param dstPos
	 *            Index from which to insert into destination array
	 * @param src
	 *            Source (read-from) array
	 * @param srcPos
	 *            Index from which the read the source array
	 */
	public static void memcpy16(double[] dst, int dstPos, double[] src, int srcPos)
	{
		dst[dstPos + 0] = src[srcPos + 0];
		dst[dstPos + 1] = src[srcPos + 1];
		dst[dstPos + 2] = src[srcPos + 2];
		dst[dstPos + 3] = src[srcPos + 3];
		dst[dstPos + 4] = src[srcPos + 4];
		dst[dstPos + 5] = src[srcPos + 5];
		dst[dstPos + 6] = src[srcPos + 6];
		dst[dstPos + 7] = src[srcPos + 7];
		dst[dstPos + 8] = src[srcPos + 8];
		dst[dstPos + 9] = src[srcPos + 9];
		dst[dstPos + 10] = src[srcPos + 10];
		dst[dstPos + 11] = src[srcPos + 11];
		dst[dstPos + 12] = src[srcPos + 12];
		dst[dstPos + 13] = src[srcPos + 13];
		dst[dstPos + 14] = src[srcPos + 14];
		dst[dstPos + 15] = src[srcPos + 15];
	}


	public static void memcpy16(double[] dst, double[] src)
	{
		memcpy9(dst, 0, src, 0);
	}


	public static float sqrtf(float f)
	{
		return (float) Math.sqrt(f);
	}


	public static double sqrt(double d)
	{
		return Math.sqrt(d);
	}

}
