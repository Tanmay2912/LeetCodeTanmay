/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min1 = Integer.MAX_VALUE;
    long min2 = Long.MAX_VALUE;   
    public void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.val < min1) {
            min1 = root.val;
        }
        else if(root.val > min1 && root.val < min2) {
            min2 = root.val;
        }
        helper(root.left);
        helper(root.right);
    }
    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        return min2 == Long.MAX_VALUE ? -1 : (int)min2;   
    }
}