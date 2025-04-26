class Solution {
    public void func(int ind, List<List<Integer>> lst, List<Integer> l, int nums[], int vis[]){
        if(ind==nums.length){
            if(l.size() == nums.length){
                lst.add(new ArrayList<>(l));
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(vis[i] == 1)continue;
            else{
                vis[i] = 1;
                l.add(nums[i]);
                func(ind+1, lst, l, nums, vis);
                l.remove(l.size()-1);
                vis[i] = 0;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        int vis[]=new int[nums.length];
        func(0, lst, l, nums, vis);
        return lst;
    }
}