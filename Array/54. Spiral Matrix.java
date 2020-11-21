class Solution {
    List<Integer> result;
    public List<Integer> spiralOrder(int[][] matrix) {
    
        int m=matrix.length;
        int n=matrix[0].length;
        result = new ArrayList<Integer>();
        spiral(0,0,m,n,matrix);
        return result;
            
        
    }
    public void spiral(int i, int j, int m, int n, int[][] ma){
        //base
        if(i>=m || j>=n)return;
        
        //get left to right
        for(int k=i;k<n;k++){
            result.add(ma[i][k]);
        }
        
        //get top to down
        for(int k=i+1;k<m;k++)
            result.add(ma[k][n-1]);
        if(i<m-1){
            //get right to left
            for(int k= n-2;k>=j;k--)
            {
                result.add(ma[m-1][k]);
            }
        }
        if(j<n-1){
            //get bottom to top
            for(int k= m-2;k>i;k--){
                result.add(ma[k][j]);
            }
        }
       spiral(i+1,j+1,m-1,n-1,ma); 
    }
}
