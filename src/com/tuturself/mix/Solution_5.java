package com.tuturself.mix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_5 {

	public String[] reorderLogFiles(String[] logs) {
		if (logs == null || logs.length == 0)
			return null;
		List<String> letterLogs = new ArrayList<>();
		List<String> digitsLogs = new ArrayList<>();
		for (String logLine : logs) {
			String[] token = logLine.split(" ");
			if (Character.isDigit(token[1].charAt(0))) {
				digitsLogs.add(logLine);
			} else {
				letterLogs.add(logLine);
			}
		}
		Collections.sort(letterLogs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] token1 = o1.split(" ");
				String[] token2 = o2.split(" ");
				int cmp = 0;
				int len = Math.min(token1.length, token2.length);
				for (int i = 1; i < len; i++) {
					cmp = token1[i].compareTo(token2[i]);
					if (cmp != 0) break;
				}
				if (cmp == 0) {
					cmp = token1[0].compareTo(token2[0]);
				}
				return cmp;
			}
		});
		letterLogs.addAll(digitsLogs);
		return letterLogs.toArray(new String[letterLogs.size()]);
	}
}
