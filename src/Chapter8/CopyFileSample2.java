package Chapter8;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileSample2
{
	public static void main(String[] args) throws IOException
	{
		File file1 = new File("Chapter8\\ReadFileInformation.class");
		File file2 = new File("Chapter8\\ReadFileInformation3.class");
		
		copy(file1, file2);
	}
	
	public static void copy(File file1, File file2) throws IOException
	{
		try (FileReader fr = new FileReader(file1);
			 FileWriter fw = new FileWriter(file2))
		{
			int i;
			while ( (i = fr.read()) != -1)
			{
				System.out.println("i: " + i);
				fw.write(i);
			}
		}
	}
}