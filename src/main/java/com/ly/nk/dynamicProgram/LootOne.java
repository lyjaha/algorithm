package com.ly.nk.dynamicProgram;

/**
 *  BM78 打家劫舍(一)
 *
 *  描述：
 *  你是一个经验丰富的小偷，准备偷沿街的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，
 *  即，如果偷了第一家，就不能再偷第二家；如果偷了第二家，那么就不能偷第一家和第三家。
 * 给定一个整数数组nums，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
 *
 * 数据范围：数组长度满足 1 ≤ n ≤ 2×10的5次方，数组中每个值满足 1≤num[i]≤5000
 *
 *  [1,2,3,4]
 *  6
 * 最优方案是偷第 2，4 个房间
 *
 * [1,3,6]
 * 7
 *
 * [2,10,5]
 * 10
 *
 */
public class LootOne {

    /**
     * 方法1：动态规划
     *
     * 知识点：动态规划
     *
     * 思路：
     * 本题本质是求一个最大的不相邻子序列和。
     * 定义一个数组 dp，其中 dp[i] 表示前 i 个房间在不触动警报的情况下的最大收益。因此，根据最后一家的情况，有两种情况：
     *
     * 最后一家被偷，即 dp[i] = dp[i-2] + nums[i];
     * 最后一家不偷，即 dp[i] = dp[i-1]。因为比如说 dp[i-1] 包含了前 i-1 个房间所有不包含第 i 间房的方案。
     * 最后，我们返回 dp[nums.length-1] 即可。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为数组长度，遍历一次数组
     * 空间复杂度：O(n)，动态规划辅助数组的空间
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public static int loot (int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        //dp[i]表示长度为i的数组，最多能偷取多少钱
        int[] dp = new int[n];
//        dp[1] = nums[0];
//        for (int i = 2; i <= n; i++) {
//            //对于每家可以选择偷或者不偷
//            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
//        }
//        return dp[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int res = loot(nums);
        System.out.println(res); // output: 4
    }
}
