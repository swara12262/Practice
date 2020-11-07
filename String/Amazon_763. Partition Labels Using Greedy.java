class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last=new int[26];
        //store last occurances of each character in string
        for(int i=0;i<s.length();i++)
            last[s.charAt(i)-'a']=i;
        
        //j to store max of last occurance for a character in a partition
        //acnchor is to store start of the partition;
        int j=0, anchor = 0;
        
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i=0;i<s.length();i++){
            j = Math.max(j, last[s.charAt(i)-'a']);
           
            //parition reached till the last occurances of each char in the partition
            if(i==j)
            {
                result.add(i-anchor+1);
                anchor = i+1;
            }
        }
        return result;
    }
}
