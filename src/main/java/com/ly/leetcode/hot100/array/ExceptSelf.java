package com.ly.leetcode.hot100.array;

import java.util.Arrays;

/**
 *  238. 除自身以外数组的乘积
 *
 *  给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *  题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *  请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 *  输入: nums = [1,2,3,4]
 *  输出: [24,12,8,6]
 *
 *  输入: nums = [-1,1,0,-3,3]
 *  输出: [0,0,9,0,0]
 *
 */
public class ExceptSelf {

    /**
     * 方法1：
     *
     * 知识点：
     *
     * 思路：
     * 1. 可以使用两个数组来存储前缀乘积和后缀乘积，用于计算除当前元素外的其余各元素的乘积。
     * 2. 首先，创建一个长度为 n 的结果数组 `answer`，并初始化为全 1。
     * 3. 遍历数组 `nums`，计算当前元素左侧所有数字的乘积，存储在结果数组中。即，`answer[i]` 存储着 `nums[i]`
     *    左侧所有数字的乘积。
     * 4. 然后，遍历数组 `nums` 反向计算当前元素右侧所有数字的乘积，与结果数组中已存储的左侧乘积相乘即可
     *    得到最终的结果。将该结果存入 `answer[i]` 中即可。
     * 5. 最后，返回结果数组 `answer`。
     *
     * 步骤：
     * 1. 定义数组 `answer`，长度与 `nums` 相同，填充初始值 1。
     * 2. 计算左侧乘积并存储在 `answer` 中：
     *    - 初始化一个变量 `leftProduct` 为 1，用来记录左侧所有数字的乘积。
     *    - 遍历 `nums`，累乘当前元素 `nums[i]` 并将结果存入 `answer[i]` 中，更新 `leftProduct`。
     * 3. 计算右侧乘积并与左侧乘积相乘得到最终结果：
     *    - 初始化一个变量 `rightProduct` 为 1，用来记录右侧所有数字的乘积。
     *    - 从 `nums` 的最后一个元素开始遍历，累乘当前元素 `nums[i]` 并将结果与左侧乘积 `answer[i]` 相乘，存入 `answer[i]` 中，同时更新 `rightProduct`。
     * 4. 返回结果数组 `answer`。
     *
     * 时空复杂度：
     * - 时间复杂度：该算法的时间复杂度为 O(n)，其中 n 是数组的长度。我们只需要遍历数组两次。
     * - 空间复杂度：该算法的空间复杂度为 O(1)，不使用额外的空间。
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        // 结果数组
        int[] answer = new int[n];

        // 计算左侧乘积并存储在answer中
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // 计算右侧乘积并与左侧乘积相乘得到最终结果
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] answer = productExceptSelf(nums);
        System.out.println("除自身外的乘积数组: " + Arrays.toString(answer));
    }
}
