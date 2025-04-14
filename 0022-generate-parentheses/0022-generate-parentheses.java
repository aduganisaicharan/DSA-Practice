class Solution {
    public void func(List<String> lst, String str, int opencnt, int closecnt, int n){
        if(opencnt == closecnt && opencnt+closecnt == 2*n){
            lst.add(str);
            return;
        }
        if(opencnt>n || closecnt>opencnt)return;
        func(lst, str+"(", opencnt+1, closecnt, n);
        func(lst, str+")", opencnt, closecnt+1, n);
    }
    public List<String> generateParenthesis(int n) {
        List<String> lst = new ArrayList<>();
        func(lst, "", 0, 0, n);
        return lst;
    }
}