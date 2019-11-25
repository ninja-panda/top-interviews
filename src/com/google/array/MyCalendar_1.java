package com.google.array;

import java.util.TreeMap;

class MyCalendar {

	TreeMap<Integer, Integer> calender;

	public MyCalendar() {
		calender = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		Integer lastKey = calender.floorKey(start);
		Integer nextKey = calender.ceilingKey(start);
		/**
		 * You can book an appointment only if the start of
		 * current appointment is greater or equal to the end
		 * of last appointment and the end of current appointment
		 * is less than or equal to the next appointment.
		 */
		if ((lastKey == null || calender.get(lastKey) <= start) &&
						(nextKey == null || nextKey >= end)) {
			calender.put(start, end);
			return true;
		}
		return false;
	}
}

public class MyCalendar_1 {
	public static void main(String[] args) {
		MyCalendar myCalendar = new MyCalendar();
		System.out.println("Book the slot :" + myCalendar.book(10, 20));
		System.out.println("Book the slot :" + myCalendar.book(15, 25));
		System.out.println("Book the slot :" + myCalendar.book(20, 30));
	}
}
