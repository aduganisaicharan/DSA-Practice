class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for(int it:nums1)str1.append((char)it);
        for(int it:nums2)str2.append((char)it);
        String s1 = str1.toString();
        String s2 = str2.toString();
        
        int i=0;
        int j=0;
        int maxlen = 0;
        while(j<s1.length()){
            while(i<=j && !s2.contains(s1.substring(i,j+1))){
                i++;
            }
            maxlen = Math.max(maxlen, j-i+1);
            j++;
        }
        return maxlen;
    }
}