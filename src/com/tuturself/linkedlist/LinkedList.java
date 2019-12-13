package com.tuturself.linkedlist;

public class LinkedList {

    public ListNode head;

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
