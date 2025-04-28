class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0;
        int j=0;
        int product = 1;
        int cnt = 0;
        while(j<nums.length){
            product*=nums[j];
            while(i<=j && product>=k){
                cnt+=nums.length - j;
                product /= nums[i];
                i++;
            }
            j++;
        }
        int total = (nums.length*(nums.length+1))/2;
        return total - cnt;
    }
}