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
public class TestSort {
    public static void main(String args[]) {
        Integer[] a = {8, 6, 3, 9, 2, 7, 5};
//      BubbleSort.bubblesort(a);
//      MergeSort.mergeSort(a);
        ShellSort.shellSort(a);
        ArrayUtil.print(a);
    }
}
