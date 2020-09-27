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
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        
        int ht_l=height(root.left);
        int ht_r=height(root.right);
        
        if(Math.abs(ht_l-ht_r)<2 && isBalanced(root.left) && isBalanced(root.right))
           return true;
        return false;
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
}
