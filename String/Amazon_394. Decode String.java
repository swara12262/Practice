class Solution {
    public String decodeString(String s) {
        Stack<Character> stk=new Stack<Character>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==']'){
                //get the string to decode from the stack
                ArrayList<Character> decodeString = new ArrayList<Character>();
                while(stk.peek()!='['){
                    decodeString.add(stk.pop());
                }
                //pop '[' from stack
                stk.pop();
                
                //get k from the stack
                int base=1;
                int k=0;
                while(!stk.isEmpty() && Character.isDigit(stk.peek()))
                {
                    k=k+(stk.pop()-'0')*base;
                    base*=10;
                }
                //push decode string on stack k times
                Collections.reverse(decodeString);
                while(k-->0){
                    for(char ch1:decodeString )
                        stk.push(ch1);
                }
                
            }else
            {
                stk.push(ch);
            }
        }
        char[] arr=new char[stk.size()];
        for(int i=arr.length-1;i>=0;i--){
            arr[i]=stk.pop();
        }
        return new String(arr);
    }
}
