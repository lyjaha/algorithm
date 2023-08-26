package com.ly.nk.dynamicProgram;

import java.util.Arrays;

/**
 *  BM70 兑换零钱(一)
 *
 *  描述：
 *  给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，
 *  代表要找的钱数，求组成aim的最少货币数。
 *  如果无解，请返回-1.
 *
 *  数据范围：数组大小满足 0≤n≤10000 ， 数组中每个数字都满足 0<val≤10000，0≤aim≤5000
 *
 *  要求：时间复杂度O(n×aim) ，空间复杂度O(aim)。
 *
 * [5,2,3],20
 * 4
 *
 * [5,2,3],0
 * 0
 *
 * [3,5],2
 * -1
 *
 */
public class ExchangeMoney {

    /**
     * 方法1：动态规划
     *
     * 知识点：动态规划
     *
     * 思路：
     *
     * 步骤：
     *  1：可以用dp[i]表示要凑出i元钱需要最小的货币数。
     *  2：一开始都设置为最大值aim+1，因此货币最小1元，即货币数不会超过aim.
     *  3：初始化dp[0]=0。
     *  4：后续遍历1元到aim元，枚举每种面值的货币都可能组成的情况，取每次的最小值即可，转移方程为
     *  dp[i]=min(dp[i],dp[i−arr[j]]+1).
     *  5：最后比较dp[aim]的值是否超过aim，如果超过说明无解，否则返回即可。
     *
     * 时空复杂度：
     * 时间复杂度：O(n ⋅ aim)，第一层遍历枚举1元到aim元，第二层遍历枚举n种货币面值
     * 空间复杂度：O(aim)，辅助数组dp的大小
     *
     * 最少货币数
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public static int minMoney (int[] arr, int aim) {
        //小于1的都返回0
        if(aim < 1) {
            return 0;
        }
        // 初始化dp数组。dp[i]表示凑齐i元最少需要多少货币数
        int[] dp = new int[aim + 1];
        // 将dp数组所有元素设置为无穷大表示初始情况下无法凑齐目标值。
//        Arrays.fill(dp,Integer.MAX_VALUE);

        // 将数组中的所有元素都设置为相同的值。
        Arrays.fill(dp, aim + 1);
        // 凑齐0元需要的硬币数为0
        dp[0] = 0;

        // 遍历要凑齐的金额
        for (int i = 1; i <= aim; i++) {
            // 遍历面值数组
            for (int j = 0; j < arr.length; j++){
                // 如果当前面值 arr[j] 可以凑齐金额 i
                if (arr[j] <= i){
                    // 更新dp数组，取最小值
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }
        // 如果 dp[aim] 大于 aim，表示无解，返回 -1；否则返回 dp[aim]，即凑齐目标金额的最少货币数量
        return dp[aim] > aim ? -1 : dp[aim];
    }

    public static void main(String args) {
        int[] arr = {1, 2, 5};
        int aim = 11;
        int result = minMoney(arr, aim);
        System.out.println("最少币数为：" + result);
    }
}
