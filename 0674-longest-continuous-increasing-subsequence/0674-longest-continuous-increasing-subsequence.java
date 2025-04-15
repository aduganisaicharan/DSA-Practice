class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 1)return 1;
        int j=1;
        int max = nums[0];
        int cnt = 0;
        int maxcnt = 0;
        while(j<nums.length){
            if(nums[j]>max){
                cnt++;
                max = Math.max(max, nums[j]);
                j++;
            }
            else{
                cnt = 0;
                max = nums[j];
                j++;
            }
            maxcnt = Math.max(maxcnt, cnt);
        }
        return maxcnt+1;
    }
}