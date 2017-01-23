package com.mallow.sort;


import java.util.ArrayList;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/4/4
 * @since JDK 1.6
 */
public class ArrayQuickSort {

   public static void quicksort(ArrayList<Integer> a,int low,int high){
      int pkey;
      if (low<high){
         pkey=partition(a, low, high);
         quicksort(a,low,pkey-1);
         quicksort(a,pkey+1,high);
      }
   }

   public static int partition(ArrayList<Integer> a,int low,int high){
      int key;
      key=a.get(low);
      while (low<high){
         while (low<high && a.get(high)>=key){
            high--;
         }
         swap(a, low, high);
         while (low<high && a.get(low)<=key){
            low++;
         }
         swap(a, low, high);
      }
      return low;
   }

   public static void swap(ArrayList<Integer> a,int low,int high){
      int temp=a.get(low);
      a.set(low,a.get(high));
      a.set(high,temp);
   }

   public static void main(String args[]){
      ArrayList<Integer> a=new ArrayList<Integer>();
      a.add(4);
      a.add(6);
      a.add(9);
      a.add(7);
      a.add(3);
      a.add(5);
      a.add(1);
      System.out.println(a);
      quicksort(a,0,a.size()-1);
      System.out.println(a);
   }
}
