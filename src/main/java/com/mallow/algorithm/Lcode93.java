/**
 * @(#)Lcode93.java, 7月 14, 2021.
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
 */
public class Lcode93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreOne(s, 4, result, new ArrayList<>());
        return result;
    }

    private void restoreOne(String s, int time, List<String> result, List<String> currentResult) {
        if (s.length() > time * 3) {
            return;
        }
        if (s.length() < time) {
            return;
        }
        if (time == 1) {
            if (validIpSeg(s)) {
                currentResult.add(s);
                result.add(currentResult.get(0) + "." + currentResult.get(1) + "." + currentResult.get(2) + "." + currentResult.get(3));
            }
        } else {
            for (int i = 1; i<=3 && i <s.length(); i++) {
                if (validIpSeg(s.substring(0, i))) {
                    List<String> newCurrentResult = new ArrayList<>();
                    newCurrentResult.addAll(currentResult);
                    newCurrentResult.add(s.substring(0, i));
                    restoreOne(s.substring(i), time - 1, result, newCurrentResult);
                }
            }
        }
    }

    private boolean validIpSeg(String s) {
        if (s.length() == 0 || s.length() > 3) {
            return false;
        }
        if (!String.valueOf(Integer.valueOf(s)).equals(s)) {
            return false;
        }
        if (Integer.valueOf(s) > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Lcode93 code = new Lcode93();
        System.out.println(code.restoreIpAddresses("0000"));
        System.out.println(code.restoreIpAddresses("2551000"));
    }

}
