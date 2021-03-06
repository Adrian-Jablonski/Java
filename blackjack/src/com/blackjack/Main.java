package com.blackjack;

public class Main {

    public static void main(String[] args) {
        PlayerInput playerInput = new PlayerInput();

        playerInput.printStartMessage();

        GamePlay gamePlay = new GamePlay();

        while (!gamePlay.getGameOver()) {
            Player player1 = new Player("Player 1");
            Player dealer = new Player("Dealer", true);
            Cards deck1 = new Cards();

            gamePlay.firstDeal(deck1, player1, dealer);
            playerInput.hitOrStay(deck1, player1);

            if (player1.getPoints() <= 21) {
                gamePlay.dealerTurn(deck1, player1, dealer);
            }

            playerInput.playAgain(gamePlay);
        }

    }
}
