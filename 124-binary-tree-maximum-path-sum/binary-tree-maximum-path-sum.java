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
/*class Solution {
    public int findMaxSum(TreeNode root, int maxSum) {
        if (root == null) {
            return 0;
        }
        int leftsum = findMaxSum(root.left, maxSum);
        int rightsum = findMaxSum(root.right, maxSum);
        int sum = leftsum + rightsum + root.val;
        maxSum = Math.max(maxSum, sum);
        return root.val + leftsum + rightsum;
        // return (root.val + Math.max(leftsum, rightsum)); 
    }

    public int maxPathSum(TreeNode root) {
        int maxsum = Integer.MIN_VALUE;
        findMaxSum(root, maxsum);
        return maxsum;
    }
}*/
class Solution {
    public int findMaxSum(TreeNode root, int maxSum[]) {
        if (root == null) {
            return 0;
        }
        int leftsum = Math.max(0, findMaxSum(root.left, maxSum));
        int rightsum = Math.max(0, findMaxSum(root.right, maxSum));
        int sum = leftsum + rightsum + root.val;
        maxSum[0] = Math.max(maxSum[0], sum);
        //return root.val + leftsum + rightsum;
        return (root.val + Math.max(leftsum, rightsum)); 
    }

    public int maxPathSum(TreeNode root) {
        int maxsum[] = new int[1];
        maxsum[0] = Integer.MIN_VALUE;
        findMaxSum(root, maxsum);
        return maxsum[0];
    }
}
