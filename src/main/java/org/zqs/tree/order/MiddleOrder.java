package org.zqs.tree.order;

import org.zqs.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 先遍历左节点
 * 在遍历父节点
 * 在遍历右节点
 */
public class MiddleOrder {


    /**
     * 递归实现
     * @param treeNode
     * @return
     */
    public List<Integer> middleOrderRecursion(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        preOrder(result, treeNode);

        return result;
    }

    public void preOrder(List<Integer> result, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        if (treeNode.left != null) {
            preOrder(result, treeNode.left);
        }
        result.add(treeNode.val);
        if (treeNode.right != null) {
            preOrder(result, treeNode.right);
        }
    }





    /**
     * 迭代实现
     * @param root
     */
    public List<Integer> middleOrderIterator(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode leftNode = root;
        while(!stack.isEmpty() || leftNode != null) {
            // 先将左子树全部放入栈
            while (leftNode != null) {
                stack.push(leftNode);
                leftNode = leftNode.left;
            }

            // 从栈中取出元素
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);

            // 遍历右节点（从右节点左子树开始遍历）
            leftNode = treeNode.right;
        }

        return result;
    }

}
