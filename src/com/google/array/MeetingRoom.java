package com.google.array;

import java.util.*;

class Meeting implements Comparable<Meeting> {

    int startTime;
    int endTime;

    public Meeting(int start, int end) {
        this.startTime = start;
        this.endTime = end;
    }

    @Override
    public int compareTo(Meeting m) {
        if (this.startTime == m.startTime) {
            return this.endTime - m.endTime;
        }
        return this.startTime - m.startTime;
    }
}

class MinHeap extends PriorityQueue<Integer> {

    public MinHeap(int capacity) {
        super(capacity, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }
}

public class MeetingRoom {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        if (intervals.length == 1) {
            return 1;
        }

        List<Meeting> meetingList = new ArrayList<>();
        for (int[] interval : intervals) {
            Meeting meeting = new Meeting(interval[0], interval[1]);
            meetingList.add(meeting);
        }
        Collections.sort(meetingList);
        MinHeap minHeap = new MinHeap(meetingList.size());
        minHeap.add(meetingList.get(0).endTime);
        for (int i = 1; i < meetingList.size(); i++) {
            Meeting meeting = meetingList.get(i);
            if(meeting.startTime < minHeap.peek()){
                minHeap.add(meeting.endTime);
            }else {
                minHeap.remove();
                minHeap.add(meeting.endTime);
            }
        }
        return minHeap.size();
    }

}
