/**
 * @(#)Lcode92.java, 7月 13, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mallow.algorithm;

/**
 * @author licy03
 */
public class Lcode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        if (left == right) {
            return head;
        }
        int cur = 1; //cur=1时 node是head
        ListNode preHead = new ListNode();  //虚拟的头
        preHead.next = head;
        ListNode pre = preHead; //当前遍历节点的前一个节点
        ListNode node = head; //当前遍历节点
        while (cur < left) {
            pre = pre.next;
            node = node.next;
            cur++;
        }
        //此时，cur=left, node即第left个元素
        pre.next = null;
        ListNode revPre = pre;  //翻转区间的前一个元素； 断开revPre的后置链
        ListNode revHead = node;  //翻转区间的头
        while (cur <= right) {
            //翻转区间内反转方向
            ListNode next = node.next;
            cur++;
            node.next = pre;
            pre = node;
            node = next;
        }
        ListNode revTail = pre; //反转区间的结尾
        ListNode revNext = node; //反转区间的下一个元素，可以是null
        revPre.next = revTail;
        revHead.next = revNext;

        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i < 5; i++) {
            node.next = new ListNode(2);
            node = node.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
