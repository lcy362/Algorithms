package com.mallow.algorithm;

import java.util.Arrays;

/**
 * leetcode 4
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class MedianOfTwoSortedArrays {
    /**
     * this method has O(m+n) complexity, not perfect
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 1) {
            return nums2[0];
        }
        if (nums2.length == 0 && nums1.length == 1) {
            return nums1[0];
        }
        int size = nums1.length + nums2.length;
        int firstIndex;
        int lastIndex;
        if (size % 2 == 0) {
            firstIndex = size/2 -1;
            lastIndex = size/2;
        } else {
            firstIndex = size/2;
            lastIndex = size/2;
        }
        int i = 0;
        int j = 0;
        int value1 = 0;
        int value2 = 0;
        for (int c = 0; c <= lastIndex; c++) {
            int currentValue;
            if (i > lastIndex || i >= nums1.length) {
                currentValue = nums2[j++];
            } else if (j > lastIndex || j>= nums2.length) {
                currentValue = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                currentValue = nums1[i++];
            } else {
                currentValue = nums2[j++];
            }
            if (c == firstIndex) {
                value1 = currentValue;
            }
            if (c == lastIndex) {
                value2 = currentValue;
            }
        }
        double result = (double) (value1 + value2)/2d;
        return result;
    }

    public static void main(String args[]) {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[] {};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
