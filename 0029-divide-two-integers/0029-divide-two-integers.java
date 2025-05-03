class Solution {
    public int divide(int divd, int divs) {
        if(divd == divs) return 1;
        if (divd == Integer.MIN_VALUE && divs == -1) {
            return Integer.MAX_VALUE;
        }
        if (divd == Integer.MIN_VALUE && divs == 1) {
            return Integer.MIN_VALUE;
        }
        boolean sign = (divd > 0) == (divs > 0);
        long n = Math.abs((long)divd);
        long d = Math.abs((long)divs);
        long ans=0;
        while(n>=d){
            int count=0;
            while(n>=(d<<(count+1))){
                count++;
            }
            ans +=( 1<<count);
            n = n - (d<<count);
        }
        if(ans>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(ans<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return sign? (int)ans: (int)-ans;
    }
}
        



        // long count = 0 ;
        // long tempdivd = Math.abs((long)divd);
        // long tempdiv = Math.abs((long)divs);
        // while(tempdivd>tempdiv){
        //     tempdivd-=tempdiv;
        //     count++;
        // }
        // if(divd<0)count=-count;
        // if(divs<0)count=-count;
        // if(count>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        // if(count<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        // return (int)count;