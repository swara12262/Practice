/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        String s="";
       return serialize(root, s);
       
    }

    public String serialize(TreeNode root, String s){
        if(root==null){
            s+="null,";
                return s;
        }
        s+=root.val+",";
        s=serialize(root.left, s);
        s=serialize(root.right, s);
        
        return s;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_arr=data.split(",");
        
        List<String> list=new ArrayList<String>(Arrays.asList(data_arr));
        return deserialize(list);
    }
    public TreeNode deserialize(List<String> list){
         
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        
        TreeNode root=new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = deserialize(list);
        root.right = deserialize(list);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
