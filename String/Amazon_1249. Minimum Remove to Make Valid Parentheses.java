class Solution {
    public String minRemoveToMakeValid(String s) {
     
        //to store indexes to be removed from the stack ')'
        Set<Integer> indexToRemove = new HashSet<Integer>();
        
        //to store indexes to be removed from the stack '('
        Stack<Integer> stk=new Stack<Integer>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(')
                stk.push(i);
            else if(ch==')'){
                if(stk.isEmpty())
                    indexToRemove.add(i);
                else
                    stk.pop();
            }
        }
        //add all '(' need to remove from stk to set
        while(!stk.isEmpty())
        {
            indexToRemove.add(stk.pop());
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!indexToRemove.contains(i))
                sb.append(s.charAt(i));
        }
        return new String(sb);
    }
}
