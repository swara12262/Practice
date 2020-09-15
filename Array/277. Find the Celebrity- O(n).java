/* The knows API is defined for you.
      bool knows(int a, int b); */

class Solution {
public:
    int findCelebrity(int n) {
        
        int c=0;
        
        for(int i=1;i<n;i++){
            if(knows(c, i))
                c=i;
                
        }
        for(int i=0;i<n;i++){
            if(i!=c){
                if(!knows(i, c) || knows(c,i))return -1;
            }
        }
        return c;
    }
};
