class Solution {
    public boolean ispalindrome(String str, int i, int j){
        while(i<j){
            if(str.charAt(i) != str.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public void func(List<List<String>> lst, List<String> l, String str, int ind){
        if(ind>=str.length()){
            lst.add(new ArrayList<>(l));
            return;
        }
        for(int i=ind;i<str.length();i++){
            if(ispalindrome(str, ind, i)){
                String st = str.substring(ind, i+1);
                l.add(st);
                func(lst, l, str, i+1);
                l.remove(l.size()-1);
            }
        }
        System.out.println(l);
    }
    public List<List<String>> partition(String s) {
        List<List<String>> lst = new ArrayList<>();
        List<String> l = new ArrayList<>();
        func(lst, l, s, 0);
        return lst;
    }
}