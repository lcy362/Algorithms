/**
 * @(#)Lcode678.java, 7月 07, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mallow.algorithm;

/**
 * @author licy03
 * balance表示左括号比又括号多的值
 * 可以对照测试例子模拟遍历到每个字符时，balance可以取的值
 * 比如((*)) 遍历到5个字符时分别是： 1 , 2,  1 2 3, 0,1,2, 0,1
 */
public class Lcode678 {

    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        int maxBalance = 0;
        int minBalance = 0;
        for (int i = 0; i < chars.length; i++) {
            char now = chars[i];
            if (now == '(') {
                maxBalance++;
                minBalance++;
            } else if (now == '*') {
                maxBalance++;
                if (minBalance > 0) {
                    minBalance--;
                }
            } else if (now == ')') {
                maxBalance--;
                if (minBalance > 0) {
                    minBalance--;
                }
                if (maxBalance < 0) {
                    return false;
                }
            }
        }
        return minBalance == 0;
    }

    public static void main(String[] args) {
        Lcode678 code = new Lcode678();
        System.out.println(code.checkValidString("((*))"));
        System.out.println(code.checkValidString(")((*))"));
        System.out.println(code.checkValidString("(((((*)))**"));
        System.out.println(code.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }

}
