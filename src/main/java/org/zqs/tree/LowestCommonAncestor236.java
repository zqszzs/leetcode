package org.zqs.tree;

import org.zqs.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowestCommonAncestor236 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode treeNodeLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode treeNodeRight = lowestCommonAncestor(root.right, p, q);

        if (treeNodeLeft != null && treeNodeRight != null) {
            return root;
        }

        if (treeNodeLeft == null) {
            return treeNodeRight;
        }

        return treeNodeLeft;
    }

}
