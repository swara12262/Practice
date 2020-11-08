class Solution {
    public boolean isIsomorphic(String s, String t) {
        //map to keep mapping of each individual char in a string s->t
        HashMap<Character, Character> mapping =new HashMap<Character, Character>();
        
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        
        for(int i=0;i<a.length;i++){
            
            //if mapping is not present then put it in the map
            if(!mapping.containsKey(a[i]) && !mapping.containsValue(b[i]) )
                mapping.put(a[i], b[i]);
            
            //if mapping for a[i] is not present  || if presnet is not equal to b[i]
            if(mapping.get(a[i])==null || mapping.get(a[i])!=b[i])
                return false;
        }
        return true;
    }
}
