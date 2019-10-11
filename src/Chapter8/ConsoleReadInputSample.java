package Chapter8;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class ConsoleReadInputSample
{
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param   args
	 * @throws  IOException
	 */
	public static void main(String[] args) throws IOException
	{
		Console console = System.console();
		if (console == null)
		{
			throw new RuntimeException("Console not available");
		}
		else
		{
			console.writer().print("Excitement Level: ");
			console.flush();
			String excitementLevel = console.readLine();

			String name = console.readLine("What is your name? ");

			Integer age = null;
			console.writer().print("Age: ");
			console.flush();

			BufferedReader reader = new BufferedReader(console.reader());
			String value = reader.readLine();
			age = Integer.parseInt(value);

			console.writer().println();
			console.format("Your name is: " + name);
			console.writer().println();
			console.format("Your age is: " + age);
			console.writer().println();
			console.printf("Your excitement level is: " + excitementLevel);
		}
	}
}
