package com.blackjack;
import java.util.Arrays;

public class Cards {
    private int cardAmount = 52;
    private String[] deck = new String[cardAmount];
    public static final String[] CARDRANKS = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public enum CardSuits {H, D, C, S}


    { // initialization block
        int cardIndex = 0;

        // Creating cards
        for (CardSuits suit: CardSuits.values()) {
            for (String rank: CARDRANKS) {
                deck[cardIndex] = rank + " " + suit;
                cardIndex ++;
            }
        }
    }

    public Cards() {

    }

    public String getDeck() {
        return Arrays.toString(deck);
    }

    public void dealCard(Cards deck1, Player player) {
        int deckSize = deck.length - 1;
        long randomNumb = Math.round(Math.random() * (deckSize) - 1);
        String currentCard = deck[(int)randomNumb];
        removeCardFromDeck(currentCard);
        player.dealtCards(deck1, currentCard);
//        return currentCard;
    }

    public int cardPoints(String card) {
        int cardPoints = 0;
        String cardRank = card.substring(0, card.indexOf(" "));

        if (cardRank.equals("A") || cardRank.equals("K") || cardRank.equals("Q") || cardRank.equals("J")) {

        }
        else {
            return Integer.parseInt(cardRank);
        }

        switch(cardRank) {
            case "A":
                cardPoints = 11;
                break;
            default :
                cardPoints = 10;
                break;
        }
        return cardPoints;
    }

    private void removeCardFromDeck(String card) {
        cardAmount -= 1;
        String updatedDeck[] = new String[cardAmount];
        int k = 0;
        for (int i = 0; i < deck.length; i++) {
            if (!deck[i].equals(card)) {
                updatedDeck[k] = deck[i];
                k++;
            }
        }
        deck = updatedDeck;
    }
}
