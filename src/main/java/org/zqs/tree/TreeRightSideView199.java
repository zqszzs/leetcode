package org.zqs.tree;

import org.zqs.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 */
public class TreeRightSideView199 {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.getFirst();
            if (treeNode != null) {
                result.add(treeNode.val);
            }

            Deque<TreeNode> child = new LinkedList<>();
            for (TreeNode node : treeNodes) {
                if (node.right != null) {
                    child.addLast(node.right);
                }
                if (node.left != null) {
                    child.addLast(node.left);
                }
            }
            treeNodes= child;
        }

        return result;
    }
}
