package sample.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangxl@ushareit.com  2020/12/28 20:28
 */
public class FilterMain {
    public static void main(String[] args) {
        List<Person> persionList = new ArrayList<Person>();
        persionList.add(new Person(1, "张三", "男", 8));
        persionList.add(new Person(2, "小小", "女", 2));
        persionList.add(new Person(3, "李四", "男", 25));
        persionList.add(new Person(4, "王五", "女", 8));
        persionList.add(new Person(5, "赵六", "女", 25));
        persionList.add(new Person(6, "大大", "男", 65));

        //1、查找年龄大于20岁的人数
        long age = persionList.stream().filter(p -> p.getAge() > 20).count();
        System.out.println(age);

        //2、查找年龄大于20岁，性别为男的人数
        List<Person> ageList = persionList.stream().filter(p -> p.getAge() > 20).filter(p -> "男".equals(p.getSex())).collect(Collectors.toList());
        System.out.println(ageList.size());
    }
}
