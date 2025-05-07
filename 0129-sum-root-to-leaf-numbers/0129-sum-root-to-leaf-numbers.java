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
    private long sum = 0;
    public void findpaths(TreeNode root, String str){
        if(root == null)return;
        if(root.left!=null)findpaths(root.left, str+root.left.val);
        else if(root.right == null) sum+=Integer.parseInt(str);
        if(root.right!=null)findpaths(root.right, str+root.right.val);
        else if(root.left == null) sum+=Integer.parseInt(str);
    }
    public int sumNumbers(TreeNode root) {
        String str = root.val+"";
        findpaths(root, str);
        return (int)(sum/2);
    }
}