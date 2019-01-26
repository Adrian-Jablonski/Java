package com.TicTacToe;

import java.util.Scanner;

public class Player {
    private char xOrO;
    private boolean human;
    private String name;

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
            Scanner in = new Scanner(System.in);
            System.out.print("Enter number to place " + this.xOrO + " :");
            int spot = in.nextInt() - 1;
            board.setBoard(spot, this.xOrO);
        }

        board.getBoard();
        board.checkForWinner(this.name);

        if (board.getTurn() >= 9) {
            board.setGameOver(true);
        }
    }
}
