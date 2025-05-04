class Solution {
    public int totalFruit(int[] fruits) {
        int i=0;
        int j=0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        int maxcnt = 0;
        while(j<fruits.length){
            hash.put(fruits[j], hash.getOrDefault(fruits[j], 0)+1);
            while(i<=j && hash.size()>2){
                hash.put(fruits[i], hash.get(fruits[i])-1);
                if(hash.get(fruits[i]) == 0){
                    hash.remove(fruits[i]);
                }
                i++;
            }
            maxcnt = Math.max(maxcnt, j-i+1);
            j++;
        }
        return maxcnt;
    }
}