package com.ly.nk.greedy;

import java.util.Arrays;

/**
 *  BM95 分糖果问题
 *
 *  描述：
 *  一群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下：
 *
 *  1. 每个孩子不管得分多少，起码分到一个糖果。
 *  2. 任意两个相邻的孩子之间，得分较多的孩子必须拿多一些糖果。(若相同则无此限制)
 *
 * 给定一个数组 arr 代表得分数组，请返回最少需要多少糖果。
 *
 * 要求: 时间复杂度为 O(n) 空间复杂度为 O(n)
 *
 *
 *  [1,1,2]
 *  4
 *  最优分配方案为1,1,2
 *
 *  [1,1,1]
 *  3
 *
 */
public class DivideCandy {

    /**
     * 方法1：贪心算法
     *
     * 知识点：贪心思想
     * 贪心思想属于动态规划思想中的一种，其基本原理是找出整体当中给的每个局部子结构的最优解，并且
     * 最终将所有的这些局部最优解结合起来形成整体上的一个最优解。
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * pick candy
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int candy (int[] arr) {

        int n = arr.length;

        if(n <= 1){
            return n;
        }

        // 1 创建一个长度为 n 的初始值均为 1 的糖果数量数组 candies
        int[] nums = new int[n];

        Arrays.fill(arr, 1);

        // 2. 从左往右遍历一遍 arr
        for (int i = 1; i < n; i++) {
            // 当前孩子得分比前一个高
            if (arr[i] > arr[i - 1]){
                // 糖果数量比前一个多一个
                nums[i] = nums[i - 1] + 1;
            }
        }

        int candyTotal = nums[n - 1];

        // 3. 从右向左遍历一遍 arr
        for (int i = n - 2; i >= 0; i--){
            // 当前孩子得分比后一个高
            if (arr[i] > arr[i + 1]) {
                // 糖果数量比后一个多一个，且不能少于当前数对应的糖果数量
                nums[i] = nums[i + 1] + 1;
            }
            candyTotal += nums[i];
        }
        return candyTotal;
    }

    public static void main(String[] args) {
        DivideCandy solution = new DivideCandy();
        int[] arr = {1, 0, 2};
        int res = solution.candy(arr);
        System.out.println(res); // 输出 5
    }
}
