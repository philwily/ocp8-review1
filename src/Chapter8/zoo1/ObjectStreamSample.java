package Chapter8;

import Chapter1.Animal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ObjectStreamSample {

	public static List<Animal> getAnimals(File file) throws IOException, ClassNotFoundException
	{
		List<Animal> animals = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file))))
		{
			while (true)
			{
				Object object = ois.readObject();
				if (object instanceof Animal)
				{
					animals.add((Animal)object);
				}
			}
		}
		catch (EOFException eofExc)
		{
			
		}
		return animals;
	}
	
	public static void createAnimalsFile(List<Animal> animals, File file) throws IOException
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file))))
		{
			for (Animal animal : animals)
			{
				oos.writeObject(animal);
			}
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Tommy Tiger",5,'T'));
		animals.add(new Animal("Peter Penguin",8,'P'));
		File dataFile = new File("animal.data");
		createAnimalsFile(animals,dataFile);
		System.out.println(getAnimals(dataFile));
	}

}
