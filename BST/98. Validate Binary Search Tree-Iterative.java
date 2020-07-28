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
        LinkedList<TreeNode> stk=new LinkedList();
        LinkedList<Integer> low=new LinkedList();
        LinkedList<Integer> up=new LinkedList();
        
        stk.add(root);
        low.add(null);
        up.add(null);
        while(!stk.isEmpty())
        {
            TreeNode tmp=stk.remove();
            Integer lower=low.remove();
            Integer upper=up.remove();
            
            if(tmp==null)continue;
            int val=tmp.val;
            
            
        
            if(lower!=null && val<=lower)return false;
            if(upper!=null && val>=upper)return false;
            
            //insert left node
            stk.add(tmp.left); low.add(lower); up.add(val);
            
            //insert right node
            stk.add(tmp.right); low.add(val); up.add(upper);

       
        }
        return true;
    }
}
