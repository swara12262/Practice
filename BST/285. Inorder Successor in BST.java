/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //if p has right node then inorder successor is in right subtree leftmost node
        if(p.right!=null){
            p=p.right;
            while(p.left!=null)p=p.left;
            return p;
        }
     
        //do inroder traversal and if in it prev node is equals to p.val then cur node is our inroder suceesor
        
        Stack<TreeNode> stk=new Stack<TreeNode>();
        int inorder = Integer.MIN_VALUE;
        
        while(!stk.isEmpty() || root!=null){
            //go left till we can
            while(root!=null)
            {
                stk.push(root);
                root=root.left;
            }
            root=stk.pop();
            if(inorder == p.val)return root;
            inorder = root.val;
            root=root.right;
                
        }
        return null;
    }
}
