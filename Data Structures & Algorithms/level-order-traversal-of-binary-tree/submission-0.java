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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root==null)return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> sub = new ArrayList<>();
            int len = queue.size();
            for(int i=0;i<len;i++){
                TreeNode curr = queue.remove();
                sub.add(curr.val);
                if(curr.left!=null)queue.add(curr.left);
                if(curr.right!=null)queue.add(curr.right);
                
            }
            if(sub.size()>0) res.add(sub);
        }
        return res;
        
    }
}
