package com.alevel.java.nix.refactor;

import java.util.Scanner;

public class TicTacToe3x3 implements TicTacToeInterface {
    Scanner scan = new Scanner(System.in);
    int size = 3;
    char curr;
    public Character[][] grid = new Character[size][size];

    public void fill() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '_';
            }
        }
    }

    @Override
    public TicTacToeInterface game() {
        fill();
        for (int n = 0; n < size; n++) {
            int a = n % 2;
            if (stepFor(a) == false) {
                printGrid();
                break;
            }
            printGrid();
            if (n == size * size - 1) {
                System.out.println("Game Over");
            }
        }
        return null;
    }

    @Override
    public boolean stepFor(int a) {
        System.out.println("Enter position: ");
        int i = scan.nextInt();
        int j = scan.nextInt();
        while (!(grid.length > i && i >= 0) || !(grid[j].length > j && j >= 0) || grid[i][j] == 'X' || grid[i][j] == '0') {
            System.out.println("Enter i position for x: ");
            i = scan.nextInt();
            System.out.println("Enter j position for x: ");
            j = scan.nextInt();
        }

        if (a == 0) {
            //  log.info("First player");
            grid[i][j] = 'X';
        } else {
            // log.info("Second player");
            grid[i][j] = '0';
        }
        curr = grid[i][j];
        return getResult(i, j);

    }

    @Override
    public boolean getResult(int i, int j) {
        if (winByRow(i) ||
                winByCol(j) ||
                winByDiagonal() ||
                winByReverseDiagonal()) {
            System.out.println("Current is win! " + curr);
            return false;
        } else return true;
    }

    @Override
    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) {
                    System.out.print(" " + " | ");
                } else
                    System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
        }
    }
    private boolean winByRow(int row) {
        for (int col = 0; col < size; col++) {
            if (curr != grid[row][col]) return false;
        }
        return true;
    }

    private boolean winByCol(int col) {
        for (int row = 0; row < size; row++) {
            if (curr != grid[row][col]) return false;
        }
        return true;
    }

    private boolean winByDiagonal() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (curr != grid[i][i])
                return false;
        }
        return true;

    }

    private boolean winByReverseDiagonal() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (curr != grid[i][size - i - 1])
                return false;
        }
        return true;
    }
}
