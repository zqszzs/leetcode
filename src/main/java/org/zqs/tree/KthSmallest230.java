package org.zqs.tree;

import org.zqs.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树中的第K个小元素
 */
public class KthSmallest230 {

    public int kthSmallest(TreeNode root, int k) {
        int i = 1;
        TreeNode leftNode = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (leftNode != null) {
                stack.push(leftNode);
                leftNode = leftNode.left;
            }

            TreeNode treeNode = stack.pop();
            if (i == k) {
                return treeNode.val;
            }
            leftNode = treeNode.right;
            i++;
        }

        return -1;
    }
}
