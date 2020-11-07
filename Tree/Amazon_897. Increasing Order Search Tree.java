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
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        //inorder traversal will produce increasing order arraylist
        inorder(root, traversal);
        
        TreeNode tmpNode=new TreeNode(0), newRoot= tmpNode;
        for(int val: traversal){
            newRoot.right  = new TreeNode(val);
            newRoot=newRoot.right;
        }
        return tmpNode.right;
    }
    public void inorder(TreeNode root, ArrayList<Integer> list){
        if(root==null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
