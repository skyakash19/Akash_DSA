class Solution {
    public int maxDepth(TreeNode root) {
        
        
        if(root == null){
            return 0;
        }
        else{
            int leftmax= maxDepth(root.left);
            int rightmax = maxDepth(root.right);
            return java.lang.Math.max(leftmax, rightmax) + 1;
        }
        
    }
}
