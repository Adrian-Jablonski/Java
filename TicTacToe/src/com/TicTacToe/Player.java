package com.TicTacToe;

import java.util.Scanner;

public class Player {
    private char xOrO;
    private boolean human;
    private String name;
    private int playerInput;

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

    public void playerMove(Board board) {
        System.out.println("TURN # " +board.getTurn());
        if (this.human) {

            userMoveInput(board);
            int spot = this.playerInput;
            board.setBoard(spot, this.xOrO);
        }

        board.getBoard();
        board.checkForWinner(this.name);

        if (board.getTurn() >= 9 && !board.getGameOver()) {
            System.out.println("DRAW");
            board.setGameOver(true);
        }
    }

    // Prevent user from entering invalid number
    private void userMoveInput(Board board) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter number to place " + this.xOrO + " :");
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
}
