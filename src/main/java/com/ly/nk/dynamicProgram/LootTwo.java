package com.ly.nk.dynamicProgram;

/**
 *  BM79 打家劫舍(二)
 *
 *  描述：
 *  你是一个经验丰富的小偷，准备偷沿湖的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，
 *  即，如果偷了第一家，就不能再偷第二家，如果偷了第二家，那么就不能偷第一家和第三家。沿湖的房间组成一个闭合的圆形，
 *  即第一个房间和最后一个房间视为相邻。
 *  给定一个长度为n的整数数组nums，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
 *  数据范围：数组长度满足 1 ≤ n ≤ 2×10的5次方，数组中每个值满足 1≤nums[i]≤5000
 *
 *  [1,2,3,4]
 *  6
 *
 *  [1,3,6]
 *  6
 *
 */
public class LootTwo {

    /**
     * 方法1：动态规划
     *
     * 知识点：动态规划
     *
     * 思路：
     * 由于首尾房间相邻，因此偷第一个房间时就不能偷最后一个房间，偷最后一个房间时就不能偷第一个房间。所以我们需要分别考虑两种情况：
     *
     * 偷第一个房间，不偷最后一个房间（即偷 1~n-1 个房间），此时最后一个房间不能被偷，因此最大金额为 dp1[nums.length-2]；
     * 偷最后一个房间，不偷第一个房间（即偷 2~n 个房间），此时第一个房间不能被偷，因此最大金额为 dp2[nums.length-1]；
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
        // 不偷最后一个房间，从第一个房间开始偷，最后一个房间不能被偷
        int[] dp1 = new int[n - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i-2] + nums[i], dp1[i-1]);
        }
        int max1 = dp1[n - 2];

        // 不偷第一个房间，从第二个房间开始偷，第一个房间不能被偷
        int[] dp2 = new int[n - 1];
        dp2[n - 2] = nums[n - 1];
        dp2[n - 3] = Math.max(nums[n - 2], nums[n - 1]);
        for (int i = n - 4; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i+2] + nums[i+1], dp2[i+1]);
        }
        int max2 = dp2[0];
        // 返回 dp1 和 dp2 中的较大值
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        int res = loot(nums);
        System.out.println(res); // output: 3
    }
}
