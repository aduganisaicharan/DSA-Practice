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
    private int maxsum = Integer.MIN_VALUE;
    public int findmaxsum(TreeNode root){
        if(root == null)return 0;
        int leftsum = Math.max(0, findmaxsum(root.left));
        int rightsum = Math.max(0, findmaxsum(root.right));
        maxsum = Math.max(maxsum, leftsum+rightsum+root.val);
        return root.val + Math.max(leftsum, rightsum);
    }
    public int maxPathSum(TreeNode root) {
        findmaxsum(root);
        return maxsum;
    }
}