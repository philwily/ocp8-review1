package Chapter5;

import java.util.Locale;

public class TestLocale 
{
	public static void main(String[] args) 
	{
		TestLocale.testLocale();
		
		
	}
	
	public static void testLocale()
	{
		Locale locale = Locale.getDefault();
		System.out.println(locale); //en_US
		
		System.out.println(Locale.GERMAN); // de
		System.out.println(Locale.GERMANY); // de_DE
		
		locale = new Locale("en", "PH");
		System.out.println(locale);
		Locale.setDefault(locale);
				
		locale = new Locale.Builder().setLanguage("fr").setRegion("CA").build();
		System.out.println(locale);
		
		locale = new Locale.Builder() // bad but legal
				.setRegion("us")
				.setLanguage("EN")
				.build();
		System.out.println(locale);
		
		locale = Locale.getDefault();
		System.out.println(locale);
		
	}
}
