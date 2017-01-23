package com.mallow.string;

/**
 * Title:编辑距离。递归
 * Description:如果A,B第一个字符相同，返回之后部分结果+1；
 * 如果不同，返回以下三个编辑距离的最小值：A去掉一个字符，B去掉一个字符，A B 各去掉一个字符
 *
 * @author lichuanyang
 * @version 1.0 2014/5/26
 * @since JDK 1.6
 */
public class EditDistance {
   public static void main(String args[]){

      String a="asdfghjkl";
      String b="asdfhjkl";
      System.out.println(recursionMethod(a,0,a.length()-1,b,0,b.length()-1));


   }

   public static int recursionMethod(String a,int aStart,int aEnd,String b,int bStart,int bEnd){
      for (int i=aStart;i<=aEnd;i++){
         System.out.print(a.charAt(i));
      }
      System.out.print("::");
      for (int i=bStart;i<=bEnd;i++){
         System.out.print(b.charAt(i));
      }
      System.out.println();
      if (aStart>aEnd){
         if (bStart>bEnd){
            return 0;
         }else {
            return bEnd-bStart;
         }
      }

      if (bStart>bEnd){
         if (aStart>aEnd){
            return 0;
         }else {
            return aEnd-aStart;
         }
      }

      if (a.charAt(aStart)==b.charAt(bStart)){
         return recursionMethod(a, aStart+1, aEnd, b, bStart+1, bEnd);
      }else {
         return min(recursionMethod(a, aStart+1, aEnd, b, bStart, bEnd),recursionMethod(a, aStart, aEnd, b, bStart+1, bEnd),recursionMethod(a, aStart+1, aEnd, b, bStart+1, bEnd))+1;
      }
   }

   public static int min(int a,int b,int c){
      if (a<b){
         if (a<c){
            return a;
         }else {
            return c;
         }
      }else {
         if (b<c){
            return b;
         }else {
            return c;
         }
      }
   }
}
