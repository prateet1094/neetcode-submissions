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
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode,int[]> map = new HashMap<>();
        map.put(null,new int[]{0,0});
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if(curr.left!=null && !map.containsKey(curr.left)) stack.push(curr.left);
            else if(curr.right!=null && !map.containsKey(curr.right)) stack.push(curr.right);
            else {
                curr = stack.pop();
                int[]ld = map.get(curr.left);
                int[]rd = map.get(curr.right);

                map.put(curr,new int[]{1 + Math.max(ld[0],rd[0]),Math.max(ld[1],Math.max(rd[1],ld[0]+rd[0]))});
            }
        }
        return map.get(root)[1];
        
    }
}
