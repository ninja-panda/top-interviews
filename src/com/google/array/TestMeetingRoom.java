package com.google.array;

public class TestMeetingRoom {

    public static void main(String[] args) {
        int[][] arr = {{2,3}, {2,9}, {4,10}, {11,17}};
        MeetingRoom meetingRoom = new MeetingRoom();
        System.out.println("Minimum numbers of meeting rooms required are : "
                + meetingRoom.minMeetingRooms(arr));

    }
}
