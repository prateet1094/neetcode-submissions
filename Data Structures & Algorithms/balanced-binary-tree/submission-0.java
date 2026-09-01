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
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        Map<TreeNode,Integer> map = new HashMap<>();
        map.put(null,0);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left!=null && !map.containsKey(node.left)) stack.push(node.left);
            else if(node.right!=null && !map.containsKey(node.right)) stack.push(node.right);
            else {
                node = stack.pop();
                int leftHt = map.get(node.left);
                int rightHt = map.get(node.right);
                if(Math.abs(leftHt-rightHt)>1)return false;
                int currHt = 1 + Math.max(leftHt,rightHt);
                map.put(node,currHt);
            }

        }
        return true;
        
    }
}
