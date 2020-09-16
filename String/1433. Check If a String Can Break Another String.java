class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] a1=s1.toCharArray();
        char[] a2=s2.toCharArray();
        
        Arrays.sort(a1);Arrays.sort(a2);
        
        //check if s1 can break s2
        int i=0;
        for(i=0;i<s1.length(); i++){
            if(a1[i]>= a2[i])
                continue;
            else
                break;
        }
        if(i==s1.length())return true;
        i=0;
        //chck if s2 can break s1
        for(i=0;i<s1.length(); i++){
            if(a1[i]<=a2[i])
                continue;
            else
                break;
        }
        if(i==s1.length())return true;
        return false;
    }
}
