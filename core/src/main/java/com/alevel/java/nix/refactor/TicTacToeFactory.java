package com.alevel.java.nix.refactor;

public class TicTacToeFactory {
    public TicTacToeInterface create(int size) {
        switch (size) {
            case 3:
                return new TicTacToe3x3();
            case 4:
                return new TicTacToe(4);
            case 5:
                return new TicTacToe(5);
            default:
                return null;
        }

    }
}
