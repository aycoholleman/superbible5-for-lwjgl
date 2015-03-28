package superbible5.gltools;

/**
 * Utility class with C-ish methods, used to make the Java code look as much as
 * possible like the original C/C++code.
 * 
 * @author ayco
 *
 */
public class C2J {

	private C2J()
	{
	}


	/**
	 * Copy first two array elements of {@code src} to {@code dst}.
	 * 
	 * @param dst The destination (write-to) array
	 * @param src The source (read-from) array
	 */
	public static void memcpy2(float[] dst, float[] src)
	{
		dst[0] = src[0];
		dst[1] = src[1];
	}


	/**
	 * Copy first two array elements of {@code src} to {@code dst}.
	 * 
	 * @param dst The destination (write-to) array
	 * @param src The source (read-from) array
	 */
	public static void memcpy2(double[] dst, double[] src)
	{
		dst[0] = src[0];
		dst[1] = src[1];
	}


	/**
	 * Equivalent to System.arraycopy with length parameter set to 3 (i.e. three
	 * elements will be copied from src to dst).
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
		memcpy16(dst, 0, src, 0);
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
		memcpy16(dst, 0, src, 0);
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
