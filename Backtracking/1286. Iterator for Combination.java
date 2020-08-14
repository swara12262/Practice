class CombinationIterator {

    Deque<String> res=new ArrayDeque();
    int len;
    String s;
    
    public CombinationIterator(String chars, int clen) {
       this.len=clen;
        this.s=chars;
        backtrack(0, new StringBuilder(""));
            
    }
    public void backtrack(int i, StringBuilder cur)
    {
        if(cur.length()==len)
        {
            res.add(new String(cur));
        }
        for(;i<s.length(); i++)
        {
            cur.append(s.charAt(i));
            backtrack(i+1, cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
    
    public String next() {
        return res.poll();
    }
    
    public boolean hasNext() {
        return !res.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
