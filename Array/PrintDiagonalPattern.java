import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int m=sc.nextInt();
            int n=sc.nextInt();
            
            int out[][]=new int[m][n];
            int cnt=1,k=0,i=0,j=0;
            //fill lower diagonal
             for (k =0; k<n; k++) {  
                j=k; 
                i=m-1 ;
            while (j>=0 && i>=0) {  
                out[i][j] = cnt;  
                cnt++;  
                i= i-1; 
                j= j-1;  
                }  
            }
            //fill upper diagonal
            for (k =m-1; k>=0; k--) {  
                j=n-1; 
                i=k-1 ;
            while (j>=0 && i>=0) {  
                out[i][j] = cnt;  
                cnt++;  
                i= i-1; 
                j= j-1;  
                }  
            }
            
           
            for( i=0;i<m;i++)
            {
                for( j=0;j<n;j++)
                    System.out.print(out[i][j]+" ");
                System.out.println();
            }
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
