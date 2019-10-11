package Chapter2;

import Chapter1.Animal;

public class Tiger implements Sprint<Animal, String> {

	@Override
	public String sprint(Animal animal) 
	{
		//System.out.println("Animal is sprinting fast! "+animal.toString());
		return "Animal is sprinting fast! "+animal.toString();
	}

}
