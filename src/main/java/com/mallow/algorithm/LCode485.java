/**
 * @(#)LCode485.java, 7月 01, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mallow.algorithm;

/**
 * @author licy03
 */
public class LCode485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int[] tillHere = new int[nums.length];
        if (nums[0] == 1) {
            tillHere[0] = 1;
            max = 1;
        } else {
            tillHere[0] = 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                tillHere[i] = tillHere[i-1] + 1;
                if (tillHere[i] > max) {
                    max = tillHere[i];
                }
            } else {
                tillHere[i] = 0;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LCode485 q = new LCode485();
        int[] nums1 = new int[]{1, 1, 3};
        System.out.println(q.findMaxConsecutiveOnes(nums1));
    }
}
