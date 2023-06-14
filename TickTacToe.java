package OOPs.TickTacToe;

import java.util.*;

public class TickTacToe {
    private Player player1, player2;
    private Board board;
    private int numPlayers;

    public static void main(String[] args) {
        TickTacToe t = new TickTacToe();
        t.startGame();
    }

    private void startGame() {
        // take player input
        Scanner s = new Scanner(System.in);
        player1 = takePlayerInput(++numPlayers);
        player2 = takePlayerInput(++numPlayers);
        // if symbols of both the players are same then take input again
        while (player1.getSymbol() == player2.getSymbol()) {
            System.out.println("Symbol is already taken! Please Enter The Symbol Again ");
            player2.setSymbol(s.next().charAt(0));

        }
        // create the board
        board = new Board(player1.getSymbol(), player2.getSymbol());
        // play the game
        boolean player1Turn = true;
        int status = board.INCOMPLETE;
        while (status == board.INCOMPLETE || status == board.INVALIDMOVE) {
            if (player1Turn) {
                System.out.println("Player 1 - " + player1.getName() + "'s Turn");
                System.out.println("Enter x:");
                int x = s.nextInt();
                System.out.println("Enter y:");
                int y = s.nextInt();
                status = board.move(player1.getSymbol(), x, y);
                if (status == board.INVALIDMOVE) {
                    System.out.println("Invalid Move!! Please Try Again");
                } else {

                    player1Turn = !player1Turn;
                    board.print();
                }

            } else {
                System.out.println("Player 2 - " + player2.getName() + "'s Turn");
                System.out.println("Enter x:");
                int x = s.nextInt();
                System.out.println("Enter y:");
                int y = s.nextInt();
                status = board.move(player2.getSymbol(), x, y);
                if (status == board.INVALIDMOVE) {
                    System.out.println("Invalid Move!! Please Try Again");
                } else {

                    player1Turn = !player1Turn;
                    board.print();
                }
            }

        }
        if (status == board.PLAYER1WINS) {
            System.out.println("Player 1- " + player1.getName() + " Wins!");
        } else if (status == board.PLAYER2WINS) {
            System.out.println("Player 2- " + player2.getName() + " Wins!");

        } else {
            System.out.println("Draw!!");
        }
    }

    private static Player takePlayerInput(int num) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter player " + num + " Name");
        String name = s.nextLine();
        System.out.println("Enter player " + num + " Symbol");
        char symbol = s.next().charAt(0);
        Player p = new Player(name, symbol);
        return p;
    }
}
