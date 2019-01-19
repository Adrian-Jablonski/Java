package com.blackjack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String dealtCard;
        int cardPoints;
        Cards deck1 = new Cards();
        Player player1 = new Player("Player 1");
        Player dealer = new Player("Dealer", true);

        Scanner reader = new Scanner(System.in);
        System.out.println("Play Blackjack? (Y/N)");
        String userInput = reader.next().toUpperCase();

        while (!userInput.equals("Y")) {
            if (userInput.equals("N")) {
                System.out.println("Good Bye");
                System.exit(0);
            }
            else {
                System.out.println("Invalid Input. Type Y or N");
                userInput = reader.next().toUpperCase();
            }
        }
        if (userInput.equals("Y")) {
            dealtCard = deck1.dealCard();
            player1.dealtCards(deck1, dealtCard);

            dealtCard = deck1.dealCard();
            dealer.dealtCards(deck1, dealtCard);

            dealtCard = deck1.dealCard();
            player1.dealtCards(deck1, dealtCard);

            System.out.println("--------");
            System.out.println(player1.getName() + ": " + player1.getPoints() + " " + dealer.getName() + ": " + dealer.getPoints());
        }

        System.out.println("Hit (H) or Stay (S)");
        userInput = reader.next().toUpperCase();

        while (userInput.equals("H")) {
            dealtCard = deck1.dealCard();
            player1.dealtCards(deck1, dealtCard);
            System.out.println("--------");
            System.out.println(player1.getName() + ": " + player1.getPoints() + " " + dealer.getName() + ": " + dealer.getPoints());

            System.out.println("Hit (H) or Stay (S)");
            userInput = reader.next().toUpperCase();
        }
        if (userInput.equals("S")) {
            System.out.println(player1.getName() + " stays");
        }

    }
}
