package sample.exam;

/**
 * @author wangxl@ushareit.com  2021/3/31 18:09
 */
public class MaxProfile {
    public static void main(String[] args) {

        MaxProfile maxProfile = new MaxProfile();
        int[] prices = {7,1,5,3,6,4};
        //int[] prices = {7,6,4,3,1};
        //System.out.println(maxProfile.maxProfit(prices));

        System.out.println(maxProfile.maxProfitTwo(prices));
    }


/*    输入: [7,1,5,3,6,4]
    输出: 5
    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。*/

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int amount = prices[j] - prices[i];
                    if (amount > max) { //如果新的差值大于旧的差值，则重新给max赋值
                        max = amount;
                    }
                    //else 不去处理
                }
                //else 不去处理
            }
        }
        return max;
    }

    //{7,1,5,3,6,4};
    public int maxProfitTwo(int [] prices) {
        int max = 0;
        int firstPointValue =prices[0];
        int secondPointValue =0;
        for (int i =0; i<prices.length-1; i++) {
            //firstPointValue = prices[i];
            secondPointValue = prices[i+1];
            if (secondPointValue < firstPointValue) {
                firstPointValue = secondPointValue;
                if (max < secondPointValue - firstPointValue) {
                    max = secondPointValue - firstPointValue;
                }
            }

        }
        return max; //////
    }

}
