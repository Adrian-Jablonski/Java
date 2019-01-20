package com.blackjack;

public class GamePlay {

    public GamePlay() {

    }

    public void firstDeal(Cards deck, Player player1, Player dealer) {
        deck.dealCard(deck, player1);
        deck.dealCard(deck, dealer);
        deck.dealCard(deck, player1);

        System.out.println("--------");
        System.out.println(player1.getName() + ": " + player1.getPoints() + " " + dealer.getName() + ": " + dealer.getPoints());
    }
}
