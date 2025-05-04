class Solution {
    public int numberOfSubstrings(String s) {
        int i=0;
        int j=0;
        int totalcnt1 = 0;
        // int totalcnt2 = 0;
        // int total = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        while(j<s.length()){
            char ch = s.charAt(j);
            hash.put(ch, hash.getOrDefault(ch, 0)+1);
            while(i<=j && hash.size() == 3){
                totalcnt1+=s.length()-j;
                hash.put(s.charAt(i), hash.get(s.charAt(i))-1);
                if(hash.get(s.charAt(i)) == 0)hash.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return totalcnt1;
    }
}