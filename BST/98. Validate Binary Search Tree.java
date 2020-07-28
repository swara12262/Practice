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
    public boolean isValidBST(TreeNode root) {
        return  isValid(root, null, null);
    }
    public boolean isValid(TreeNode root, Integer low, Integer up){
        if(root==null) return true;
        
        Integer i= root.val;
        
        if(low!=null && i<=low)return false;
        if(up!=null && i>=up)return false;
        
        if(!isValid(root.left, low, i))return false;
        if(!isValid(root.right, i, up))return false;
        
        return true;
    }
}
