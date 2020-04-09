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
        return list.stream()
                .filter(s1 -> s1.matches("[0-9]{4}[0-1][0-9][0-3][0-9]"))
                .collect(Collectors.toList());

    }
}
