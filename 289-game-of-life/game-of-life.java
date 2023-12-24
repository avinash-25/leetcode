class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] arr=new int[n][m];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                int count=0;
                if(j+1<board[i].length && board[i][j+1]==1){
                    count++;
                }
                if(j-1>=0 && board[i][j-1]==1){
                    count++;
                }
                if(i+1<board.length && board[i+1][j]==1){
                    count++;
                }
                if(i-1>=0 && board[i-1][j]==1){
                    count++;
                }
                if(i-1>=0 && j-1>=0){
                    if(board[i-1][j-1]==1){
                        count++;
                    }
                }
                if(i-1>=0 && j+1<board[i].length){
                    if(board[i-1][j+1]==1){
                        count++;
                    }
                }
                if(i+1<board.length && j-1>=0){
                    if(board[i+1][j-1]==1){
                        count++;
                    }
                }
                if(i+1<board.length && j+1<board[i].length){
                    if(board[i+1][j+1]==1){
                        count++;
                    }
                }
                //System.out.print(count+" ");
                if(board[i][j]==0){
                    if(count==3){
                        arr[i][j]=1;
                    }
                }
                if(board[i][j]==1){
                    if(count<2){
                        arr[i][j]=0;
                    }
                    else if(count>3){
                        arr[i][j]=0;
                    }
                    else{
                        arr[i][j]=1;
                    }
                }
                
                
            }
        }
        for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
            board[i][j]=arr[i][j];
        }
    }
        
  }       
}