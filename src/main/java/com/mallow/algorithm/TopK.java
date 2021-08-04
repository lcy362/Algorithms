/**
 * @(#)TopK.java, 8月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mallow.algorithm;

/**
 * @author licy03
 */
public class TopK {

    public int findKthLargest(int[] nums, int k) {
        return quickFind(nums, 0, nums.length - 1, k, nums.length);
    }

    public int quickFind(int[] nums, int low, int high, int k, int n) {
        int nextKey = partition(nums, low, high);
        if (nextKey == n - k) {
            return nums[nextKey];
        } else if (nextKey < n - k) {
            return quickFind(nums, nextKey + 1, high, k, n);
        } else {
            return quickFind(nums, low, nextKey - 1, k, n);
        }

    }

    private int partition(int[] nums, int low, int high) {
        int p = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= p) {
                high--;
            }
            if (nums[high] <= p) {
                swap(nums, low, high);
            }

            while (low < high && nums[low] <= p) {
                low++;
            }
            if (nums[low] >= p) {
                swap(nums, low, high);
            }
        }
        return low;
    }

    private void swap(int[] nums, int a, int b) {
        int x = nums[a];
        nums[a] = nums[b];
        nums[b] = x;
    }

    public static void main(String args[]) {
        TopK code = new TopK();
        System.out.println(code.findKthLargest(new int[]{1, 3, 7, 2, 5, 6, 7, 9}, 4));
    }
}
