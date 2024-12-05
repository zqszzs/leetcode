package org.zqs.tree;

import org.zqs.common.TreeNode;

import java.util.*;

/**
 * 先序遍历
 * 1. 根节点开始
 * 2. 先序遍历左子树
 * 3. 先序遍历右子树
 **/
public class PreorderTraversal144 {

    public static void main(String[] args) {

    }


    /**
     * 方法1 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        preorderTraversal(root, result);
        return result;
    }


    public void preorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }


    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            result.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return result;
    }
}
