package com.tuturself.mix;

import java.util.Stack;

/**
 * Reverse Words in a String
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 */
public class Solution_24 {

	public String reverseWords(String s) {

		int left = 0;
		int right = s.length() - 1;

		// remove leading spaces
		while (left <= right) {
			if (s.charAt(left) == ' ') {
				left++;
			} else break;
		}

		// remove trailing spaces
		while (left <= right) {
			if (s.charAt(right) == ' ') {
				right--;
			} else break;
		}

		StringBuilder word = new StringBuilder();
		Stack<String> wordStack = new Stack();
		while (left <= right) {
			char current = s.charAt(left);
			if (current != ' ') {
				word.append(current);
			} else {
				if (word.length() > 0) {
					String sWord = word.toString();
					wordStack.push(sWord);
					word = new StringBuilder();
				}
			}
			left++;
		}
		if (word.length() > 0) {
			String sWord = word.toString();
			wordStack.push(sWord);
		}
		StringBuilder result = new StringBuilder();
		while (wordStack.size() > 0) {
			result.append(wordStack.pop());
			if (wordStack.size() != 0) result.append(" ");
		}
		return result.toString();
	}
}
