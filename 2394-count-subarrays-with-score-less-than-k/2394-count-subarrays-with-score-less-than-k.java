class Solution {
    static long mod = (long)1e18+7;
    public long countSubarrays(int[] nums, long k) {
        int i=0;
        int j=0;
        long sum = 0;
        long len = 0;
        long cnt = 0;
        while(j<nums.length){
            sum+=(long)nums[j];
            len++;
            long product = sum*len;
            while(i<=j && product>=k){
                cnt+=nums.length - j;
                sum-=(long)nums[i];
                len--;
                product = sum*len;
                i++;
            }
            j++;
        }
        long total = ((nums.length)%mod*(nums.length+1)%mod)%mod/2;
        return total-cnt;
    }
}