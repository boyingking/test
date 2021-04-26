package sample.exam;

import java.util.Optional;

/**
 * @author wangxl@ushareit.com  2021/4/13 11:20
 */
public class OptionalExam {

    public static void main(String[] args) {
        Optional emptyOptional = Optional.ofNullable(Optional.empty())
                .filter(param -> param.get() != "aa");
    }
}
