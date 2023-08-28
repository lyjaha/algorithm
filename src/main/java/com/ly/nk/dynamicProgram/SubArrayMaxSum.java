package com.ly.nk.dynamicProgram;

/**
 *  BM72 连续子数组的最大和
 *
 *  描述：
 *  输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
 *
 *  数据范围:
 *  1<=n<=2×10的5次方
 *  −100<=a[i]<=100
 *
 *  要求:时间复杂度为O(n)，空间复杂度为O(n)
 *  进阶:时间复杂度为O(n)，空间复杂度为O(1)
 *
 *  [1,-2,3,10,-4,7,2,-5]
 *  18
 *  经分析可知，输入数组的子数组[3,10,-4,7,2]可以求得最大和为18
 *
 *  [2]
 *  2
 *
 *  [-10]
 *  -10
 *
 */
public class SubArrayMaxSum {

    /**
     * 方法1：动态规划
     *
     * 知识点：
     *
     * 思路：
     *
     * dp[i] = max(dp[i-1] + nums[i], nums[i])
     *
     * 步骤：
     *  1：可以用dp数组表示以下标 i 为终点的最大连续子数组和。
     *  2：遍历数组，每次遇到一个新的数组元素，连续的子数组要么加上变得更大，要么这个元素本身就更大，要么会更小，更小我们就舍弃，
     *  因此状态转移为 dp[i] = max(dp[i−1] + nums[i], nums[i])。
     *  3：因为连续数组可能会断掉，每一段只能得到该段最大值，因此我们需要维护一个最大值。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为数组长度，遍历一次数组
     * 空间复杂度：O(n)，动态规划辅助数组长度为 n
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public static int findGreatestSumOfSubArray (int[] nums) {

        if (nums == null || nums.length == 0) { // 特殊情况判断
            return 0;
        }

        //记录到下标i为止的最大连续子数组和
        int n = nums.length;
        int[] dp = new int[n];
        // 初始化dp数组的第一个素
        dp[0] = nums[0];

        // 初始化结果为数组的第一个元素
        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            //状态转移：连续子数组和最大值
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;

    }

    /**
     * 方法2：动态规划空间优化
     *
     * 知识点：动态规划 + 贪心法
     *
     * 思路：
     *
     * dp[i] = max(dp[i-1] + nums[i], nums[i])
     *
     * 步骤：
     *  1：我们可以使用两个变量迭代来代替数组。
     *  2：状态转移的时候更新变量y，该轮循环结束的再更新x为y即可做到每次迭代都是上一轮的dp。
     *  3：遍历数组，每次只要比较取最大值即可。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为数组长度，遍历一次数组
     * 空间复杂度：O(1)，常数级变量，无额外辅助空间
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public static int findGreatestSumOfSubArray2 (int[] nums) {

        if (nums == null || nums.length == 0) { // 特殊情况判断
            return 0;
        }

        // 初始化结果为数组的第一个元素
        int res = nums[0];
        // 初始化当前子序列和为数组的第一个元素
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            //状态转移：连续子数组和最大值,计算当前子序列的和
            sum  = Math.max(sum  + nums[i], nums[i]);
            //维护最大值
            res = Math.max(res, sum);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = findGreatestSumOfSubArray(nums);
//        int ans = findGreatestSumOfSubArray2(nums);
        System.out.println(ans); // 输出6

    }
}
