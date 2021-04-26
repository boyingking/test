package sample.stream;

import java.util.*;

/**
 * @author wangxl@ushareit.com  2020/12/28 20:31
 */
public class SortMain {

    public static void main(String[] args) {
        String[] arr1 = {"abc", "a", "bc", "abcd"};
        Arrays.stream(arr1).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        System.out.println("++++++++");
        //输出：a、bc、abc、abcd


        /**
         * 倒序
         * reversed(),java8泛型推导的问题，所以如果comparing里面是非方法引用的lambda表达式就没办法直接使用reversed()
         * Comparator.reverseOrder():也是用于翻转顺序，用于比较对象（Stream里面的类型必须是可比较的）
         * Comparator. naturalOrder()：返回一个自然排序比较器，用于比较对象（Stream里面的类型必须是可比较的）
         */
        Arrays.stream(arr1).sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
        System.out.println("++++++++");
        //输出：abcd、abc、bc、a
        Arrays.stream(arr1).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("++++++++");
        //输出：bc、abcd、abc、a
        Arrays.stream(arr1).sorted(Comparator.naturalOrder()).forEach(System.out::println);
        System.out.println("++++++++");
        //输出：a、abc、abcd、bc




        List<Person> persionList = new ArrayList<Person>();
        persionList.add(new Person(1, "张三", "男", 8));
        persionList.add(new Person(2, "小小", "女", 2));
        persionList.add(new Person(3, "李四", "男", 25));
        persionList.add(new Person(4, "王五", "女", 8));
        persionList.add(new Person(5, "赵六", "女", 25));
        persionList.add(new Person(6, "大大", "男", 65));


        //1、找到年龄最小的岁数
        Collections.sort(persionList, (x, y) -> x.getAge().compareTo(y.getAge()));
        Integer age = persionList.get(0).getAge();
        System.out.println("年龄最小的有:" + age);
        //输出：年龄最小的有:2

        //2、找到年龄最小的姓名
        String name = persionList.stream()
                .sorted(Comparator.comparingInt(x -> x.getAge()))
                .findFirst()
                .get().getName();
        System.out.println("年龄最小的姓名:" + name);
        //输出：年龄最小的姓名:小小

    }
}
