package com.leetcode;

/**
 * @author datnh0710
 * @created 14/01/2022 - 12:16 PM
 * @packege com.leetcode
 * @project java
 */
public class SumofLeftLeaves {
    public static void main(String[] args) {

    }

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null)
            return sum;
        if (root.left != null && (root.left.left == null && root.left.right == null))
            sum += root.left.val;
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }


}
