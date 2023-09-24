package com.ly.leetcode.hot100.dublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  15. 三数之和
 *
 *  给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 *  同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 *  请你返回所有和为 0 且不重复的三元组。
 *  注意：答案中不可以包含重复的三元组。
 *
 *  输入：nums = [-1,0,1,2,-1,-4]
 *  输出：[[-1,-1,2],[-1,0,1]]
 *  解释：
 *  nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 *  nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 *  nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 *  不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 *  注意，输出的顺序和三元组的顺序并不重要。
 *
 *  输入：nums = [0,1,1]
 *  输出：[]
 *  解释：唯一可能的三元组和不为 0 。
 *
 *  输入：nums = [0,0,0]
 *  输出：[[0,0,0]]
 *  解释：唯一可能的三元组和为 0 。
 *
 */
public class ThreeNumberSum {

    /**
     * 方法1：排序 + 双指针
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     * 1.首先，将给定的数组进行排序，这样可以方便后续的操作。
     * 2.遍历排序后的数组，将当前元素作为第一个数，然后在剩余的元素中使用双指针来寻找满足三数之和为0的另外两个数。
     * 3.在遍历过程中，如果当前元素大于0，那么可以直接返回结果，因为排序后的数组中不可能存在三数之和为0的组合。
     * 4.对于当前元素，使用两个指针分别指向当前元素的下一个位置和数组的末尾，然后根据三数之和与0的大小关系移动指针。
     *   如果三数之和大于0，则将右指针左移。
     *   如果三数之和小于0，则将左指针右移。
     *   如果三数之和等于0，则将找到的三元组加入结果集中，并同时将左右指针向内移动，继续寻找下一个组合。
     * 5.重复上述步骤，直到遍历完所有元素。
     *
     * 时空复杂度：
     * 时间复杂度为 O(n^2)，其中 n 是数组的长度。排序的时间复杂度为 O(nlogn)，双指针遍历的时间复杂度为 O(n)。
     * 空间复杂度为 O(1)，不包括存储结果的空间。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // 首先对数组进行排序
        Arrays.sort(nums);

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素大于0，则不可能存在三数之和为0的组合，直接返回结果
            if (nums[i] > 0) {
                return result;
            }

            // 避免重复结果，跳过相同的元素
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            // 使用双指针寻找满足三数之和为0的组合
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到满足条件的组合，加入结果集
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 避免重复结果，跳过相同的元素
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    // 移动指针继续寻找下一个组合
                    left++;
                    right--;
                }else if (sum < 0){
                    // 三数之和小于0，左指针右移
                    left++;
                }else {
                    // 三数之和大于0，右指针左移
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

}
