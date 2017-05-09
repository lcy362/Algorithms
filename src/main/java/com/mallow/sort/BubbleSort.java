package com.mallow.sort;


import com.mallow.util.ArrayUtil;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/4/5
 * @since JDK 1.6
 */
public class BubbleSort {
    public static void bubblesort(Integer[] a) {
        int l = a.length;
        for (int i = 0; i < l; i++) {
            for (int j = l - 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    ArrayUtil.swap(a, j - 1, j);
                }
            }
            ArrayUtil.print(a);
        }
    }


}
