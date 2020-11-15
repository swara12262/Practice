class Solution {
    public int maximalRectangle(char[][] matrix) {
        int area=0;
        if(matrix.length==0)return 0;
        int[] ht=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0')
                    ht[j]=0;
                else
                    ht[j]+='1'-'0';
            }
            //calculate area for single row each times
            
            area=Math.max(area, areaOfHistogramRec(ht));
        }
        return area;
    }
    public int areaOfHistogramRec(int[] ht){
        Stack<Integer> stk=new Stack<Integer>();
        stk.push(-1);
        int maxArea=0;
        
        for(int i=0;i<ht.length;i++){
            //decreasing hts
            while(stk.peek()!=-1 && ht[stk.peek()]>=ht[i]){
                maxArea=Math.max(maxArea, ht[stk.pop()]* (i-stk.peek()-1) );
            }
            stk.push(i);
        }
        while(stk.peek()!=-1 ){
                maxArea=Math.max(maxArea, ht[stk.pop()]* (ht.length-stk.peek()-1 ));
            }
        return maxArea;
    }
}
