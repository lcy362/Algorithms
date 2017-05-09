package com.mallow.sort;


import com.mallow.util.ArrayUtil;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/4/4
 * @since JDK 1.6
 */
public class QuickSort {

    public static void quicksort(Integer[] a, int low, int high) {
        int pkey;
        if (low < high) {
            pkey = partition(a, low, high);
            System.out.println("pkey::" + pkey);
            quicksort(a, low, pkey - 1);
            quicksort(a, pkey + 1, high);
        }
    }

    public static int partition(Integer[] a, int low, int high) {
        int key;
        key = a[low];
        ArrayUtil.print(a);
        while (low < high) {
            while (low < high && a[high] >= key) {
                high--;
            }
            ArrayUtil.swap(a, low, high);
            System.out.println(low + "  " + high);
            ArrayUtil.print(a);
            while (low < high && a[low] <= key) {
                low++;
            }
            ArrayUtil.swap(a, low, high);
            System.out.println(low + "  " + high);
            ArrayUtil.print(a);
        }
        return low;
    }


    public static void main(String args[]) {
        Integer[] a = {4, 6, 3, 9, 2, 7, 5};
        quicksort(a, 0, a.length - 1);
        ArrayUtil.print(a);
    }

}
