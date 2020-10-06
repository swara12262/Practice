class Solution {
    public String[] reorderLogFiles(String[] logs) {
     
        Arrays.sort(logs, new Comparator<String>(){
            
            public int compare(String s1, String s2){
                
                String[] tmp1=s1.split(" ", 2);
                String[] tmp2=s2.split(" ", 2);
                
                //check if it is letter log or digit log
                boolean isDigit1=Character.isDigit(tmp1[1].charAt(0));
                boolean isDigit2=Character.isDigit(tmp2[1].charAt(0));
                
                //if both are letter logs
                if(!isDigit1 && !isDigit2){
                    if(tmp1[1].compareTo(tmp2[1])!=0)
                        return tmp1[1].compareTo(tmp2[1]);
                    else
                        return tmp1[0].compareTo(tmp2[0]);
                }
                else if(!isDigit1 && isDigit2){
                    //if first is letter log then it should come before digit log
                    return -1;
                }
                else if(isDigit1 && !isDigit2){
                    return 1;
                }
                else{
                    //both logs are digit logs
                    return 0;
                }
                
            }
        });
        return logs;
    }
}
