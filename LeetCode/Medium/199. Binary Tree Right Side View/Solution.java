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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(root , res);
        return res;
    }


    private void bfs(TreeNode root, List<Integer> res) {

        Queue<TreeNode> que = new LinkedList<>();

        if(root != null) que.offer(root);

        while(!que.isEmpty()){
            int s = que.size();

            while(s-- >  0){
                TreeNode node = que.poll();
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);

                if(s == 0) res.add(node.val);
            }

        }
    }
}
