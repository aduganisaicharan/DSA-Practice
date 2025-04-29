class Solution {
    public int gcd(int a, int b){
        if(b==0)return a;
        return gcd(b, a%b);
    }
    public String gcdOfStrings(String str1, String str2) {
        String s1 = str1+str2;
        String s2 = str2+str1;
        if(!s1.equals(s2))return "";
        int gcd = gcd(s1.length(), str1.length());
        String str = str1.substring(0, gcd);
        return str;
    }
}