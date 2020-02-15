package level1;

public class Horse {
    Horse() {
    }

    public boolean oneStep(int nowRow, int nowColl, int wR, int wC) {
        boolean s = false;
        if (wR == nowRow - 2 || wR == nowRow + 2) {
            if (wC == nowColl + 1 || wC == nowColl - 1) {
                s = true;
            } else {
                s = false;
            }
        } else {
            s = false;
        }
        return s;
    }
}