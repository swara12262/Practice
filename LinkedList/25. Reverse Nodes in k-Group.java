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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int t=k;
        if(head==null || head.next==null)return head;
        ListNode cur=head,next=null;
        
        while(cur.next!=null && t>1)
        {
            cur=cur.next;
            t--;
        }
        System.out.println(cur.val +"*"+ t);
    
        if(t>1)return head;
        
        next = cur.next;
            
        cur.next = null;
        
        ListNode newHead = reverse(head);
        head=newHead;
        while(newHead.next!=null)
        {
            
            newHead=newHead.next;
        }
       // System.out.println(next.val+"*");
        if(next!=null)        
            newHead.next=reverseKGroup(next, k);
        
        return head;
        
        
    }
    public ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null)return head;
        
        ListNode newHead=reverse(head.next);
        
        head.next.next=head;
        head.next=null;
        
        return newHead;
    }
}
