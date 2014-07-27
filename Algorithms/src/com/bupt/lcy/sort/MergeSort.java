package com.bupt.lcy.sort;

import com.bupt.lcy.util.ArrayUtil;

/**
 * Title:
 * Description:有错
 *
 * @author lichuanyang
 * @version 1.0 2014/6/22
 * @since JDK 1.6
 */
public class MergeSort {
   public static void mergeSort(Integer[] a){
      mSort(a,0,a.length-1);
   }

   public static void mSort(Integer[] a,int start,int end){
      System.out.println(start+":"+end);
      if (start==end){
         System.out.println("ok");

      }else {
         int m=(start+end)/2;
         mSort(a, start, m);
         mSort(a, m + 1, end);
         merge(a,start,m,end);
      }

   }
   public static void merge(Integer[] a,Integer start,int m,int end){
      System.out.println(start+":"+m+":"+end+":");
      ArrayUtil.print(a);
      Integer[] t=new Integer[end-start+2];
      int i=start;
      int j=m+1;
      int k=0;
      System.out.println("ijk:"+i+":"+j+":"+k);
      while (i<=m && j<=end){
         System.out.println(a[i]+"::"+a[j]);
         if (a[i]<=a[j]){

            t[k++]=a[i];
            i++;
         }else {
            t[k++]=a[j];
            j++;
         }
         System.out.println("----------------");
      }
      if (i>m){
         while (j<=end){
            t[k++]=a[j++];
         }
      }else {
         while (i<=m){
            t[k++]=a[i++];
         }
      }
      for (int kk=0;kk<k;k++){
         a[start+kk]=t[kk];
      }
   }
}
