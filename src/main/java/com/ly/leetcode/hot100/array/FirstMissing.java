package com.ly.leetcode.hot100.array;

/**
 *  41. 缺失的第一个正数
 *
 *  给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 *  输入：nums = [1,2,0]
 *  输出：3
 *
 *  输入：nums = [3,4,-1,1]
 *  输出：2
 *
 *  输入：nums = [7,8,9,11,12]
 *  输出：1
 *
 */
public class FirstMissing {

    /**
     * 方法1：哈希表
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
     * @return
     */
    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // 第一个遍历：将负数和大于n的正数改为n+1
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // 第二个遍历：将已出现的数字对应位置的元素变为负数
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // 第三个遍历：找到第一个正数所在的位置 i，返回 i+1
        for (int i = 0; i < n; i ++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // 若数组中的元素均为正数，则返回n+1
        return n + 1;

    }


    /**
     * 方法2：置换
     *
     * 知识点：
     *
     * 思路：
     * 1. 我们可以利用原数组来实现找出最小的未出现的正整数。
     * 2. 遍历数组，将每个正整数 nums[i] 放到索引为 nums[i]-1 的位置上，即将 nums[i] 与 nums[nums[i]-1]
     *    进行交换。
     * 3. 然后再次遍历数组，找到第一个满足 nums[i] != i+1 的索引 i+1，即为最小的未出现的正整数。
     * 4. 如果数组中所有的元素都满足 nums[i] = i+1，则最小的未出现的正整数为 n+1（数组长度为 n）。
     *
     *
     * 步骤：
     * 1. 如果数组为空，则最小的未出现的正整数为 1。
     * 2. 遍历数组：
     *    - 当前元素 nums[i] 为正数且小于等于数组长度 n，且 nums[i] != nums[nums[i]-1]，则交换 nums[i]
     *    与 nums[nums[i]-1] 的位置。
     * 3. 再次遍历数组：
     *    - 如果 nums[i] != i+1，则返回 i+1 作为最小的未出现的正整数。
     * 4. 如果数组中所有的元素都满足 nums[i] = i+1，则最小的未出现的正整数为 n+1。
     *
     *
     * 时空复杂度：
     * 时间复杂度：该算法的时间复杂度为 O(n)，其中 n 是数组的长度。我们最多需要遍历数组两次。
     * 空间复杂度：该算法的空间复杂度为 O(1)，不使用额外的空间。
     *
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive2(int[] nums) {

        int n = nums.length;

        // 遍历数组，将每个正整数放到索引为nums[i]-1的位置上，即将nums[i]与nums[nums[i]-1]进行交换
        for (int i = 0; i < n; i++) {
            // 当前元素nums[i]为正数且小于等于数组长度n，且nums[i] != nums[nums[i]-1]
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];

                nums[i] = nums[temp - 1];

                nums[temp - 1] = temp;
            }
        }

        // 再次遍历数组，找到第一个满足nums[i] != i+1的索引i+1，即为最小的未出现的正整数
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果数组中所有的元素都满足nums[i] = i+1，则最小的未出现的正整数为n+1
        return n + 1;

    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int result = firstMissingPositive2(nums);
        System.out.println("最小的未出现的正整数: " + result);
    }
}
