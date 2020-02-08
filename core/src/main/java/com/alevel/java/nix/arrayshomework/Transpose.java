package com.alevel.java.nix.arrayshomework;

import java.util.Arrays;

public class Transpose {

    int[][] matrix;

    Transpose(int[][] matrix) {
        this.matrix = matrix;
    }

    Transpose() {
        this.matrix = new int[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}};
    }


    private void rectang(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        System.out.print(Arrays.deepToString(newMatrix));

    }


    public void toTranspose() {
        if (matrix.length != matrix[0].length) {
            rectang(matrix);
        } else {
            square(matrix);
        }
    }

    public void square(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.print((Arrays.deepToString(matrix)));

    }

}
