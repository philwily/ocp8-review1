package Chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileSample
{
	public static void main(String[] args) throws IOException
	{
		File file1 = new File("Chapter8\\ReadFileInformation.class");
		File file2 = new File("Chapter8\\ReadFileInformationCopy.class");
		copy(file1, file2);
	}
	
	public static void copy(File file1, File file2) throws IOException
	{
		try (FileInputStream fis = new FileInputStream(file1);
		     FileOutputStream fos = new FileOutputStream(file2))
		{
			int b = 0;
			while ( (b = fis.read()) != -1)
			{
				fos.write(b);
			}
		}
	}
}