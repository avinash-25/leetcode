class Solution {
    public boolean isValidSudoku(char[][] board) {
        byte row = 0;
        byte col = 0;
        List<Character> list = new ArrayList<Character>(); 
        for (row = 0; row <= 8; row++){ 
            for (col = 0; col <= 8; col++){ 
                if (board[row][col] == '.') continue;
                else {
                    if (list.contains(board[row][col])) 
                        return false; 
                    else list.add(board[row][col]); 
                    } 
            }
            list.clear(); 
        }
      
        for (col = 0; col <= 8; col++){ 
            for (row = 0; row <= 8; row++){
                if (board[row][col] == '.') continue;
                else {
                    if (list.contains(board[row][col]))
                        return false;
                    else list.add(board[row][col]);
                }
            }
            list.clear(); 
        } 
        for (byte rowOffset = 0; rowOffset < 9; rowOffset += 3){
            for (byte colOffset = 0; colOffset < 9; colOffset += 3){
                list.clear();
                for (row = 0; row <= 2; row++){ 
                    for (col = 0; col <= 2; col++){
                        if (board[row + rowOffset][col + colOffset] == '.'){ 
                            continue;
                        }
                        else {
                            if (list.contains(board[row + rowOffset][col + colOffset])){
                                return false;
                            }
                            else {
                                list.add(board[row + rowOffset][col + colOffset]);
                            }
                        }
                    }
                }
            }
        }
        return true; 
    }
}