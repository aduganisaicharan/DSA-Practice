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
// class Solution {
//     static int minlevel = Integer.MAX_VALUE;
//     static void func(TreeNode root, HashMap<Integer,List<Integer>> hash, int v){
//         if(root == null)return;
//         hash.putIfAbsent(v, new ArrayList<>());
//         minlevel = Math.min(minlevel, v);
//         hash.get(v).add(root.val);
//         func(root.left, hash, v-1);
//         func(root.right, hash, v+1);
//     }
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         List<List<Integer>> lst = new ArrayList<>();
//         HashMap<Integer, List<Integer>> hash = new HashMap<>();
//         minlevel = Integer.MAX_VALUE;
//         func(root, hash, 0);
//         while(hash.containsKey(minlevel)){
//             List<Integer> temp = hash.get(minlevel);
//             lst.add(temp);
//             minlevel++;
//         }
//         return lst;
//     }
// }

class Solution {
    int min, max = 0;
    HashMap<Integer, List<int[]>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traversal(root, 0, 0);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            Collections.sort(map.get(i), (int[] a, int[] b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
            ArrayList<Integer> t = new ArrayList<>();
            for(int [] a : map.get(i)){
                t.add(a[1]);
            }
            res.add(t);
        }
        return res;
    }

    public void traversal(TreeNode root, int x, int y) {
        if (root == null)
            return;
        min = Math.min(min, y);
        max = Math.max(max, y);
        map.computeIfAbsent(y, k -> new ArrayList<int[]>()).add(new int[] { x, root.val });
        traversal(root.left, x + 1, y - 1);
        traversal(root.right, x + 1, y + 1);
    }
}