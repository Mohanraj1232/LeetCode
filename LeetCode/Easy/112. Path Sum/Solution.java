class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,0,targetSum);
    }
    public boolean dfs(TreeNode root,int curSum,int targetSum){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return (root.val+curSum)==targetSum;
        }

        return dfs(root.left, curSum + root.val, targetSum) ||
               dfs(root.right, curSum + root.val, targetSum);
    }
}
