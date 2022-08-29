package com.mallow.tree;

/**
 * Title:
 * Description:
 *
 * @author lichuanyang
 * @version 1.0 2014/5/4
 * @since JDK 1.6
 */
public class TreeNode {
    public String data;
    public TreeNode left;
    public TreeNode right;

    public int val;

    public TreeNode(String data) {
        this.data = data;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public String getData() {
        return data;
    }

    public int getVal() {
        return val;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
