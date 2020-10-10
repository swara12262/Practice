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
    List<List<Integer>> lst=new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return lst;
        helper(root, 0);
        return lst;
    }
    
    public void helper(TreeNode root, int level){
        if(level==lst.size())
            lst.add(new ArrayList<Integer>());
        
        lst.get(level).add(root.val);
        if(root.left!=null){
            helper(root.left, level+1);
        }
        if(root.right!=null){
            helper(root.right, level+1);
        }
    }
}
