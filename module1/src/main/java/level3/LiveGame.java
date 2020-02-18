package level3;

public class LiveGame {
    int rows;
    int colls;
    boolean[][] arr;

    LiveGame(boolean[][] arr) {
        this.arr = arr;
        rows = this.arr.length;
        colls = this.arr[0].length;
    }

    LiveGame() {
        this.arr = new boolean[][]{{false, true, false, false, true}, {true, false, true, false, false},
                {false, true, true, false, false}, {true, false,false,true,true},{true, false,false,true,false}};
        rows = this.arr.length;
        colls = this.arr[0].length;
    }


    public boolean[][] nextState() {
        boolean[][] newarr = new boolean[rows + 2][colls + 2];

        int rowLength = Math.min(rows, arr.length);
        for (int n = 0; n < rowLength; n++) {
            boolean[] row = arr[n];
            if (row == null) continue;
            int columnLenght = Math.min(colls, row.length);
            System.arraycopy(row, 0, newarr[n + 1], 1, columnLenght);
        }
        for (int i = 1; i < newarr.length - 1; i++) {
            for (int j = 1; j < newarr[i].length - 1; j++) {
                int alive = 0;
                if (newarr[i][j + 1] != false) {
                    alive++;
                }
                if (newarr[i][j - 1] != false) {
                    alive++;
                }
                if (newarr[i + 1][j] != false) {
                    alive++;
                }
                if (newarr[i - 1][j] != false) {
                    alive++;
                }
                if (newarr[i + 1][j + 1] != false) {
                    alive++;
                }
                if (newarr[i - 1][j - 1] != false) {
                    alive++;
                }
                if (newarr[i - 1][j + 1] != false) {
                    alive++;
                }
                if (newarr[i + 1][j - 1] != false) {
                    alive++;
                }
                if (newarr[i][j] == true) {
                    if (alive < 2 || alive > 3)
                        arr[i - 1][j - 1] = false;//die
                }
                if (newarr[i][j] == false && alive == 3) {
                    arr[i - 1][j - 1] = true;
                }
            }
        }
        return arr;
    }
}
