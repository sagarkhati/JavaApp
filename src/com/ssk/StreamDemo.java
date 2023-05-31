package com.ssk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(3, 8, 4, 6, 5, 3, 2);

		// allMatch
		boolean allMatch = list.stream().allMatch(i -> i % 2 == 0);
		System.out.println(allMatch);

		// anyMatch
		boolean anyMatch = list.stream().anyMatch(i -> i % 2 == 0);
		System.out.println(anyMatch);

		// builder
		boolean anyMatch2 = Stream.builder().add(1).add(2).add(3).add(4).build().anyMatch(i -> (int) i > 0);
		System.out.println("anyMatch2: " + anyMatch2);

		// collect
		List<Integer> collect = list.stream().collect(Collectors.toList());
		System.out.println("collect: " + collect);
		ArrayList<Object> arrayList = list.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(arrayList);

		// concat
		Stream.concat(Arrays.asList(1, 2, 3).stream(), Arrays.asList(5, 6, 7).stream()).forEach(System.out::println);

		// count
		long count = list.stream().count();
		System.out.println("count: " + count);

		// distinct
		long count2 = list.stream().distinct().count();
		System.out.println(count2);

		// empty
		long count5 = Stream.empty().count();
		System.out.println("count5: " + count5);

		// filter
		long count3 = list.stream().filter(i -> i % 2 == 0).count();
		System.out.println(count3);

		// findAny
		Optional<Integer> findAny = list.stream().findAny();
		System.out.println(findAny.get());

		// findFirst
		Optional<Integer> findFirst = list.stream().findFirst();
		System.out.println(findFirst.get());

		// flatMap
		List<List<Integer>> list2 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
		List<Integer> collect2 = list2.stream().flatMap(i -> i.stream().filter(j -> j % 2 == 0))
				.collect(Collectors.toList());
		System.out.println(collect2);

		List<String> list3 = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");

		// flatMapToDouble
		ArrayList<Object> collect3 = list3.stream().flatMapToDouble(str -> DoubleStream.of(str.length()))
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(collect3);

		// flatMapToInt
		ArrayList<Object> collect4 = list3.stream().flatMapToInt(str -> IntStream.of(str.length()))
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(collect4);

		// flatMapToLong
		ArrayList<Object> collect5 = list3.stream().flatMapToLong(str -> LongStream.of(str.length()))
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(collect5);

		// forEach
		list.stream().forEach(System.out::println);

		// forEachOrdered
		list.stream().forEachOrdered(System.out::println);

		// generate
		Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println);

		// iterate
		Stream.iterate(10, i -> i + 1).limit(5).forEach(System.out::println);

		// limit
		list.stream().limit(2).forEach(System.out::println);

		// map
		List<Integer> collect6 = list.stream().map(i -> i * i).collect(Collectors.toList());
		System.out.println("collect6: " + collect6);

		// mapToDouble
		list.stream().mapToDouble(i -> i * 2).forEach(System.out::println);

		// mapToInt
		list.stream().mapToInt(i -> i * 2).forEach(System.out::println);

		// mapToLong
		list.stream().mapToLong(i -> i * 2).forEach(System.out::println);

		// max
		Optional<Integer> max = list.stream().max(Integer::compareTo);
		System.out.println("max: " + max.get());

		// min
		Optional<Integer> min = list.stream().min(Integer::compareTo);
		System.out.println(min.get());

		// noneMatch
		boolean noneMatch = list.stream().noneMatch(i -> i > 6);
		System.out.println("noneMatch: " + noneMatch);

		// of
		Stream.of("Geeks", "for", "Geeks").forEach(System.out::println);
		Stream.of(1).forEach(System.out::println);
		Stream.of("A").forEach(System.out::println);
		Stream.of(list).forEach(System.out::println);

		// peek
		long count4 = list.stream().peek(System.out::println).count();
		System.out.println("count4:" + count4);

		// reduce
		Optional<Integer> reduce = list.stream().reduce(Math::min);
		System.out.println("reduce: " + reduce.get());
		Integer reduce2 = list.stream().reduce(0, Integer::sum);
		System.out.println("reduce2: " + reduce2);
		Integer reduce3 = list.stream().reduce(0, Integer::sum, Integer::sum);
		System.out.println("reduce3: " + reduce3);

		// skip
		List<Integer> collect7 = list.parallelStream().skip(2).collect(Collectors.toList());
		System.out.println(collect7);

		// sorted
		List<Integer> collect8 = list.parallelStream().sorted().collect(Collectors.toList());
		System.out.println(collect8);
		List<Integer> collect9 = list.parallelStream().sorted((i1, i2) -> i2 - i1).collect(Collectors.toList());
		System.out.println(collect9);

		// toArray
		Object[] array = list.stream().toArray();
		System.out.println(Arrays.toString(array));
		Integer[] array2 = list.stream().toArray(Integer[]::new);
		System.out.println(Arrays.toString(array2));

		// iterate - java 9
		Stream.iterate(100, i -> i < 105, i -> i + 1).forEach(System.out::println);

		// ofNullable - java 9
		long count6 = Stream.ofNullable(null).count();
		System.out.println(count6);

		List<String> list4 = Arrays.asList("aman", "amar", "suraj", "suvam", "Zahafuj");

		// takeWhile - java 9
		List<String> collect10 = list4.stream().takeWhile(name -> (name.charAt(0) == 'a')).collect(Collectors.toList());
		System.out.println(collect10);

		// dropWhile - java 9
		List<String> collect11 = list4.stream().dropWhile(name -> (name.charAt(0) == 'a')).collect(Collectors.toList());
		System.out.println(collect11);
	}

}
