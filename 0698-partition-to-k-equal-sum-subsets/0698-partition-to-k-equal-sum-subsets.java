class Solution {
    static boolean func(int target, int arr[], int i, int sum, boolean bool[], int k){
        if(k==0)return true;

        // passing the updated boolean visited array
        if(sum == target){
            return func(target, arr, 0, 0, bool, k-1);// found one group of subset
        }

        for(int j=i;j<arr.length;j++){
            if(bool[j]!=true && sum+arr[j]<=target){
                bool[j] = true;
                if(func(target, arr, j+1, sum+arr[j], bool, k))return true;
                bool[j] = false;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int it:nums)sum+=it;
        if(sum%k!=0)return false;
        int target = sum/k;
        boolean bool[] = new boolean[nums.length];
        return func(target, nums, 0, 0, bool, k);
    }
}