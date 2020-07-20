/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class MyNestedInteger
{
    NestedInteger n;
    int depth;
    MyNestedInteger(NestedInteger n, int depth)
    {
        this.n=n;
        this.depth=depth;
    }
}
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        
        int i=0, depth=1, out=0;
        for(NestedInteger ni: nestedList)
        {
            depth=1;
               if(ni.isInteger())
               {
                    out+=ni.getInteger();
                  // System.out.println(out+"--"+ni.getInteger());
                }
                else
                {  
                    depth++;
                    Stack<MyNestedInteger> stk=new Stack<MyNestedInteger>();
                    MyNestedInteger mn=new MyNestedInteger(ni, depth);
                    stk.push(mn);
                    
                    while(!stk.isEmpty())
                    {
                        MyNestedInteger tmp=stk.pop();
                        for(NestedInteger tni:tmp.n.getList())
                        {
                           if(tni.isInteger())
                               out+=tmp.depth*tni.getInteger();
                            else
                            {
                                MyNestedInteger myns=new MyNestedInteger(tni, tmp.depth+1);
                                stk.push(myns);
                            }
                        }
                        
                    }
                   
                }
            i++;
        }
        return out;
    }
}
