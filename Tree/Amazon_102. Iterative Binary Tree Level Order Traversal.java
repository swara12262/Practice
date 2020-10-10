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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        List<List<Integer>> lst=new ArrayList();
        if(root==null)return lst;
        while(!q.isEmpty()){
            int size=q.size();            
            ArrayList<Integer> tmp=new ArrayList<Integer>();
            while(size-->0){
                TreeNode t = q.remove();
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
                tmp.add(t.val);
            }
            lst.add(tmp);            
        }
        return lst;
        
    }
}
