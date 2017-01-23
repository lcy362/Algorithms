package com.mallow.tree;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/5/4
 * @since JDK 1.6
 */
public class Traverse {

   public static void main(String args[]){
      Node head=new Node("head");
      Tree tree=new Tree(head);
      head=tree.getHead();

      preOrder(head);
      System.out.println();
      inOrder(head);
      System.out.println();
      postOrder(head);
   }

   public static void preOrder(Node node){
      if (node==null){
         return;
      }
      System.out.print(node.getData() + " ");
      preOrder(node.getLeft());
      preOrder(node.getRight());

   }

   public static void inOrder(Node node){
      if (node==null){
         return;
      }

      inOrder(node.getLeft());
      System.out.print(node.getData() + " ");
      inOrder(node.getRight());
   }

   public static void postOrder(Node node){
      if (node==null){
         return;
      }

      postOrder(node.getLeft());

      postOrder(node.getRight());
      System.out.print(node.getData() + " ");
   }
}
