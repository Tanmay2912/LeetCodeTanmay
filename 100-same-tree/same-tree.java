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
    public boolean check(TreeNode p, TreeNode q) {
        // both null → same
        if (p == null && q == null)
            return true;
        // one null → not same
        if (p == null || q == null)
            return false;
        // values differ → not same
        if (p.val != q.val)
            return false;
        // check left and right subtrees
        return check(p.left, q.left) && check(p.right, q.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p, q);
    }
}
