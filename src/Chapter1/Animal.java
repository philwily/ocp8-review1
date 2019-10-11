package Chapter1;

import java.io.Serializable;

//public abstract class Animal implements Serializable 
public class Animal implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private char type;
	
	public Animal(String name, int age, char type) 
	{
		this.name = name;
		this.age = age;
		this.type = type;
	}
	
	public String getName() { return name; }
	public int getAge() { return age; }
	public char getType() { return type; }
	
	public void printName() 
	{
		System.out.println(name);
	}
	
	public void careFor()
	{
		play();
	}
	
	public void play()
	{
		System.out.println("Pet animal");
	}
	
	public String toString() 
	{
		return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
	}
}
