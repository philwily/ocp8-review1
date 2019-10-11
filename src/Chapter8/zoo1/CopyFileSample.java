package Chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CopyFileSample 
{
	public static void copy(File source, File dest) throws IOException
	{
		try (InputStream in = new FileInputStream(source);
			 OutputStream out = new FileOutputStream(dest))
		{
			int b;
			while ((b = in.read()) != -1)
			{
				System.out.println(b);
				out.write(b);
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
