package com.google.array;

import java.util.HashSet;
import java.util.Set;

class NextClosestTimeSolution {

	public String nextClosestTime(String time) {
		int hours = Integer.parseInt(time.substring(0, 2));
		int minutes = Integer.parseInt(time.substring(3));
		int currentTimeInMinutes = 60 * hours + minutes;
		Set<Integer> allowed = new HashSet();
		for (char c : time.toCharArray()) {
			if (c != ':') {
				allowed.add(c - '0');
			}
		}

		while (true) {
			currentTimeInMinutes = (currentTimeInMinutes + 1) % (24 * 60);
			int[] digits = new int[]{currentTimeInMinutes / 60 / 10,
							currentTimeInMinutes / 60 % 10,
							currentTimeInMinutes % 60 / 10,
							currentTimeInMinutes % 60 % 10};
			if (isValid(allowed, digits)) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(digits[0]).append(digits[1]);
				buffer.append(":");
				buffer.append(digits[2]).append(digits[3]);
				return buffer.toString();
			}
		}
	}

	private boolean isValid(Set<Integer> allowed, int[] digits) {
		for (int d : digits) {
			if (!allowed.contains(d)) {
				return false;
			}
		}
		return true;
	}

}

public class NextClosestTime {
	public static void main(String[] args) {
		String time = "23:59";
		NextClosestTimeSolution nextClosestTimeSolution = new NextClosestTimeSolution();
		System.out.println(nextClosestTimeSolution.nextClosestTime(time));
	}
}
