package leetcoder;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> col  = new HashSet<>();
            Set<Character> row  = new HashSet<>();
            Set<Character> b  = new HashSet<>();
            for(int j=0;j<9;j++)
            {
                char c = board[i][j];
                if(c!='.' && !col.add(c)) {
                    return false;
                }
                c = board[j][i];
                if(c!='.' && !row.add(c)){
                    return false;
                }
                int nr = 3*(i/3)+ j/3;
                int nc = 3*(i%3)+ j%3;
                c = board[nr][nc];
                if(c!='.' && !b.add(c)){
                    return false;
                }

            }
        }
        return true;
    }
}

