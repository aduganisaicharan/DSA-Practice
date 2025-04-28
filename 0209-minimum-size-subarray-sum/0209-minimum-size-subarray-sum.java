class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            while(i<=j && sum>=target){
                if(sum >= target){
                    minlen = Math.min(minlen, j-i+1);
                }
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return (minlen != Integer.MAX_VALUE)?minlen:0;
    }
}