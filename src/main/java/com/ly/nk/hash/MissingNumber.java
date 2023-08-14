package com.ly.nk.hash;

import java.util.HashMap;
import java.util.Map;

/**
 *  BM53 缺失的第一个正整数   (大于0的整数)
 *
 *  描述：
 *  给定一个无重复元素的整数数组nums，请你找出其中没有出现的最小的正整数
 *
 *  进阶： 空间复杂度 O(1)，时间复杂度 O(n)
 *
 *  示例：
 *  输入：[1,0,2]
 *  返回值：3
 *
 *  输入：[-2,3,4,1,5]
 *  返回值：2
 *
 *  输入：[4,5,6,8,9]
 *  返回值：1
 */
public class MissingNumber {

    /**
     * 方法1：哈希表
     *
     * 思路：
     * n个长度的数组，没有重复，则如果数组填满了 1～n，那么缺失 n+1，如果数组填不满 1～n，那么缺失的就是
     * 1～n中的数字。对于这种快速查询某个元素是否出现过的问题，还是可以使用哈希表快速判断某个数字是否出现过。
     *
     * 步骤：
     *  1：构建一个哈希表，用于记录数组中出现的数字。
     *  2：从1开始，遍历到 n，查询哈希表中是否有这个数字，如果没有，说明它就是数组缺失的第一个正整数，即找到。
     *  3：如果遍历到最后都在哈希表中出现过了，那缺失的就是n+1.
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，第一次遍历数组，为 O(n)，第二次最坏从1遍历到O(n)
     * 空间复杂度：O(n)，哈希表记录n个不重复的元素，长度为 n
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minNumberDisappeared (int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> resMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            resMap.put(nums[i], 1);
        }

        int res = 1;

        while (resMap.containsKey(res)) {
            res++;
        }
        return res;
    }


    /**
     * 方法2：原地hash
     *
     * 思路：
     *
     * 步骤：
     *  1：我们可以先遍历数组将所有的负数都修改成n+1。
     *  2：然后再遍历数组，每当遇到一个元素绝对值不超过n时，则表示这个元素是1～n中出现的元素，我们可以将这个数值对应的
     *  下标里的元素改成负数，相当于每个出现过的正整数，我们把与它值相等的下标都指向一个负数，这就是类似哈希表的实现原理的操作。
     *  3：最后遍历数组的时候碰到的第一个非负数，它的下标就是没有出现的第一个正整数，因为它在之前的过程中没有被修改，
     *  说明它这个下标对应的正整数没有出现过。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，多次遍历数组，都是单层循环
     * 空间复杂度：O(1)，原地哈希，以索引为指向，没有额外空间
     */
    public int minNumberDisappeared2 (int[] nums) {

        int n = nums.length;

        //
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0){
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            // 1-n范围
            if (Math.abs(nums[i]) <= n) {
                nums[Math.abs(nums[i]) - 1] = -1 * Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;

    }
}
