package ro.sci.ale.feb04;

public class TicTacToe {
    private char[][] board;

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    private char currentPlayer;

    /**
     * the constructor for the TicTacToe class
     */
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    /**
     * method to display the game board
     */
    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            if (i == 0 || i == 1) {
                System.out.println("\n-----------");
            }
        }
        System.out.println("\n");
    }

    /**
     * method to check if the board is full
     *
     * @return isFull if all the cells of the board are completed, false otherwise
     */
    public boolean fullBoard() {
        boolean fullBoard = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    fullBoard = false;
                }
            }
        }
        return fullBoard;
    }

    /**
     * method to check the entire board
     *
     * @return true if there is a win, false otherwise
     */
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    /**
     * method to check in rows to see if are winners
     * use method check
     *
     * @return false if there are not winners, true otherwise
     */
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (check(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * method to check in columns to see if are winners
     * use method check
     *
     * @return false if there are not winners, true otherwise
     */
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (check(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * method to check the two diagonals to see if either is a win
     * use method check
     *
     * @return true if either wins
     */
    private boolean checkDiagonalsForWin() {
        return ((check(board[0][0], board[1][1], board[2][2]) == true)
                            || (check(board[0][2], board[1][1], board[2][0]) == true));
    }

    /**
     * method to check if all three values are the same indicating a win
     *
     * @param c1 the mark that the player inputs
     * @param c2 the mark that the player inputs
     * @param c3 the mark that the player inputs
     * @return true
     */
    private boolean check(char c1, char c2, char c3) {

        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    /**
     * method to change the player marks
     */
    public void changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = '0';
        } else {
            currentPlayer = 'X';
        }
    }

    /**
     * method to place the mark of the current player
     *
     * @param row the rows of the game board
     * @param col the column of the game board
     * @return false
     */
    public boolean placeMark(int row, int col) {
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayer;
                    return true;
                }
            }
        }
        return false;
    }
}


