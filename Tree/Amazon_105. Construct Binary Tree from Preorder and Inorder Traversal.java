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
    int pre_index;
    //hashmap to store index of all elements inorder array
    HashMap<Integer, Integer> index_map=new HashMap<Integer, Integer>();
    int[] inoder;
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pre_index=0;
        this.inoder=inorder;
        this.preorder = preorder;
        for(int i=0;i<inorder.length;i++)
            index_map.put(inorder[i], i);
        return helper(0, inorder.length);
    }
    
    public TreeNode helper(int left, int right){
        
        if(left==right)return null;

        TreeNode root= new TreeNode(preorder[pre_index]);
        pre_index++;
        
        int index=index_map.get(root.val);
        
        root.left= helper(left, index);
        root.right= helper( index+1, right);
        
        return root;
        
    }
    
}
