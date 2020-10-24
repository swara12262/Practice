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
    int d;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return d;
    }
    int helper(TreeNode root){
        if(root==null)
            return 0;
        
        int h1=helper(root.left);
        int h2=helper(root.right);
        
        d=Math.max(d, h1+h2);
        return 1+Math.max(h1, h2);
    }
}
