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
     
        HashSet<ListNode> set=new HashSet<ListNode>();
        ListNode curA=headA;
        while(curA!=null){
            set.add(curA);
            curA=curA.next;
        }
        ListNode curB=headB;
        while(curB!=null){
            if(set.contains(curB))
                return curB;
            curB=curB.next;
        }
        return null;
    }
}
