package com.tuturself.linkedlist;

import java.util.Stack;

public class PalindromeCheck_I {

	public boolean usingStack(ListNode head) {
		boolean isPalindrome = true;
		if (head == null) {
			return true;
		}
		/**
		 * Insert the LinkedList in a Stack. So if the LinkedList
		 * content is J -> A -> V -> A , then the Stack's POP order
		 * will give result in reverse order : A -> V -> A -> J
		 */
		ListNode temp = head;
		Stack<ListNode> stack = new Stack<>();
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}

		/**
		 * Now traverse the LinkedList and check every POP element
		 * from Stack. For a Palindrome every element will match.
		 */
		temp = head;
		while (temp != null) {
			if (temp.val != stack.pop().val) {
				isPalindrome = false;
				break;
			}
			temp = temp.next;
		}
		return isPalindrome;
	}
}
