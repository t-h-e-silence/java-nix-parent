package level3;

public class LiveGame {
    int rows;
    int colls;
    int[][] arr;

    LiveGame(int[][] arr) {
        this.arr = arr;
        rows = this.arr.length;
        colls = this.arr[0].length;
    }

    LiveGame() {
        this.arr = new int[][]{{0, 1, 0, 0, 1}, {1, 0, 1, 0, 0}, {0, 1, 1, 0, 0}, {1, 0, 0, 1, 1}, {1, 0, 0, 1, 0}};
        rows = this.arr.length;
        colls = this.arr[0].length;
    }


    public int[][] nextState() {
        int[][] newarr = new int[rows + 2][colls + 2];

        int rowLength = Math.min(rows, arr.length);
        for (int n = 0; n < rowLength; n++) {
            int[] row = arr[n];
            if (row == null) continue;
            int columnLenght = Math.min(colls, row.length);
            System.arraycopy(row, 0, newarr[n + 1], 1, columnLenght);
        }
        for (int i = 1; i < newarr.length - 1; i++) {
            for (int j = 1; j < newarr[i].length - 1; j++) {
                int alive = 0;
                if (newarr[i][j + 1] != 0) {
                    alive++;
                }
                if (newarr[i][j - 1] != 0) {
                    alive++;
                }
                if (newarr[i + 1][j] != 0) {
                    alive++;
                }
                if (newarr[i - 1][j] != 0) {
                    alive++;
                }
                if (newarr[i + 1][j + 1] != 0) {
                    alive++;
                }
                if (newarr[i - 1][j - 1] != 0) {
                    alive++;
                }
                if (newarr[i - 1][j + 1] != 0) {
                    alive++;
                }
                if (newarr[i + 1][j - 1] != 0) {
                    alive++;
                }
                if (newarr[i][j] == 1) {
                    if (alive < 2 || alive > 3)
                        arr[i - 1][j - 1] = 0;//die
                }
                if (newarr[i][j] == 0 && alive == 3) {
                    arr[i - 1][j - 1] = 1;
                }
            }
        }
        return arr;
    }
}
