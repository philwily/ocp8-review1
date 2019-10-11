package Chapter8;

import java.io.File;

public class ReadFileInformation
{
	public static void main(String[] args) 
	{
		File file1 = new File("F:\\Java\\OCP\\src\\Chapter8\\zoo.txt");
		File file2 = new File("F:\\Java\\OCP\\src\\Chapter8\\zoo1");
		printResult(file1);
		System.out.println();
		printResult(file2);
	}

	public static void printResult(File file)
	{
		System.out.println("File exists: " + file.exists());
		if (file.exists())
		{
			System.out.println("Absolute Path: " + file.getAbsolutePath());
			System.out.println("Parent Path: " + file.getParent());
			System.out.println("Is Directory: " + file.isDirectory());
			if (file.isFile())
			{
				System.out.println("File Size: " + file.length());
				System.out.println("File Last Modified: " + file.lastModified());
			}
			else
			{
				File[] files = file.listFiles();
				for (File f1 : files)
				{
					System.out.println("\t" + f1.getName());
				}
			}
		}
	}
}