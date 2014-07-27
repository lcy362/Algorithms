package com.bupt.lcy.search;

import com.bupt.lcy.util.ArrayUtil;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/4/5
 * @since JDK 1.6
 */
public class FibonacciSearch {
   private static Integer[] F=new Integer[20];
   public static int search(Integer[] a,Integer key){
      calculateF();
      ArrayUtil.print(F);
      int n=a.length;
      int low=0;
      int high=a.length-1;
      int k=0;
      int mid;
      while (n>F[k]-1){
         k++;
      }
      System.out.println("k::"+k);
      Integer[] aa=new Integer[F[k]-1];
      for (int i=0;i<n;i++){
         aa[i]=a[i];
      }
      for (int i=n;i<F[k]-1;i++){
         aa[i]=a[n-1];
      }
      ArrayUtil.print(aa);

      while (low<=high){
         mid=low+F[k-1]-1;
         System.out.println(low+" "+high+" "+mid);
         if (key<aa[mid]){
            high=mid-1;
            k=k-1;
         }else if (key>aa[mid]){
            low=mid+1;
            k=k-2;
         }else{
            if (mid<=n){
               return mid;
            }else{
               return n;
            }
         }
      }
      return 0;
   }
   public static void calculateF(){
      F[0]=0;
      F[1]=1;
      for (int i=2;i<20;i++){
         F[i]=F[i-1]+F[i-2];
      }
   }
}
