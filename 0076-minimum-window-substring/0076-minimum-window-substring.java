class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        int anslen = Integer.MAX_VALUE;
        String res = "";
        int i=0;
        int j=0;
        HashMap<Character, Integer> hash2 = new HashMap<>();
        for(char ch:t.toCharArray()){
            hash2.put(ch, hash2.getOrDefault(ch, 0)+1);
        }
        int cnt = hash2.size();
        while(j<s.length()){
            if(hash2.containsKey(s.charAt(j))){
                hash2.put(s.charAt(j), hash2.get(s.charAt(j))-1);
                if(hash2.get(s.charAt(j)) == 0)cnt--;
            }
            while(i<=j && cnt == 0){
                if(hash2.containsKey(s.charAt(i))){
                    hash2.put(s.charAt(i), hash2.get(s.charAt(i))+1);
                    if(hash2.get(s.charAt(i)) == 1)cnt++;
                }
                res = s.substring(i, j+1);
                if(res.length()<anslen){
                    anslen = res.length();
                    ans = res;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}