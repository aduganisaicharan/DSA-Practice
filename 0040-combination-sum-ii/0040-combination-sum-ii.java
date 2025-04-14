class Solution {
    public void func(List<List<Integer>> lst, List<Integer> l, int sum, int arr[], int i){
        if(sum == 0){
            List<Integer> newlist = new ArrayList<>(l);
            lst.add(newlist);
            return;
        }
        for(int j=i;j<arr.length;j++){
            if(j>i && arr[j] == arr[j-1])continue;
            if(arr[j] > sum)break;
            if(arr[j]<=sum){
                l.add(arr[j]);
                func(lst, l, sum-arr[j], arr, j+1);
                l.remove(l.size()-1);
            }
        }
        // func(lst, l, sum, arr, i+1);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lst = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> l = new ArrayList<>();
        func(lst, l, target, candidates, 0);
        return lst;
    }
}