// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public void inorder(TreeNode root, List<Integer> lst){
//         if(root == null)return;
//         inorder(root.left, lst);
//         lst.add(root.val);
//         inorder(root.right, lst);
//     }
//     public boolean isSymmetric(TreeNode root) {
//         List<Integer> lst = new ArrayList<>();
//         inorder(root.left, lst);
//         List<Integer> lst2 = new ArrayList<>();
//         inorder(root.right, lst2);
//         int i=0;
//         int j=lst.size()-1;
//         while(i<=j){
//             if(lst.get(i)!=lst2.get(j))return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return check(p.left, q.right) && check(p.right, q.left);
    }
}