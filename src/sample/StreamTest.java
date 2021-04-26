package sample;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c", "d"};
        Arrays.stream(arr)
                .peek(System.out::println)
                .count();
        System.out.println("Hello World!");

        List<Integer> l = IntStream.range(1,100).limit(5)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(l);//[1, 2, 3, 4, 5]

        System.out.println("hi^^^^");


        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("a",180);
        map.put("b",141);
        map.put("c",198);
        map.put("d",84);

        map.entrySet().stream().map(entry -> entry.getValue()).sorted((x,y) -> y.compareTo(x)).forEach(i -> System.out.println(i));

        map.entrySet().stream().map(entry -> entry.getValue()).sorted((x,y) -> y.compareTo(x)).findFirst().orElse(1);

    }
}
