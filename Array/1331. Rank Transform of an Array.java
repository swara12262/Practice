class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] tmp=new int[arr.length];
        if(arr.length==0)return new int[]{};
        int j=0;
        for(int i:arr){
            tmp[j++]=i;
        }
        Arrays.sort(tmp);
        
        int[] res=new int[arr.length];
        Map<Integer, Integer> ranks=new HashMap<Integer, Integer>();
        int rank=1;
        ranks.put(tmp[0], rank++);
        
        for(int i=1;i<tmp.length;i++){
            if(tmp[i]!=tmp[i-1])
                ranks.put(tmp[i], rank++);
        }
        j=0;
        
        for(int i: arr){
            res[j++]=ranks.get(i);   
        }
        return res;
        
    }
}
