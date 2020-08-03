class MyHashSet {

    Bucket[] bucket;
    int range;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.range=769;
        bucket=new Bucket[this.range];
        for(int i=0;i<this.range;++i)
            bucket[i]=new Bucket();
    }
    int hash_func(int key){
        return key%this.range;
    }
    
    public void add(int key) {
        int hash=hash_func(key);
        this.bucket[hash].add(key);
    }
    
    public void remove(int key) {
        int hash=hash_func(key);
        this.bucket[hash].delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash=hash_func(key);
        return this.bucket[hash].exists(key);
    }
}
class Bucket{
    LinkedList<Integer> container;
    Bucket(){
        this.container=new LinkedList<Integer>();
    }
    void add(Integer key){
        int index=this.container.indexOf(key);
        if(index==-1){
            this.container.addFirst(key);
        }
    }
    void delete(Integer key){
            this.container.remove(key);
    }
    boolean exists(Integer key){
        int index = this.container.indexOf(key);
        return index!=-1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
