package Chapter9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest
{
	public static void main (String[] args)
	{
		System.out.println("Exists: food.txt: " + Files.exists(Paths.get("Chapter9\\food.txt")));
		System.out.println("Exists: test: " + Files.exists(Paths.get("Chapter9\\test")));
		System.out.println("Exists: test.txt: " + Files.exists(Paths.get("Chapter9\\test.txt")));
		
		try 
		{
			// returns true also for symbolic links referring to same file
			// 1st check is if equal (will not normalize and not required existing)
			// next follows if refers to same file
			System.out.println("isSameFile: " + Files.isSameFile(Paths.get("Chapter9\\.\\food.txt"), Paths.get("Chapter9\\food.txt"))); //existing 
			System.out.println("isSameFile: " + Files.isSameFile(Paths.get("Chapter9\\test.txt"), Paths.get("Chapter9\\test.txt"))); // not existing, but equal path
			System.out.println("isSameFile: " + Files.isSameFile(Paths.get("Chapter9\\.\\test.txt"), Paths.get("Chapter9\\test.txt"))); // not existing, different path not normalized
		}
		catch (IOException e)
		{
			System.out.println("Expected as path is not existing");
			System.out.println();
		}
		
		try 
		{
			Files.createDirectory(Paths.get("Chapter9\\test1"));
			Files.createDirectories(Paths.get("Chapter9\\test2\\test3\\test4"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			Files.copy(Paths.get("Chapter9\\test1"), Paths.get("Chapter9\\test3"));
			Files.copy(Paths.get("Chapter9\\food.txt"), Paths.get("Chapter9\\test3\\food2.txt"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try (InputStream is = new FileInputStream("Chapter9\\food.txt");
		     OutputStream os = new FileOutputStream("Chapter9\\food2.txt"))
		{
			Files.copy(is, Paths.get("Chapter9\\food4.txt"));
			
			Files.copy(Paths.get("Chapter9\\food4.txt"), os);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			Files.move(Paths.get("Chapter9\\test3"), Paths.get("Chapter9\\test4"));
			Files.move(Paths.get("Chapter9\\food4.txt"), Paths.get("Chapter9\\test4\\food3.txt"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		Path path1 = Paths.get("Chapter9\\food.txt");
		List<String> data = new ArrayList<>();
		try (BufferedReader br = Files.newBufferedReader(path1, Charset.forName("US-ASCII")))
		{
			String line = null;
			while ( (line = br.readLine()) != null)
			{
				data.add(line);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		Path path2 = Paths.get("Chapter9\\food2.txt");
		try (BufferedWriter bw = Files.newBufferedWriter(path2, Charset.forName("UTF-16")))
		{
			for (String line : data)
			{
				bw.write(line);
				bw.write("\n");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			List<String> allLines = Files.readAllLines(path2, Charset.forName("UTF-16"));
			for (String line : allLines)
			{
				System.out.println(line);
			}
			Files.deleteIfExists(Paths.get("Chapter9\\test10"));
			Files.delete(Paths.get("Chapter9\\food2.txt"));
			Files.delete(Paths.get("Chapter9\\test1"));
			Files.delete(Paths.get("Chapter9\\test2\\test3\\test4"));
			Files.delete(Paths.get("Chapter9\\test2\\test3"));
			Files.delete(Paths.get("Chapter9\\test2"));
			Files.delete(Paths.get("Chapter9\\test4\\food2.txt"));
			Files.delete(Paths.get("Chapter9\\test4\\food3.txt"));
			Files.delete(Paths.get("Chapter9\\test4"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
}