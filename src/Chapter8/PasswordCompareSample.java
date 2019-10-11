package Chapter8;

import java.io.Console;
import java.util.Arrays;

public class PasswordCompareSample 
{
	public static void main(String[] args)
	{
		Console console = System.console();
		if (console != null)
		{
			char[] password = console.readPassword("Please input password: ");
			console.format("Enter password again: ");
			console.flush();
			char[] repeat = console.readPassword();
			
			boolean match = Arrays.equals(password, repeat);
			
			console.format("Your passwords: " + (match ? "Correct" : "Incorrect"));
		}
	}
}