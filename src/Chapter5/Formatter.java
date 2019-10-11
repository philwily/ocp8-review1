package Chapter5;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formatter {

	public static void main(String[] args) throws ParseException
	{
		Formatter.testNumberFormat();
		Formatter.testDateTimeFormat();
	}
	
	public static void testNumberFormat() throws ParseException
	{
		int attendeesPerYear = 3_200_000;
		int attendeesPerMonth = attendeesPerYear / 12;
		
		NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
		NumberFormat nf2 = NumberFormat.getInstance(Locale.GERMANY);
		NumberFormat nf3 = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		NumberFormat nf4 = NumberFormat.getInstance(new Locale("en", "PH"));
		
		System.out.println("US: " + nf1.format(attendeesPerMonth));
		System.out.println("GERMANY: " + nf2.format(attendeesPerMonth));
		System.out.println("CANADA_FRENCH: " + nf3.format(attendeesPerMonth));
		System.out.println("PH_EN: " + nf4.format(attendeesPerMonth));
		System.out.println();
		
		double price = 48;
		nf1 = NumberFormat.getCurrencyInstance(Locale.US);
		nf2 = NumberFormat.getCurrencyInstance(Locale.GERMANY);
		nf3 = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
		nf4 = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
		
		System.out.println("US: " + nf1.format(price));
		System.out.println("GERMANY: " + nf2.format(price));
		System.out.println("CANADA_FRENCH: " + nf3.format(price));
		System.out.println("PH_EN: " + nf4.format(price));
		System.out.println();
		
		nf1 = NumberFormat.getInstance(Locale.US);
		nf2 = NumberFormat.getInstance(Locale.GERMANY);
		nf3 = NumberFormat.getInstance(Locale.FRANCE);
		nf4 = NumberFormat.getInstance(new Locale("en", "PH"));
		
		String s = "40.45";
		System.out.println("US: " + nf1.parse(s));
		System.out.println("GERMANY: " + nf2.parse(s));
		System.out.println("FRANCE: " + nf3.parse(s));
		System.out.println("PH_EN: " + nf4.parse(s));
		System.out.println();
		
		NumberFormat nf = NumberFormat.getInstance();
		String one = "456abc";
		String two = "-2.5165x10";
		String three = "x85.3";
		System.out.println(nf.parse(one)); // 456
		System.out.println(nf.parse(two)); // -2.5165
		//System.out.println(nf.parse(three));// throws ParseException
		
		String amt = "$92,807.99";
		NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.US);
		double value = (Double) cf.parse(amt);
		System.out.println(value); // 92807.99
		System.out.println();
	}

	public static void testDateTimeFormat()
	{
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		System.out.println(date.getDayOfWeek()); // MONDAY
		System.out.println(date.getMonth()); // JANUARY
		System.out.println(date.getYear()); // 2020
		System.out.println(date.getDayOfYear()); // 20
		System.out.println();
		
		LocalTime time = LocalTime.of(11, 12, 34);
		LocalDateTime dateTime = LocalDateTime.of(date, time); 
		
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println();
		
		DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(date.format(shortDateTime));
		System.out.println(dateTime.format(shortDateTime));
		System.out.println(shortDateTime.format(date));
		System.out.println(shortDateTime.format(dateTime));
		//System.out.println(time.format(shortDateTime));
		System.out.println();
		
		DateTimeFormatter mediumDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println(date.format(mediumDate));
		System.out.println(dateTime.format(mediumDate));
		System.out.println(mediumDate.format(date));
		System.out.println(mediumDate.format(dateTime));
		//System.out.println(time.format(mediumDateTime));
		System.out.println();
		
		DateTimeFormatter mediumDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.UK);
		System.out.println(dateTime.format(mediumDateTime));
		System.out.println(mediumDateTime.format(dateTime));
		//System.out.println(time.format(mediumDateTime));
		System.out.println();
		
		Locale myLocale = Locale.getDefault();
		System.out.println("My locale: " + myLocale);
		System.out.println();
		
		
	}
}
