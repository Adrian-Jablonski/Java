package com.blackjack;

public class Player {
    private String name;
    private boolean dealer = false;
    private int points = 0;
    private int acesInHand = 0;
    private String[] cardsInHand;

    public Player(String name) {
        this.name = name;
    }
    public Player(String name, boolean dealer) {
        this(name);
        this.dealer = dealer;
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }

    public void dealtCards(Cards deck, String dealtCard) {
        int cardPoints = deck.cardPoints(dealtCard);
        System.out.print(this.name + " was dealt a ");
        System.out.println(dealtCard);
        this.points += cardPoints;
    }
}
