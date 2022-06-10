package com.mallow.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/5/4
 * @since JDK 1.6
 */
public class Traverse {

    public static void main(String args[]) {
        Node head = new Node("head");
        Tree tree = new Tree(head);
        head = tree.getHead();

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
        preOrderWithStack(head);
        System.out.println();
        inOrderWithStack(head);
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());

    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft());
        System.out.print(node.getData() + " ");
        inOrder(node.getRight());
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeft());

        postOrder(node.getRight());
        System.out.print(node.getData() + " ");
    }

    public static void preOrderWithStack(Node root) {
        if (root == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.getData() + " ");
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    public static void inOrderWithStack(Node root) {
        if (root == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.getData() + " ");
                if (node.getRight() != null) {
                    root = node.getRight();
                }
            }
        }
    }


}
