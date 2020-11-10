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
    int max_width;
    public int widthOfBinaryTree(TreeNode root) {
        max_width=0;
        if(root==null)return max_width;
        
        //que to store node and corr column index
        Queue<Pair<TreeNode, Integer>> q=new LinkedList<Pair<TreeNode, Integer>>();
        
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> head=q.peek();
            
            int size=q.size();
            int index=0;
            TreeNode tNode=null;
            while(size-->0){
                Pair<TreeNode, Integer> node=q.poll();
                 tNode=node.getKey();
                index = node.getValue();
                
                if(tNode.left!=null)
                    q.add(new Pair(tNode.left, index*2));
                if(tNode.right!=null)
                    q.add(new Pair(tNode.right, index*2+1));
            }
            max_width=Math.max(max_width, index-head.getValue()+1);
        }
        return max_width;
    }
}
