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
    // this is recursive method
    public void Traversal(TreeNode root, List<Integer> ans) {
        if(root == null) 
            return;
        traversal(root.left, ans);
        traversal(root.right, ans);
        ans.add(root.val);
    }
    // this is iterative method
    public void traversal(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);
            if(root.left != null) 
                st1.push(root.left);
            if(root.right != null)
                st1.push(root.right);
        }
        while(!st2.isEmpty()) {
            TreeNode node = st2.pop();
            ans.add(node.val);
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        traversal(root, ans);
        return ans;
    }
}