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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> que=new PriorityQueue(new Comparator<ListNode>(){
        public int compare(ListNode l1, ListNode l2){
        return l1.val-l2.val;
        }});
        
        ListNode newHead=null, last=null;
        for(ListNode l1: lists)
        {
            if(l1!=null)
                que.add(l1);
        }
        
        while(!que.isEmpty()){
            ListNode tmp=que.poll();
            if(tmp.next!=null)
                que.add(tmp.next);
            if(newHead==null)
            {
                newHead=tmp;
                last=tmp;
            }
            else
            {
                last.next=tmp;
                last=tmp;
            }
        }
        
            
        return newHead;
    }
}
