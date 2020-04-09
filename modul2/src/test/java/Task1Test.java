import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @org.junit.jupiter.api.Test
    void listOfData() {
        Task1 t=new Task1();
        ArrayList list = new ArrayList<String>();
        list.add("2020/04/02");
        list.add("20200402");
        list.add("02042020");
        list.add("02/04/2020");
        list.add("02-04-2020");
        ArrayList exp=new ArrayList<String>();
        exp.add("20200402");
        assertEquals(exp, t.listOfData(list));

    }

}