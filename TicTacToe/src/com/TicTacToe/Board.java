package com.TicTacToe;

public class Board {
    private char[] board = new char[9];
    private boolean gameOver = false;
    private int turn = 0;

    public Board() {
        for (int i = 0; i < 9; i++) {
            board[i] = (char)(i + 1 + '0');
        }
    }

    public void getBoard() {
        System.out.println(
                "\n " + board[0] + " | " + board[1] + " | " + board[2] +
                "\n __ ___ __" +
                "\n " + board[3] + " | " + board[4] + " | " + board[5] +
                "\n __ ___ __" +
                "\n " + board[6] + " | " + board[7] + " | " + board[8] + "\n"
        );
    }

    public void setBoard(int spot, char piece) {
        this.board[spot] = piece;
    }

    public boolean getGameOver() {
        if (this.gameOver) {
            System.out.print("Game Over"); //TODO: Place this somewhere else to prevent it printing twice when first player wins
        }
        return this.gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getTurn() {
        return this.turn;
    }

    public void addTurn() {
        this.turn += 1;
    }

    public void assignXorO(Player player1, Player player2) {
        player1.setxOrO('X');
        player2.setxOrO('O');
        System.out.println(player1.getName() + " is " + player1.getXorO() + "\n" + player2.getName() +  " is " + player2.getXorO());
    }

    public void checkForWinner(String name) {
        boolean row1Win = this.checkIfEquals(board[0], board[1], board[2]);
        boolean row2Win = this.checkIfEquals(board[3], board[4], board[5]);
        boolean row3Win = this.checkIfEquals(board[6], board[7], board[8]);
        boolean col1Win = this.checkIfEquals(board[0], board[3], board[6]);
        boolean col2Win = this.checkIfEquals(board[1], board[4], board[7]);
        boolean col3Win = this.checkIfEquals(board[2], board[5], board[8]);
        boolean diag1Win = this.checkIfEquals(board[0], board[4], board[8]);
        boolean diag2Win = this.checkIfEquals(board[2], board[4], board[6]);

        if (row1Win || row2Win || row3Win || col1Win || col2Win || col3Win || diag1Win || diag2Win) {
            System.out.println(name + " WINS!");
            this.gameOver = true;
        }
    }

    public boolean checkIfEquals(char char1, char char2, char char3) {
        if (char1 == char2 && char2 == char3) {
            return true;
        }
        return false;
    }
}
