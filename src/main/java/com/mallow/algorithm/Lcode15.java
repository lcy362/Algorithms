/**
 * @(#)Lcode15.java, 8月 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mallow.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author licy03
 * 三数之和=0
 */
public class Lcode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int a = nums[i];
            int x = i + 1;
            int y = length - 1;
            while (x < y) {
                int b = nums[x];
                int expectC = - a - b;
                while (nums[y] > expectC && x < y) {
                    y--;
                }
                if (nums[y] == expectC && x != y) {
                    result.add(Arrays.asList(a, b, expectC));
                }
                x++;
                while (x < length && nums[x] == nums[x-1]) {
                    x++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Lcode15 code = new Lcode15();
        System.out.println(code.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(code.threeSum(new int[] {0, 0, 0}));
        System.out.println(code.threeSum(new int[] {1, 2, -2, -1}));
    }
}
