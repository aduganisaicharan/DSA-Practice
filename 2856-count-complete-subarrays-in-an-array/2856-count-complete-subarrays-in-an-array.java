class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int i=0;
        int j=0;
        while(i<nums.length){
            HashMap<Integer, Integer> hash = new HashMap<>();
            if(hash.containsKey(nums[i]) && hash.get(nums[i])>1){
                hash.put(nums[i], hash.get(nums[i])-1);
            }
            else if(hash.containsKey(nums[i]) && hash.get(nums[i]) == 1){
                hash.remove(nums[i]);
            }
            j=i;
            while(j<nums.length){
                hash.put(nums[j], hash.getOrDefault(nums[j], 0)+1);
                if(hash.size() == set.size()){
                    cnt++;
                    cnt = cnt+(nums.length - (j+1));
                    break;
                }
                j++;
            }
            i++;
        }
        return cnt;
    }
}