package com.bupt.lcy.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/5/4
 * @since JDK 1.6
 */
public class Graph {
   private int[][] edges;
   private int num;
   private boolean[] visited;
   private LinkedList<Integer> queue=new LinkedList<Integer>();
   public Graph(int n){
      num=n;
      edges=new int[n][n];
      visited=new boolean[n];
      for (int i=0;i<n;i++){
         for (int j=0;j<n;j++){
            edges[i][j]=0;
         }
      }
   }

   public void connect(int a,int b){
      edges[a][b]=1;
      edges[b][a]=1;
   }

   public ArrayList<Integer> getConnectedNodes(int a){
      ArrayList<Integer> nodes=new ArrayList<Integer>();
      for (int i=0;i<num;i++){
         if (isConnected(a,i)){
            nodes.add(i);
         }
      }
      return nodes;
   }

   private Boolean isConnected(int a,int b){
      if (edges[a][b]==1)
         return true;
      else
         return false;
   }



   private void dfs(int i){
      visited[i]=true;
      System.out.print(i+" ");
      for (int j=0;j<num;j++){
         if (isConnected(i,j) && !visited[j]){
            dfs(j);
         }
      }
   }

   /**
    * 深度优先遍历，递归
    */
   public void dfsTraverse(){
      for (int i=0;i<num;i++){
         visited[i]=false;
      }
      for (int i=0;i<num;i++){
         if (!visited[i]){
            dfs(i);
         }
      }
      System.out.println();

   }

   /**
    * 广度优先遍历，队列
    * 遍历到一个结点时，将其所有相邻节点入队
    */
   public void bfsTraverse(){
      for (int i=0;i<num;i++){
         visited[i]=false;
      }
      for (int i=0;i<num;i++){
         if (!visited[i]){
            visited[i]=true;
            System.out.print(i+" ");
            queue.add(i);
            while (!queue.isEmpty()){
               queue.remove();
               for (int j=0;j<num;j++){
                  if (isConnected(i,j)&&!visited[j]){
                     visited[j]=true;
                     System.out.print(j+" ");
                     queue.add(j);
                  }
               }
            }
         }
      }
      System.out.println();
   }


}
