package level3;

import level3.LiveGame;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LiveGameTest {

    @Test
    void nextState() {

        int[][] arr = {{0, 1, 0, 0, 1}, {1, 0, 1, 0, 0}, {0, 1, 1, 0, 0}, {1, 0, 0, 1, 1}, {1, 0, 0, 1, 0}};
        int[][] exparr = {{0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {1, 0, 1, 0, 0}, {1, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        String expstr = Arrays.deepToString(exparr);
        LiveGame l = new LiveGame(arr);
        int[][] newarr = l.nextState();
        String newstr = Arrays.deepToString(newarr);
        assertEquals(expstr, newstr);
    }
}