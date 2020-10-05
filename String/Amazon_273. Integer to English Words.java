class Solution {
    //for returning one digit numbers
    String  one(int num){
        switch(num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
                
        }
        return "";
    }
    
    //for returning two digit nums less than 20
    String  twoLessThan20(int num){
        switch(num){
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
                
        }
        return "";
    }
    
    //for returning tens place numbers
    String  ten(int num){
        switch(num){
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
                
        }
        return "";
    }
    
    //for handling two digit numbers
    String two(int num){
        
        if(num==0)
            return "";
        if(num<10)
            return one(num);
        else if(num<20)
            return twoLessThan20(num);
        else{
            int div=num/10;
            int rem=num-div*10;
            if(rem==0)
                return ten(div);
            else{
                return ten(div)+" "+one(rem);
            }
            
        }
        
    }
    
    //for handling three digit numbers
    
    String three(int num){
        String res="";
        int hun=num/100;
        int rem=num- hun*100;
        if(hun!=0 && rem!=0){
            res+=one(hun);
            res+=" Hundred ";
            res+=two(rem);
            return res;
        }
        else if(hun==0 && rem!=0){
            return two(rem);
        }
        else if(hun!=0 && rem==0){
            return one(hun)+" Hundred";
        }
        return "";
    }
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        int billion  = num/1000000000;
        int million = (num- billion*1000000000)/1000000;
        int thousand = (num- billion*1000000000- million*1000000)/1000;
        int rem= (num-billion*1000000000- million*1000000- thousand*1000);
        
        String res="";
        if(billion!=0){
            res+=three(billion)+" Billion";
        }
        if(million!=0){
            if(!res.isEmpty())
                res+=" ";
            res+=three(million)+ " Million";
        }
        if(thousand!=0){
            if(!res.isEmpty())
                res+=" ";
            res+=three(thousand)+ " Thousand";
            
        }
        if(rem!=0){
            if(!res.isEmpty())
                res+=" ";
            res+=three(rem);
        }
        return res;
    }
}
