package com.tuturself.mix;

import java.util.HashMap;
import java.util.Map;

public class Solution_11 {

	public static void main(String[] args) {
		String s = "Iamjavadevelopper";
		Map<Character, Integer> characterByCount = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int count = characterByCount.getOrDefault(c, 0);
			characterByCount.put(c, count + 1);
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (characterByCount.get(c) == 1) result.append(c);
			else result.append('*');
		}
		System.out.println(result.toString());
	}
}
