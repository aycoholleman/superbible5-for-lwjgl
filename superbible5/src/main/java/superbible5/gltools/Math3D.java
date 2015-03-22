package superbible5.gltools;

public final class Math3D {

	public static final double M3D_PI = Math.PI;
	public static final double M3D_2PI = 2D * M3D_PI;
	public static final double M3D_PI_DIV_180 = M3D_PI / 180D;
	public static final double M3D_INV_PI_DIV_180 = 180D / M3D_PI;


	//@formatter:off
	public static float  m3dDegToRad(float x)	{ return (float) (x * M3D_PI_DIV_180); }
	public static double m3dDegToRad(double x)	{ return x * M3D_PI_DIV_180; }
	
	public static float  m3dRadToDeg(float x)	{ return (float) (x * M3D_INV_PI_DIV_180); }
	public static double m3dRadToDeg(double x)	{ return x * M3D_INV_PI_DIV_180; }
	
	public static float  m3dHrToDeg(float x)	{ return (float) (x * (1F / 15F)); }
	public static double m3dHrToDeg(double x)	{ return x * (1D / 15D); }
	
	public static float  m3dHrToRad(float x) 	{ return m3dDegToRad(m3dHrToDeg(x)); }
	public static double m3dHrToRad(double x) 	{ return m3dDegToRad(m3dHrToDeg(x)); }
	
	public static float  m3dDegToHr(float x)	{ return x * 15F; }
	public static double m3dDegToHr(double x)	{ return x * 15D; }
	
	public static float m3dRadToHr(float x)		{ return m3dDegToHr(m3dRadToDeg(x)); }
	public static double m3dRadToHr(double x)	{ return m3dDegToHr(m3dRadToDeg(x)); }	
	//@formatter:on

	public static int m3dIsPOW2(int iValue)
	{
		int nPow2 = 1;
		while (iValue > nPow2) {
			nPow2 = (nPow2 << 1);
		}
		return nPow2;
	}


	//@formatter:off
	public static void m3dLoadVector2(float[] v, float x, float y) 
		{ v[0] = x; v[1] = y; }
	public static void m3dLoadVector3(float[] v, float x, float y, float z)
		{ v[0] = x; v[1] = y; v[2] = z; }
	public static void m3dLoadVector4(float[] v, float x, float y, float z, float w)
		{ v[0] = x; v[1] = y; v[2] = z; v[3] = w; }
	
	public static void m3dLoadVector2(double[] v, double x, double y) 
		{ v[0] = x; v[1] = y; }
	public static void m3dLoadVector3(double[] v, double x, double y, double z)
		{ v[0] = x; v[1] = y; v[2] = z; }
	public static void m3dLoadVector4(double[] v, double x, double y, double z, double w)
		{ v[0] = x; v[1] = y; v[2] = z; v[3] = w; }

	
	
	public static void	m3dCopyVector2(float[] dst, float[] src) { memcpy2(dst, src); }
	public static void	m3dCopyVector2(double[] dst, double[] src) { memcpy2(dst, src); }

	public static void	m3dCopyVector3(float[] dst, float[] src) { memcpy3(dst, src); }
	public static void	m3dCopyVector3(double[] dst, double[] src) { memcpy3(dst, src); }

	public static void	m3dCopyVector4(float[] dst, float[] src) { memcpy4(dst, src); }
	public static void	m3dCopyVector4(double[] dst, double[] src) { memcpy4(dst, src); }

	
	
	public static void m3dAddVectors2(float[] r, float[] a, float[] b)
		{ r[0] = a[0] + b[0]; r[1] = a[1] + b[1]; }
	public static void m3dAddVectors2(double[] r, double[] a, double[] b)
		{ r[0] = a[0] + b[0]; r[1] = a[1] + b[1]; }
	
	public static void m3dAddVectors3(float[] r, float[] a, float[] b)
		{ r[0] = a[0] + b[0]; r[1] = a[1] + b[1]; r[2] = a[2] + b[2]; }
	public static void m3dAddVectors3(double[] r, double[] a, double[] b)
		{ r[0] = a[0] + b[0]; r[1] = a[1] + b[1]; r[2] = a[2] + b[2]; }
	
	public static void m3dAddVectors4(float[] r, float[] a, float[] b)
		{ r[0] = a[0] + b[0]; r[1] = a[1] + b[1]; r[2] = a[2] + b[2]; r[3] = a[3] + b[3]; }
	public static void m3dAddVectors4(double[] r, double[] a, double[] b)
		{ r[0] = a[0] + b[0]; r[1] = a[1] + b[1]; r[2] = a[2] + b[2]; r[3] = a[3] + b[3]; }

	

	public static void m3dSubtractVectors2(float[] r, float[] a, float[] b)
		{ r[0] = a[0] - b[0]; r[1] = a[1] - b[1];  }
	public static void m3dSubtractVectors2(double[] r, double[] a, double[] b)
		{ r[0] = a[0] - b[0]; r[1] = a[1] - b[1]; }
	
	public static void m3dSubtractVectors3(float[] r, float[] a, float[] b)
		{ r[0] = a[0] - b[0]; r[1] = a[1] - b[1]; r[2] = a[2] - b[2]; }
	public static void m3dSubtractVectors3(double[] r, double[] a, double[] b)
		{ r[0] = a[0] - b[0]; r[1] = a[1] - b[1]; r[2] = a[2] - b[2]; }
	
	public static void m3dSubtractVectors4(float[] r, float[] a, float[] b)
		{ r[0] = a[0] - b[0]; r[1] = a[1] - b[1]; r[2] = a[2] - b[2]; r[3] = a[3] - b[3]; }
	public static void m3dSubtractVectors4(double[] r, double[] a, double[] b)
		{ r[0] = a[0] - b[0]; r[1] = a[1] - b[1]; r[2] = a[2] - b[2]; r[3] = a[3] - b[3]; }

	
	
	public static void m3dScaleVector2(float[] v, float scale) 
		{ v[0] *= scale; v[1] *= scale; }
	public static void m3dScaleVector2(double[] v, double scale) 
		{ v[0] *= scale; v[1] *= scale; }
	
	public static void m3dScaleVector3(float[] v, float scale) 
		{ v[0] *= scale; v[1] *= scale; v[2] *= scale; }
	public static void m3dScaleVector3(double[] v, double scale) 
		{ v[0] *= scale; v[1] *= scale; v[2] *= scale; }
	
	public static void m3dScaleVector4(float[] v, float scale) 
		{ v[0] *= scale; v[1] *= scale; v[2] *= scale; v[3] *= scale; }
	public static void m3dScaleVector4(double[] v, double scale) 
		{ v[0] *= scale; v[1] *= scale; v[2] *= scale; v[3] *= scale; }	
	//@formatter:on

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


	//@formatter:off
	public static void memcpy2(float[] dst, float[] src)
		{ dst[0] = src[0]; dst[1] = src[1]; }
	public static void memcpy3(float[] dst, float[] src)
		{ dst[0] = src[0]; dst[1] = src[1]; dst[2] = src[2]; }
	public static void memcpy4(float[] dst, float[] src)
		{ dst[0] = src[0]; dst[1] = src[1]; dst[2] = src[2]; dst[3] = src[3]; }
	
	public static void memcpy2(double[] dst, double[] src)
		{ dst[0] = src[0]; dst[1] = src[1]; }
	public static void memcpy3(double[] dst, double[] src)
		{ dst[0] = src[0]; dst[1] = src[1]; dst[2] = src[2]; }
	public static void memcpy4(double[] dst, double[] src)
		{ dst[0] = src[0]; dst[1] = src[1]; dst[2] = src[2]; dst[3] = src[3]; }
	//@formatter:on

}
