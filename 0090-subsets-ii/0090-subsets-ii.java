class Solution {
    public void func(HashSet<List<Integer>> set, int arr[], int i, List<Integer> l){
        if(i==arr.length){
            set.add(new ArrayList<>(l));
            return;
        }
        l.add(arr[i]);
        func(set, arr, i+1, l);
        l.remove(l.size()-1);
        func(set, arr, i+1, l);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> l = new ArrayList<>();
        func(set, nums, 0, l);
        for(List<Integer> lt:set)lst.add(lt);
        return lst;
    }
}