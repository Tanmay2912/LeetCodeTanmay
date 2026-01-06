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
    public int levelOrderTraversal(TreeNode root, List<List<Integer>> ans, Queue<TreeNode> q) {
        if(root == null) 
            return 0;
        q.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int ansLevel = 0;
        while(!q.isEmpty()) {
            int sum = 0;
            level++;
            int size = q.size();
            List<Integer> levelorder = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode front = q.poll();
                levelorder.add(front.val);
                sum += front.val;
                if(front.left != null) 
                    q.offer(front.left);
                if(front.right != null) 
                    q.offer(front.right);
            }
            if(sum > maxSum) {
                maxSum = sum;
                ansLevel = level;
            }
            ans.add(levelorder);
        }
        return ansLevel;
    }
    public int maxLevelSum(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        return levelOrderTraversal(root, ans, q);
    }
}