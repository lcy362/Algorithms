package com.bupt.lcy.algorithm;

/**
 * Title:最长公共子序列
 * Description:算法导论，用一个矩阵表示两个位置截至到当前字符的最长公共序列，
 *
 * @author lichuanyang
 * @version 1.0 14-5-16
 * @since JDK 1.6
 */
public class LCS {

   public static void main(String args[]){
      System.out.println(LCS("BDCABA", "ABCBDAB"));
   }

   public static String LCS(String a,String b){
      String c="";

      int l1=a.length();
      int l2=b.length();
      a='#'+a;
      b='#'+b;
      int[][] leng=new int[l1+1][l2+1];  //最长子序列长度
      int[][] direction=new int[l1+1][l2+1];  //方向:0 左 1上 2左上
      for (int i=0;i<=l1;i++){
         leng[i][0]=0;
         direction[i][0]=0;
      }
      for (int i=0;i<=l2;i++){
         leng[0][i]=0;
         direction[0][i]=0;
      }
      for (int i=1;i<=l1;i++){
         for (int j=1;j<=l2;j++){
            if (a.charAt(i)==b.charAt(j)){
               leng[i][j]=leng[i-1][j-1]+1;
               direction[i][j]=2;
            }else{
               if (leng[i-1][j]>leng[i][j-1]){
                  leng[i][j]=leng[i-1][j];
                  direction[i][j]=0;
               }else {
                  leng[i][j]=leng[i][j-1];
                  direction[i][j]=1;
               }
            }
         }
      }

      int nowi=l1;
      int nowj=l2;
      while (nowi>0 && nowj>0){
         if (direction[nowi][nowj]==2){
            c=a.charAt(nowi)+c;
            nowi--;
            nowj--;
         }else if (direction[nowi][nowj]==1){
            nowj--;
         }else {
            nowi--;
         }
      }
      return c;
   }
}
