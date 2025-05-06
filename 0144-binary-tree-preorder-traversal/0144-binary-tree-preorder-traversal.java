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
    public void preorder(List<Integer> lst, TreeNode root){
        if(root == null)return;
        lst.add(root.val);
        preorder(lst, root.left);
        preorder(lst, root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        preorder(lst, root);
        return lst;
    }
}