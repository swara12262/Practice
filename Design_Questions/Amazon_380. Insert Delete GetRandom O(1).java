class RandomizedSet {

    //element as key and its corresponding index from list as value
    Map<Integer, Integer> map;
    
    //list to store actual elements
    List<Integer> list;
    
    //to get the random ele from the list
    Random    rand =new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map=new HashMap<Integer,Integer>();
        list=new ArrayList<Integer>();
     
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        //check if element is already present in map
        if(map.containsKey(val))
            return false;
        
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        //copy lastelement to index at which element to be deleted is present and delete last element
        
        int last =list.get(list.size()-1);
        int index = map.get(val);
        

        map.put(last, index);
        list.set(index, last);     
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));

   //eturn list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
