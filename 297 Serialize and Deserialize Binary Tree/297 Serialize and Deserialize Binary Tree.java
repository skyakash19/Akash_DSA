public class Codec {
    public String recserialize(TreeNode root, String str){
    
        if(root == null){
            str += "null,";
        }
        else{
            str += str.valueOf(root.val) +",";
            str = recserialize(root.left, str);
            str = recserialize(root.right, str);
        }
        
        return str;
    }
    public String serialize(TreeNode root) {
        
        return recserialize(root, "");
        
        
    }

    public TreeNode recdeserialize(List<String> strs){
        if(strs.get(0).equals("null")){
            strs.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(strs.get(0)));
        strs.remove(0);
        root.left= recdeserialize(strs);
        root.right = recdeserialize(strs);
        
        return root;
    }
    public TreeNode deserialize(String data) {
        
        String[] strArray = data.split(",");
        List<String> strList = new LinkedList<String>(Arrays.asList(strArray));
        return recdeserialize(strList);
    }
}
