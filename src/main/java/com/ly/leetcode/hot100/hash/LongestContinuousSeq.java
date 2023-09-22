package com.ly.leetcode.hot100.hash;

import java.util.HashSet;
import java.util.Set;

/**
 *  128. 最长连续序列
 *
 *  给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *  请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *  示例
 *  输入：nums = [100,4,200,1,3,2]
 *  输出：4
 *  解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 *  输入：nums = [0,3,7,2,5,8,4,6,0,1]
 *  输出：9
 *
 *
 */
public class LongestContinuousSeq {

    /**
     * 方法1：哈希表
     *
     * 知识点：
     *
     * 思路：
     * 1.遍历数组中的每个数字，对于每个数字，判断其是否是一个序列的起始数字，即判断它的前一个数字是否存在于集合中。
     * 如果不存在，则说明当前数字是一个序列的起始数字。
     * 2.对于每个序列的起始数字，不断向后查找连续的数字，直到找不到下一个数字为止，记录当前序列的长度。
     *
     * 步骤：
     * 1.创建一个HashSet集合，并将数组中的所有数字存入集合中。
     * 2.初始化最长序列的长度为0。
     * 3.遍历数组中的每个数字：
     *   判断当前数字是否是一个序列的起始数字，即判断它的前一个数字是否存在于集合中。
     *   如果不存在，则当前数字是一个序列的起始数字。
     *   不断向后查找连续的数字，直到找不到下一个数字为止，记录当前序列的长度。
     *   更新最长序列的长度。
     * 4.返回最长序列的长度作为结果。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中 n 为数组的长度。
     * 空间复杂度：O(n)。哈希表存储数组中所有的数需要 O(n) 的空间。
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        // 初始化最长序列的长度为0
        int longestStreak = 0;

        // 遍历数组中的每个数字
        for (int num : numSet) {
            // 判断当前数字是否是一个序列的起始数字，即判断它的前一个数字是否存在于集合中
            if (!numSet.contains(num - 1)) {
                // 如果不存在，则当前数字是一个序列的起始数字
                int currentNum = num;
                int currentStreak = 1;

                // 不断向后查找连续的数字，直到找不到下一个数字为止
                while (numSet.contains(currentNum + 1)){
                    currentNum++;
                    currentStreak++;
                }
                // 更新最长序列的长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        int longestStreak = longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence: " + longestStreak);
    }
}
