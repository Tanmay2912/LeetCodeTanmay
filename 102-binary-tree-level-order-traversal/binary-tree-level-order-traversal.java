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
    public void traversal(TreeNode root, List<List<Integer>> ans, Queue<TreeNode> q) {
        if(root == null) return;
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode front = q.poll();
                level.add(front.val);
                if(front.left != null) 
                    q.offer(front.left);
                if(front.right != null) 
                    q.offer(front.right);
            }
            ans.add(level);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>(); 
        Queue<TreeNode> q = new LinkedList<>();
        traversal(root, ans, q);
        return ans;
    }
}
