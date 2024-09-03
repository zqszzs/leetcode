package org.zqs.tree;

import org.zqs.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 173 二叉树中序搜索迭代器
 */
public class BSTIterator {

    private List<Integer> iteratorList = new ArrayList<>();
    private int current = 0;

    public BSTIterator(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode left = root;
        while (!stack.isEmpty() || left != null) {
            while (left != null) {
                stack.push(left);
                left = left.left;
            }
            TreeNode treeNode = stack.pop();
            iteratorList.add(treeNode.val);
            left = treeNode.right;
        }
    }

    public int next() {
        if (current >= iteratorList.size()) {
            throw new RuntimeException("iterator exception");
        }
        return iteratorList.get(current++);

    }

    public boolean hasNext() {
        return current < iteratorList.size();
    }
}
