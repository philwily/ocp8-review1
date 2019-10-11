package Chapter4;

import java.util.Arrays;
import java.util.Optional;

public class OptionalExample 
{
	public static void main(String[] args)
	{
		System.out.println(average(90, 100)); // Optional[95.0]
		System.out.println(average()); // Optional.empty
		
		Optional<Double> average = average(90, 100);
		Optional<Double> average2 = average();
//		if (average.isPresent())
//		{
//			System.out.println("A1: " + average.get());
//		}
//		if (average2.isPresent())
//		{
//			System.out.println("A2: " + average2.get());
//		}
		average.ifPresent(System.out::println);
		System.out.println(average2.orElse(Double.NaN));
		System.out.println(average2.orElseGet(()->Math.random()));
		System.out.println(average2.orElseThrow(()->new IllegalStateException()));
		
		average2.ifPresent(System.out::println);
		System.out.println(average2.orElse(Double.NaN));
		System.out.println(average2.orElseGet(Math::random));
		System.out.println(average2.orElseThrow(IllegalStateException::new));
	}
	
	public static Optional<Double> average(int... scores)
	{
		Double returnValue = null;
		if (scores.length != 0)
		{
			int totalScore = 0;
			for (int score : scores)
			{
				totalScore += score;
			}
			returnValue =(double) totalScore / scores.length;
		}
			
		return Optional.ofNullable(returnValue);
		
	}
}
