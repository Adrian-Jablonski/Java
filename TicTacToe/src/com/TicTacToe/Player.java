package com.TicTacToe;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Player {
    private char xOrO;
    private boolean human;
    private String name;
    private int playerInput;
    private boolean playAgain = true;
    private int wins = 0;
    private int losses = 0;
    private int draw = 0;

    public Player(boolean human, String name) {
        this.human = human;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public char getXorO() {
        return this.xOrO;
    }

    public void setxOrO(char xOrO) {
        this.xOrO = xOrO;
    }

    public boolean getPlayAgain() {return this.playAgain;}

    public void setPlayAgain() {
        this.playAgainInput();
    }

    public int getWins() {return this.wins;}

    public void setWins(int wins) {this.wins = wins;}

    public int getLosses() {return this.losses;}

    public void setLosses(int losses) {this.losses = losses;}

    public int getDraw() {return this.draw;}

    public void setDraw(int draw) {this.draw = draw;}

    public void playerMove(Board board, Player player) {
        System.out.println("TURN # " +board.getTurn());
        if (this.human) {

            userMoveInput(board);
            int spot = this.playerInput;
            board.setBoard(spot, this.xOrO);
        }

        board.getBoard();
        boolean playerWon = board.checkForWinner(this.name);

        if (playerWon) {
            this.setWins(this.getWins() + 1);
            player.setLosses(player.getLosses() + 1);
        }

        if (board.getTurn() >= 9 && !board.getGameOver()) {
            System.out.println("DRAW");
            board.setGameOver(true);
            this.setDraw(this.getDraw() + 1);
            player.setDraw(player.getDraw() + 1);
        }
    }

    // Prevent user from entering invalid number
    private void userMoveInput(Board board) {

        Scanner in = new Scanner(System.in);
        System.out.print(this.name + "- Enter number to place " + this.xOrO + " :");
        try {
            this.playerInput = in.nextInt() - 1;
            if (board.checkIfSpotTaken(playerInput)) {
                invalidInput(board);
            }
        }
        catch(Exception err){
            System.out.print("Enter a number from 1 - 9. ");
            invalidInput(board);
        }
    }

    private void invalidInput(Board board) {
        System.out.println("Invalid Input");
        userMoveInput(board);
    }

    private void playAgainInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Play Again? Y/N: ");
        try {
//            String pattern = "Y|N";
            Pattern pattern = Pattern.compile("Y|N", Pattern.CASE_INSENSITIVE);
            String userInput = in.next(pattern).toUpperCase();

            if (userInput.equals("Y")) {
                this.playAgain = true;
            }
            else if (userInput.equals("N")) {
                this.playAgain = false;
            }
        } catch(Exception err) {
            System.out.print("Enter Y or N. ");
            this.playAgainInput();
        }
    }

    public void showStats() {
        System.out.println(this.name + ": Wins: " + this.getWins() + " Losses: " + this.getLosses() + " Draw: " + this.getDraw());
    }
}
