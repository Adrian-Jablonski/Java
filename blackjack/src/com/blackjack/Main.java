package com.blackjack;

public class Main {

    public static void main(String[] args) {
        String dealtCard;
        int cardPoints;
        Cards deck1 = new Cards();
        Player player1 = new Player("Player 1");
        Player dealer = new Player("Dealer", true);

        dealtCard = deck1.dealCard();
        cardPoints = deck1.cardPoints(dealtCard);
        player1.dealtCards(dealtCard, cardPoints);

        System.out.println(player1.getPoints());

        dealtCard = deck1.dealCard();
        cardPoints = deck1.cardPoints(dealtCard);
        player1.dealtCards(dealtCard, cardPoints);

        System.out.println(player1.getPoints());


    }
}
