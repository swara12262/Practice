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
    public boolean isSubtree(TreeNode s, TreeNode t) {
    
         if (s == null || t == null)
            return s == t;
        
        return isSubtree(s.left, t) || isSubtree(s.right, t) || validate(s, t);  
    }
    public boolean  validate(TreeNode s, TreeNode t){
         
        if (s == null || t == null)
            return s == t;
        return s.val==t.val && validate(s.left, t.left) && validate(s.right, t.right);
    }
}
