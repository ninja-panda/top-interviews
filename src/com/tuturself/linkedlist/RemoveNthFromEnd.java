package com.tuturself.linkedlist;

public class RemoveNthFromEnd {

    public ListNode remove(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode fastPtr = temp;
        ListNode slowPtr = temp;
        // Advances first pointer so that the gap
        // between first and second is n nodes apart
        while (n >= 0 && fastPtr != null) {
            fastPtr = fastPtr.next;
            n--;
        }

        // Move first to the end, maintaining the gap
        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = slowPtr.next.next;
        return temp.next;
    }
}
