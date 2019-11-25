package com.google.array;

import java.util.TreeMap;

class MyCalendarTwo {

	TreeMap<Integer, Integer> calender;

	public MyCalendarTwo() {
		calender = new TreeMap();
	}

	public boolean book(int start, int end) {
		// Line Number 14
		calender.put(start, calender.getOrDefault(start, 0) + 1);
		// Line Number 15
		calender.put(end, calender.getOrDefault(end, 0) - 1);
		int activeMeetings = 0;
		for(int count : calender.values()){
			activeMeetings = activeMeetings + count;
			if(activeMeetings >= 3){
				/**
				 * The meeting can't be book. So we should normalize the counter
				 * added in line number 14 and 15
				 */
				calender.put(start, calender.get(start) - 1);
				calender.put(end, calender.get(end) + 1);
				return false;
			}
		}
		return true;
	}
}

public class MyCalendar_2 {
}
