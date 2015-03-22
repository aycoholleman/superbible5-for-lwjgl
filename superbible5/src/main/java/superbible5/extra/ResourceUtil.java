package superbible5.extra;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ResourceUtil {

	public static File getResource(Class<?> forClass, String relativePath)
	{
		return new File(forClass.getResource("").getPath() + relativePath);
	}


	public static String getResourceAsString(Class<?> forClass, String relativePath)
	{
		InputStream is = forClass.getResourceAsStream(relativePath);
		if (is == null) {
			throw new RuntimeException(String.format("Invalid path: \"%s\"", relativePath));
		}
		return fromInputStream(is);
	}


	private static String fromInputStream(InputStream is)
	{
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int numBytes;
		byte[] data = new byte[512];
		try {
			while ((numBytes = is.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, numBytes);
			}
			buffer.flush();
			is.close();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		return new String(buffer.toByteArray());
	}
}
