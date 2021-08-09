/**
 * @(#)Lcode5.java, 8月 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mallow.algorithm;

/**
 * @author licy03
 */
public class Lcode5 {

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        String result = s.substring(0, 1);
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        char[] ss = s.toCharArray();
        for (int len = 2; len <= s.length(); len++) {
            for (int start = 0; start < s.length() - len + 1; start++) {
                int end = start + len - 1; //start, end 是闭区间
                if (ss[start] == ss[end]) {
                    if (len < 3) {
                        isPalindrome[start][end] = true;
                        if (len > max) {
                            max = len;
                            result = s.substring(start, end + 1);
                        }
                    } else {
                        isPalindrome[start][end] = isPalindrome[start + 1][end - 1];
                        if (isPalindrome[start][end]) {
                            if (len > max) {
                                max = len;
                                result = s.substring(start, end + 1);
                            }
                        }
                    }
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Lcode5 code = new Lcode5();
        System.out.println(code.longestPalindrome("sabbbad"));
        System.out.println(code.longestPalindrome("bb"));
    }
}
