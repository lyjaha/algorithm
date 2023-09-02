package com.ly.nk.dynamicProgram;

import java.util.Arrays;

/**
 * BM82 买卖股票的最好时机(三)
 *
 *  描述：
 *  假设你有一个数组prices，长度为n，其中prices[i]是某只股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
 *  1. 你最多可以对该股票有两笔交易操作，一笔交易代表着一次买入与一次卖出，但是再次购买前必须卖出之前的股票
 *  2. 如果不能获取收益，请返回0
 *  3. 假设买入卖出均无手续费
 *
 *  要求: 空间复杂度 O(n)，时间复杂度 O(n)
 *  进阶：空间复杂度 O(1)，时间复杂度 O(n)
 *
 *  [8,9,3,5,1,3]
 *  4
 *  第三天(股票价格=3)买进，第四天(股票价格=5)卖出，收益为2
 *  第五天(股票价格=1)买进，第六天(股票价格=3)卖出，收益为2
 *  总收益为4。
 *
 *  [9,8,4,1]
 *  0
 *
 *  [1,2,8,3,8]
 *  12
 *  第一笔股票交易在第一天买进，第三天卖出；第二笔股票交易在第四天买进，第五天卖出；总收益为12。
 * 因最多只可以同时持有一只股票，所以不能在第一天进行第一笔股票交易的买进操作，又在第二天进行第二笔股票交易的买进操作
 * （此时第一笔股票交易还没卖出），最后两笔股票交易同时在第三天卖出，也即以上操作不满足题目要求。
 */
public class BuyAndSellStock3 {

    /**
     * 方法1：动态规划
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为数组长度，只遍历一次数组
     * 空间复杂度：O(n)，动态规划二维辅助相当于5个一维数组
     *
     * 两次交易所能获得的最大收益
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public static int maxProfit (int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int n = prices.length;

        int[][] dp = new int[n][5];
        //初始化dp为最小
        Arrays.fill(dp[0], -10000);
        //第0天不持有状态
        dp[0][0] = 0;
        //第0天持有股票
        dp[0][1] = -prices[0];
        //状态转移
        for(int i = 1; i < n; i++){
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        //选取最大值，可以只操作一次
        return Math.max(dp[n - 1][2],Math.max(0, dp[n - 1][4]));
    }

    /**
     * 方法2：
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为数组长度，只遍历一次数组
     * 空间复杂度：O(1)，
     *
     * 两次交易所能获得的最大收益
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public static int maxProfit2 (int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int dp0 = 0, dp1 = -prices[0], dp2 = 0, dp3 = -prices[0], dp4 =0, tmp;
        for (int i = 1; i < prices.length; i++) {
            tmp = dp0;
            dp0 = tmp;
            dp1 = Math.max(dp1, tmp - prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i]);
            dp3 = Math.max(dp3, dp2 - prices[i]);
            dp4 = Math.max(dp4, dp3 + prices[i]);
        }
        return Math.max(dp2, Math.max(dp4, 0));
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4}; // 示例输入
        int maxProfit = maxProfit(prices);
        int maxProfit2 = maxProfit2(prices);
        System.out.println("Max: " + maxProfit);
        System.out.println("Max2: " + maxProfit2);
    }
}
