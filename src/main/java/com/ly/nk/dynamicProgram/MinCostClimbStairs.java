package com.ly.nk.dynamicProgram;

/**
 *  BM64 最小花费爬楼梯
 *
 *  描述：
 *  给定一个整数数组cost，其中cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用，下标从0开始。一旦你支付此费用，
 *  即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 *  输入：[2,5,20]
 *  返回值：5
 *  说明：你将从下标为1的台阶开始，支付5 ，向上爬两个台阶，到达楼梯顶部。总花费为5
 *
 *  输入：[1,100,1,1,1,90,1,1,80,1]
 *  返回值：6
 *  说明：你将从下标为 0 的台阶开始。
 *  1.支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 *  2.支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 *  3.支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 *  4.支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 *  5.支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 *  6.支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 *
 */
public class MinCostClimbStairs {

    /**
     * 方法1：动态规划
     *
     * 知识点：
     * 动态规划基本思想：将待求解的问题分解成若干个相互联系的子问题，先求解子问题，然后从子问题的解得到原问题的解；
     * 对于重复出现的子问题，只在第一次进行求解，并把答案保存起来，然后再次遇到时则直接引用答案，不比重新求解。
     *
     * 思路：
     *
     * 步骤：
     *  1：可以用一个数组记录每次爬到第i阶楼梯的最小花费，然后每增加一级台阶就转移一次状态，最终得到结果。
     *  2：（初始状态） 因为可以直接从第0级或是第1级台阶开始，因此这两级的花费都直接为0.
     *  3：（状态转移） 每次到一个台阶，只有两种情况，要么是它前一级台阶向上一步，要么是它前两级的台阶向上两步，
     * 因为在前面的台阶花费我们都得到了，因此每次更新最小值即可，
     * 转移方程为：dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为给定的数组长度，遍历一次数组
     * 空间复杂度：O(n)，辅助数组dp的空间
     *
     *
     * @param cost int整型一维数组
     * @return int整型
     */
    public int minCostClimbingStairs (int[] cost) {

        int len = cost.length;
        //dp[i]表示爬到第i阶楼梯需要的最小花费
        int[] dp = new int[len + 1];

        // 初始值为0
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= len; i++) {
            //每次选取最小的方案
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];

    }

    public static void main(String[] args) {
        MinCostClimbStairs climbStairs = new MinCostClimbStairs();
        int[] cost1 = {10, 15, 20};
        System.out.println(climbStairs.minCostClimbingStairs(cost1)); // 预期输出：15

        int[] cost2 = {1, 100, 1, 1, 1, 100,1, 1, 100, 1};
        System.out.println(climbStairs.minCostClimbingStairs(cost2)); // 预期输出：6
    }

}
