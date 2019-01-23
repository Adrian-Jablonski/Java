package com.blackjack;

public class GamePlay {

    private boolean gameOver = false;

    public boolean getGameOver() {return gameOver;}
    public void setGameOver(boolean gameOver) {this.gameOver = gameOver;}

    public GamePlay() {

    }

    public void firstDeal(Cards deck, Player player1, Player dealer) {
        deck.dealCard(deck, player1);
        deck.dealCard(deck, dealer);
        deck.dealCard(deck, player1);

        System.out.println("--------");
        System.out.println(player1.getName() + ": " + player1.getPoints() + " " + dealer.getName() + ": " + dealer.getPoints());
    }

    public void dealerTurn(Cards deck, Player player1, Player dealer) {
        while (dealer.getPoints() < 17) {
            deck.dealCard(deck, dealer);
            System.out.println("--------");
            System.out.println(dealer.getName() + ": " + dealer.getPoints());
        }
        checkWinner(player1, dealer);
    }
    public void checkWinner(Player player1, Player dealer) {
        int player1Points = player1.getPoints();
        int dealerPoints = dealer.getPoints();

        System.out.println(player1.getName() + ": " + player1.getPoints() + " " + dealer.getName() + ": " + dealer.getPoints());

        if (dealerPoints > 21) {
            System.out.println(dealer.getName() + " bust " + player1.getName() + " wins!" );
        }
        else if (player1Points > dealerPoints) {
            System.out.println(player1.getName() + " wins!");
        }
        else if (player1Points < dealerPoints) {
            System.out.println(player1.getName() + " loses");
        }
        else {
            System.out.println("Push");
        }
    }
}
