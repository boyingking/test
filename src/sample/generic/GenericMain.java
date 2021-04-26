package sample.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author wangxl@ushareit.com  2020/12/24 20:48
 */
public class GenericMain {

    public static void main(String[] args) {

    }

    public static <T, R> List<R> forEach(List<T> ts, Function<T, R> func) {

        return new ArrayList<>();
    }
}
