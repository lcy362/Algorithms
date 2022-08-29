package com.mallow.tree;

public class LC124 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        oneSideMax(root);
        return res;
    }

    //此半区可以贡献的最大值
    private int oneSideMax(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, oneSideMax(node.left)); //半区贡献负值时，视为0
        int right = Math.max(0, oneSideMax(node.right));
        res = Math.max(res, left + node.val + right);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        LC124 l = new LC124();
        TreeNode root = new TreeNode(-10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);
        System.out.println(l.maxPathSum(root) == 42);

        TreeNode root2 = new TreeNode(2);
        root2.setLeft(new TreeNode(-1));
        System.out.println(l.maxPathSum(root2) == 2);
    }
}
