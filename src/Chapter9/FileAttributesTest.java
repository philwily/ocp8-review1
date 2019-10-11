package Chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class FileAttributesTest
{
	public static void main(String[] args)
	{
		System.out.println("test: ");
		Path path1 = Paths.get("Chapter9\\test");
		System.out.println("Is Directory: " + Files.isDirectory(path1));
		System.out.println("Is Regular File: " + Files.isRegularFile(path1));
		System.out.println("Is Symbolic Link: " + Files.isSymbolicLink(path1));
		System.out.println("Is Readable: " + Files.isReadable(path1));
		System.out.println("Is Executable: " + Files.isExecutable(path1));
		try
		{
			System.out.println("Is Hidden: " + Files.isHidden(path1));
			System.out.println("Size: " + Files.size(path1));
			System.out.println("Last Modified Time: " + Files.getLastModifiedTime(path1));
			FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
			Files.setLastModifiedTime(path1, fileTime);
			System.out.println("Last Modified Time: " + Files.getLastModifiedTime(path1));
			System.out.println("Owner: " + Files.getOwner(path1));
			UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("ayaph");
			Files.setOwner(path1, user);
			System.out.println("Owner: " + Files.getOwner(path1));
			user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("Everyone");
			Files.setOwner(path1, user);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println();
		
		System.out.println("food.txt: ");
		Path path2 = Paths.get("Chapter9\\food.txt");
		System.out.println("Is Directory: " + Files.isDirectory(path2));
		System.out.println("Is Regular File: " + Files.isRegularFile(path2));
		System.out.println("Is Symbolic Link: " + Files.isSymbolicLink(path2));
		System.out.println("Is Readable: " + Files.isReadable(path2));
		System.out.println("Is Executable: " + Files.isExecutable(path2));
		try
		{		
			System.out.println("Is Hidden: " + Files.isHidden(path2));
			System.out.println("Size: " + Files.size(path2));
			System.out.println("Last Modified Time: " + Files.getLastModifiedTime(path2));
			FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
			Files.setLastModifiedTime(path2, fileTime);
			System.out.println("Last Modified Time: " + Files.getLastModifiedTime(path2));
			System.out.println("Owner: " + Files.getOwner(path2));
			UserPrincipal user = path2.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("ayaph");
			Files.setOwner(path2, user);
			System.out.println("Owner: " + Files.getOwner(path2));
			user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("Everyone");
			Files.setOwner(path2, user);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}