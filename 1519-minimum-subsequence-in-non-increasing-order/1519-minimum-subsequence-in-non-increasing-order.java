class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<int[]> lst = new ArrayList<>();
        int totalsum = 0;
        for(int i=0;i<nums.length;i++){
            lst.add(new int[]{nums[i], i});
            totalsum+=nums[i];
        }
        lst.sort((a,b)->{
            return b[0] - a[0];
        });
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<lst.size();i++){
            sum+=lst.get(i)[0];
            res.add(lst.get(i)[0]);
            if(sum>(totalsum-sum)){
                break;
            }
        }
        Collections.sort(res);
        Collections.reverse(res);
        return res;
    }
}