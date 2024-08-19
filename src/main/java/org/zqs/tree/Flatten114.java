package org.zqs.tree;

import org.zqs.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 114. 二叉树展开为链表
 */
public class Flatten114 {

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);

        TreeNode currentNode = root;
        while(!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }

            treeNode.left = null;
            treeNode.right = null;

            if (root !=  treeNode) {
                currentNode.right = treeNode;
                currentNode = treeNode;
            }
        }
    }
}

