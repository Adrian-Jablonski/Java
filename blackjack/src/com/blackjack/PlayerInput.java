package com.blackjack;
import java.util.Scanner;

public class PlayerInput {
    private Scanner reader = new Scanner(System.in);
    private String userInput;

    public PlayerInput() {}

    public void setUserInput() {
        this.userInput = reader.next().toUpperCase();
    }

    public void printStartMessage() {
        System.out.println("Play Blackjack? (Y/N)");
        this.checkUserStartGameInput();
    }

    public void checkUserStartGameInput() {
        this.setUserInput();
        switch(this.userInput) {
            case "Y":
                break;
            case "N":
                System.out.println("Good Bye");
                System.exit(0);
                break;
            default:
                this.invalidMessage('Y', 'N');
                break;
        }
    }

    public void hitOrStay(Cards deck, Player player) {
        System.out.println("Hit (H) or Stay (S)");
        this.setUserInput();
        switch(this.userInput) {
            case "H":
                deck.dealCard(deck, player);
                int currentPoints = player.getPoints();
                if (currentPoints <= 21) {
                    this.printPlayerPointsMsg(player);
                    this.hitOrStay(deck, player);
                }
                else {
                    System.out.println(player.getName() + " bust");
                }
                break;
            case "S":
                System.out.println(player.getName() + " stays");
                break;
            default:
                this.invalidMessage('H', 'S', deck, player);
                break;
        }
    }

    public void invalidMessage(char opt1, char opt2) {
        System.out.println("Invalid Input. Type " + opt1 + " or " + opt2);
        this.checkUserStartGameInput();
    }

    public void invalidMessage(char opt1, char opt2, Cards deck, Player player) {
        System.out.println("Invalid Input. Type " + opt1 + " or " + opt2);
        this.hitOrStay(deck, player);

    }

    public void printPlayerPointsMsg(Player player) {
        System.out.println(player.getName() + ": " + player.getPoints());
    }
}
