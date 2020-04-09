import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void unique() {
        Task2 t = new Task2();
        ArrayList<String> list = new ArrayList<>();

        list.add("cat");
        list.add("dog");
        list.add("Tea");
        list.add("cat");
        list.add("dog");
        assertEquals("Tea", t.unique(list));
        ArrayList<String> l = new ArrayList<>();
        assertEquals(null, t.unique(l));
        list.add("Tea");
        assertEquals(null, t.unique(list));

    }
}