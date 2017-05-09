package com.mallow.sort;


import com.mallow.util.ArrayUtil;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/6/22
 * @since JDK 1.6
 */
public class ShellSort {
    public static void shellSort(Integer[] a) {
        int i = 0;
        int j = 0;
        int increment = a.length / 3 + 1;
        int temp;
        while (increment >= 1) {
            System.out.println("increment::" + increment);
            ArrayUtil.print(a);
            for (i = increment; i < a.length; i++) {
                temp = a[i];
                for (j = i - increment; j >= 0 && a[j] > temp; j -= increment) {
                    a[j + increment] = a[j];
                    ArrayUtil.print(a);
                }
                a[j + increment] = temp;
                ArrayUtil.print(a);
            }
            if (increment == 1) {
                break;
            }
            increment = increment / 3 + 1;
        }
    }
}
