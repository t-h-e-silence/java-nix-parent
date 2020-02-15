package level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    void oneStep() {
        Horse h = new Horse();
        boolean state;
        state = h.oneStep(4, 7, 2, 6);
        assertEquals(true, state);
        state = h.oneStep(4, 5, 6, 6);
        assertEquals(true, state);
        state = h.oneStep(4, 5, 6, 7);
        assertEquals(false, state);
    }
}