package com.tuturself.linkedlist;

import java.util.Stack;

public class PalindromeCheck_II {

	public boolean usingHalfStack(ListNode head) {
		boolean isPalindrome = true;
		if (head == null) {
			return true;
		}

		/**
		 * First move to the middle of the linked list.
		 * PUSH the elements of the first half in a Stack,
		 * while finding the middle of the linked list.
		 */
		ListNode fastPtr = head, slowPtr = head;
		Stack<ListNode> stack = new Stack<>();
		while (fastPtr != null && fastPtr.next != null) {
			stack.push(slowPtr);
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}

		/**
		 * If the linked list is of odd length, then
		 * skip the middle elements of the list
		 */
		int length = length(head);
		if (length % 2 != 0) {
			slowPtr = slowPtr.next;
		}

		/**
		 * Match the last half of the linked list
		 * with the poped elements of the stack
		 */
		while (slowPtr != null) {
			int data1 = slowPtr.val;
			int data2 = stack.pop().val;
			if (data1 != data2) {
				isPalindrome = false;
				break;
			}
			slowPtr = slowPtr.next;
		}
		return isPalindrome;
	}

	private int length(ListNode head) {
		ListNode temp = head;
		int len = 0;
		while (temp != null) {
			temp = temp.next;
			len++;
		}
		return len;
	}
}
