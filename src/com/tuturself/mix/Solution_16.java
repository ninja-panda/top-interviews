package com.tuturself.mix;

import java.util.*;

public class Solution_16 {

	class Word {
		String content;
		Integer count;

		public Word(String content, int cnt) {
			this.content = content;
			this.count = cnt;
		}
	}

	class MinHeap extends PriorityQueue<Word> {
		public MinHeap(int capacity) {
			super(capacity, new Comparator<Word>() {
				@Override
				public int compare(Word word1, Word word2) {
					if(word1.count == word2.count)
						return word2.content.compareTo(word1.content);
					return word1.count - word2.count;
				}
			});
		}
	}

	public List<String> topKFrequent(String[] words, int k) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			int count = map.getOrDefault(word, 0);
			map.put(word, count + 1);
		}
		MinHeap minHeap = new MinHeap(k);
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for (Map.Entry<String, Integer> entry : entrySet) {
			Word word = new Word(entry.getKey(), entry.getValue());
			minHeap.offer(word);
			if (minHeap.size() > k){
				minHeap.poll();
			}
		}
		while(minHeap.size() > 0){
			result.add(minHeap.poll().content);
		}
		Collections.reverse(result);
		return result;
	}
}