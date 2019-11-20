package com.tuturself.linkedlist;


public class AddTwoNumbers {

    public ListNode add(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        int advance = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + advance;
            advance = sum / 10;
            sum = sum % 10;
            current.next = new ListNode(sum);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            if (advance == 0) {
                current.next = l1;
            } else {
                current.next = add(l1, new ListNode(advance));
            }
        } else if (l2 != null) {
            if (advance == 0) {
                current.next = l2;
            } else {
                current.next = add(l2, new ListNode(advance));
            }
        }
        // when both the lists are finished but still the carry
        // is greater than 0. Example is (5+5) = 10
        else if (l1 == null && l2 == null && advance > 0) {
            current.next = new ListNode(advance);
        }
        return head.next;
    }
}
