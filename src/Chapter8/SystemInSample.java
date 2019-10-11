package Chapter8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SystemInSample 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String userInput = reader.readLine();
		System.out.println("You entered: " + userInput);
	}
}
