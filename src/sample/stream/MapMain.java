package sample.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wangxl@ushareit.com  2020/12/30 11:33
 */
public class MapMain {

    public static void main(String[] args) {

        List<User> user = new ArrayList<>();
        user.add(new User("zhangsan"));
        user.add(new User("lisi"));
        user.add(new User("wangwu"));



    }


    /**
     * @param users 用户集合
     * @return 用户名字集合
     */
    public List<String> mapOfStream(List<User> users){
        List<String> usersNames = users.stream().map(User::getName).collect(Collectors.toList());
        // 另一种写法
        Function<User, String> function = (user) -> user.getName();
        List<String> usersNames2 = users.stream().map(function).collect(Collectors.toList());
        //return usersNames2;

        // 获取每个用户的名字的长度
        // 写法一
        List<Integer> userNameLength = users.stream()
                .map(User::getName)// 获取用户名
                .map(String::length) // 获取每个用户名的长度
                .collect(Collectors.toList()); // 返回一个集合
        // 写法二
        Function<User, String> name = user -> user.getName();
        Function<String, Integer> len = s -> s.length();
        List<Integer> userNameLength2 = users.stream().map(name).map(len).collect(Collectors.toList());
        // 写法三
        List<Integer> userNameLength3 = users.stream().map(s -> s.getName()).map(s -> s.length()).collect(Collectors.toList());
        return usersNames;
    }

}

class User {
    public User(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
