package com.ssk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptionalInMapDemo {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 21, 42, 4, 12, 4, 41, 2, 1, 4, 12, 241, 2, 312, 1, 2, 1, 3, 4,
				5, 1, 3, 51, 5);

		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

		list.forEach(i -> countMap.put(i, countMap.getOrDefault(i, 0) + 1));

		System.out.println("Elements\tOccurrence");
		countMap.forEach((k, v) -> System.out.println(k + "\t\t" + v));
	}

}
