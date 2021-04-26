package sample.stream;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangxl@ushareit.com  2020/12/29 11:48
 */
public class IfAbsentMain {

    public Map<String, Object> map1 = new HashMap();

    public Map<String, AtomicInteger> map2 = new HashMap();

    public Map<String, List<String>> map3 = new HashMap();

    List<String> list = Arrays.asList("1", "2", "3", "2", "3", "2");

    /**
     * 1、业务逻辑：如果key的value值为null，则在map中放入该key和设置相应的value值
     */
    public void map1() {

        // java8之前，从map中根据key获取value操作可能会有下面的操作
        Object key = map1.get("key");
        if (key == null) {
            key = new Object();
            map1.put("key", key);
        } else {
            //如果key对应的value值存在，进行相应的操作
        }

        // java8之后，上面的操作可以简化为一行，若key对应的value为空，会将第二个参数的返回值存入并返回
        Object key2 = map1.computeIfAbsent("key1", k -> new Object());
        System.out.println(map1);
        //输出：{key1=java.lang.Object@708f5957, key=java.lang.Object@68999068}
    }


    /**
     * 2、统计List出现相同字符串的个数
     */
    public void map2() {

        //这里虽然只有一行代码但信息量很大，首先它采用量java的新特性lambda表达式来遍历list集合
        //这里表示如果map中的key对应的value值为null，则该key对应value值为new AtomicInteger()并执行自增加1，如果key已经存在，则直接value值自增1
        list.forEach(str -> map2.computeIfAbsent(str, k -> new AtomicInteger()).incrementAndGet());
        System.out.println(map2);
        //输出：{1=1, 2=3, 3=2}

    }

    /**
     * 3、如果key对应的value不存在，则创建新List并放入数据，存在则往直接往list放入数据
     */
    public void map3() {

        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("apple");
        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("orange");
        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("pear");
        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("banana");
        map3.computeIfAbsent("lisi", k -> genValue(k)).add("water");

        System.out.println(map3);
        //输出结果：{lisi=[water], zhangsan=[apple, orange, pear, banana]}

    }

    static List<String> genValue(String str) {
        return new ArrayList<String>();
    }

    public static void main(String[] args) {
        IfAbsentMain main = new IfAbsentMain();
        System.out.println("=========map1==========");
        main.map1();
        System.out.println("=========map2==========");
        main.map2();
        System.out.println("=========map3==========");
        main.map3();
    }

}
