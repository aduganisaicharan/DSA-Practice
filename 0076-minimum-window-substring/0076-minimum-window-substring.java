class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c , map.getOrDefault(c, 0) + 1);
        }
        int cnt = map.size();
        int j = 0, i = 0, n = s.length();
        int start = -1, end = -1;
        while(j < n){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) cnt--;
            }
            while(cnt == 0){
                char c1 = s.charAt(i);
                if(map.containsKey(c1)){
                    map.put(c1, map.get(c1) + 1);
                    if(map.get(c1) == 1) cnt++;
                }
                if(start == -1 || end - start + 1 > j - i + 1){
                    start = i;
                    end = j;
                }
                i++;
            }
            j++;
        }
        if(start == -1) return "";
        return s.substring(start, end+1);
    }
}