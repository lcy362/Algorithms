package com.bupt.lcy.tree;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/5/4
 * @since JDK 1.6
 */
public class Node {
   private String data;
   private Node left;
   private Node right;

   public Node(String data){
      this.data=data;
   }

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public Node getLeft() {
      return left;
   }

   public void setLeft(Node left) {
      this.left = left;
   }

   public Node getRight() {
      return right;
   }

   public void setRight(Node right) {
      this.right = right;
   }
}
