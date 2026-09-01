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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        int level = 0;
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if(curr.left!=null && !visited.contains(curr.left)){
                stack.push(curr.left);
            } else {
                curr = stack.pop();
                visited.add(curr);
                level++;
                if(level==k)return curr.val;
                if(curr.right!=null){
                    stack.push(curr.right);
                }
            } 
        }
        return -1;
        
    }
}
