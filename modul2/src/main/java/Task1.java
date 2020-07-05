import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Task1 {

    private Date toDate(String s) {
        List<String> knownPatterns = new ArrayList<String>();
        knownPatterns.add(new String("yyyy/MM/dd"));
        knownPatterns.add(new String("yyyy-MM-dd"));
        knownPatterns.add(new String("dd-MM-yyyy"));
        knownPatterns.add(new String("dd/MM/yyyy"));
        for (String pattern : knownPatterns) {
            try {
                SimpleDateFormat format = new SimpleDateFormat(pattern);
                format.setLenient(false);
                return format.parse(s);
            } catch (ParseException pe) {
            }
        }
        return null;
    }

    public List<String> formatString(Collection<String> list) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        List<String> formattedStr = new ArrayList<>();
        for (String s : list) {
            Date date = toDate(s);
            formattedStr.add(format.format(date));
        }
        return formattedStr;
    }

}
