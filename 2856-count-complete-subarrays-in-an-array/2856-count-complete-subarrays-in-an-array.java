class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums)set.add(i);
        int i=0;
        int j=0;
        int cnt = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        while(j<nums.length && i<nums.length){
            hash.put(nums[j], hash.getOrDefault(nums[j], 0)+1);
            while(hash.size() == set.size()){
                cnt+= nums.length - j;
                if(hash.get(nums[i])>1){
                    hash.put(nums[i], hash.get(nums[i])-1);
                }
                else if(hash.get(nums[i]) == 1){
                    hash.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
        return cnt;
    }
}