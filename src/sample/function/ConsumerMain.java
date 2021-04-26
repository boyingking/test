package sample.function;

import java.util.function.Consumer;

/**
 * @author wangxl@ushareit.com  2020/12/25 17:14
 */
public class ConsumerMain {

    public static void main(String[] args) {

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("consumer  " + s );
            }
        };

        consumer.accept("wangxl");


        Consumer<String> consumer1 = s -> System.out.println("lamda " + s);
        consumer.accept("rst server");


        //封装到其他方法中
        modify(51,x-> System.out.println(x - 22));

        modify(552, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer - 23);
            }
        });

    }


    public static void modify(int num, Consumer<Integer> consumer) {
        consumer.accept(num);
    }
}
