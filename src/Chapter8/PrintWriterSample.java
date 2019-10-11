package Chapter8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterSample 
{
	public static void main(String[] args) throws IOException 
	{
		File file1 = new File("Chapter8\\zoo.log");
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file1))))
		{
			pw.print("Today's weather is: ");
			pw.println("Sunny");
			pw.print("Today's temperature is: ");
			pw.print(1/3.0);
			pw.println('C');
			pw.format("It has rained ");
			pw.format("%.02f", 20.24/2);
			pw.format(" inches this year");
			pw.println();
			pw.printf("It may rain ");
			pw.printf("%.02f", 42.4/2);
			pw.printf(" inches this year"); 
		}
	}
}
