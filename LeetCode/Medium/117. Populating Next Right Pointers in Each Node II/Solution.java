/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        Queue<Node> que = new LinkedList<>();

        if(root != null) que.add(root);

        while(!que.isEmpty()){
            int s = que.size();

            while(s-- > 0){
                Node cur = que.poll();

                if(s == 0){
                    cur.next = null;
                }else{
                    cur.next = que.peek();
                }

                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
            }
        }

        return root;
    }
}