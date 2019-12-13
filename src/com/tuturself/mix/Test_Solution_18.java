package com.tuturself.mix;


import com.tuturself.linkedlist.LinkedList;

public class Test_Solution_18 {

	public static void main(String[] args) {
		LinkedList head_1 = new LinkedList(1);
		head_1.add(2);
		head_1.add(3);
		head_1.add(4);
		head_1.add(5);
		head_1.add(6);
		head_1.add(7);
		head_1.add(8);


		Solution_18 solution_18 = new Solution_18();
		head_1.print();
		System.out.println();
		solution_18.reorderList(head_1.head);
		head_1.print();
	}
}
