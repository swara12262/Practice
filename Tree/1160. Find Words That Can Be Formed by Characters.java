class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int sum=0;
        int[] fchar=new int[256];
        for(int i=0;i<chars.length();i++)
            fchar[chars.charAt(i)]++;
        
        for(int i=0;i<words.length;i++)
        {
            int[] fword=new int[256];
            for(int j=0;j<words[i].length();j++)
                fword[words[i].charAt(j)]++;
            if(isGoodString(fchar, fword))
                sum+=words[i].length();
            
        }
        return sum;
    }
    public boolean isGoodString(int[] fchar, int[] fword)
    {
        for(int i=0;i<fchar.length;i++)
            if(fchar[i]<fword[i])
                return false;
        return true;
    }
}
