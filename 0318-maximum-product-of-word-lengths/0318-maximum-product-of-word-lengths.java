class Solution {
    public int maxProduct(String[] words) {
        int bitmask[] = new int[words.length];
        int len[] = new int[words.length];
        for(int i=0;i<words.length;i++){
            int mask = 0;
            for(char ch:words[i].toCharArray()){
                mask|=1<<(ch-'a');
            }
            bitmask[i] = mask;
            len[i] = words[i].length();
        }
        int max  = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((bitmask[i] & bitmask[j]) == 0){
                    max = Math.max(max, len[i]*len[j]);
                }
            }
        }
        return max;
    }
}