class Solution {
    public List<String> commonChars(String[] A) {
        //stores min of all occurecess of all strings
        int[] min_freq=new int[26];
        
        //assign Integer.MAX_VALUE 
        for(int i=0;i<26;i++)
            min_freq[i]=Integer.MAX_VALUE;
        
        for(String s: A)
        {
            int[] s_freq=new int[26];
            for(int i=0;i<s.length();i++)
                s_freq[s.charAt(i)-'a']++;
            
            //strore the min frequency of chars in a string in min_freq[]
            
            for(int i=0;i<26;i++)
                min_freq[i]=Math.min(min_freq[i], s_freq[i]);
            
        }
        List<String> lst=new ArrayList<String>();
        
        //characters with same freq. are stored in min_freq array
        
        for(int i=0;i<26;i++)
        {
            while(min_freq[i]>0)
            {
                lst.add(""+(char)(i+97));
                min_freq[i]--;
            }
             
        }
        return lst;
        
    }
}
