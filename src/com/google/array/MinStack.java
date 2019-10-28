package com.google.array;


import java.util.LinkedList;
import java.util.List;

class Node {
    int value;
    int min;
}

class MinStack {

    List<Node> data;

    public MinStack() {
        data = new LinkedList<>();
    }

    //push(x) -- Push element x onto stack.
    public void push(int x) {
        Node node = new Node();
        node.value = x;
        if (data.isEmpty()) {
            node.min = x;
        } else {
            node.min = Math.min(x, peek().min);
        }
        data.add(node);
    }

    //pop() -- Removes the element on top of the stack.
    public void pop() {
        if (!data.isEmpty()) {
            data.remove(data.size() - 1);
        }
    }

    //top() -- Get the top element.
    public int top() {
        return peek().value;
    }

    //getMin() -- Retrieve the minimum element in the stack.
    public int getMin() {
        return peek().min;
    }

    private Node peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Empty Stack");
        }
        return data.get(data.size() - 1);
    }
}
