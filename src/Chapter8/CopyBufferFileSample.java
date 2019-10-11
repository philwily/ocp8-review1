package Chapter8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CopyBufferFileSample
{
	public static void main(String[] args) throws IOException
	{
		File file1 = new File("Chapter8\\ReadFileInformation.class");
		File file2 = new File("Chapter8\\ReadFileInformationCopy2.class");
		copy(file1, file2);
	}
	
	public static void copy(File file1, File file2) throws IOException
	{
		try (InputStream is = new BufferedInputStream(new FileInputStream(file1));
		     OutputStream os = new BufferedOutputStream(new FileOutputStream(file2)))
		{
			byte[] buffer = new byte[1024];
			int length = 0;
			while ( (length = is.read(buffer)) != -1)
			{
				//System.out.println("Length: " + length);
				os.write(buffer, 0, length);
				os.flush();
			}
		}
	}
}