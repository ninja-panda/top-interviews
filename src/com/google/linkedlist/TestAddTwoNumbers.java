package com.google.linkedlist;

public class TestAddTwoNumbers {

    public static void main(String[] args) {
        ListNode firstListHead = LinkedListUtil.getListNode(1);
        LinkedList firstList = new LinkedList(firstListHead);
        firstList.add(LinkedListUtil.getListNode(5));
        firstList.add(LinkedListUtil.getListNode(1));
        firstList.add(LinkedListUtil.getListNode(8));

        ListNode secondListHead = LinkedListUtil.getListNode(3);
        LinkedList secondList = new LinkedList(secondListHead);
        secondList.add(LinkedListUtil.getListNode(6));
        secondList.add(LinkedListUtil.getListNode(3));
        secondList.add(LinkedListUtil.getListNode(9));

        ListNode head3 = LinkedListUtil.reverse(firstListHead);
        ListNode head4 = LinkedListUtil.reverse(secondListHead);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode head5 = addTwoNumbers.add(head3, head4);
        head5 = LinkedListUtil.reverse(head5);
        LinkedListUtil.print(head5);
    }
}
