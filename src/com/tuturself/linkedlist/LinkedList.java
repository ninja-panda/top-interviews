package com.tuturself.linkedlist;

public class LinkedList {

    ListNode head;

    public LinkedList(int v) {
        head = new ListNode(v);
    }

    public void add(int val) {
        ListNode node = new ListNode(val);
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public ListNode reverse() {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
            if(temp == null){
                System.out.print("NULL");
            }
        }
    }
}
