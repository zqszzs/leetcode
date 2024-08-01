package org.zqs.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }



    public static TreeNode buildTreeNode(int [] nums) {
        TreeNode first = null;
        TreeNode treeNode = null;

        for (int i = 0; i < nums.length; i++) {
            if (treeNode == null) {
                first = treeNode = new TreeNode(nums[i]);
            }
        }

        return treeNode;

    }
 }
