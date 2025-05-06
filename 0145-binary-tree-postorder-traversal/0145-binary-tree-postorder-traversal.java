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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null)return lst;
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    lst.add(temp.val);
                    while(!st.isEmpty() &&  st.peek().right == temp){
                        temp = st.peek();
                        st.pop();
                        lst.add(temp.val);
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
        return lst;
    }
}