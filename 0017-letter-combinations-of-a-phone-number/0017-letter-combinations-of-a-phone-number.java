class Solution {
    static void func(List<String> lst, String arr[], StringBuilder sb, int i, String digits, int len){
        if(i>=len){
            lst.add(sb.toString());
            return;
        }
        String str = arr[digits.charAt(i)-'0'];
        for(char ch:str.toCharArray()){
            sb.append(ch);
            func(lst, arr, sb, i+1, digits, len);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)return new ArrayList<>();
        String arr[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> lst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        func(lst, arr, sb, 0, digits, digits.length());
        return lst;
    }
}