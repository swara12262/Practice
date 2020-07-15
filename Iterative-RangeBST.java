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
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans=0;
        Stack<TreeNode> stk=new Stack<TreeNode>();
        stk.push(root);
        while(!stk.isEmpty())
        {
            TreeNode tmp= stk.pop();
            if(L<=tmp.val && tmp.val<=R)
                ans+=tmp.val;
            if(tmp.val>L && tmp.left!=null)
                stk.push(tmp.left);
            if(tmp.val<R && tmp.right!=null)
                stk.push(tmp.right);
                
        }
        
        return ans;
    }
}
