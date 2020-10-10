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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        
        que.add(root);
        que.add(root);
        
        while(!que.isEmpty()){
            TreeNode t1=que.remove();
            TreeNode t2=que.remove();
            
            if(t1==null && t2==null)continue;
            if(t1==null || t2==null)return false;
            if(t1.val != t2.val)return false;
            
            que.add(t1.right);
            que.add(t2.left);
            que.add(t2.right);
            que.add(t1.left);
            
        }
        return true;
        
    }
}
