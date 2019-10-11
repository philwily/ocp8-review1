package Chapter4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
	
	public static void main(String[] args)
	{
		
		StreamExample.testGenerateIterate();
		StreamExample.testTerminal();
		StreamExample.testIntermediate();
		
		List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
		Stream<String> s = list.stream();
		s.filter(str->str.length()==4).sorted().limit(2).forEach(System.out::println);
	}
	
	public static void testGenerateIterate()
	{
		Stream<Double> random1 = Stream.generate(Math::random);
		Stream<Double> random2 = Stream.generate(() -> Math.random());
		
		//random1.forEach(System.out::println);
		//random2.forEach(x -> System.out.println(x));
		
		Stream<Integer> oddNumbers = Stream.iterate(1, n -> n+2);
		//oddNumbers.forEach(System.out::println);
	}

	public static void testTerminal()
	{
		//count
		Stream<String> s = Stream.of("Monkey", "gorilla", "bamboo");
		System.out.println(s.count());
		
		//min/max
		s = Stream.of("monkey", "ape", "bamboo");
		Optional<String> min = s.min((s1,s2)->s1.compareTo(s2));
		min.ifPresent(System.out::println);
		
		s = Stream.empty();
		min = s.min((s1,s2)->s1.compareTo(s2));
		System.out.println(min.isPresent());
		min.ifPresent(System.out::println);
		
		//findAny/findFirst
		s = Stream.of("monkey", "ape", "bamboo");
		Optional<String> findAny = s.findAny();
		findAny.ifPresent(System.out::println);
		
		s = Stream.generate(()->"chimp");
		Optional<String> findAny2 = s.findAny();
		findAny2.ifPresent(System.out::println);
		
		//allMatch, noneMatch, anyMatch
		List<String> animals = Arrays.asList("monkey", "2", "chimp");
		Predicate<String> isLetter = x -> Character.isLetter(x.charAt(0));
		System.out.println("ANY MATCH: " + animals.stream().anyMatch(isLetter));
		System.out.println("ALL MATCH: " + animals.stream().allMatch(isLetter));
		System.out.println("NO MATCH: " + animals.stream().noneMatch(isLetter));
		
		Stream<String> infinite = Stream.generate(()->"chimp");
		System.out.println("ANY MATCH1: " + infinite.anyMatch(isLetter));
		//infinite = Stream.generate(()->"chimp");
		//System.out.println("ALL MATCH: " + infinite.allMatch(isLetter));
		infinite = Stream.generate(()->"chimp");
		System.out.println("NO MATCH: " + infinite.noneMatch(isLetter));
		
		//forEach
		s = Stream.of("monkey", "ape", "bamboo");
		s.forEach(System.out::println);
		
		//reduce
		List<String> letters = Arrays.asList("w", "o", "l", "f");
		String word = letters.stream().reduce("", String::concat);
		System.out.println("WORD: " + word);
		
		Stream<Integer> stream = Stream.of(3, 5, 6);
		int result = stream.reduce(1, (x,y)->x*y);
		System.out.println("RESULT: " + result);
		
		stream = Stream.empty();
		result = stream.reduce(1, (x,y)->x*y);
		System.out.println("RESULT: " + result);
		
		BinaryOperator<Integer> operator = (x,y)->x*y;
		stream = Stream.empty();
		stream.reduce(operator).ifPresent(System.out::println);
		stream = Stream.of(3);
		stream.reduce(operator).ifPresent(System.out::println);
		stream = Stream.of(3, 5, 6);
		stream.reduce(operator).ifPresent(System.out::println);
		
		stream = Stream.of(3, 5, 6);
		stream.reduce(1, operator, operator);
		
		// collect
		s  = Stream.of("w", "o", "l", "f");
		StringBuilder builder = s.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(builder);
		
		s = Stream.of("w", "o", "l", "f");
		TreeSet<String> treeset = s.collect(TreeSet<String>::new, TreeSet::add, TreeSet::addAll);
		System.out.println(treeset);
		
		s = Stream.of("w", "o", "l", "f");
		System.out.println(s.collect(Collectors.toCollection(TreeSet::new)));
		
		s = Stream.of("w", "o", "l", "f");
		System.out.println(s.collect(Collectors.toSet()));
	}
	
	public static void testIntermediate()
	{
		//filter
		Stream<String> s = Stream.of("monkey", "ape", "bamboo", "Meowth");
		s = s.filter(str->str.startsWith("m"));
		s.forEach(System.out::print);
		System.out.println();
		
		//distinct
		s = Stream.of("duck", "duck", "duck", "goose");
		s.distinct().forEach(System.out::print);
		System.out.println();
		
		//limit and skip
		Stream<Integer> ints = Stream.iterate(1, n->n+1);
		ints.skip(5).limit(3).forEach(System.out::print);
		System.out.println();
		
		//map
		s = Stream.of("duck", "duck", "duck", "goose");
		ints = s.map(String::length);
		ints.forEach(System.out::print);
		System.out.println();
		
		//flatmap
		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("Bonobo");
		List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
		animals.flatMap(List::stream).forEach(System.out::println);
		
		//sorted
		s = Stream.of("brown-", "bear-");
		s.sorted().forEach(System.out::print);
		System.out.println();
		
		s = Stream.of("brown bear-", "grizzly-");
		s.sorted(Comparator.reverseOrder()).forEach(System.out::print); // grizzly-brown bear-
		
		//s = Stream.of("brown bear-", "grizzly-");
		//s.sorted(Comparator::reverseOrder);
		
		// peek
		s = Stream.of("black bear", "brown bear", "grizzly");
		long count = s.filter(str->str.startsWith("g")).peek(System.out::println).count();
		System.out.println(count);
	}
}
