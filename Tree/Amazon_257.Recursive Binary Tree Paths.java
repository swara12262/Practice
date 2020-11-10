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
    List<String> paths;
    
    public List<String> binaryTreePaths(TreeNode root) {
        paths=new ArrayList<String>();
         helper(root,"");
        return paths;
    }
    public void helper(TreeNode root, String path){
        if(root!=null){
            path=path+root.val;
            if(root.left==null && root.right==null){
                paths.add(path);
            }
            path=path+"->";
            helper(root.left, path);
            helper(root.right, path);
        }
    }
    
}
