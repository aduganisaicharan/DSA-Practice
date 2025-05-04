class Solution {
    public int findmax(HashMap<Character, Integer> hash){
        int max = -1;
        for(char ch:hash.keySet()){
            max = Math.max(max, hash.get(ch));
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int i=0;
        int j=0;
        int maxlen = 0;
        while(j<s.length()){
            char ch = s.charAt(j);
            hash.put(ch, hash.getOrDefault(ch, 0)+1);
            int maxfreq = findmax(hash);
            while((j-i+1)-maxfreq > k){
                hash.put(s.charAt(i), hash.get(s.charAt(i))-1);
                maxfreq = findmax(hash);
                i++;
            }
            maxlen = Math.max(maxlen, j-i+1);
            j++;
        }
        return maxlen;
    }
}