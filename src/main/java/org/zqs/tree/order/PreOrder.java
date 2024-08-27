package org.zqs.tree.order;

import org.zqs.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 先遍历根节点，
 * 在遍历左子树，
 * 在遍历右子树
 */
public class PreOrder {


    /**
     *
     * 递归实现
     * @param treeNode
     * @return
     */
    public List<Integer> preOrderRecursion(TreeNode treeNode) {

        List<Integer> result = new ArrayList<>();
        preOrder(result, treeNode);

        return result;
    }

    public void preOrder(List<Integer> result, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        result.add(treeNode.val);
        if (treeNode.left != null) {
            preOrder(result, treeNode.left);
        }

        if (treeNode.right != null) {
            preOrder(result, treeNode.right);
        }
    }


    /**
     * 迭代实现
     * @param root
     */
    public List<Integer> preOrderIterator(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            // 遍历根节点
            result.add(treeNode.val);

            // 右节点进栈
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }

            // 左节点进栈
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }

        return result;
    }
}
