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
        if(root == null) {
            return;
        }
        traversal(root.left, ans);
        ans.add(root.val);
        traversal(root.right, ans);
    }
    // this is iterative method
    public void traversal(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true) {
            if(node != null) {
                st.push(node);
                node = node.left;
            }
            else {
                if(st.isEmpty()) {
                    break;
                }
                node = st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        return ans;
    }
}