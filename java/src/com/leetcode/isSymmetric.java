package com.leetcode;

/**
 * @author datnh0710
 * @created 13/01/2022 - 11:53 AM
 * @packege com.leetcode
 * @project java
 */
public class isSymmetric {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return bfs(root.left, root.right);
    }

    // recursive
    public static boolean bfs(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null)
            return true;
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val != rightNode.val)
            return false;
        boolean checkLeft = bfs(leftNode.left, rightNode.right);
        boolean checkRight = bfs(leftNode.right, rightNode.left);
        return (checkLeft && checkRight);
    }

    // iteratively
}
