package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/4.
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 注意你不能在买入股票前卖出股票。

 示例 1:
 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

 示例 2:
 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _121best_time_to_buy_and_sell_stock {
    /**
     * 方法1.自己的暴力解法
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length;i++){
            int curProfit=0;
            for(int j=i+1;j<prices.length;j++){
                if((prices[j]-prices[i])>curProfit){
                    curProfit=prices[j]-prices[i];
                }
            }
            if(curProfit>max) max=curProfit;
        }
        return max;
    }

    //一次遍历

    /**
     * 2.方法二一次遍历
     * 参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode/
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {

        //思路整理
        //1.最小值和最大利润：
        //2.目标找到当前最小值，和其对应的最大利润。
        //   （1）理解为一个向上的拐点：minprice解释为向上的拐点更合适，容易理解

        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for (int i=0;i<prices.length;i++){
            //(1)如果后面有小于minprice的，则把这个值赋给minprice。
            //形象化理解：找到最小点
            if(prices[i]<minprice){
                minprice=prices[i];
            }else if(prices[i]-minprice>maxprofit){
                //(2)如果后面，减去最小值，大于之前的利润，就是这个
                //形象化理解：找到这个最小点之后的最大利润
                maxprofit=prices[i]-minprice;
            }
            //依次循环
        }
        return maxprofit;


    }
}
