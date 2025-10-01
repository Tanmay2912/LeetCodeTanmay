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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        if (inorder.length != postorder.length) return null;
        return helper(inorder, 0, inorder.length - 1,
                      postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int inL, int inR,
                            int[] postorder, int postL, int postR) {
        if (inL > inR || postL > postR) return null;

        int rootVal = postorder[postR];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inL;
        while (inIndex <= inR && inorder[inIndex] != rootVal) {
            inIndex++;
        }
        
        int leftSize = inIndex - inL; 

        root.left = helper(inorder, inL, inIndex - 1,
                           postorder, postL, postL + leftSize - 1);

        root.right = helper(inorder, inIndex + 1, inR,
                            postorder, postL + leftSize, postR - 1);

        return root;
    }
}
