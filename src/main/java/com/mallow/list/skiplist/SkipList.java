package com.mallow.list.skiplist;

import lombok.Getter;

/**
 * Created by lcy on 2017/5/9.
 */
@Getter
public class SkipList<E extends Comparable<? super E>> {

    public static final double P = 0.5;
    public static final int MAX_LEVEL = 6;

    public final SkipNode<E> head = new SkipNode<E>(MAX_LEVEL, null);
    public int level = 0;

    public boolean contains(E searchVal) {
        SkipNode<E> x = head;
        for (int i = level; i >= 0; i--) {
            while (x.nextNodes[i] != null
                    && x.nextNodes[i].getValue().compareTo(searchVal) < 0) {
                x = x.nextNodes[i];
            }
        }
        x = x.nextNodes[0];
        return x != null && x.getValue().equals(searchVal);
    }

    public void insert(E value) {
        SkipNode<E> x = head;
        @SuppressWarnings("unchecked")
        SkipNode<E>[] update = new SkipNode[MAX_LEVEL + 1];

        for (int i = level; i >= 0; i--) {
            while (x.nextNodes[i] != null && x.nextNodes[i].getValue().compareTo(value) < 0) {
                x = x.nextNodes[i];
            }
            update[i] = x;
        }

        x = x.nextNodes[0];

        if (x == null || !x.getValue().equals(value)) {
            int nodeLevel = generateLevel();

            if (nodeLevel > level) {
                for (int i = level + 1; i <= nodeLevel; i++) {
                    update[i] = head;
                }
                level = nodeLevel;
            }

            x = new SkipNode<E>(nodeLevel, value);

            for (int i = 0; i <= nodeLevel; ++i) {
                x.nextNodes[i] = update[i].nextNodes[i];
                update[i].nextNodes[i] = x;
            }
        }
    }

    public void delete(E value) {
        SkipNode<E> x = head;
        @SuppressWarnings("unchecked")
        SkipNode<E>[] update = new SkipNode[MAX_LEVEL + 1];

        for (int i = level; i >= 0; --i) {
            while (x.nextNodes[i] != null && x.nextNodes[i].getValue().compareTo(value) < 0) {
                x = x.nextNodes[i];
            }

            update[i] = x;
        }

        x = x.nextNodes[0];

        if (x.getValue().equals(value)) {
            for (int i = 0; i <= level; ++i) {
                if (update[i].nextNodes[i] != x) {
                    break;
                }
                update[i].nextNodes[i] = x.nextNodes[i];
            }

            while (level > 0 && head.nextNodes[level] == null) {
                level--;
            }
        }
    }

    private int generateLevel() {
        for (int level = 0; level <= MAX_LEVEL; level++) {
            if (Math.random() > P) {
                return level;
            }
        }
        return MAX_LEVEL;
    }

    private void traverseLevel(int level) {
        SkipNode current = head;
        System.out.print("level: " + level + ": ");
        while (current != null) {
            System.out.print(current.getValue() + ",");
            current = current.nextNodes[level];
        }
        System.out.println();
    }

    public static void main(String args[]) {
        SkipList<Integer> list = new SkipList<>();
        for (int i = 0; i < 100; i++) {
            list.insert(i);
        }
        for (int level = 0; level <= MAX_LEVEL; level++) {
            list.traverseLevel(level);
        }
    }
}
