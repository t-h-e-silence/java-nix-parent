import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public List<String> listOfData(Collection<String> list) {
        if(list.isEmpty()){
            return null;
        }
        return list.stream().filter(s1 -> s1.matches("[0-9]{4}[0-1][0-9][0-3][0-9]")).collect(Collectors.toList());
    }


        public static void main(String[] args) throws ParseException {
        Task1 t=new Task1();
        ArrayList list = new ArrayList<String>();
        list.add("2020/04/02");
            list.add("20200402");
        list.add("02042020");
        list.add("02/04/2020");
        list.add("02-04-2020");
            System.out.println( t.listOfData(list));
    }
}
