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
    public int dfs(TreeNode node, int maxInPath){
        if(node==null)return 0;
        int res = 0;
        if(node.val>=maxInPath)res++;
        res = res +  dfs(node.left,Math.max(maxInPath,node.val)) + dfs(node.right,Math.max(maxInPath,node.val));
        return res;
        
    }
    public int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }
}
