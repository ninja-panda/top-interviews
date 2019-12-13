package com.tuturself.mix;

import java.util.*;

public class Solution_17 {

	public String mostCommonWord(String paragraph, String[] banned) {
		Map<String, Integer> frequency = new HashMap<>();
		String[] words = paragraph.replaceAll("\\p{P}", " ").toLowerCase().split(" ");
		for (String ban : banned) frequency.put(ban, -1);
		for (String word : words) {
			if (word.length() > 0) {
				int count = frequency.getOrDefault(word, 0);
				if (count == -1) continue;
				frequency.put(word, count + 1);
			}
		}
		return Collections.max(frequency.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
}
