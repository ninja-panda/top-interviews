package com.tuturself.linkedlist;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList palindromeList = new LinkedList(1);
		palindromeList.add(2);
		palindromeList.add(3);
		palindromeList.add(2);
		palindromeList.add(1);

		System.out.println("The Original Linked List");
		palindromeList.print();
		System.out.println();
		PalindromeCheck_I palindromeCheck_i = new PalindromeCheck_I();
		System.out.println("Is Palindrome: " + palindromeCheck_i.usingStack(palindromeList.head));
		PalindromeCheck_II palindromeCheck_ii = new PalindromeCheck_II();
		System.out.println("Is Palindrome: " + palindromeCheck_ii.usingHalfStack(palindromeList.head));
		PalindromeCheck_III palindromeCheck_iii = new PalindromeCheck_III();
		System.out.println("Is Palindrome: " + palindromeCheck_iii.isPalindrome(palindromeList.head));
		palindromeList.print();
	}
}
