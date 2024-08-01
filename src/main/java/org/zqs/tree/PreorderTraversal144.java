package org.zqs.tree;


import org.zqs.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<TreeNode> child = new ArrayList<>();
            for (TreeNode treeNode : list) {
                if (treeNode == null) {
                    continue;
                }
                result.add(treeNode.val);
                if (treeNode.left != null) {
                    child.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    child.add(treeNode.right);
                }
            }

            list = child;
        }

        return result;
    }
}
