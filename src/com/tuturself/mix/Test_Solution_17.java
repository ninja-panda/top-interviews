package com.tuturself.mix;

public class Test_Solution_17 {

	public static void main(String[] args) {
		String paragraph = "Bob. hIt, baLl";
		String[] banned = {"bob", "hit"};
		Solution_17 solution_17 = new Solution_17();
		System.out.println(solution_17.mostCommonWord(paragraph,banned));
	}
}
