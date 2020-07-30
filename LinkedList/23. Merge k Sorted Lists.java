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
    ListNode newHead;
    public ListNode mergeKLists(ListNode[] lists) {
        
        ArrayList<Integer> lst=new ArrayList();
        for(ListNode cur: lists)
        {
            while(cur!=null){
                lst.add(cur.val);
                cur=cur.next;
            }
        }
        Collections.sort(lst);
        
        
        for(Integer i: lst)
        {
           // System.out.print(i+"*");
            add(i);
        }
        return newHead;
        
    }
    public void add(int i)
    {
        if(newHead==null)
        {
            newHead =new ListNode(i);
            return;
        }
        ListNode cur=newHead;
        
        while(cur.next!=null)
            cur=cur.next;
        
        cur.next=new ListNode(i);
    }
}
