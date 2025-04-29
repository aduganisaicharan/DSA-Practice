class Solution {
    public boolean checkvalid(char ch[], char cha[]){
        Arrays.sort(ch);
        int i=0;
        while(i<ch.length){
            if(ch[i] != cha[i])return false;
            i++;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        char arr[] = p.toCharArray();
        Arrays.sort(arr);
        int cnt = 0;
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<=s.length()-p.length();i++){
            if(checkvalid(s.substring(i, i+p.length()).toCharArray(), arr)){
                lst.add(i);
            };
        }
        return lst;
    }
}