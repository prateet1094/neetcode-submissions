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
        if(root==null)return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int len = que.size();
            int val = -200;
            for(int i=0;i<len;i++){
                TreeNode curr = que.remove();
                val = curr.val;
                if(curr.left!=null) que.add(curr.left);
                if(curr.right!=null) que.add(curr.right);
            }
            if(val!=-200)res.add(val);
            
        }
        return res;

        
    }
}
