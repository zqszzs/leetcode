package org.zqs.tree;

import org.zqs.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 中序遍历： 左中右
 */
public class TreeMiddleIterator94 {

    public static void main(String[] args) {

    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> value = new ArrayList();
        inorderTraversal(root,value );
        return value;
    }

    public void inorderTraversal(TreeNode node, List<Integer> val) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, val);
        val.add(node.val);
        inorderTraversal(node.right, val);
    }



    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
