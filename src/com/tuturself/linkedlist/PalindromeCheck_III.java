package com.tuturself.linkedlist;

public class PalindromeCheck_III {

	public boolean isPalindrome(ListNode head) {
		boolean isPalindrome = true;
		if (head == null) {
			return true;
		}

		// Find the middle node of the linked list
		ListNode fastPtr = head, slowPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}

		ListNode temp = slowPtr;

		// Reverse the linked list from Middle
		ListNode tempHead = reverseList(temp);
		ListNode preserveMiddle = tempHead;
		// Set fastPtr to head
		fastPtr = head;

		/**
		 * Compare nodes from head and reverse nodes from
		 * middle to check if the linked list is palindrome
		 */
		while (tempHead != null) {
			if (fastPtr.val != tempHead.val) {
				isPalindrome = false;
				break;
			}
			fastPtr = fastPtr.next;
			tempHead = tempHead.next;
		}
		// reconstruct the LinkedList
		ListNode middle = reverseList(preserveMiddle);
		slowPtr = head;
		while (slowPtr != null){
			slowPtr = slowPtr.next;
		}
		slowPtr = middle;
		return isPalindrome;
	}

	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}
}
