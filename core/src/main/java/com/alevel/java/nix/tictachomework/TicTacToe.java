package com.alevel.java.nix.tictachomework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;


public class TicTacToe {

    public Character[][] grid = new Character[3][3];
    Scanner scan = new Scanner(System.in);
    public Logger log = LoggerFactory.getLogger(TicTacToe.class);


    private int result() {
        assert grid[2][0] != null;
        if ((grid[0][0] != null && grid[0][0].equals(grid[0][2]) && grid[0][0].equals(grid[0][1])) ||
                (grid[0][0] != null && grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2])) ||
                (grid[0][0] != null && grid[0][0].equals(grid[1][0]) && grid[0][0].equals(grid[2][0])) ||
                (grid[0][2] != null && grid[0][2].equals(grid[0][1]) && grid[0][2].equals(grid[2][0])) ||
                (grid[1][0] != null && grid[1][0].equals(grid[1][1]) && grid[1][0].equals(grid[1][2])) ||
                (grid[2][0] != null && grid[2][0].equals(grid[2][1]) && grid[2][0].equals(grid[2][2])) ||(grid[0][1] != null && grid[1][1].equals(grid[0][1]) && grid[1][1].equals(grid[1][2]))) {
            System.out.println("Winner! ");
            return 1;
        } else {
            System.out.println("Next player");
        }
        return 0;
    }

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

    private void stepFor(int a) {

        System.out.println("Enter position: ");
        int i = scan.nextInt();
        int j = scan.nextInt();
        while (!(grid.length > i && i >= 0) || !(grid[j].length > j && j >= 0) || grid[i][j] != null) {
            System.out.println("Enter i position for x: ");
            i = scan.nextInt();
            System.out.println("Enter j position for x: ");
            j = scan.nextInt();
        }
        if (a == 0) {
            log.info("First player");
            grid[i][j] = 'X';
        } else {
            log.info("Second player");
            grid[i][j] = '0';
        }
    }

    public void playGame() {

        log.info("Start of Game");
        for (int n = 0; n < 9; n++) {
            int a = n % 2;
            stepFor(a);
            printGrid();
            int res = result();
            if (res == 1) {
                if (a == 0) {
                    log.info("First player is winner");
                    System.out.println("First player - X -  won!");
                    log.info("Game over");
                } else {
                    log.info("Second player is winner");
                    System.out.println("Second player - 0 - won!");
                    log.info("Game over");
                }
                break;
            }
            if (n == 8) {
                log.info("No one win");
                System.out.println("Game Over");
                log.info("Game over");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.playGame();
    }
}
