class Solution {
    public boolean hasAlternatingBits(int n) {
        int cnt = 0;
        if((n&1) == 1){
            while(n>0){
                if(cnt>1 || cnt<0)return false;
                if((n&1) == 1){
                    cnt++;
                }
                else{
                    cnt--;
                }
                n = n>>1;
            }
            if(cnt == 1)return true;
        }
        else{
            while(n>0){
                if(cnt>0 || cnt<-1)return false;
                if((n&1) == 0){
                    cnt--;
                }
                else{
                    cnt++;
                }
                n = n>>1;
            }
            if(cnt == 0)return true;
        }
        return false;
    }
}