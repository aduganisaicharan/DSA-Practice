class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        // if(s.length()!=0)maxlen = 1;
        HashSet<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            while(i<=j && set.contains(ch)){
                maxlen = Math.max(maxlen, j-i);
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            j++;
        }
        maxlen = Math.max(maxlen, j-i);
        return maxlen;
    }
}


// class Solution {
//     static void removeall(HashMap<Character, Integer> hash,int from,  int to, String s){
//         for(int i=from;i<to;i++){
//             char ch = s.charAt(i);
//             if(hash.containsKey(ch)){
//                 hash.remove(ch);
//             }
//         }
//         return ;
//     }
//     public int lengthOfLongestSubstring(String s) {
//         HashMap<Character, Integer> hash = new HashMap<>();
//         int i=0;
//         int j = 0;
//         int len = 0;
//         while(j<s.length()){
//             char ch = s.charAt(j);
//             if(hash.containsKey(ch)){
//                 int prev = i;
//                 i = hash.get(ch)+1;
//                 removeall(hash,prev, i, s);
//             }
//             hash.put(ch, j);
//             len  = Math.max(len, j-i+1);
//             j++;
//         }
//         return len;
//     }
// }



//         // int i=0;
//         // int len = 0;
//         // int j=0;
//         // while(j<s.length()){
//         //     char ch = s.charAt(i);

//         //     while(set.contains(ch)){
//         //         i++;
//         //         set.remove(ch);
//         //     }
//         //     set.add(ch);
//         //     len = Math.max(len, j-i+1); 
//         //     j++;
//         // }
//         // return len;