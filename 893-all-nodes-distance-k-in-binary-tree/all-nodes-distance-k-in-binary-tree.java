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
    // this bfs traversal is to mark parent pointer in the hashmap
    public void markParent(TreeNode root, Map<TreeNode, TreeNode> parent) {
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode front = q.poll();
                if(front.left != null) {
                    q.offer(front.left);
                    parent.put(front.left, front); //child, parent
                }
                if(front.right != null) {
                    q.offer(front.right);
                    parent.put(front.right, front);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()) {
            if(curr_level == k) break;
            curr_level++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                //check left 
                if(current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                //check right
                if(current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                //check parent
                if(parent.get(current) != null && visited.get(parent.get(current)) == null) {
                    queue.offer(parent.get(current));
                    visited.put(parent.get(current), true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(TreeNode node : queue) {
            ans.add(node.val);
        }
        return ans;
    }
}