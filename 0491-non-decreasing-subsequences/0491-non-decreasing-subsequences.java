class Solution {
    public void func(Set<List<Integer>> lst, List<Integer> l, int arr[], int i){
        if(i == arr.length){
            if(l.size()>=2){
                lst.add(new ArrayList<>(l));
            }
            return;
        }
        if(l.size() == 0 || l.get(l.size()-1)<=arr[i]){
            l.add(arr[i]);
            func(lst, l, arr, i+1);
            l.remove(l.size()-1);
        }
        func(lst, l, arr, i+1);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        func(set, l, nums, 0);
        for(List<Integer> lt:set)lst.add(lt);
        return lst;
    }
}