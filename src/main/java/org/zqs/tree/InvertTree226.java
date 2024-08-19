package org.zqs.tree;

import org.zqs.common.TreeNode;

public class InvertTree226 {

    public static void main(String[] args) {

    }


    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;


        invertTree(left);
        invertTree(right);

        root.left = right;
        root.right = left;

        return root;
    }
}
