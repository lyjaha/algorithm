package com.ly.leetcode.hot100.subString;

import java.util.HashMap;
import java.util.Map;

/**
 *  560. 和为 K 的子数组
 *  给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 *  子数组是数组中元素的连续非空序列。
 *
 *
 */
public class SubArraySum {

    /**
     * 方法1：枚举
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n^2)O，其中 n 为数组的长度。枚举子数组开头和结尾需要 O(n^2)的时间，
     * 其中求和需要 O(1) 的时间复杂度，因此总时间复杂度为 O(n^2)。
     * 空间复杂度：O(1)。只需要常数空间存放若干变量。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        // 统计满足条件的子数组个数
        int count = 0;

        for (int start = 0; start < nums.length; ++start) {
            // 记录当前子数组的和
            int sum = 0;

            // 从起始位置开始向前遍历
            for (int end = start; end >= 0; --end) {
                // 累加子数组的元素和
                sum += nums[end];

                // 如果子数组的和等于目标值k，则增加计数器count
                if (sum == k) {
                    count++;
                }
            }
        }
        // 返回满足条件的子数组个数
        return count;
    }


    /**
     * 方法2：前缀和 + 哈希表优化
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中 n 为数组的长度。我们遍历数组的时间复杂度为 O(n)，中间利用哈希表查询删除的复杂度均为 O(1)，
     *  因此总时间复杂度为 O(n)。
     *
     * 空间复杂度：O(n)，其中 n 为数组的长度。哈希表在最坏情况下可能有 n 个不同的键值，因此需要 O(n) 的空间复杂度。

     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        // 哈希表用于记录累积和及其出现次数
        Map<Integer, Integer> map = new HashMap<>();

        // 初始化，累积和为0的出现次数为1
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            // 在哈希表中查找与当前累积和差值为k的累积和的出现次数
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // 更新哈希表中当前累积和的出现次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
