package org.zqs.tree;

import org.zqs.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode left =  root.left;
        TreeNode right =  root.right;
        return equals(left, right);
    }


    public boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (!(node1 != null && node2 != null && node1.val == node2.val)) {
            return false;
        }

        return equals(node1.left, node2.right) && equals(node1.right, node2.left);
    }







    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            if (node1 == null && node2 == null) {
                continue;
            }

            if ((node1 == null || node2 == null) || (node1.val != node2.val)) {
                return false;
            }

            stack.push(node1.left);
            stack.push(node2.right);

            stack.push(node1.right);
            stack.push(node2.left);
        }

        return true;
    }
}
