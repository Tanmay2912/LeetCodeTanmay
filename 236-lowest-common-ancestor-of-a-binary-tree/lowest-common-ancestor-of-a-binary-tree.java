/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lwc(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lwc(root.left, p, q);
        TreeNode right = lwc(root.right, p, q);
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else {
            return root;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lwc(root, p, q);
    }
}
/*class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) 
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) 
            return right;
        else if(right == null)
            return left;
        else 
            return root;
    }
}*/