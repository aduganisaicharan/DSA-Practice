class Solution {
    public void func(List<List<Integer>> lst, List<Integer> l, int arr[], int i, int sum, int k, int n){
        if(i==arr.length){
            if(l.size() == k && sum == n){
                lst.add(new ArrayList<>(l));
                return;
            }
            return;
        }
        l.add(arr[i]);
        func(lst, l, arr, i+1, sum+arr[i], k, n);
        l.remove(new Integer(arr[i]));
        func(lst, l, arr, i+1, sum, k, n);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = new int[10];
        for(int i=1;i<arr.length;i++){
            arr[i] = i;
        }
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        func(lst, l, arr, 1, 0, k, n);
        return lst;
    }
}