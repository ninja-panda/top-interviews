package com.google.linkedlist;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        LinkedList linkedList = new LinkedList(head);
        linkedList.add(LinkedListUtil.getListNode(2));
        linkedList.add(LinkedListUtil.getListNode(3));
        linkedList.add(LinkedListUtil.getListNode(4));
        linkedList.add(LinkedListUtil.getListNode(5));
        remove(head, 2);
        print(head);
    }

    private static ListNode remove(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode fastPtr = temp;
        ListNode slowPtr = temp;

        while (n >= 0 && fastPtr != null) {
            fastPtr = fastPtr.next;
            n--;
        }

        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = slowPtr.next.next;
        return temp.next;
    }

    private static void print(ListNode head) {
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
