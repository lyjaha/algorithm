package com.ly.leetcode.hot100.dublePointer;

/**
 *  283.移动零
 *
 *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *  请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *  进阶：你能尽量减少完成的操作次数吗？
 *
 *  输入: nums = [0,1,0,3,12]
 *  输出: [1,3,12,0,0]
 *
 *  输入: nums = [0]
 *  输出: [0]
 *
 *
 */
public class MoveZero {

    /**
     * 方法1：双指针
     *
     * 知识点：双指针
     *
     * 思路：
     * 使用左右指针的方式，将非零元素移动到数组的左侧。遍历数组，若当前元素非零，则将其与左指针指向的元素进行交换，
     * 并将左指针右移。最终，左指针左侧的元素都是非零元素，右指针及其右侧的元素都是零。
     *
     * 步骤：
     * 1.初始化左指针 left 和右指针 right 为0，数组长度 n 为 nums 的长度。
     * 2.循环遍历数组，直到右指针 right 达到数组末尾：
     *    若当前元素nums[right]不为零，则交换nums[left]和nums[right]的值，并将左指针left右移一位。
     *    将右指针right右移一位。
     * 3.完成循环后，所有非零元素已经移动到数组的左侧，数组的右侧都是零元素。
     * 4.返回处理后的数组nums。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中 n 为序列长度。每个位置至多被遍历两次。
     * 空间复杂度：O(1)。只需要常数的空间存放若干变量。
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        // 数组长度, 左指针, 右指针
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            // 如果当前元素不为零
            if (nums[right] != 0) {
                // 交换左指针和右指针指向的元素
                swap(nums, left, right);
                // 左指针右移一位
                left++;
            }
            // 右指针右移一位
            right++;
        }

    }

    private void swap(int[] nums, int left, int right) {
        // 交换元素
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 方法2：遍历
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZero moveZero = new MoveZero();
        moveZero.moveZeroes(nums);
        System.out.println("Modified Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
