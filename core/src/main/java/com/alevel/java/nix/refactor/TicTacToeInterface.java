package com.alevel.java.nix.refactor;

public interface TicTacToeInterface {
    void fill();
    TicTacToeInterface game();
    boolean stepFor(int a);
    boolean getResult(int row, int coll);
    void printGrid();
}
