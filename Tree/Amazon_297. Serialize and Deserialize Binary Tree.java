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
        return serialize(root, "");   
    }
    public String serialize(TreeNode root, String str){
        if(root==null)
        {
            str+="null,";
            return str;
        }
        else{
            str+=String.valueOf(root.val)+",";
            str = serialize(root.left, str);
            str = serialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_arr=data.split(",");
        List<String> list=new LinkedList(Arrays.asList(data_arr));
        return deserialize(list);
    }
    public TreeNode deserialize(List<String> list){
        if(list.get(0).equals("null"))
        {
            list.remove(0);
            return null;
        }
        TreeNode node=new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left=deserialize(list);
        node.right=deserialize(list);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
