package Chapter8;

import java.io.Console;
import java.io.IOException;

public class ConsoleSample {

	public static void main(String[] args) throws IOException
	{
		Console console = System.console();
		if (console != null)
		{
			String userInput = console.readLine();
			console.writer().println("You entered the following: " + userInput);
		}
		else 
		{
			System.out.println("Console is null");
		}
	}

}
