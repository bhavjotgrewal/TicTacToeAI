public class Functions {

    private static class Move {
        int row;
        int col;
    }

    private static char player = 'X';
    private static char computer = 'O';

    //checking if there are empty spots left;
    private static boolean checkMovesLeft(char board[][]) {
        for(int i = 0; i < 3; i++) {
            for(int n = 0; n < 3; n++) {
                if(board[i][n] == '_') {
                    return true;
                }
            }
        }
        return false;
    }

    //checking if possible rows, columns, or diagonals have a winner, and then returning corresponding integer values
    private static int returnScore(char board[][]) {
        for (int row = 0; row < 3; row ++) {
            if ((board[row][0] == player) && (board[row][1] == player) && (board[row][2] == player)) {
                return 10;
            }
            if ((board[row][0] == computer) && (board[row][1] == computer) && (board[row][2] == computer)) {
                return -10;
            }
        }
        for (int column = 0; column < 3; column ++) {
            if ((board[0][column] == player) && (board[1][column] == player) && (board[2][column] == player)) {
                return 10;
            }
            else if ((board[0][column] == computer) && (board[1][column] == computer) && (board[2][column] == computer)) {
                return -10;
            }
        }
        if ((board[0][0] == player) && (board[1][1] == player) && (board[2][2] == player)) {
            return 10;
        }
        else if ((board[0][0] == computer) && (board[1][1] == computer) && (board[2][2] == computer)) {
            return -10;
        }
        else if ((board[0][2] == player) && (board[1][1] == player) && (board[2][0] == player)) {
            return -10;
        }
        else if ((board[0][2] == computer) && (board[1][1] == computer) && (board[2][0] == computer)) {
            return -10;
        }
        return 0;
    }


    //minimizing the maximum possible loss
    private static int miniMax(char board[][], int depth, Boolean isMax) {
        int score = returnScore(board);

        //the maximum possible score
        if (score == 10) {
            return score;
        }

        //minimum score
        if (score == -10) {
            return score;
        }

        if (checkMovesLeft(board) == false) {
            return 0;
        }

        if (isMax) {
            int best = -1000;

            for (int i = 0; i < 3; i++) {
                for (int n = 0; n < 3; n++) {
                    if (board[i][n] == '_') {
                        board[i][n] = player;
                        best = Math.max(best, miniMax(board, depth + 1, !isMax));
                        board[i][n] = '_';
                    }
                }
            }
            return best;
        }

        else {
            int best = 1000;
            for (int i = 0; i < 3; i++) {
                for (int n = 0; n < 3; n++) {
                    if (board[i][n] == '_') {
                        board[i][n] = computer;
                        best = Math.min(best, miniMax(board, depth + 1, !isMax));
                        board[i][n] = '_';
                    }
                }
            }
            return best;
        }  
    }

    private static Move findBestMove(char board[][]) {
        int bestValue = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        for (int i = 0; i < 3; i++){ 
            for (int n = 0; n < 3; n++) {
                if (board[i][n] == '_') {
                    board[i][n] = player;
                    int moveValue = miniMax(board, 0, false);
                    board[i][n] = '_';
                    if (moveValue > bestValue) {
                        bestMove.row = i;
                        bestMove.col = n;
                        bestValue = moveValue;
                    }
                }
            }
        }

        return bestMove;

    }

    public static void main(String[] args) { 
        char board[][] = {{ 'X', 'O', 'X' }, 
                         { 'O', 'O', 'X' }, 
                         { '_', '_', '_' }}; 
  
        Move bestMove = findBestMove(board); 

        System.out.printf("ROW: %d COL: %d\n\n",  bestMove.row, bestMove.col ); 
    } 
  
}    
    

