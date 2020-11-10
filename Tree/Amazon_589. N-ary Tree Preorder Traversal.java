/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> ans;
    public List<Integer> preorder(Node root) {
        ans=new ArrayList<Integer>();
        if(root==null)return ans;
        preOrder(root, ans);
        return ans;
        
    }
    public void preOrder(Node root, List<Integer> ans){
     
        ans.add(root.val);
        for(Node node: root.children){
            preOrder(node, ans);
        }
        
    }
    
}
