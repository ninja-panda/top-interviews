package com.google.practice;

public class LinkedList {
    Node head;

    public LinkedList(int v) {
        head = new Node(v);
    }

    public void add(int v) {
        Node node = new Node(v);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
}
