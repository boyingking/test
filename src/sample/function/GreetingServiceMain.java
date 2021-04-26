package sample.function;

import java.util.function.Consumer;

/**
 * @author wangxl@ushareit.com  2020/12/24 20:04
 */
public class GreetingServiceMain {

    public static void main(String[] args) {
        GreetingService service = msg-> System.out.println(msg + " world");
        service.sayMsg("hello");

        GreetingService innerService = new GreetingService<String>() {  //此写法与上面的lamda写法一样的含义
            @Override
            public void sayMsg(String message) {
                System.out.println(message + "hahahaha");
            }
        };
        innerService.sayMsg("i say");


        //Consumer/Function/SupplierMain/Predicate  这几个 仅仅是“系统预定义好的函数”，没有什么特殊之处
        Consumer<String> consumer = msg -> System.out.println(msg + "consumer");
        consumer.accept(" this is a ");
    }
}
