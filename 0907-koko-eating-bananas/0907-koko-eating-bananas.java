class Solution {
    static int maxi(int piles[]){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
    static long checkcount(int arr[], long midval){
        long hrscnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0 && arr[i]<=midval){
                hrscnt++;
            }
            else{
                hrscnt+=arr[i]/midval;
                if(arr[i]%midval!=0){
                    hrscnt++;
                }
            }
        }
        return hrscnt;
    }
    public int minEatingSpeed(int[] piles, int h) {
        long low = 1;
        long high = maxi(piles);
        if(piles.length == h)return maxi(piles);
        int res = Integer.MAX_VALUE;
        while(low<=high){
            long mid = (low+high)/2;
            System.out.println(mid);
            long val = checkcount(piles, mid);
            if(val <= h){
                res = (int)mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }
}































