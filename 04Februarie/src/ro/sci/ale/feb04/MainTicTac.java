package ro.sci.ale.feb04;

import java.util.Scanner;

public class MainTicTac {
    private static int row, col;
    private static Scanner scan = new Scanner(System.in);
    private static char player;

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        game.displayBoard();


        while (game.checkForWin() == false && game.fullBoard() == false) {
            player = game.getCurrentPlayer();
            System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (row[1-3] column[1-3]):");
            row = scan.nextInt() - 1;
            col = scan.nextInt() - 1;
            if (game.placeMark(row, col)) {
                game.displayBoard();
                game.changePlayer();
            }
        }
        if (game.fullBoard() == false) {
            System.out.println("Player: '" + player + "' won");
        } else {
            System.out.println("Draw");
        }

    }
}
