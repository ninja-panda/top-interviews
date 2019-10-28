package com.google.linkedlist;

public class TestMergeTwoSortedList {

    public static void main(String[] args) {
        ListNode firstListHead = LinkedListUtil.getListNode(1);
        LinkedList firstList = new LinkedList(firstListHead);
        firstList.add(LinkedListUtil.getListNode(5));
        firstList.add(LinkedListUtil.getListNode(10));
        firstList.add(LinkedListUtil.getListNode(19));

        ListNode secondListHead = LinkedListUtil.getListNode(1);
        LinkedList secondList = new LinkedList(secondListHead);
        secondList.add(LinkedListUtil.getListNode(1));
        secondList.add(LinkedListUtil.getListNode(6));
        secondList.add(LinkedListUtil.getListNode(9));

        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode listNode = mergeTwoSortedList.merge(firstListHead,secondListHead);
        LinkedListUtil.print(listNode);
    }
}
