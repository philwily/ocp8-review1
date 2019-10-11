package Chapter4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {

	public static void main(String[] args) 
	{
		CollectorsTest.testBasic();
		CollectorsTest.testMaps();
		CollectorsTest.testGrouping();
	}
	
	public static void testBasic()
	{
		Stream<String> strStream = Stream.of("lions", "tigers", "bears");
		String result = strStream.collect(Collectors.joining("--", "1 ", " Z"));
		System.out.println("Result: " + result); 
		
		strStream = Stream.of("lions", "tigers", "bears");
		Double length = strStream.collect(Collectors.averagingInt(String::length));
		System.out.println("Length: " + length); 
		
		strStream = Stream.of("lions", "tigers", "bears");
		TreeSet ts = strStream.filter(s->s.startsWith("l")).collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Tree: " + ts); 
	}
	
	public static void testMaps()
	{
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		Map<String, Integer> map = ohMy.collect(Collectors.toMap(s->s, s->s.length()));
		System.out.println(map);
		
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, String> map2 = ohMy.collect(Collectors.toMap(String::length, k->k, (s1, s2)->s1+", " + s2, TreeMap::new));
		System.out.println(map2);
		System.out.println(map2.getClass());
	}
	
	public static void testGrouping()
	{
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
		System.out.println(map + " " + map.getClass());
		
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, Set<String>> set = ohMy.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		System.out.println(set + " " + set.getClass());
		
		ohMy = Stream.of("lions", "tigers", "bears");
		set = ohMy.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toCollection(TreeSet::new)));
		System.out.println(set + " " + set.getClass());
		
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Boolean, List<String>> map2 = ohMy.collect(Collectors.partitioningBy(s->s.length() <= 5));
		System.out.println(map2 + " " + map2.getClass());
		
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Boolean, Set<String>> set2 = ohMy.collect(Collectors.partitioningBy(s->s.length() <= 5, Collectors.toSet()));
		System.out.println(set2 + " " + set2.getClass());
		
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, Long> intLong = ohMy.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(intLong + " " + intLong.getClass());
		
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, Optional<Character>> newMap = ohMy.collect(
				Collectors.groupingBy(String::length, 
				Collectors.mapping(s->s.charAt(0), 
				Collectors.minBy(Comparator.naturalOrder()))));
		System.out.println(newMap + " " + newMap.getClass());
		
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, Set<Character>> newMap2 = ohMy.collect(
				Collectors.groupingBy(String::length, 
				Collectors.mapping(s->s.charAt(0), Collectors.toSet())));
		System.out.println(newMap2 + " " + newMap2.getClass());
	}

}
