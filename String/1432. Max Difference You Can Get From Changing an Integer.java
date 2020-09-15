class Solution {
    public int maxDiff(int num) {
        String s=String.valueOf(num);
        
        int max=0, min=0;
        
        //find max number
        int i=0;
        while(i<s.length() && s.charAt(i)=='9'){
            i++;
        }
        String s1="";
        //replace all occurances of ch by 9
        if(i<s.length()){
        s1=s;
        s1=s1.replaceAll(s.charAt(i)+"", "9");
        max=Integer.parseInt(s1);
        //System.out.print(max);
        }
        else
            max=max=Integer.parseInt(s);
        //find min number
        i=0;
        while(i<s.length() && ( s.charAt(i)=='1' || s.charAt(i)=='0'))
        {
            i++;
        }
        s1=s;
        if(i==0){
            s1=s1.replaceAll(s.charAt(i)+"", "1");
            min=Integer.parseInt(s1);
        }else if(i<s.length()){
            s1=s1.replaceAll(s.charAt(i)+"", "0");
            min=Integer.parseInt(s1);   
        }
        else
            min=Integer.parseInt(s);
        
        return max-min;     
        
    }
}
