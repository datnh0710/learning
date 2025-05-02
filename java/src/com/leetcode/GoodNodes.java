package com.leetcode;

public class GoodNodes {
    public static void main(String[] args) {

    }

    static int count = 0;

    public static int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }


    public static int dfs(TreeNode node, int max) {
        if (node == null) {
            return count;
        }
        if (node.val >= max) {
            count++;
        }

        return dfs(node.left, Math.max(max, node.val)) + dfs(node.right, Math.max(max, node.val));
    }

}
