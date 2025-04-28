class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> lst = new ArrayList<>();
        int curr = 0;
        for(int i=0;i<nums.length;i++){
            curr = curr<<1;
            curr = (curr | nums[i])%5;
            lst.add(curr == 0);
        }
        return lst;
    }
}