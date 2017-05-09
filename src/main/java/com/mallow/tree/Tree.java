package com.mallow.tree;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/5/4
 * @since JDK 1.6
 */
public class Tree {
    private Node head;

    public Tree(Node head) {
        this.head = head;
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        Node h = new Node("h");
        Node i = new Node("i");

        this.head.setLeft(a);
        this.head.setRight(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
        g.setRight(h);
        e.setLeft(i);

    }

    public Node getHead() {
        return head;
    }
}
