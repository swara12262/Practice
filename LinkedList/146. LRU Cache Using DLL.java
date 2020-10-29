class LRUCache {
    
    class DLinkNode{
        int key;
        int val;
        DLinkNode prev;
        DLinkNode next;
    }

    HashMap<Integer, DLinkNode> cache=new HashMap<Integer, DLinkNode>();
    int size;
    int capacity;
    DLinkNode head, tail;
    
    public LRUCache(int capacity) {
    
        this.capacity=capacity;
        this.size=0;
        head=new DLinkNode();
        tail=new DLinkNode();
        
        head.next=tail;
        tail.prev=head;
    }
    public void addNode(DLinkNode node){
        node.prev=head;
        node.next=head.next;
        
        head.next.prev=node;
        head.next=node;
    }
    public void removeNode(DLinkNode node){
        DLinkNode next=node.next;
        DLinkNode prev=node.prev;
        
        prev.next=next;
        next.prev=prev;
        
    }
    public DLinkNode popTail(){
        DLinkNode node = tail.prev;
        removeNode(node);
        
        return node;
    }
    public void moveToHead(DLinkNode node){
        removeNode(node);
        addNode(node);
    }
    public int get(int key) {
        DLinkNode node= cache.get(key);
        if(node==null)return -1;
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DLinkNode node= cache.get(key);
        
        if(node==null){
            node=new DLinkNode();
            node.key=key;
            node.val=value;
            size++;
            cache.put(key, node);
            addNode(node);
            if(size> this.capacity){
                DLinkNode res= popTail();
                cache.remove(res.key);
                size--;
            }
        }
        else{
            node.val=value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
