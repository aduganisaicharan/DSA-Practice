public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=31;i>=0;i--){
            int bit = n&1;
            res+=bit*(1<<i);
            n=n>>1;
        }
        return res;
    }
}