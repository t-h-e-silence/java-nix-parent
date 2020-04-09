import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2 {
    public  String unique(Collection<String> list) {
        if(list.isEmpty()){
            return null;
        }
        String unique=null;
        Map<String, Long> stringCountMap = list.stream().
                collect(Collectors.groupingBy(s -> s, HashMap::new, Collectors.counting()));
        for (String s : stringCountMap.keySet()) {
            if (stringCountMap.get(s) == 1) {
                return unique= s; }
        }
        return unique;
    }

}
