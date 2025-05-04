class Solution {
    public int maxScore(int[] card, int k) {
        int leftsum = 0;
        int rightsum = 0;
        int i=0;
        int j = card.length-1;
        int maxsum =0;
        while(i<k){
            leftsum+=card[i];
            maxsum = Math.max(maxsum, leftsum);
            i++;
        }
        i=i-1;
        while(i>=0){
            leftsum-=card[i];
            rightsum += card[j];
            maxsum = Math.max(maxsum, leftsum+rightsum);
            j--;
            i--;
        }
        return maxsum;
    }
}



// int prefix[] = new int[card.length];
//         int suffix[] = new int[card.length];
//         prefix[0] = card[0];
//         for(int i=1;i<card.length;i++){
//             prefix[i] = prefix[i-1]+card[i];
//         }
//         suffix[card.length-1] = card[card.length-1];
//         for(int i=card.length-2;i>=0;i--){
//             suffix[i] = suffix[i+1]+card[i];
//         }
//         int max = 0;
//         int sum = 0;
//         for(int i=0;i<k;i++){
//             sum = prefix[i]+suffix[k-(i+1)-1];
//             max=Math.max(sum, max);
//         }