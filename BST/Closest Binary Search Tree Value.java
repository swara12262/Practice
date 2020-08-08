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
    int res;
    public int closestValue(TreeNode root, double target) {
	Double min = Double.MAX_VALUE;
	TreeNode cur = root;
	
	while(cur != null) {
		if(target == cur.val) return cur.val;
		
		if(Math.abs(target - cur.val) < min) {
			min = Math.abs(target - cur.val);
			res = cur.val;
		}
		
		if(target > cur.val) {
			cur = cur.right;
		} else {
			cur = cur.left;
		}
	}
	
	return res;   
    }
}
