import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @org.junit.jupiter.api.Test
    void listOfData() throws ParseException {
        Task1 t=new Task1();
        ArrayList list = new ArrayList<String>();
        list.add("2020/04/02");
        list.add("02/04/2020");
        list.add("02-04-2020");
        list.add("28-12-1999");

        ArrayList newList = new ArrayList<String>();
        newList.add("20200402");
        newList.add("20200402");
        newList.add("20200402");
        newList.add("19991228");

        assertEquals(newList.toString(), t.formatString(list).toString());
    }

}