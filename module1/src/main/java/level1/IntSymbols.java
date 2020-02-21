package level1;

import java.util.HashSet;

public class IntSymbols {
    int arr[];

    IntSymbols(int[] arr) {
        this.arr = arr;
    }

    IntSymbols() {
        this.arr = new int[]{1, 4, 5, 1, 1, 3};
    }

    public int lengthOfUniq() {
        if (arr == null)
            return 0;
        HashSet<Integer> uniq = new HashSet<Integer>();
        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (uniq.add(arr[i])) {
                curr++;
            }
        }
        return curr;
    }
}
