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
    //add left boundry
    //add leaves 
    //add right boundry using stack
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
     
        List<Integer> res=new ArrayList<Integer>();
        //check if our root is null
        if(root==null)return res;
        //check if root node is leaf node
        if(!isLeaf(root))
        {
            res.add(root.val);
            
        }
        //add left boundry
        TreeNode t= root.left;
        while(t!=null){
            if(!isLeaf(t))
                res.add(t.val);
            if(t.left!=null)
                t=t.left;
            else
                t=t.right;
        }
        //now add leaves
        addLeaves(res, root);
        
        //now add right boundry
        Stack<Integer> stk=new Stack<Integer>();
        
        t= root.right;
        while(t!=null){
            if(!isLeaf(t))
                stk.add(t.val);
            if(t.right!=null)
                t=t.right;   
            else
                t=t.left;   
        }
        while(!stk.isEmpty())
        {
            res.add(stk.pop());
            
        }
        return res;
    }
    public boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    public void addLeaves(List<Integer> res, TreeNode root){
        if(isLeaf(root))
            res.add(root.val);
        if(root.left!=null)
            addLeaves(res, root.left);
        if(root.right!=null)
            addLeaves(res, root.right);
    }
}
