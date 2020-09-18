class Solution {
    public int romanToInt(String s) {
    int ans=0;
        HashMap<Character, Integer> map=new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int i=0;
        while(i<s.length()){
            
            int n1 = map.get(s.charAt(i));
            int n2=0;
            if(i<s.length()-1)
                n2= map.get(s.charAt(i+1));
            if(n2>n1)
            {
                ans+=n2-n1;
                i+=2;
            }
            else
            {
                ans+=n1;
                i++;
            }     
        }
        return ans;
    
    }
}
