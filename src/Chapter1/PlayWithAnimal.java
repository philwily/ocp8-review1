package Chapter1;

public class PlayWithAnimal {

	public static void main(String[] args) {
		Animal animal = new Lion(1, 5, "Leo");
		//Lion animal = new Lion();
		animal.printName();
		animal.careFor();
		System.out.println(animal);
	}

}
