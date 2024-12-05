package org.zqs.tree;

import org.zqs.common.TreeNode;

// todo
public class DeleteNode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        if (root.left == null) {
            return root.right;
        }

        if (root.right == null) {
            return root.left;
        }


        TreeNode successor = root.right;
        while (successor.left != null) {
            successor =  successor.left;
        }
        root.right = deleteNode(root.right, successor.val);
        successor.left = root.left;
        successor.right = root.right;
        return successor;
    }

}
