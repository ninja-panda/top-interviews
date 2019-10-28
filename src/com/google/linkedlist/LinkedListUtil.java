package com.google.linkedlist;

public class LinkedListUtil {

    public static ListNode getListNode(int val) {
        ListNode listNode = new ListNode(val);
        return listNode;
    }

    public static ListNode reverse(ListNode head) {
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

    public static void print(ListNode head) {
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
