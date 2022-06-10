package com.mallow.algorithm;

import javax.swing.tree.TreeNode;

public class Lcode105 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        if (preorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    private TreeNode build(int[] preorder, int[] inorder, int pres, int pree, int ins, int ine) {
        if (pres > pree) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pres]);
        int preIdxInIn = 0;
        for (int i = ins; i <= ine; i++) {
            if (inorder[i] == preorder[pres]) {
                preIdxInIn = i;
                break;
            }
        }
        int leftSize = preIdxInIn - ins;
        TreeNode left = build(preorder, inorder, pres + 1, pres + leftSize, ins, preIdxInIn - 1);
        TreeNode right = build(preorder, inorder, pres + leftSize + 1, pree, preIdxInIn + 1, ine);
        root.left = left;
        root.right = right;
        return root;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}



