package Chapter5;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ZooOpen {

	public static void main(String[] args) 
	{
		Locale locale1 = new Locale("en", "US");
		Locale locale2 = Locale.FRANCE;
		
		printProperties(locale1);
		printProperties(locale2);
	}
	
	public static void printProperties(Locale locale)
	{
		ResourceBundle rb = ResourceBundle.getBundle("Chapter5/Zoo", locale);
		//System.out.println(rb.getString("hello"));
		//System.out.println(rb.getString("open"));
		
		rb.keySet().stream().map(k -> k + " " + rb.getString(k)).forEach(System.out::println);
		
		Properties props = new Properties();
		rb.keySet().stream().forEach(key->props.put(key, rb.getString(key)));
		
		System.out.println(props.getProperty("notReallyAProperty"));
		System.out.println(props.getProperty("notReallyAProperty", "123"));
	}

}
