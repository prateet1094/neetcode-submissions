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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1,map);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int pre_i, int pre_j, int in_i,int in_j,HashMap<Integer,Integer> map){
        if(pre_i<0 || pre_j<0 || pre_i>=preorder.length || pre_j>=preorder.length || in_i>=inorder.length || in_j>=inorder.length || pre_i>pre_j || in_i>in_j){
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre_i]);
        int idx = map.get(preorder[pre_i]);
        int eleInLeft = idx - in_i;
        int eleInRight  = in_j-idx;

        node.left = buildTree(preorder,inorder,pre_i+1,pre_i+eleInLeft,in_i,idx-1,map);
        node.right = buildTree(preorder,inorder,pre_j-eleInRight+1,pre_j,idx+1,in_j,map);
        return node;

    }
}
