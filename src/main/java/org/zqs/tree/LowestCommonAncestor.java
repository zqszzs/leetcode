package org.zqs.tree;

import org.zqs.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return null;
    }

    public void iterator(TreeNode root, List<TreeNode> child, Map<Integer, List<Integer>> pathMap) {
        List<Integer> path = pathMap.get(root.val);

        for (TreeNode treeNode : child) {
            List<Integer> childPath = new ArrayList<>(path);
            childPath.add(treeNode.val);
            pathMap.put(treeNode.val, childPath);


            List<TreeNode> childChild = new ArrayList<>();
            if (treeNode.left != null) {
                childChild.add(treeNode.left);
            }
            if (treeNode.right != null) {
                childChild.add(treeNode.right);
            }
            if (!childChild.isEmpty()) {
                iterator(treeNode, childChild, pathMap);
            }
        }
    }
}
