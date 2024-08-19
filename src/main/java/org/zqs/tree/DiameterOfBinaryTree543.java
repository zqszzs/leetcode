package org.zqs.tree;

import org.zqs.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfBinaryTree543 {

    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int length = 0;
        List<TreeNode> child = new ArrayList<>();
        child.add(root);

        while (!child.isEmpty()) {
            List<TreeNode> child1 = new ArrayList<>();
            for (TreeNode treeNode : child) {
                if (treeNode.left != null) {
                    child1.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    child1.add(treeNode.right);
                }
            }

            child = child1;
            length++;
        }

        return length - 1;
    }
}
