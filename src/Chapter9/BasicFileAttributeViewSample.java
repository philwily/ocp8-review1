package Chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributeViewSample 
{
	public static void main(String[] args) throws IOException
	{
		Path path1 = Paths.get("Chapter9\\food.txt");
		BasicFileAttributeView view = Files.getFileAttributeView(path1, BasicFileAttributeView.class);
		BasicFileAttributes data = view.readAttributes();
		
		System.out.println("Last Modified: " + data.lastModifiedTime());
		
		FileTime lastModified = FileTime.fromMillis(data.lastModifiedTime().toMillis()+10_000);
		view.setTimes(lastModified, null, null);
		
		data = view.readAttributes();
		System.out.println("Last Modified: " + data.lastModifiedTime());
		
	}
}