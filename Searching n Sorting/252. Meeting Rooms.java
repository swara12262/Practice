class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
   
        List<Pair> list=new ArrayList<Pair>();
        for(int[] in: intervals){
            list.add(new Pair(in[0], in[1]));
        }
        Collections.sort(list, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return (int)p1.getKey()-(int)p2.getKey();
            }
        });
        int prev=0;
        for(Pair p : list){
               if(prev!=0 && prev> (int)p.getKey()) 
                   return false;
            prev=(int)p.getValue();
        }
        return true;
    }
}
