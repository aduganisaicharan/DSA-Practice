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
        
        Queue<TreeNode> levelOrder = new LinkedList<>(); // to store the nodes of each level
        List<Integer> ans = new ArrayList<>(); // to store the rightmost nodes or the right side view elements

        if(root == null){
            return ans;
        }

        levelOrder.add(root); // adding first node and null value
        levelOrder.add(null);

        while(!levelOrder.isEmpty()) {
            TreeNode curr = levelOrder.remove(); // the first element of the queue is removed and stored in curr 

            if(curr == null && levelOrder.isEmpty()){ // the queue has no further elements therefore all the nodes are travelled
                break;
            }

            if(curr==null){ // if the queue is not empty we add null value to represent new level
                levelOrder.add(null);
            }
            if(curr!=null){ // adding non-null child of curr node
                if(curr.left!=null)
                levelOrder.add(curr.left);

                if(curr.right!=null)
                levelOrder.add(curr.right);
            }

            if(levelOrder.peek()==null && curr!=null){ // if the next element in the queue is null the curr node is the rightmost node so we add the curr value in the arraylist
                ans.add(curr.val);
            }
        }

        return ans;
    }
}