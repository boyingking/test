package sample.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxl@ushareit.com  2020/12/30 15:14
 */
public class SortInterviewMain {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 111);
        map.put("b", 235);
        map.put("c", 35);
        map.put("d", 68);
        map.put("e", 10);

        map.entrySet().stream().sorted(Comparator.comparing(entries -> entries.getValue(), Comparator.reverseOrder())).forEach(System.out::println);
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())).forEach(System.out::println);
    }

}
