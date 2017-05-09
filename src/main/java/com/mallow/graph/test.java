package com.mallow.graph;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/5/4
 * @since JDK 1.6
 */
public class test {
    public static void main(String args[]) {
        Graph graph = new Graph(7);
        graph.connect(0, 1);
        graph.connect(0, 4);
        graph.connect(1, 2);
        graph.connect(4, 5);
        graph.connect(1, 5);
        graph.connect(5, 3);
        graph.connect(5, 6);
        graph.connect(3, 6);
        graph.connect(0, 2);

        graph.dfsTraverse();
        graph.bfsTraverse();
    }
}
