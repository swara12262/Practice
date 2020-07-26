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
    
    HashMap<Integer, Integer> map=new HashMap();
    int[] pre;
    int pre_index;
    public TreeNode bstFromPreorder(int[] preorder) {
        this.pre=preorder;
        int[] inorder=Arrays.copyOf(preorder, preorder.length);
        
        Arrays.sort(inorder);
        
        //pull index of elements in inorder array in hashmap;
        int i=0;
        for(int n: inorder)
            map.put(n,i++);
        return buildBST(0, inorder.length);
    }
    public TreeNode buildBST(int left, int right)
    {
        if(left==right)
            return null;
        
        //set the root of BST as the left index
        TreeNode root=new TreeNode(pre[pre_index]);
        pre_index++;
        
        //calculate the index of this root in inorder map
        int index=map.get(root.val);
        
        root.left=buildBST(left, index);
        
        root.right=buildBST(index+1, right);
        return root;
    }
}
