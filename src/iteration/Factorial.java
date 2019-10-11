package iteration;

public class Factorial
{
	public static void main(String[] args)
	{
		int input = 5;
		int factorial = 1;
		for (int i = 1; i <= input; i++)
		{
			factorial *= i;
		}
		
		System.out.println(input + " factorial: " + factorial);
	}
	
}