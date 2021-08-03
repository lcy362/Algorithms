/**
 * @(#)LCode46.java, 7月 26, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mallow.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author licy03
 * 全排列
 */
public class LCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        generate(numList, result, numList.size(), 0);
        return result;
    }

    private void generate(List<Integer> numList, List<List<Integer>> result, int n, int start) {
        if (start == n) {
            result.add(new ArrayList<>(numList));
        }
        for (int i = start; i < n; i++) {
            if (i != start) {
                Collections.swap(numList, i, start);
            }
            generate(numList, result, n, start + 1);
            if (i != start) {
                Collections.swap(numList, i, start);
            }
        }
    }

    public static void main(String[] args) {
        LCode46 code = new LCode46();
        System.out.println(code.permute(new int[]{1, 2, 3}));
    }
}
