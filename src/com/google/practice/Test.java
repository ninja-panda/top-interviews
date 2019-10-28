package com.google.practice;

public class Test {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(9);
        list1.add(9);
        list1.add(9);

        LinkedList list2 = new LinkedList(1);
        list2.add(1);
        Solution solution = new Solution();
        Node node = solution.addTwoList(list1.head, list2.head);

        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
