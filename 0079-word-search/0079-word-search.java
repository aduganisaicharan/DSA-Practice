class Solution {
    static boolean boole = false;
    static int[] max = new int[]{Integer.MIN_VALUE};
    public void func(boolean bool[][], char board[][], String word, int ind, int i, int j){
        max[0] = Math.max(ind, max[0]);
        if(ind == word.length()){
            boole = true;
            return ;
        }
        if(i<0 || i==board.length || j<0 || j==board[0].length) return;
        if(word.charAt(ind) == board[i][j] && bool[i][j]==false){
            bool[i][j] = true;
            func(bool, board, word, ind+1, i, j+1);
            func(bool, board, word, ind+1, i, j-1);
            func(bool, board, word, ind+1, i+1, j);
            func(bool, board, word, ind+1, i-1, j);
            bool[i][j]=false;
        }

    }
    public boolean exist(char[][] board, String word) {
        max =new int[]{Integer.MIN_VALUE};
        boole = false;
                boolean bool[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                func(bool, board, word, 0, i, j);
                if(boole == true)return true;
            }
        }
        return false;
    }
}