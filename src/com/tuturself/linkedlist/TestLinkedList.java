package com.tuturself.linkedlist;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(9);

        LinkedList list2 = new LinkedList(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(1);

        System.out.println("First List >>");
        list1.print();
        System.out.println("\nSecond List >>");
        list2.print();
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        LinkedList result = new LinkedList(0);
        result.head = addTwoNumbers.add(list1.head,list2.head);
        System.out.println("\nSun >>");
        result.print();
    }
}
