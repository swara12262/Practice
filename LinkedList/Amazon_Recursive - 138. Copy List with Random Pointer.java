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
    
    //HashMap to store old node as key and new node as value
    HashMap<Node, Node> map=new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        
        if(head==null)
            return null;
    
        if(map.containsKey(head))
            return map.get(head);
        
        Node newNode=new Node(head.val, null, null);
        map.put(head,newNode);
        
        newNode.next= copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        
        return newNode;
        
    }
}
