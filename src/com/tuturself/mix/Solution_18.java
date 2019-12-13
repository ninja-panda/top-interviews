package com.tuturself.mix;


import com.tuturself.linkedlist.ListNode;

public class Solution_18 {

	public void reorderList(ListNode head) {
		if (head == null) return;
		if (head.next == null) return;
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		while (fastPtr != null && fastPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		ListNode middle = slowPtr.next;
		slowPtr.next = null;
		middle = reverse(middle);
		head = merge(head, middle);
	}

	public ListNode reverse(ListNode head) {
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

	private ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head = new ListNode(0);
		ListNode current = head;
		int i = 2;
		while (l1 != null && l2 != null) {
			if (i % 2 == 0) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			i++;
			current = current.next;
		}
		if (l1 != null) {
			current.next = l1;
		}
		if (l2 != null) {
			current.next = l2;
		}
		return head.next;
	}
}
