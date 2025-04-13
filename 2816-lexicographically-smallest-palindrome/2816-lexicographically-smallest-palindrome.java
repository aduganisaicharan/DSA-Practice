class Solution {
    public String makeSmallestPalindrome(String s) {
        char arr[] = s.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            if(arr[i]!=arr[j]){
                if(arr[i]<arr[j]){
                    arr[j] = arr[i];
                }
                else{
                    arr[i] = arr[j];
                }
            }
            i++;
            j--;
        }
        String str = "";
        for(char ch:arr){
            str+=ch+"";
        }
        return str;
    }
}