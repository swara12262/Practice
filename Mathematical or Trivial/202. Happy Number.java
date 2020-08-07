class Solution {
    public boolean isHappy(int n) {
        
        HashSet set=new HashSet();
        while(!set.contains(n) && n!=1){
            set.add(n);
            int sum =sumOfDigits(n);
            //System.out.println(sum+" ");
            n=sum;
        }
        if(n==1)
            return true;
        return false;
    }
    int sumOfDigits(int n){
        int sum=0;
        while(n>0){
            int num=n%10;
            sum=sum + (num*num);
            n/=10;
        }
        return sum;
    }
}
