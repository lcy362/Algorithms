/**
 * @(#)Lcode443.java, 7月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mallow.algorithm;

import com.mallow.util.ArrayUtil;

/**
 * @author licy03
 */
public class Lcode443 {

    public int compress(char[] chars) {
        int thisCharLen = 1;
        int resultPos = 0;
        for (int currentPos = 0; currentPos < chars.length; currentPos++) {
            char currentChar = chars[currentPos];
            if (currentPos == chars.length - 1 || currentChar != chars[currentPos + 1]) {
                chars[resultPos++] = currentChar;
                if (thisCharLen > 1) {
                    for (char c : String.valueOf(thisCharLen).toCharArray()) {
                        chars[resultPos++] = c;
                    }
                }
                thisCharLen = 1;
            } else {
                thisCharLen++;
            }
        }
        ArrayUtil.print(chars);
        return resultPos;
    }

    public static void main(String[] args) {
        Lcode443 solution = new Lcode443();
        System.out.println(solution.compress("ab".toCharArray()));
        System.out.println(solution.compress("a".toCharArray()));
        System.out.println(solution.compress("aabbbbbccc".toCharArray()));
        System.out.println(solution.compress("abbbbbbbbbbbbb".toCharArray()));
        System.out.println(solution.compress("aabbbbbbbbbbbb".toCharArray()));
    }
}
