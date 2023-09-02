package com.ly.nk.dynamicProgram;

/**
 *  BM80 买卖股票的最好时机(一)
 *
 *  描述：
 *  假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
 *  1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天
 *  2.如果不能获取到任何利润，请返回0
 *  3.假设买入卖出均无手续费
 *
 *  要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 *  [8,9,2,5,4,7,1]
 *  5
 *  在第3天(股票价格 = 2)的时候买入，在第6天(股票价格 = 7)的时候卖出，最大利润 = 7-2 = 5 ，不能选择在第2天买入，第3天卖出，这样就亏损7了；同时，你也不能在买入前卖出股票。
 *
 *  [2,4,1]
 *  2
 *
 *  [3,2,1]
 *  0
 */
public class BuyAndSellStock {

    /**
     * 方法1：动态规划
     *
     * 知识点：动态规划
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为数组长度，遍历一次数组
     * 空间复杂度：O(n)，动态规划辅助数组的空间
     *
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {

        int n = prices.length;
        // 定义一个维数组 dp，其中 dp[i][0] 表示第 i 天不持有股票的最大收益，
        // dp[i][1] 表示第 i 天持有股票的最大收益
        int[][] dp = new int[n][2];

        // 第一天不持有股票，收益为0
        dp[0][0] = 0;
        // 第一天持有股票，收益为买入股票的负值
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];
    }

    /**
     * 方法2：贪心
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit2 (int[] prices) {
        //TODO
        return 0;
    }

}
