class Solution {
    public int findposition(int i, int j){
        int position = -1;
        if(i<3 && j<3)position = 0;
        else if(i<3 && j>2 && j<6)position = 1;
        else if(i<3 && j>5 && j<9)position = 2;
        else if(i>2 && i<6 && j<3)position = 3;
        else if(i>2 && i<6 && j>2 && j<6)position = 4;
        else if(i>2 && i<6 && j>5 && j<9)position = 5;
        else if(i>5 && i<9 && j<3)position = 6;
        else if(i>5 && i<9 && j>2 && j<6)position = 7;
        else if(i>5 && i<9 && j>5 && j<9)position = 8;
        return position;
    }
    public boolean checkrow(int val, int row[]){
        for(int i=0;i<row.length;i++){
            if(row[i] == val){
                return false;
            }
        }
        return true;
    }
    public boolean checkcol(int val, List<int[]> rows, int j){
        for(int i=0;i<rows.size();i++){
            if(rows.get(i)[j] == val){
                return false;
            }
        }
        return true;
    }
    public boolean checksubmat(List<int[][]> submat, int i, int j, int val) {
        int pos = findposition(i, j);
        int tempmat[][] = submat.get(pos);
        for(int iind=0;iind<tempmat.length;iind++){
            for(int jind=0;jind<tempmat[0].length;jind++){
                if(tempmat[iind][jind] == val){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean func(char board[][], int visited[][], List<int[]> rows, List<int[][]> submat, int n){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.' && visited[i][j]==0){
                    for(int k=1;k<=9;k++){
                        if(checksubmat(submat, i, j, k) && checkrow(k, rows.get(i)) && checkcol(k, rows, j)){
                            visited[i][j] = k;
                            int pos = findposition(i, j);
                            submat.get(pos)[i%3][j%3] = k;
                            rows.get(i)[j] = k;
                            board[i][j] = (char)(k+'0');
                            if(func(board, visited, rows, submat, n)) return true;
                            board[i][j] = '.';
                            visited[i][j] = 0;
                            rows.get(i)[j] = 0;
                            submat.get(pos)[i%3][j%3] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        int visited[][] = new int[board.length][board[0].length];
        List<int[]> cols = new ArrayList<>();
        List<int[][]> submatrix = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            int arr[] = new int[board[0].length];
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    visited[i][j] = board[i][j]-'0';
                    arr[j] = board[i][j]-'0';
                }
            }
            cols.add(arr);
        }
        for(int i=0;i<9;i++){
            submatrix.add(new int[3][3]);
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int pos = findposition(i,j);
                submatrix.get(pos)[i%3][j%3] = visited[i][j];
            }
        }
        func(board, visited, cols, submatrix, 9);
        
    }
}
