package Chapter8;

import java.io.Console;

public class ConsoleSample
{
	public static void main(String[] args)
	{
		Console console = System.console();
		if (console != null)
		{
			console.writer().print("Name: ");
			console.flush();
			String userInput = console.readLine();
			console.writer().println("Hello " + userInput);
		}
	}
}