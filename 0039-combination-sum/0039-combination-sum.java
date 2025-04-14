class Solution {
    public void func(List<List<Integer>> lst, List<Integer> l, int sum, int arr[], int i){
        if(i == arr.length){
            if(sum == 0){
                lst.add(new ArrayList<>(l));
                return;
            }
            return;
        }
        if(arr[i]<=sum){
            l.add(arr[i]);
            func(lst, l, sum-arr[i], arr, i);
            l.remove(new Integer(arr[i]));
        }
        func(lst, l, sum, arr, i+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        func(lst, l, target, candidates, 0);
        return lst;
    }
}