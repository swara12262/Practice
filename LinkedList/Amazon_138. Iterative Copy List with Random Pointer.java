/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> map=new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {
    
        if(head==null)return null;
        
        Node cur=head;
        Node newNode=new Node(cur.val);
        map.put(cur, newNode);
        
        while(cur!=null){
            if(cur.next!=null){
                if(map.containsKey(cur.next))
                    newNode.next= map.get(cur.next);
                else
                {
                    map.put(cur.next, new Node(cur.next.val));
                    newNode.next= map.get(cur.next);
                }
            }
            if(cur.random!=null){
                if(map.containsKey(cur.random))
                    newNode.random= map.get(cur.random);
                else
                {
                    map.put(cur.random, new Node(cur.random.val));
                    newNode.random= map.get(cur.random);
                }
            }
            cur=cur.next;
            newNode=newNode.next;
        }
        return map.get(head);
    }
}
