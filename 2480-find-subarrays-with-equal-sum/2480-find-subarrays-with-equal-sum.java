class Solution {
    public boolean findSubarrays(int[] nums) {
        int i=0;
        HashSet<Integer> set = new HashSet<>();
        while(i<nums.length-1){
            if(set.contains(nums[i]+nums[i+1])){
                return true;
            }
            else{
                set.add(nums[i] + nums[i+1]);
            }
            i++;
        }
        return false;
    }
}