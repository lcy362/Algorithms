package com.mallow.algorithm;

import java.util.HashMap;

/**
 * leetcode 3
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Created by lcy on 2017/2/15.
 */
public class LongestSubstringNotRepeat {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        HashMap<Character, Integer> charPos = new HashMap<>();
        char[] chars = s.toCharArray();
        int len = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            if (charPos.containsKey(chars[i])) {
                int tempstart = charPos.get(chars[i]) + 1;
                if (tempstart > start) {
                    start = tempstart;
                }
                end++;
                len = end - start;
            } else {
                len++;
                end++;
            }
            charPos.put(chars[i], i);
            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LongestSubstringNotRepeat l = new LongestSubstringNotRepeat();
        System.out.println(l.lengthOfLongestSubstring("abcdbcbb"));
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
        System.out.println(l.lengthOfLongestSubstring("abba"));
    }
}
