package com.alevel.java.nix.refactor;

public class Main {
    public static void main(String[] args) {

        TicTacToeFactory factory=new TicTacToeFactory();
        TicTacToeInterface t=factory.create(5).game();
    }
}
