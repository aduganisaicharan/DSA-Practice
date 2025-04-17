class Solution {
    public boolean checkvalid(int visited[][], int i, int j){
        // col up
        for(int ind=i-1;ind>=0;ind--){
            if(visited[ind][j] == -1){
                return true;
            }
            else if(visited[ind][j] == 1){
                break;
            }
        }
        // col down
        for(int ind=i+1;ind<visited.length;ind++){
            if(visited[ind][j] == -1){
                return true;
            }
            else if(visited[ind][j] == 1){
                break;
            }
        }
        // row left
        for(int ind=j-1;ind>=0;ind--){
            if(visited[i][ind] == -1){
                return true;
            }
            else if(visited[i][ind] == 1){
                break;
            }
        }
        // row right
        for(int ind=j+1;ind<visited.length;ind++){
            if(visited[i][ind] == -1){
                return true;
            }
            else if(visited[i][ind] == 1){
                break;
            }
        }
        // up left
        int row = i-1;
        int col = j-1;
        while(row>=0 && col>=0){
            if(visited[row][col] == -1){
                return true;
            }
            else if(visited[row][col] == 1){
                break;
            }
            row--;
            col--;
        }
        // up right
        row = i-1;
        col = j+1;
        while(row>=0 && col<visited.length){
            if(visited[row][col] == -1){
                return true;
            }
            else if(visited[row][col] == 1){
                break;
            }
            row--;
            col++;
        }
        // down left
        row = i+1;
        col = j-1;
        while(row<visited.length && col>=0){
            if(visited[row][col] == -1){
                return true;
            }
            else if(visited[row][col] == 1){
                break;
            }
            row++;
            col--;
        }
        // down right 
        row = i+1;
        col = j+1;
        while(row<visited.length && col<visited.length){
            if(visited[row][col] == -1){
                return true;
            }
            else if(visited[row][col] == 1){
                break;
            }
            row++;
            col++;
        }
        return false;
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int visited[][] = new int[8][8];
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<queens.length;i++){
            int x = queens[i][0];
            int y = queens[i][1];
            visited[x][y] = 1;
        }
        int x = king[0];
        int y = king[1];
        visited[x][y] = -1;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(visited[i][j] == 1){
                    if(checkvalid(visited, i, j)){
                        l.add(i);
                        l.add(j);
                        lst.add(new ArrayList<>(l));
                        l.clear();
                    }
                }
            }
        }
        return lst;
    }
}