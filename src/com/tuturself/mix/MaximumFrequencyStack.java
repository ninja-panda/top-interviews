package com.tuturself.mix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {

	int maxFrequency = 0;
	Map<Integer, Integer> frequency;
	Map<Integer, Stack<Integer>> elementsByFrequency;

	public MaximumFrequencyStack() {
		frequency = new HashMap<>();
		elementsByFrequency = new HashMap<>();
	}

	public void push(int x) {
		int freq = frequency.getOrDefault(x, 0);
		freq = freq + 1;
		frequency.put(x, freq);
		maxFrequency = Math.max(freq, maxFrequency);
		Stack<Integer> stack = elementsByFrequency.get(freq);
		if (stack == null) {
			stack = new Stack<>();
			elementsByFrequency.put(freq, stack);
		}
		stack.push(x);
	}

	public int pop() {
		Stack<Integer> stack = elementsByFrequency.get(maxFrequency);
		int x = stack.pop();
		frequency.put(x,frequency.get(x)-1);
		if(stack.size() == 0) maxFrequency--;
		return x;
	}
}
