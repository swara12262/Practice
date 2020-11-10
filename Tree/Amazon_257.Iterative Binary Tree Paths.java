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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<String>();
        if(root==null)return ans;
        Stack<String> paths=new Stack<String>();
        Stack<TreeNode> node_stk=new Stack<TreeNode>();

        paths.add(String.valueOf(root.val));
        node_stk.add(root);
        String path="";
        
        while(!node_stk.isEmpty()){
            String path_var=paths.pop();
            TreeNode node=node_stk.pop();
            path=path_var;
            if(node.left==null && node.right==null)
                ans.add(path_var);
            if(node.left!=null){
                path+="->";
                path+=node.left.val;
                paths.add(path);
                node_stk.add(node.left);
            }
            path=path_var;
            if(node.right!=null){
                path+="->";
                path+=node.right.val;
                paths.add(path);
                node_stk.add(node.right);
            }
        }
        return ans;
    }
}
