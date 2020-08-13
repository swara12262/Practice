class Solution {
    HashMap<String, String> phone = new HashMap<String, String>(){{
    put("2","abc");
    put("3","def");
    put("4","ghi");
    put("5","jkl");
    put("6","mno");
    put("7","pqrs");
    put("8","tuv");
    put("9","wxyz");
    }};
    
    List<String> out=new ArrayList();
    
    
    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0)
            backtrack("", digits);
        return out;
    }
    public void backtrack(String output, String next_digit )
    {
        if(next_digit.length()==0)
            out.add(output);
        else
        {
            String str=next_digit.substring(0, 1);
            //take corresponding letter for this digit
            String letters  = phone.get(str);
            
            //for each digit add it in comibinatoin
            for(int i=0;i<letters.length();i++){
                //letter to add in our output
                String letter= phone.get(str).substring(i, i+1);
                
                backtrack(output+letter, next_digit.substring(1));
            }
        }
    }
}
