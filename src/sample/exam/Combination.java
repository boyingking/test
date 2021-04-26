package sample.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 说明：这个解题思路是从网上找的，代码是自己写的
 *
 * @author wangxl@ushareit.com  2021/4/8 20:09
 */
public class Combination {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<List<Integer>> combination = combination(arr, 3, 10);
        for (List<Integer> list : combination) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private static List<List<Integer>> combination(int[] arr, int n, int m) {
        List<List<Integer>> res = new ArrayList<>();

        //先穷举所有元素（对应下标）相加的情况
        for (int i = 0; i < Math.pow(2, arr.length); i++) {

            //相加个数为n
            if (numbersOfOne(i) == n) {
                int s = 0;
                List<Integer> temp = new ArrayList<>();
                //计算n个数的和
                for (int j = 0; j < arr.length; j++) {
                    //当前位是不是1
                    if ((i & 1 << (arr.length - 1 - j)) != 0) {
                        s += arr[j];
                        temp.add(arr[j]);
                    }
                }
                //如果和为n
                if (s == m) {
                    res.add(temp);
                }
            }
        }
        return res;
    }

    //求n转为二进制中1的个数
    public static int numbersOfOne(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

}
