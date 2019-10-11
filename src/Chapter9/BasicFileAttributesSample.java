package Chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class BasicFileAttributesSample
{
	public static void main(String[] args) throws IOException
	{
		Path path = Paths.get("Chapter9\\food.txt");
		
		BasicFileAttributes data = Files.readAttributes(path, BasicFileAttributes.class);
		
		System.out.println("Is path a directory: " + data.isDirectory());
		System.out.println("Is path a regular file: " + data.isRegularFile());
		System.out.println("Is path a symbolic link: " + data.isSymbolicLink());
		System.out.println("Is path not a directory, regular file, or symbolic link: " + data.isOther());
		
		System.out.println("Size: " + data.size());
		System.out.println("Creation Time: " + data.creationTime());
		System.out.println("Last Modified: " + data.lastModifiedTime()); 
		System.out.println("Last Access: " + data.lastAccessTime());
		System.out.println("Unique file identifier: " + data.fileKey());
		
	}
}
