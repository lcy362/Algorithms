/**
 * @(#)Lcode146.java, 7月 14, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mallow.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author licy03
 * lcode-46  https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {

    private int capacity;
    private int size = 0;
    Node head, tail;
    Map<Integer, Node> data = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (data.containsKey(key)) {
            Node node = data.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = head.next;
            node.prev = head;
            node.next.prev = node;
            head.next = node;
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = data.get(key);
        if (node == null) {
           node = new Node();
           node.key = key;
           node.value = value;
           node.next = head.next;
           node.prev = head;
           node.next.prev = node;
           head.next = node;
           data.put(key, node);
           size++;
           if (size > capacity) {
               Node newLast = tail.prev.prev;
               Node last = tail.prev;
               last.prev = null;
               last.next = null;
               newLast.next = tail;
               tail.prev = newLast;
               data.remove(last.key);

           }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.value = value;
            node.next = head.next;
            node.prev = head;
            node.next.prev = node;
            head.next = node;
        }
    }

    public class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
