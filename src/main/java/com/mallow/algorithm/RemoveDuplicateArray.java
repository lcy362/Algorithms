package com.mallow.algorithm;

/**
 * leetcode26 Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Created by lcy on 2017/2/16.
 */
public class RemoveDuplicateArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int pos = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}
