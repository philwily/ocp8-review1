package Chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class CopyTextFileSample
{
	public static void main(String[] args) throws IOException
	{
		File file1 = new File("Chapter8\\zoo.txt");
		File file2 = new File("Chapter8\\zoocopy.txt");
		
		List<String> lines = read(file1);
		write(lines, file2);
	}
	
	public static List<String> read(File file1) throws IOException
	{
		List<String> lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file1)))
		{
			String s;
			while ( (s = br.readLine()) != null)
			{
				lines.add(s);
			}
		}			
		return lines;
	}
	
	public static void write(List<String> lines, File file2) throws IOException
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file2)))
		{
			for (String line : lines) 
			{
				bw.write(line);
				bw.newLine();
			}
		}
	}
		
}
