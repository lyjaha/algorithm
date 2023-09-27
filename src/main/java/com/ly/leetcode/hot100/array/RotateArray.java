package com.ly.leetcode.hot100.array;

import java.util.Arrays;

/**
 *  189. 轮转数组
 *
 *  给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *  输入: nums = [1,2,3,4,5,6,7], k = 3
 *  输出: [5,6,7,1,2,3,4]
 *  解释:
 *  向右轮转 1 步: [7,1,2,3,4,5,6]
 *  向右轮转 2 步: [6,7,1,2,3,4,5]
 *  向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 *  输入：nums = [-1,-100,3,99], k = 2
 *  输出：[3,99,-1,-100]
 *  解释:
 *  向右轮转 1 步: [99,-1,-100,3]
 *  向右轮转 2 步: [3,99,-1,-100]
 *
 */
public class RotateArray {

    /**
     * 方法1：使用额外的数组
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度： O(n)，其中 n 为数组的长度。
     * 空间复杂度： O(n)。
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {

        int n = nums.length;

        int[] newArr = new int[n];

        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums,0, n);

    }


    /**
     * 方法2：环状替换
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中 n 为数组的长度。每个元素只会被遍历一次。
     * 空间复杂度：O(1)。只需常数空间存放若干变量。
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {

    }


    /**
     * 方法3：数组翻转
     *
     * 知识点：
     *
     * 思路：
     * 1. 首先，我们可以观察到，当数组进行 k 次向右轮转后，尾部的 k % n 个元素会被移动到数组的头部，
     *    其余的元素向后移动 k % n 个位置。
     * 2. 为了原地完成操作，我们可以使用反转的方法来实现。先将整个数组进行反转，然后再分别反转前 k % n 个元素
     *    和后面的 n - (k % n) 个元素，即可得到目标结果。
     * 3. 这样的原地反转操作可以保证数组元素向右轮转 k 个位置，并且不需要额外的空间。
     *
     * 步骤：
     * 1. 如果数组为空或者 k 为 0，直接返回原数组。
     * 2. 计算需要进行反转的次数 k % n。
     * 3. 对整个数组进行反转，即反转数组中所有的元素。
     * 4. 反转数组中前 k % n 个元素。
     * 5. 反转数组中剩余的 n - (k % n) 个元素。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中 n 为数组的长度。每个元素被翻转两次，一共 n 个元素，因此总时间复杂度为 O(2n) = O(n)。
     * 空间复杂度：O(1)，没有使用额外的空间，符合原址反转的要求。
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {

        if (nums == null || k == 0) {
            return ;
        }

        int n = nums.length;
        // 计算需要进行反转的次数 k % n
        k %= n;

        // 反转整个数组
        reverse(nums, 0, n - 1);

        // 反转数组中前 k % n 个元素
        reverse(nums, 0, k - 1);

        // 反转数组中剩余的 n - (k % n) 个元素
        reverse(nums, k, n - 1);

    }


    /**
     *
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("原数组：" + Arrays.toString(nums));
        rotate(nums, k);
        System.out.println("向右轮转 " + k + " 个位置后的数组：" + Arrays.toString(nums));
    }
}
