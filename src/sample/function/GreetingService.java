package sample.function;

/**
 * @author wangxl@ushareit.com  2020/12/24 17:53
 */
@FunctionalInterface
public interface GreetingService<T> {
    void sayMsg(T message);
}
