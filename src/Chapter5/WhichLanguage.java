package Chapter5;

import java.util.Locale;
import java.util.ResourceBundle;

public class WhichLanguage
{
	public static void main(String[] args)
	{
		Locale locale = null;
		if (args.length == 1)
			locale = new Locale(args[0]);
		else
			locale = new Locale(args[0], args[1]);
		ResourceBundle rb = ResourceBundle.getBundle("Chapter5.Labels", locale);
		if (args.length == 1)
			System.out.println(rb.getString("hello"));
		else
			System.out.println(rb.getObject("hello"));
	}
}