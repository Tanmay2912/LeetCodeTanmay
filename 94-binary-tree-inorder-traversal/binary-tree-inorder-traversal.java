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
    public void inorderTraversalInBT(TreeNode root, List<Integer> ans)
    {
        if(root==null) { return; }
        inorderTraversalInBT(root.left,ans);
        ans.add(root.val);
        inorderTraversalInBT(root.right,ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        inorderTraversalInBT(root,ans);
        return ans;
    }
}