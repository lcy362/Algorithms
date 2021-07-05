/**
 * @(#)Lcode279.java, 7月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mallow.algorithm;

/**
 * @author licy03
 */
public class Lcode279 {

    public int numSquares(int n) {
        int[] squares = new int[n+1];
        squares[1] = 1;
        for (int num = 2; num <= n; num++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i * i <= num; i++) {
                if (squares[num - i*i] < min) {
                    min = squares[num - i*i];
                }
            }
            squares[num] = min + 1;
        }
        return squares[n];
    }

    public static void main(String[] args) {
        Lcode279 code = new Lcode279();
        System.out.println(code.numSquares(1));
        System.out.println(code.numSquares(2));
        System.out.println(code.numSquares(12));
        System.out.println(code.numSquares(13));
    }

}
