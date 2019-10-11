package Chapter4;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStream {

	public static void main(String[] args) 
	{
		PrimitiveStream.testPrimitiveStreams();
		PrimitiveStream.testOptional();
		PrimitiveStream.testStatistics();
	}
	
	public static void testPrimitiveStreams()
	{
		DoubleStream ds1 = DoubleStream.of(3.14);
		DoubleStream ds2 = DoubleStream.of(1.0, 1.1, 1.2);
		
		ds1.forEach(System.out::println);
		ds2.forEach(System.out::println);
		
		DoubleStream ds3 = DoubleStream.generate(Math::random);
		DoubleStream ds4 = DoubleStream.iterate(0.5,  d-> d/2);
		ds3.limit(3).forEach(System.out::println);
		ds4.limit(3).forEach(System.out::println);
		
		
		IntStream is1 = IntStream.iterate(1,  n->n+1).limit(5);
		is1.forEach(System.out::println);
		
		is1 = IntStream.rangeClosed(1, 5);
		is1.forEach(System.out::println);
	}
	
	public static void testOptional()
	{
		System.out.println();
		IntStream is = IntStream.rangeClosed(1,  10);
		OptionalDouble od = is.average();
		od.ifPresent(System.out::println);
		System.out.println(od.getAsDouble());
		System.out.println(od.orElseGet(()->Double.NaN));
	}
	
	public static void testStatistics()
	{
		System.out.println();
	}
	
	private static int max(IntStream ints)
	{
		OptionalInt max = ints.max();
		return max.orElseThrow(RuntimeException::new);
	}
	
	private static int range(IntStream ints)
	{
		IntSummaryStatistics statistics = ints.summaryStatistics();
		if (statistics.getCount() > 0)
			throw new RuntimeException();
		return statistics.getMax() - statistics.getMin();
	}

}
