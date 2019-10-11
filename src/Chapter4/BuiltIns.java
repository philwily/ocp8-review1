package Chapter4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BuiltIns 
{
	public static void testSupplier()
	{
		System.out.println("--------- SUPPLIER --------------");
		Supplier<LocalDate> sup1 = LocalDate::now;
		Supplier<LocalDate> sup2 = () -> LocalDate.now();
		
		System.out.println("1:" + sup1.get());
		System.out.println("2:" + sup2.get());
		
		Supplier<StringBuilder> sb1 = StringBuilder::new;
		Supplier<StringBuilder> sb2 = () -> new StringBuilder();
		
		System.out.println("3:" + sb1.get());
		System.out.println("4:" + sb2.get());
		
		Supplier<List<String>> al1 = ArrayList<String>::new;
		System.out.println("5:" + al1);
		System.out.println("6:" + al1.get());	
	}
	
	public static void testConsumer()
	{
		System.out.println("--------- CONSUMER --------------");
		Consumer<String> c1 = s -> System.out.println(s);
		Consumer<String> c2 = System.out::println;
		
		c1.accept("Hello ");
		c2.accept("World!");
		
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> bic1 = (k,v) -> map.put(k, v);
		BiConsumer<String, Integer> bic2 = map::put;
		
		bic1.accept("chicken", 7);
		bic2.accept("chick", 1);
		
		System.out.println("Map: " + map);
		
		Map<String, String> map2 = new HashMap<>();
		BiConsumer<String, String> bics1 = (k,v) -> map2.put(k, v);
		BiConsumer<String, String> bics2 = map2::put;
		
		bics1.accept("chicken", "Cluck");
		bics2.accept("chick", "Tweep");
		
		
		System.out.println("Map2: " + map2);
	}
	
	public static void testPredicate()
	{
		System.out.println("--------- PREDICATE --------------");
		Predicate<String> pred1 = s -> s.isEmpty();
		Predicate<String> pred2 = String::isEmpty;
		
		System.out.println("HELLO TEST: " + pred1.test("Hello"));
		System.out.println("BLANK TEST: " + pred2.test(""));
		
		BiPredicate<String, String> bipred1 = (s,a) -> s.startsWith(a);
		BiPredicate<String, String> bipred2 = String::startsWith;
		System.out.println("HELLO TEST: " + bipred1.test("Chicken", "Chick"));
		System.out.println("BLANK TEST: " + bipred2.test("Chicken", "Chick"));
		
		String testString = getValue();
		Predicate<String> pred3 = (a) -> testString.startsWith(a);
		Predicate<String> pred4 = testString::startsWith;
		System.out.println("HELLO TEST: " + pred3.test("Chick"));
		System.out.println("BLANK TEST: " + pred4.test("Chick"));
	}
	
	public static void testFunction()
	{
		System.out.println("--------- FUNCTION --------------");
		Function<String, Integer> func1 = s -> s.length();
		Function<String, Integer> func2 = String::length;
		
		System.out.println(func1.apply("cluck"));
		System.out.println(func2.apply("cluck"));
		
		BiFunction<String, String, String> bifunc1 = (s1, s2) -> s1.concat(s2);
		BiFunction<String, String, String> bifunc2 = String::concat;
		
		System.out.println(bifunc1.apply("baby ", "chick"));
		System.out.println(bifunc2.apply("baby ", "chick"));
		
		UnaryOperator<String> unary1 = s -> s.toUpperCase();
		UnaryOperator<String> unary2 = String::toUpperCase;
		
		System.out.println(unary1.apply("chick"));
		System.out.println(unary2.apply("chick"));
		
		BinaryOperator<String> binary1 = (s1, s2) -> s1.concat(s2);
		BinaryOperator<String> binary2 = String::concat;
		
		System.out.println(binary1.apply("baby ", "chick"));
		System.out.println(binary2.apply("baby ", "chick"));
		
	}
	
	public static String getValue()
	{
		return "Chicken";
	}
	
	public static void main(String[] args)
	{
		BuiltIns.testSupplier();
		BuiltIns.testConsumer();
		BuiltIns.testPredicate();
		BuiltIns.testFunction();
	}

}
