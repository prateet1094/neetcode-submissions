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
    public class TraverseNode {
        int depth;
        int dia;
        public TraverseNode(int depth,int dia){
            this.depth = depth;
            this.dia = dia;
           
        }
    }

    public TraverseNode traverseNode(TreeNode node){
        if(node==null){
            return new TraverseNode(0,0);
        }
        TraverseNode left = traverseNode(node.left);
        TraverseNode right = traverseNode(node.right);

        int depth = 1 + Math.max(left.depth,right.depth);
        int dia = Math.max(left.dia,Math.max(right.dia, left.depth + right.depth));
        return new TraverseNode(depth,dia);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        return traverseNode(root).dia;
    }
}
