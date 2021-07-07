/**
 * @(#)Lcode86.java, 7月 07, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mallow.algorithm;

/**
 * @author licy03
 */
public class Lcode86 {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode();
        ListNode bigHead = new ListNode();
        ListNode smallTail = smallHead;
        ListNode bigTail = bigHead;
        ListNode node = head;
        while (node != null) {
           ListNode next = node.next;
           if (node.val < x) {
               smallTail.next = node;
               smallTail = smallTail.next;
               if (next != null) {
                   smallTail.next = null;
               }
           } else {
               bigTail.next = node;
               bigTail = bigTail.next;
               if (next != null) {
                   bigTail.next = null;
               }
           }
           node = next;
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
