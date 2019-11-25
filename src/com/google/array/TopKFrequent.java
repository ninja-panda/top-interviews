package com.google.array;

import java.util.*;

class Word {
	int num;
	int count;

	public Word(int n, int c) {
		this.num = n;
		this.count = c;
	}
}

class WordMinHeap extends PriorityQueue<Word> {
	public WordMinHeap(int size) {
		super(size, new Comparator<Word>() {
			@Override
			public int compare(Word o1, Word o2) {
				return o1.count - o2.count;
			}
		});
	}
}

class Solution_11 {
	public List <Integer> topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> frequencyMap = new HashMap <>();
		for (int num: nums) {
			int count = frequencyMap.getOrDefault(num, 0);
			frequencyMap.put(num, (count + 1));
		}
		WordMinHeap wordMinHeap = new WordMinHeap(k);
		for (int num: frequencyMap.keySet()) {
			int count = frequencyMap.get(num);
			Word word = new Word(num, count);
			if (wordMinHeap.size() < k) {
				wordMinHeap.add(word);
			} else {
				Word topWord = wordMinHeap.peek();
				if (word.count > topWord.count) {
					wordMinHeap.poll();
					wordMinHeap.offer(word);
				}
			}
		}
		List<Integer> list = new ArrayList <>();
		while (!wordMinHeap.isEmpty()) {
			Word word = wordMinHeap.poll();
			list.add(word.num);
		}
		return list;
	}
}

public class TopKFrequent {
	public static void main(String[] args) {
		Solution_11 solution_11 = new Solution_11();
		int k = 2;
		int[] nums = {4,1,-1,2,-1,2,3};
		List < Integer > result = solution_11.topKFrequent(nums, k);
		System.out.println(result);
	}
}