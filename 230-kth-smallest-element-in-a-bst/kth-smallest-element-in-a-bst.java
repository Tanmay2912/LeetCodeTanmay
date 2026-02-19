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
    public void inorderTraversal(TreeNode root, List<Integer> inList) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left, inList);
        inList.add(root.val);
        inorderTraversal(root.right, inList);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inList = new ArrayList<>();
        inorderTraversal(root, inList);
        return inList.get(k-1);
    }
}

