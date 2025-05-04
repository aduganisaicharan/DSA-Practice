class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int i=0;
        int j=0;
        int cnt1 = 0;
        int cnt2 = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j<nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(i<=j && map.size() >= k){
                cnt1 += nums.length - j;
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i])==0)map.remove(nums[i]);
                i++;
            }
            j++;
        }
        i=0;
        j=0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        while(j<nums.length){
            hash.put(nums[j], hash.getOrDefault(nums[j],0)+1);
            while(i<=j && hash.size() > k){
                cnt2+=nums.length - j;
                hash.put(nums[i], hash.get(nums[i])-1);
                if(hash.get(nums[i]) == 0)hash.remove(nums[i]);
                i++;
            }
            j++;
        }
        return cnt1-cnt2;
    }
}