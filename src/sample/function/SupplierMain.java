package sample.function;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author wangxl@ushareit.com  2020/12/25 16:52
 */
public class SupplierMain {

    public static void main(String[] args) {

        int num1 = 100;
        int num2 = 200;

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return num1+ num2;
            }
        };

        System.out.println("supplier" + supplier.get());


        Supplier<Integer> supplier1 = ()->num1+num2;

        System.out.println("supplier1" + supplier1);





    }



}
