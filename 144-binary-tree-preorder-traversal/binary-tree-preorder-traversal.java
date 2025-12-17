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
    // this is recursive method to solve 
    public void traversal(TreeNode root, List<Integer> ans) {
        if(root == null) 
            return;
        ans.add(root.val);
        traversal(root.left, ans);
        traversal(root.right, ans);
    }
    // this is iterative method to solve 
    public void Traversal(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode top = st.pop();
            ans.add(top.val);
            if(top.right != null)
                st.push(top.right);
            if(top.left != null)
                st.push(top.left);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        return ans;
    }
}