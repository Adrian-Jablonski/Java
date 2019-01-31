package com.TicTacToe;

import java.util.Random;
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

    public Player() {

    }

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
        int spot;
        if (this.human) {

            userMoveInput(board);
            spot = this.playerInput;
        }
        else {
            spot = computerMove(board) - 1;
            System.out.println("Computer: " + (spot + 1));
        }
        board.setBoard(spot, this.xOrO);

        board.showBoard();
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

    public String player2Type() {
        Scanner in = new Scanner(System.in);
        System.out.print("Play vs (1)Human or (2)Computer: ");
        try {
            Pattern pattern = Pattern.compile("1|2");
            String player2Type= in.next(pattern);
            if (player2Type.equals("1")) {
                return "Human";
            }
            else if (player2Type.equals("2")) {
                return "Computer";
            }

        }
        catch(Exception err){
            System.out.print("Enter 1 for Human or 2 for Computer ");
            player2Type();
        }
        return "";
    }

    private int computerMove(Board board) {
        int spot = 1;
        char boardSpaces[] = board.getBoard();
        String options = "";

        for(char space: boardSpaces) {
            if (notXorO(space)) {
                spot = checkForMove(space, boardSpaces);
                if (spot == -1) {
                    options += space;
                }
                else {
                    return spot + 1;
                }
            }
            else {
//                System.out.println("Spot Taken: "+ space);
            }
        }

        int optionLen = options.length();
        int randNumb = (int)Math.floor(Math.random() * optionLen);

        spot = Integer.parseInt(options.substring(randNumb, randNumb + 1));

        return spot;
    }

    private boolean notXorO(char space) {
        if (space == 'X' || space =='O') {
            return false;
        }
        return true;
    }

    private int checkForMove(char space, char[] board) {
        int placeOn = -1;
        int spaceInt = (int)space - 49; // Convert from ASCII Value
        String boardSpaces[] = new String(board).split("");

        switch(spaceInt) {
            case 0:
                if ((boardSpaces[1].equals(boardSpaces[2])) || (boardSpaces[3].equals(boardSpaces[6])) || (boardSpaces[4].equals(boardSpaces[8])) ) {
                    placeOn = spaceInt;
                }
                break;
            case 1:
                if ((boardSpaces[0].equals(boardSpaces[2])) || (boardSpaces[4].equals(boardSpaces[7]))) {
                    placeOn = spaceInt;
                }
                break;
            case 2:
                if ((boardSpaces[0].equals(boardSpaces[1])) || (boardSpaces[5] .equals(boardSpaces[8])) || (boardSpaces[4].equals(boardSpaces[6]))) {
                    placeOn = spaceInt;
                }
                break;
            case 3:
                if ((boardSpaces[0].equals(boardSpaces[6])) || (boardSpaces[4].equals(boardSpaces[5])) ) {
                    placeOn = spaceInt;
                }
                break;
            case 4:
                if ((boardSpaces[0].equals(boardSpaces[8])) || (boardSpaces[2].equals(boardSpaces[6])) || (boardSpaces[1].equals(boardSpaces[7])) || (boardSpaces[3].equals(boardSpaces[5]))) {
                    placeOn = spaceInt;
                    break;
                }
            case 5:
                if ((boardSpaces[3].equals(boardSpaces[4])) || (boardSpaces[2].equals(boardSpaces[8]))) {
                    placeOn = spaceInt;
                }
                break;
            case 6:
                if ((boardSpaces[0].equals(boardSpaces[3])) || (boardSpaces[7].equals(boardSpaces[8]))) {
                    placeOn = spaceInt;
                }
                break;
            case 7:
                if ((boardSpaces[1].equals(boardSpaces[4])) || (boardSpaces[6].equals(boardSpaces[8]))) {
                    placeOn = spaceInt;
                }
                break;
            case 8:
                if ((boardSpaces[0].equals(boardSpaces[4])) || (boardSpaces[3].equals(boardSpaces[6])) || (boardSpaces[6].equals(boardSpaces[7]))) {
                    placeOn = spaceInt;
                }
                break;
            default:
                placeOn = -1;
                break;
        }

        return placeOn;
    }
}