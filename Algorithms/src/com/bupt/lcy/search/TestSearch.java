package com.bupt.lcy.search;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/4/5
 * @since JDK 1.6
 */
public class TestSearch {
   public static void main(String args[]) {
      Integer[] a ={1,2,3,4,6,9,12,13,14,15,17,18,21,22,25};
//      int x=BinarySearch.binarySearch(a,5);
      int x=FibonacciSearch.search(a,15);
      System.out.println(x);

   }
}
