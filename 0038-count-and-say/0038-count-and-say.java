class Solution {
    public String func(String str, int n){
        if(n==0){
            return str;
        }
        int cnt = 0;
        int ele = 0;
        String st = "";
        for(int i=0;i<str.length();i++){
            if(ele == 0){
                ele = str.charAt(i)-'0';
                cnt = 1;
            }
            else if(ele == str.charAt(i)-'0'){
                cnt++;
            }
            else{
                st+=cnt+""+ele;
                ele = str.charAt(i)-'0';
                cnt = 1;
            }
        }
        st += cnt+""+ele;
        System.out.println(st);
        return func(st, n-1);
    }
    public String countAndSay(int n) {
        if(n==1)return "1";
        String str = "1";
        return func(str, n-1);
    }
}