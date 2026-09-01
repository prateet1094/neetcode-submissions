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
    public class StackNode {
        int depthTillNow;
        TreeNode node;
        public StackNode(int depthTillNow, TreeNode node){
            this.depthTillNow = depthTillNow;
            this.node = node;
        }
    }
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if(root==null)return 0;
        Stack<StackNode> stack = new Stack<StackNode>();
        stack.push(new StackNode(1,root));
        while(!stack.isEmpty()){
            StackNode curr = stack.pop();
            if(curr.node.left==null && curr.node.right==null){
                maxDepth = Math.max(maxDepth,curr.depthTillNow);
            } else {
                if(curr.node.left!=null){
                    stack.push(new StackNode(1 + curr.depthTillNow,curr.node.left));
                }
                if(curr.node.right!=null){
                    stack.push(new StackNode(1 + curr.depthTillNow,curr.node.right));
                }
            }
        }
        return maxDepth;
        
    }
}
