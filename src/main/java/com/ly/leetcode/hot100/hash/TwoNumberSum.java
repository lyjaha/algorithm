package com.ly.leetcode.hot100.hash;

import java.util.HashMap;
import java.util.Map;

/**
 *  1. 两数之和
 *
 *  描述：
 *  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，
 *  并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例：
 * nums = [2,7,11,15], target = 9
 * [0,1]
 * 因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * nums = [3,2,4], target = 6
 * [1,2]
 *
 * nums = [3,3], target = 6
 * [0,1]
 *
 */
public class TwoNumberSum {

    /**
     * 方法1：暴力枚举
     *
     * 知识点：
     *
     * 思路：
     * 枚举数组中的每一个数 x，寻找数组中是否存在 target - x。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(N的2次方)，其中 N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     * 空间复杂度：O(1)。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        // 遍历数组，查找满足条件的两个数
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 如果找到满足条件的两个数
                if (nums[i] + nums[j] == target) {
                    // 将第一个数的索引存入结果数组的第一个位置
                    res[0] = i;
                    // 将第二个数的索引存入结果数组的第二个位置
                    res[1] = j;
//                    // 将第一个数的值存入结果数组的第一个位置
//                    res[0] = nums[i];
//                    // 将第二个数的值存入结果数组的第二个位置
//                    res[1] = nums[j];
                    return res;
                }
            }
        }
        // 如果没有找到满足条件的两个数，返回结果数组（默认为[0, 0]）
        return res;
    }

    /**
     * 方法2：哈希表
     *
     * 知识点：哈希表
     *
     * 思路：
     * 遍历数组，对于每个元素，计算与目标值的差值，然后查找差值是否在哈希表中存在，若存在则找到了一对满足条件的元素。
     * 在这个过程中，使用哈希表可以将查找时间从O(n)降低到O(1)，因为哈希表的查找操作的平均时间复杂度为O(1)。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(N)，其中 N 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
     *
     * 空间复杂度：O(N)，其中 N 是数组中的元素数量。主要为哈希表的开销。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/two-sum/solutions/434597/liang-shu-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 遍历数组，查找满足条件的两个数
        for (int i = 0; i < n; i++) {
            // 如果哈希表中存在与当前元素配对的补数
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            // 将当前元素及其索引存入哈希表中
            hashMap.put(nums[i], i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,3};
        System.out.println(twoSum(nums, 6));
    }
}
