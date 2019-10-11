package Chapter8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyBufferFileSample 
{
	public static void copy(File source, File dest) throws IOException
	{
		try (InputStream in = new BufferedInputStream(new FileInputStream(source));
			 OutputStream out = new BufferedOutputStream(new FileOutputStream(dest)))
		{
			byte[] buffer= new byte[1024];
			int lengthRead;
			while ((lengthRead = in.read(buffer)) > 0)
			{
				System.out.println(buffer);
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		File source = new File("Zoo.txt");
		System.out.println(source.getAbsolutePath());
		File dest = new File("ZooCopy.txt");
		copy(source, dest);
	}
}
