package com.mallow.algorithm;

/**
 * Created by lcy on 2017/2/16.
 */
public class EasyProblems {
    /**
     * 344. Reverse String
     * https://leetcode.com/problems/reverse-string/
     * @param s
     * @return
     */
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int mid = len/2;
        for (int i = 0; i< mid; i++) {
            char temp = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = temp;
        }
        return String.valueOf(chars);
    }
}
