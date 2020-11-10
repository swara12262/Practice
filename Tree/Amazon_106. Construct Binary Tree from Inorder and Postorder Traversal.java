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
    
    int post_index;
    Map<Integer, Integer> index_map;
    int[] inorder;
    int[] postorder;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post_index=postorder.length-1;
        this.inorder=inorder;
        this.postorder=postorder;
        index_map=new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++)
            index_map.put(inorder[i], i);
        
        return buildTree(0, inorder.length-1);
    }
    public TreeNode buildTree(int left, int right){
        if(left>right)return null;
        
        TreeNode root=new TreeNode(postorder[post_index]);
        post_index--;
        
        int index=index_map.get(root.val);
        
        root.right=buildTree( index+1, right);
        root.left=buildTree(left, index-1);
        
      
        return root;
    }
}
