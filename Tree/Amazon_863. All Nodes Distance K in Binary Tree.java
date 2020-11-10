/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //map to keep parent of each node
    Map<TreeNode, TreeNode> parent;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent= new HashMap<TreeNode, TreeNode>();
        //fill parent map using dfs
        fillUsingDfs(root, null);
        
        //now perform bfs from target node
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        //null to indicate distance kth nodes from the target
        q.add(null);
        q.add(target);
        
        //to keep track of seen nodes
        HashSet<TreeNode> seen =new HashSet<TreeNode>();
        //null ie. parent of root node is already seen
        seen.add(null);
        seen.add(target);
        
        //to keep track of distance form target node
        int dist=0;
        
        while(!q.isEmpty()){
            TreeNode node=q.remove();
            
            if(node==null){
                if(dist==K){
                    List<Integer> ans=new ArrayList<Integer>();
                    while(!q.isEmpty())
                    {
                        ans.add(q.remove().val);
                    }
                    return ans;
                }
                dist++;
                q.add(null);
                
            }else{
                
                if(node.left!=null && !seen.contains(node.left)){
                    q.add(node.left);
                    seen.add(node.left);
                }
                if(node.right!=null && !seen.contains(node.right)){
                    q.add(node.right);
                    seen.add(node.right);
                }
                TreeNode par= parent.get(node);
                if( !seen.contains(par)){
                    q.add(par);
                    seen.add(par);
                }
            }
        }
        return new ArrayList<Integer>();
        
    }
    public void fillUsingDfs(TreeNode root, TreeNode par){
        if(root!=null){
            parent.put(root, par);
            fillUsingDfs(root.left, root);
            fillUsingDfs(root.right, root);
        }
    }
}
