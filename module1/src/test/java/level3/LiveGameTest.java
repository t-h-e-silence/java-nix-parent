package level3;

import level3.LiveGame;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LiveGameTest {

    @Test
    void nextState() {

        boolean[][] arr ={{false, true, false, false, true}, {true, false, true, false, false},
                {false, true, true, false, false}, {true, false,false,true,true},{true, false,false,true,false}};
        boolean[][] exparr = {{false, true, false, false, false}, {true, false, true,true, false},
                {true, false, true, false, false}, {true, false, false, true,true}, {false, false, false, true,true}};
        String expstr = Arrays.deepToString(exparr);
        LiveGame l = new LiveGame(arr);
        boolean[][] newarr = l.nextState();
        String newstr = Arrays.deepToString(newarr);
        assertEquals(expstr, newstr);
    }
}