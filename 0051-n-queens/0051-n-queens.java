class Solution {
    public boolean checkvalid(boolean visited[][], int i, int j){
        // column 
        for(int ind=0;ind<=i;ind++){
            if(visited[ind][j] == true){
                return false;
            }
        }
        // diagonal upleft
        int row = i-1;
        int col = j-1;
        while(row>=0 && col>=0){
            if(visited[row][col] == true){
                return false;
            }
            row--;
            col--;
        }
        // diagonal upside right
        row = i-1;
        col = j+1;
        while(row>=0 && col<visited.length){
            if(visited[row][col]){
                return false;
            }
            row--;
            col++;
        }
        return true;
    }
    public String constructString(int index, int n){
        String str="";
        for(int i=0;i<n;i++){
            if(i==index){
                str+="Q";
            }
            else{
                str+=".";
            }
        }
        return str;
    }
    public void func(boolean visited[][], int i, int qcnt, List<List<String>> lst, List<String> l, int n){
        if(qcnt == 0){
            lst.add(new ArrayList<>(l));
            return;
        }
        for(int ind=0;ind<visited.length;ind++){
            if(checkvalid(visited, i, ind)){
                String str = constructString(ind, n);
                visited[i][ind] = true;
                l.add(str);
                func(visited, i+1, qcnt-1, lst, l, n);
                visited[i][ind] = false;
                l.remove(l.size()-1);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boolean visited[][] = new boolean[n][n];
        List<List<String>> lst = new ArrayList<>();
        List<String> l = new ArrayList<>();
        func(visited, 0, n, lst, l, n);
        return lst;
    }
}