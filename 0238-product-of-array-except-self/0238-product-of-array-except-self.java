class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix[] = new int[nums.length];
        int suffix[] = new int[nums.length];
        prefix[0] = nums[0];
        suffix[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++)prefix[i]=prefix[i-1]*nums[i];
        for(int i=nums.length-2;i>=0;i--)suffix[i]=suffix[i+1]*nums[i];
        int res[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = ((i>0)?prefix[i-1]:1)*((i+1<nums.length)?suffix[i+1]:1);
        }
        return res;
    }
}