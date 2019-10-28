package com.google.practice;

public class Solution {

    public Node addTwoList(Node h1, Node h2) {

        if (h1 == null && h2 == null) {
            return null;
        }
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        Node h = new Node(0);
        Node current = h;
        int carry = 0;
        while (h1 != null && h2 != null) {
            int sum = h1.value + h2.value + carry;
            carry = sum / 10;
            sum = sum % 10;
            current.next = new Node(sum);
            h1 = h1.next;
            h2 = h2.next;
            current = current.next;
        }

        if (h1 != null) {
            if (carry > 0) {
                current.next = addTwoList(h1, new Node(carry));
            } else {
                current.next = h1;
            }
        } else if (h2 != null) {
            if (carry > 0) {
                current.next = addTwoList(h2, new Node(carry));
            } else {
                current.next = h2;
            }
        } else if (h1 == null && h2 == null && carry > 0) {
            current.next = new Node(carry);
        }
        return h.next;
    }
}
