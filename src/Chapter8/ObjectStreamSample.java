package Chapter8;

import Chapter1.Animal;
import Chapter1.Animal2	;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ObjectStreamSample
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		File file1 = new File("Chapter8\\zoo.txt");
		List<Animal> animals = readInput(file1);
		List<Animal2> animals2 = readInput2(file1);
		System.out.println("Animals: " + animals.size());
		System.out.println("Animals2: " + animals.size());
		
		File file2 = new File("Chapter8\\animal.dat");
		write(animals, file2);
		
		File file3 = new File("Chapter8\\animal2.dat");
		write2(animals2, file3);
		
		animals = read(file2);
		System.out.println(animals);
		
		animals2 = read2(file3);
		System.out.println(animals2);
		
	}
	
	public static List<Animal> readInput(File file1) throws IOException
	{
		List<Animal> animals = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file1)))
		{
			String str;
			while ((str = br.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(str, ",");
				String name = null;
				int age = 0;
				char type = ' ';
				int tokens = st.countTokens(); 
				for (int i = 0; i < tokens; i++)
				{
					switch(i)
					{
						case 0:
							st.nextToken();
							break;
						case 1:
							name = st.nextToken();
							break;
						case 2:
						{
							age = Integer.parseInt(st.nextToken());
							break;
						}
						case 3:
						{
							type = Character.valueOf(st.nextToken().charAt(0));
							break;
						}
						default:
							break;
					}
				}
				
				Animal animal = new Animal(name, age, type);
				animals.add(animal);
			}
		}
		
		return animals;
	}
	
	public static List<Animal2> readInput2(File file1) throws IOException
	{
		List<Animal2> animals = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file1)))
		{
			String str;
			while ((str = br.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(str, ",");
				String name = null;
				int age = 0;
				char type = ' ';
				int tokens = st.countTokens(); 
				for (int i = 0; i < tokens; i++)
				{
					switch(i)
					{
						case 0:
							st.nextToken();
							break;
						case 1:
							name = st.nextToken();
							break;
						case 2:
						{
							age = Integer.parseInt(st.nextToken());
							break;
						}
						case 3:
						{
							type = Character.valueOf(st.nextToken().charAt(0));
							break;
						}
						default:
							break;
					}
				}
				
				Animal2 animal = new Animal2(name, age, type);
				animals.add(animal);
			}
		}
		
		return animals;
	}
	
	public static void write(List<Animal> animals, File file) throws IOException
	{
		int ctr = 0;
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file))))
		{
			for (Animal animal : animals)
			{
				oos.writeObject(animal);
				ctr++;
			}
		}
		
		System.out.println("Animals written: " + ctr);
	}
	
	public static void write2(List<Animal2> animals, File file) throws IOException
	{
		int ctr = 0;
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file))))
		{
			for (Animal2 animal : animals)
			{
				oos.writeObject(animal);
				ctr++;
			}
		}
		
		System.out.println("Animals written: " + ctr);
	}
	
	public static List<Animal> read(File file) throws IOException, ClassNotFoundException
	{
		List<Animal> animals = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file))))
		{
			while (true)
			{
				Object object = ois.readObject();
				if (object instanceof Animal)
				{
					Animal animal = (Animal) object;
					animals.add(animal);
				}
			}
		}
		catch (EOFException eofException) {}
		
		return animals;
	}
	
	public static List<Animal2> read2(File file) throws IOException, ClassNotFoundException
	{
		List<Animal2> animals = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file))))
		{
			while (true)
			{
				Object object = ois.readObject();
				if (object instanceof Animal2)
				{
					Animal2 animal = (Animal2) object;
					animals.add(animal);
				}
			}
		}
		catch (EOFException eofException) {}
		
		return animals;
	}
}