package sample.function;

import java.util.function.Function;

/**
 * @author wangxl@ushareit.com  2020/12/25 17:41
 */
public class FunctionMain {

    public static void main(String[] args) {

        Function<Integer,Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 423;
            }
        };

        System.out.println(function.apply(100));


        Function<Integer,Integer> function1 = x -> x+ 100;

        System.out.println(function1.apply(1232));


    }
}
