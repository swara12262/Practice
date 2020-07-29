/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node, int index)
    {
        this.node=node;
        this.index=index;
    }
}
class Solution {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> reslst=new ArrayList();
        if(root==null)return reslst;
        HashMap<Integer, ArrayList> map=new HashMap();
        Queue<Pair> que=new LinkedList();
        que.add(new Pair(root, 0));
        while(!que.isEmpty())
        {
            Pair tmp=que.poll();
            int index=tmp.index;
            TreeNode node=tmp.node;
            ArrayList<Integer> tmplist=null;
            if(map.containsKey(index))
            {
                tmplist= map.get(index);
                tmplist.add(node.val);
                map.put(index, tmplist);
            }
            else
            {
                tmplist=new ArrayList();
                tmplist.add(node.val);
                map.put(index, tmplist);
                    
            }
            if(node.left!=null)
                que.add(new Pair(node.left, index-1));
            if(node.right!=null)
                que.add(new Pair(node.right, index+1));
        }
        
        List<Integer> lst=new ArrayList(map.keySet());
        Collections.sort(lst);
        
        
        for(int i: lst)
        {
            reslst.add(map.get(i));
        }
        return reslst;
        
    }
}
