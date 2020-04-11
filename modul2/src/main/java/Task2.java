import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public  String unique(Collection<String> list) {
        if(list.isEmpty()){
            return null;
        }
        String unique=null;
        Map<String, Long> stringCountMap = list.stream().
                collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
        for (Map.Entry<String, Long> s : stringCountMap.entrySet()) {
            if (s.getValue()== 1) {
                return unique= s.getKey(); }
        }
        return unique;
    }

}

