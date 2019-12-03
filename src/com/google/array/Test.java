package com.google.array;

public class Test {

	public static void main(String[] args) {
		String s1 = "aabhjl";
		String s2 = "klopp";
		String s3 = "aaklbhojppl";
		InterleavingString interleavingString = new InterleavingString();
		System.out.println("Is Interleaving > " + interleavingString.isInterleave(s1,s2,s3));
	}
}
