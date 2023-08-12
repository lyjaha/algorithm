package com.ly.nk.hash;

import java.util.HashMap;
import java.util.Map;

/**
 *  BM50 两数之和
 *
 *  描述：
 *  给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
 *
 * 数据范围：2≤len(numbers)≤10的5次方，−10 ≤ numbersi ≤ 10的9次方，0 ≤ target ≤ 10的9次方
 * 要求：空间复杂度O(n)，时间复杂度O(nlogn)
 *
 */
public class twoSum {

    /**
     * 方法1：哈希表
     *
     * 思路：
     *
     * 步骤：
     *  1：构建一个哈希表，其中key值为遍历数组过程中出现过的值，value值为其相应的下标，因为我们最终要返回的是下标。
     *  2：遍历数组每个元素，如果目标值减去该元素的结果在哈希表中存在，说明我们先前遍历的时候它出现过，根据记录的下标，
     *  就可以得到结果。
     *  3：如果相减后的结果没有在哈希表中，说明先前遍历的元素中没有它对应的另一个值，那我们将它加入哈希表，
     *  等待后续它匹配的那个值出现即可。
     *  4：需要注意最后的结果是下标值加1.
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，仅仅遍历数组一次，每次查询哈希表都是O(1)
     * 空间复杂度：O(n)，最坏情况下找到数组结尾才找到，其他都加入哈希表，因此哈希表最长为n−1的长度
     *
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[0];
    }
}
