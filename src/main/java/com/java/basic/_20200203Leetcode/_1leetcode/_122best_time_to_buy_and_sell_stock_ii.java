package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/4.
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 示例 1:
 输入: [3,3,5,0,0,3,1,4]
 输出: 6
 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。

 示例 2:
 输入: [1,2,3,4,5]
 输出: 4
 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _122best_time_to_buy_and_sell_stock_ii {
     /**
     * 思路：
     * 【思路是对的，实现有问题】
     * 1.两个指针，一个前一个后，每个上升线段
     * 2.一个sum接收线段上升之和
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
//        int first=0,second=0;
        if (prices.length<=1){
            return 0;
        }
//错误原因：复杂解法，没有解决思路了
//        int mini=Integer.MAX_VALUE;
//        for (int i=0;i<prices.length;i++){
//            if(prices[i]<mini){
//                first=i;
//
//            }else if()
//        }
        int res=0;
        for (int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                res+=prices[i+1]-prices[i];
            }
        }
        return res;

    }

}
