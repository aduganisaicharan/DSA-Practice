class Solution {
    public boolean checkvalid(HashMap<Character, Integer> hash, HashMap<Character, Integer> map){
        if(hash.size() != map.size())return false;
        for(char ch:hash.keySet()){
            if(!hash.get(ch).equals(map.get(ch)))return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for(char ch:p.toCharArray())hash.put(ch, hash.getOrDefault(ch, 0)+1);
        int i=0;
        int j=p.length()-1;
        HashMap<Character, Integer> hash2 = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        if(p.length()>s.length())return lst;
        for(int x=i;x<=j;x++){
            hash2.put(s.charAt(x), hash2.getOrDefault(s.charAt(x), 0)+1);
        }
        while(j<s.length()){
            if(checkvalid(hash2, hash))lst.add(i);
            hash2.put(s.charAt(i), hash2.get(s.charAt(i))-1);
            if(hash2.get(s.charAt(i)) == 0)hash2.remove(s.charAt(i));
            i++;
            j++;
            if(j<s.length())hash2.put(s.charAt(j), hash2.getOrDefault(s.charAt(j), 0)+1);
        }
        return lst;
    }
}