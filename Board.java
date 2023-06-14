package OOPs.TickTacToe;

import javax.swing.plaf.ColorUIResource;

public class Board {
    private char board[][];
    private int boardSize = 3;
    private char p1Symbol, p2Symbol;
    // count of number of cells that are filled
    int count;
    private static final char Empty = ' ';

    public final int PLAYER1WINS = 1;
    public final int PLAYER2WINS = 2;
    public final int DRAW = 3;
    public final int INCOMPLETE = 4;
    public final int INVALIDMOVE = 5;

    public Board(char p1Symbol, char p2Symbol) {
        board = new char[boardSize][boardSize];
        // initialize the matrix with spaces
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = Empty;
            }
        }
        this.p1Symbol = p1Symbol;
        this.p2Symbol = p2Symbol;
    }

    public void print() {
        System.out.println("-----------------");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print("| " + board[i][j] + " |");

            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-----------------");
    }

    public int move(char symbol, int x, int y) {
        // Check if the move is valid
        if (x < 0 || y < 0 || x >= boardSize || y >= boardSize || board[x][y] != Empty) {
            return INVALIDMOVE;
        }
        // mark the symbol on board
        board[x][y] = symbol;
        count++;
        // row
        if (board[x][0] != Empty && board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
            // check which symbol is on the place return that symbol player as winner
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }
        // Column
        if (board[0][x] != Empty && board[0][x] == board[1][x] && board[0][x] == board[2][x]) {
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }
        // diagonal (0,0)(1,1)(2,2)
        if (board[0][0] != Empty && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }
        // diagonal (0,2)(1,1)(2,0)
        if (board[0][2] != Empty && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return symbol == p1Symbol ? PLAYER1WINS : PLAYER2WINS;
        }
        if (count == boardSize * boardSize) {
            return DRAW;
        }
        return INCOMPLETE;
    }

}
