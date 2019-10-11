package Chapter5;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TestDateTime {

	public static void main(String[] args) 
	{
		TestDateTime.testNow();
		TestDateTime.testDateTimeCreation();
		TestDateTime.testDST();
		TestDateTime.testPlusMinus();
		
		System.out.println(Duration.of(1, ChronoUnit.MINUTES));
		System.out.println(Duration.ofMinutes(1));
		System.out.println(Duration.of(60, ChronoUnit.SECONDS));
		
		System.out.println(Duration.ofDays(1));
		System.out.println(Period.ofDays(1));
		
	}
	
	public static void testNow()
	{
		System.out.println("LocalDate.now(): " + LocalDate.now());
		System.out.println("LocalTime.now(): " + LocalTime.now());
		System.out.println("LocalDateTime.now(): " + LocalDateTime.now());
		System.out.println("ZonedDateTime.now(): " + ZonedDateTime.now());
		System.out.println();
	}
	
	public static void testDateTimeCreation()
	{
		LocalDate date1 = LocalDate.of(2015, Month.AUGUST, 31);
		LocalDate date2 = LocalDate.of(2015, 8, 31);
		
		System.out.println("LocalDate.of(): " + date1);
		System.out.println("LocalDate.of(): " + date2);
		
		LocalDate date3 = LocalDate.parse("2017-08-21");
		System.out.println("LocalDate.parse(): " + date3);
		System.out.println();
		
		LocalTime time1 = LocalTime.of(6,  15);
		LocalTime time2 = LocalTime.of(6,  15, 30);
		LocalTime time3 = LocalTime.of(6, 15, 30, 200);
				
		System.out.println("LocalTime.of(): " + time1);
		System.out.println("LocalTime.of(): " + time2);
		System.out.println("LocalTime.of(): " + time3);
		System.out.println();
		
		LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.AUGUST, 31, 6,15,30);
		LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
		LocalDateTime dateTime3 = LocalDateTime.parse("2017.08.31 20:30", format);
		
		System.out.println("LocalDateTime.of(): " + dateTime1);
		System.out.println("LocalDateTime.of(): " + dateTime2);
		System.out.println("LocalDateTime.parse(): " + dateTime3);
		System.out.println();
		
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MMM dd, yyyy. HH:mm");
		System.out.println("LocalDateTime.format(): " + dateTime3.format(format2));
		System.out.println();
		
		ZoneId zone = ZoneId.of("Asia/Tokyo");
		ZonedDateTime zoneDateTime1 = ZonedDateTime.of(2015, 8, 31, 6,15,30, 200, zone);
		ZonedDateTime zoneDateTime2 = ZonedDateTime.of(date1, time1, zone);
		ZonedDateTime zoneDateTime3 = ZonedDateTime.of(dateTime2, zone);
		
		System.out.println("ZonedDateTime.of(): " + zoneDateTime1);
		System.out.println("ZonedDateTime.of(): " + zoneDateTime2);
		System.out.println("ZonedDateTime.of(): " + zoneDateTime3);
		System.out.println();
		
		ZoneId.getAvailableZoneIds().stream().filter(x->x.contains("Manila")).forEach(System.out::println);	
		System.out.println();
	}
	
	public static void testDST()
	{
		LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
		LocalTime time = LocalTime.of(1, 30);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
		System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]
		dateTime = dateTime.plusMinutes(29);
		dateTime = dateTime.plusSeconds(60);
		System.out.println(dateTime); // 2016–03–13T03:00–04:00[US/Eastern]
		System.out.println("Is Daylight Savings Time: " + zone.getRules().isDaylightSavings(dateTime.toInstant()));
		System.out.println();
		
		LocalDate date2 = LocalDate.of(2016, Month.NOVEMBER, 6);
		LocalTime time2 = LocalTime.of(1, 30);
		ZoneId zone2 = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime2 = ZonedDateTime.of(date2, time2, zone2);
		System.out.println(dateTime2); // 2016–11–06T01:30–04:00[US/Eastern]
		dateTime2 = dateTime2.plusHours(1);
		System.out.println(dateTime2); // 2016–11–06T01:30–05:00[US/Eastern]
		dateTime2 = dateTime2.plusHours(1);
		System.out.println(dateTime2); // 2016–11–06T02:30–05:00[US/Eastern]
		System.out.println("Is Daylight Savings Time: " + zone2.getRules().isDaylightSavings(dateTime2.toInstant()));
		System.out.println();		
		
		LocalDate date3 = LocalDate.of(2016, Month.MARCH, 13);
		LocalTime time3 = LocalTime.of(2, 30);
		ZoneId zone3 = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime3 = ZonedDateTime.of(date3, time3, zone3);
		System.out.println(dateTime3); // 2016–03–13T03:30–04:00[US/Eastern]
		System.out.println("Is Daylight Savings Time: " + zone3.getRules().isDaylightSavings(dateTime3.toInstant()));
		System.out.println();
	}
	
	public static void testPlusMinus()
	{
		LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.AUGUST, 31, 6,15,30);
		System.out.println("dateTime: " + dateTime1);
		System.out.println("dateTime.plusHours(2): " + dateTime1.plusHours(2));
		System.out.println("dateTime.plusDays(3): " + dateTime1.plusDays(3));
		System.out.println("dateTime.getDayOfWeek(): " + dateTime1.getDayOfWeek());
		System.out.println();
		
		ZoneId zone1 = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime2 = ZonedDateTime.of(dateTime1, zone1);
		ZonedDateTime dateTime3 = dateTime2.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
		System.out.println("Next Thursday: " + dateTime3);
		Period period = Period.ofMonths(1);
		System.out.println("Period is: " + period);
		System.out.println("dateTime2.minus(1 month): " + dateTime2.minus(period));
		System.out.println("Same date time in different timezone: " + dateTime2.withZoneSameInstant(ZoneId.of("US/Pacific")));
		System.out.println();
		
		LocalTime begins = LocalTime.of(12,17,32);
		LocalTime totality = LocalTime.of(13,35,56);
		long minutes = ChronoUnit.MINUTES.between(begins, totality);
		System.out.println("Between: " + minutes);
		Duration duration = Duration.ofMinutes(minutes);
		System.out.println("Duration: " + duration);
		System.out.println();
		
		Instant nowInstant = Instant.now();
		ZoneId zone2 = ZoneId.of("Asia/Tokyo");
		ZonedDateTime dateTime4 = ZonedDateTime.of(dateTime1, zone2);
		Instant dateTime1Instant = dateTime4.toInstant();
		long minutesBetweenInstants = ChronoUnit.MINUTES.between(nowInstant, dateTime1Instant);
		Duration duration1 = Duration.ofMinutes(minutesBetweenInstants);
		System.out.println("Duration between: " + duration1);
		System.out.println();
		
		System.out.println("Now Instant Epoch: " + nowInstant.getEpochSecond());
		System.out.println();
		
		ZonedDateTime nowZoned = ZonedDateTime.now();
		System.out.println("is Before: " + nowZoned.isBefore(dateTime4));
		System.out.println("is After: " + nowZoned.isAfter(dateTime4));
		System.out.println("is Leap Year: " + dateTime4.toLocalDate().isLeapYear());
		System.out.println("is Leap (2024): " + Year.of(2024).isLeap());
		System.out.println();
		
	}

}
