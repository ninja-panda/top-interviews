package com.google.linkedlist;

public class LinkedList {

    //java.util.LinkedList
    public ListNode head;

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public void add(ListNode node) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
}
