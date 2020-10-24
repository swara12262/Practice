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
    int max_sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
         max_gain(root);
        return max_sum;
    }
    public int max_gain(TreeNode root){
        if(root==null)
            return 0;
        
        int left_gain=Math.max(max_gain(root.left),0);
        
        int right_gain=Math.max(max_gain(root.right),0);
        
        int price_newpath= root.val+left_gain+right_gain;
        
        max_sum=Math.max(max_sum, price_newpath);
        
        return root.val+Math.max(left_gain, right_gain);
    }
}
