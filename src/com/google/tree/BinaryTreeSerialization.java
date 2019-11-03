package com.google.tree;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeSerialization {

    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        _serialize(root, sb);
        return sb.toString();
    }
    private void _serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        _serialize(node.left, sb);
        _serialize(node.right, sb);
    }
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        LinkedList<String> l = new LinkedList <>(Arrays.asList(arr));
        return _deserialize(l);
    }
    private TreeNode _deserialize(LinkedList<String> l) {
        if (l.getFirst().equals("null")) {
            l.removeFirst();
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(l.getFirst()));
        l.removeFirst();
        node.left = _deserialize(l);
        node.right = _deserialize(l);
        return node;
    }
}
