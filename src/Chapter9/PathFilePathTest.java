package Chapter9;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathFilePathTest
{

	public static void printPathInformation(Path path)
	{
		System.out.println("File Name: " + path.getFileName());
		System.out.println("Root: " + path.getRoot());

		Path currentParent = path;
		while ( (currentParent = currentParent.getParent()) != null)
		{
			System.out.println("\tCurrent Parent: " + currentParent);
		}
	}
	public static void main(String[] args)
	{
		printPathInformation(Paths.get("/zoo/armadillo/Shells.txt"));
		System.out.println();
		printPathInformation(Paths.get("armadillo/Shells.txt"));
		System.out.println();
		
		Path path1 = Paths.get("C:","birds","egret.txt");
		System.out.println("Absolute: " + path1.isAbsolute());
		System.out.println("Absolute Path: " + path1.toAbsolutePath());
		System.out.println();
		
		Path path2 = Paths.get("birds","egret.txt");
		System.out.println("Absolute: " + path2.isAbsolute());
		System.out.println("Absolute Path: " + path2.toAbsolutePath());
		System.out.println();
		
		Path path3 = Paths.get("/mammal/carnivore/raccoon.image");
		System.out.println("Subpath from 0 to 3: " + path3.subpath(0,3));
		System.out.println("Subpath from 1 to 3: " + path3.subpath(1,3));
		System.out.println("Subpath from 1 to 2: " + path3.subpath(1,2));
		//System.out.println("Subpath from 0 to 4: " + path3.subpath(0,4));
		//System.out.println("Subpath from 1 to 1: " + path3.subpath(1,1));
		System.out.println();
		
		// Relativize - both paths should be absolute or relative, else IllegalArgumentException
		Path path4 = Paths.get("fish.txt");
		Path path5 = Paths.get("birds.txt");
		
		System.out.println("Relativize Path 4 to 5: " + path4.relativize(path5));
		System.out.println("Relativize Path 5 to 4: " + path5.relativize(path4));
		System.out.println();
		
		Path path6 = Paths.get("E:\\habitat");
		Path path7 = Paths.get("E:\\sanctuary\\raven");
		
		System.out.println("Relativize Path 6 to 7: " +path6.relativize(path7));
		System.out.println("Relativize Path 7 to 6: " +path7.relativize(path6));
		System.out.println();
		
		// Resolve
		// Absolute + relative = combined path
		// Relative + relative = combined path
		// Relative + absolute = Absolute
		// Absolute1 + Absolute2 = Absolute2		
		Path path8 = Paths.get("/cats/../panther");
		Path path9 = Paths.get("food");
		Path path12 = Paths.get("taste");
		
		System.out.println("Absolute.resolve.relative: " + path8.resolve(path9));
		System.out.println("Relative.resolve.absolute: " + path9.resolve(path8));
		System.out.println("Relative.resolve.relative: " + path9.resolve(path12));
		
		Path path10 = Paths.get("/turkey/food");
		Path path11 = Paths.get("/tiger/cage");
		
		System.out.println("Absolute.resolve.absolute: " + path10.resolve(path11));
		System.out.println("Absolute.resolve.absolute=Path11? " + path10.resolve(path11).equals(path11));
		System.out.println();
		
		Path path13 = path6.relativize(path7); // ..\sanctuary\raven
		Path path14 = path6.resolve(path13); // E:\habitat\..\santuary\raven
		System.out.println("Normalize E:\\habitat\\..\\santuary\\raven: " + path14.normalize());
		System.out.println();
		
		Path path15 = Paths.get(".\\Chapter9\\food.txt");
		Path path16 = Paths.get(".");
		try
		{
			System.out.println("Real Path: " + path15.toRealPath());
			System.out.println("Real Path: " + path16.toRealPath());
		}
		catch (IOException e)
		{
			System.out.println("Not existing");
		}
		
	}
}