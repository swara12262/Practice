/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null && head==null)return true;
        
        if(root==null )return false;
        
        if(head==null)return true;
        
        return  validate(head, root) || isSubPath(head, root.right) ||
            isSubPath(head, root.left);
    }
    public boolean validate(ListNode head, TreeNode root){
         if(root==null && head==null)return true;
        
        if(root==null )return false;
        
        if(head==null)return true;
        
        return head.val==root.val &&
            (validate(head.next, root.left) ||validate(head.next, root.right));  
    }
}
