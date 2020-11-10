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
        if(root==null)return 0;
        
     height(root);
        return d;
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        
        int lt_ht = height(root.left);
        int rt_ht = height(root.right);
        
        d=Math.max(d, lt_ht+rt_ht);
        
        return 1+Math.max(lt_ht, rt_ht);
    }
}
