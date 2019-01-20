package com.blackjack;

public class Main {

    public static void main(String[] args) {
        Cards deck1 = new Cards();
        Player player1 = new Player("Player 1");
        Player dealer = new Player("Dealer", true);
        PlayerInput playerInput = new PlayerInput();

        playerInput.printStartMessage();

        GamePlay gamePlay = new GamePlay();

        gamePlay.firstDeal(deck1, player1, dealer);
        playerInput.hitOrStay(deck1, player1);

        //TODO: Add code for dealer playing


    }
}
