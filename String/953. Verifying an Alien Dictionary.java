class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] index =  new int[26];
        for(int i=0;i<order.length();i++)
            index[order.charAt(i)-'a']=i;
        
        //check for each adjacent words if they are sorted
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            boolean valid = false;
            //find first diff            
            for(int j=0;j<Math.min(w1.length(), w2.length());j++){
                char ch1= w1.charAt(j);char ch2= w2.charAt(j);            
                if(ch1!=ch2 ){
                    if(index[ch1-'a']>index[ch2-'a'])
                        return false;
                    valid=true;
                    break;
                }
            }
            //if we didnt find a diff 
            if(!valid){
                if(w1.length()>w2.length())return false;
            }
        }
        return true;
    }
}
