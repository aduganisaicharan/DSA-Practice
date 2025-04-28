class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i=0;
        int j=0;
        int cnta = 0;
        int cntb = 0;
        int sum = 0;
        while(j<nums.length){
            sum+=nums[j];
            while(i<=j && sum>=goal){
                cnta+=nums.length-j;
                sum-=nums[i];
                i++;
            }
            j++;
        }
        i = 0;
        j = 0;
        sum = 0;
        while(j<nums.length){
            sum+=nums[j];
            while(i<=j && sum>goal){
                cntb+=nums.length-j;
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return cnta - cntb;
    }
}