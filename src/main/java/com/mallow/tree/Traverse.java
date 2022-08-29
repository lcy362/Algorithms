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
        TreeNode head = new TreeNode("head");
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

    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.getData() + " ");
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());

    }

    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        inOrder(treeNode.getLeft());
        System.out.print(treeNode.getData() + " ");
        inOrder(treeNode.getRight());
    }

    public static void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        postOrder(treeNode.getLeft());

        postOrder(treeNode.getRight());
        System.out.print(treeNode.getData() + " ");
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
