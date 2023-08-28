package com.ly.nk.dynamicProgram;

import java.util.Arrays;

/**
 *  BM71 最长上升子序列(一)
 *
 *  描述：
 *  给定一个长度为 n 的数组 arr，求它的最长严格上升子序列的长度。
 *  所谓子序列，指一个数组删掉一些数（也可以不删）之后，形成的新数组。例如 [1,5,3,7,3] 数组，其子序列有：[1,3,3]、[7] 等。
 *  但 [1,6]、[1,3,5] 则不是它的子序列。
 *  我们定义一个序列是 严格上升 的，当且仅当该序列不存在两个下标 i 和 j 满足i<j 且arri≥arrj。
 *
 * 数据范围：0≤n≤1000
 * 要求：时间复杂度O(n的2次方)， 空间复杂度O(n)
 *
 *  [6,3,1,5,2,3,7]
 *  4
 *  该数组最长上升子序列为 [1,2,3,7] ，长度为4
 *
 */
public class LongestAscentSub {

    /**
     * 方法1：动态规划
     *
     * 知识点：动态规划
     * 定义状态：首先要明确问题的状态，即的子问题是什么，要保存什么样的状态。
     *
     * 如果是一维问题，可以定义一个一维的状态数组dp，其中dp[i]表示第个位置的状态。
     * 如果是二维问题，可以定义一个二维的数组dp，其中dp[i][j]表示第i行第j列的状态。
     * 初始化状态：确定初始状态的值，即第一个子问题的解。
     *
     * 根据问题的具体要求，设置初始状态的值。
     * 确定状态转移方程：根据问题的具体要求，到子问题与原问题之间的关系，通过一个递推公式来表示状态之间的转移。
     *
     * 根据题目的要求，找到问题与原问题之间的关系，即dp[i]与dp[i-1]、dp[i-2]...等之间的关系。
     * 计算状态：根据状态转移方程，计算出所有子问题的解。
     *
     * 通过迭代或递归等方法，计算出所有的状态值。
     * 返回：确定问题的最优解。
     *
     * 根据最终的状态值得到的最优解。
     *
     * 思路：
     * 本题是求一个数组的最长严格上升子序列（即子序列中的每个数都前面的数大），采用动态规划求解。具体实现步骤如下：
     *
     * 定义状态：定义一个长度为 n 的 dp 数组，其中 dp[i] 表示以 arr[i] 结尾的最长严格上升子序列的长度。这里需要注意，
     * 因为必须包 arr[i]，因此 dp[i] 至少为 1。
     * 初始化状态：将 dp 数组的所有元素初始化为 1，即 dp[i] = 1。
     * 状态转移方程：在 i 之前的元素 j 中，如果存在一个元素 arr[j] 比 arr[i] 小，那么以 arr[i] 结尾的最长严格
     * 上升子序就可以在以 arr[j] 结尾的最长严格上升子序列基础上加上 arr[i] 而得到。因此，
     * 状态转移方程为：dp[i] = max{dp[j]} + 1 (其中 j < i 且 arr[j] < arr[i])
     * 计算状态：通过迭代计算所有 dp 值，最终得到最长子序列的长度。
     * 5.结果：返回 dp 数组中的最大值，即为所求的最长严格上升子序列的长度。
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * 给定数组的最长严格上升子序列的长度。
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    public static int longestIncreaseSub (int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 初始化dp数组，表示每个元素本身构成一个长度为1的最长上升子序列
        int n = arr.length;
        int[] dp = new int[n];
        // 初始值为1
        Arrays.fill(dp, 1);
        //或者在第一个for循环中使用， dp[i] = 1;

        // 初始化最长序列长度为1
        int res = dp[0];

        for (int i = 1; i < n; i++) {
            // 枚举i前面的所有元素
            for (int j = 0; j < i; j++){
                // 如果当前元素可以扩展前面的基础上升子序列
                if (arr[i] > arr[j]){
                    // 计算dp[i]的最大值，更新dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新最长子序列的长度
            res = Math.max(res, dp[i]);
        }
        // 返回最长上升子序列的长度
        return res;
    }

    /**
     * 方法2：贪心 + 二分查找
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * 给定数组的最长严格上升子序列的长度。
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    public static int longestIncreaseSub2 (int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //TODO
        return 1;

    }

        public static void main(String[] args) {
        LongestAscentSub sub = new LongestAscentSub();
//        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] arr = {1,3,2};
        System.out.println(sub.longestIncreaseSub(arr)); // 预期输出：4
    }
}
