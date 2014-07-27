/**
 *
 */
package com.bupt.lcy.search;

/**
 * Title: BinarySearch
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014-4-3
 * @since JDK 1.6
 */

public class BinarySearch {

   /**
    * @param a   array
    * @param key
    * @return index of key,or where should key insert into
    */
   public static int binarySearch(Integer[] a, Integer key) {
      int low = 0;
      int high = a.length - 1;
      int mid = 0;
      while (low <= high) {
         mid = (low + high) >>> 1;
         int m = a[mid];
         if (m < key)
            low = mid + 1;
         else if (m > key)
            high = mid - 1;
         else
            return mid;
      }
      if (a[mid]<=key){
         return mid+1;
      }
      else{
         return mid;
      }
   }


}
