package com.TicTacToe;

public class Main {

    public static void main(String[] args) {

        // Create player
        Player player1 = new Player(true, "Player1");
        Player player2 = new Player(true, "Player2");

        while (player1.getPlayAgain()) {
            // Create board with an array containing each spot
            Board board = new Board();

            board.getBoard();
            board.assignXorO(player1, player2);

            // Ask player where to move
            // Check for a winner
            while (!board.getGameOver()) {
                if (board.getTurn() <= 8) {
                    board.addTurn();
                    player1.playerMove(board);
                }
                else {

                }
                if (board.getTurn() <= 8 && !board.getGameOver()) {
                    board.addTurn();
                    player2.playerMove(board);
                }
            }
            // Ask for rematch
            player1.setPlayAgain();
        }


        // Keep track of wins, losses, and draws

        // Set up game vs computer having computer move based on player movement
    }
}
