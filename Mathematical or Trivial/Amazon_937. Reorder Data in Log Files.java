class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letterLogs= new ArrayList<String>();
        ArrayList<String> digitLogs= new ArrayList<String>();
        
        for(String s: logs){
            String[] tmp=s.split("\\s",2);
            if(Character.isDigit(tmp[1].charAt(0)))
                digitLogs.add(s);
            else
                letterLogs.add(s);
            
        }
        Collections.sort(letterLogs, new Comparator(){
            public int compare(Object o1, Object o2){
                String s1=(String)o1;
                String s2=(String)o2;
                String[] tmp1=s1.split("\\s", 2);
                String[] tmp2=s2.split("\\s", 2);
                
                if(tmp1[1].compareTo(tmp2[1])!=0){
                    return tmp1[1].compareTo(tmp2[1]);
                }
                else{
                    return tmp1[0].compareTo(tmp2[0]);
                }
            }
        });
        
        String[] res=new String[logs.length];
        int i=0;
        for(String s: letterLogs){
            res[i]= s;
            i++;
        }
        for(String s: digitLogs){
            res[i]=s;
            i++;
        }
        return res;
    }
}
