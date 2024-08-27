package org.zqs.tree.order;

import org.zqs.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 先遍历左节点
 * 在遍历右节点
 * 在遍历父节点
 */
public class BackOrder {


    /**
     * 递归实现
     * @param treeNode
     * @return
     */
    public List<Integer> backOrderRecursion(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        backOrder(result, treeNode);

        return result;
    }

    public void backOrder(List<Integer> result, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        if (treeNode.left != null) {
            backOrder(result, treeNode.left);
        }
        if (treeNode.right != null) {
            backOrder(result, treeNode.right);
        }
        result.add(treeNode.val);
    }





    /**
     *
     * 迭代实现
     * @param root
     */
    public List<Integer> backOrderIterator(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode leftNode = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || leftNode != null) {
            // 先放将左子树依次放入堆栈
            while (leftNode != null) {
                stack.push(leftNode);
                leftNode = leftNode.left;
            }

            TreeNode treeNode = stack.pop();
            // 如果没有右节点，或者右节点被访问过，那么将当前节点添加到结果中
            if (treeNode.right == null || treeNode.right == pre) {
                result.add(treeNode.val);
                pre = treeNode;
            } else {
                // 如果有右节点，那么将当前父节点入栈（先访问右节点，在访问父节点）
                stack.push(treeNode);

                // 遍历右节点(从右节点的左子树开始遍历)
                leftNode = treeNode.right;
            }
        }
        return result;
    }

}
