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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead =null;
        ListNode prev=null;
        int carry=0;
        ListNode cur1=l1;
        ListNode cur2=l2;
        while(cur1!=null || cur2!=null){
            int i1=(cur1!=null) ? cur1.val:0;
            int i2=(cur2!=null) ? cur2.val:0;
            int sum=i1+i2+carry;
            carry=sum/10;
            //System.out.println(sum+ ""+carry);
            ListNode newNode=new ListNode(sum%10);
            if(prev==null)
                newHead=newNode;
            else
                prev.next=newNode;
            prev=newNode;
            if(cur1!=null)cur1=cur1.next;
            if(cur2!=null)cur2=cur2.next;
        }
       if(carry>0){
           prev.next=new ListNode(carry);
       }
        return newHead;
        
    }
}
