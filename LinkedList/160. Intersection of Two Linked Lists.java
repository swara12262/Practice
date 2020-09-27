/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     
        int lenA=length(headA);
        int lenB=length(headB);
        int diff=Math.abs(lenA-lenB);
        ListNode curA=headA;
        ListNode curB=headB;
        
        if(lenA>lenB){
            while(curA!=null && diff-->0)curA=curA.next;
        }
        else{
            while(curB!=null && diff-->0)curB=curB.next;
        }
        
        while(curA!=curB){
            curA=curA.next;
            curB=curB.next;
        }
        
        if(curA==curB)return curA;
        
        return null;
        
    }
    public int length(ListNode head){
        ListNode cur=head;
        int res=0;
        while(cur!=null){
            cur=cur.next;
            res++;
        }
        return res;
    }
}
