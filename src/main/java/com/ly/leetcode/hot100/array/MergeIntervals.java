package com.ly.leetcode.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  56. 合并区间
 *  以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 *  请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *  输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 *  输出：[[1,6],[8,10],[15,18]]
 *  解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 *  输入：intervals = [[1,4],[4,5]]
 *  输出：[[1,5]]
 *  解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */
public class MergeIntervals {

    /**
     * 方法1：排序 + 双指针
     *
     * 知识点：双指针
     *
     * 思路：
     * 1. 首先，根据区间的起始位置对所有区间进行排序，以确保相邻的区间在起始位置上是有序的。
     * 2. 创建一个结果列表`merged`，用来存储合并后的区间。
     * 3. 遍历排序后的区间列表，对每个区间进行合并操作：
     *    - 当结果列表为空，或当前区间的起始位置大于结果列表中最后一个区间的结束位置时，说明当前区间没有重叠，可以直接加入结果列表中。
     *    - 否则，当前区间与结果列表中最后一个区间存在重叠，将它们合并为一个新的区间，更新结果列表中最后一个区间的结束位置为当前区间的结束位置。
     * 4. 遍历结束后，结果列表`merged`中存储的就是合并后的不重叠区间。
     *
     * 步骤：
     * 1. 创建结果列表`merged`用来存储合并后的区间。
     * 2. 根据区间的起始位置对输入的区间列表`intervals`进行排序。
     * 3. 遍历排序后的区间列表，执行以下操作：
     *    - 如果结果列表`merged`为空，或当前区间的起始位置大于结果列表中最后一个区间的结束位置，则将当前区间加入结果列表。
     *    - 否则，将当前区间与结果列表中最后一个区间进行合并，并更新结果列表中最后一个区间的结束位置。
     * 4. 返回结果列表`merged`。
     *
     * 时空复杂度：
     * 时间复杂度：该算法的时间复杂度为O(nlogn)，其中n是区间的个数。在算法中，我们先对区间进行排序，然后遍历一次区间列表。
     * 空间复杂度：该算法的空间复杂度为O(n)，其中n是区间的个数。我们使用了额外的结果列表来存储合并后的区间。
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {

        // 结果列表
        List<int[]> merged = new ArrayList<>();

        // 根据区间的起始位置进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length; i++) {
            // 当前区间的起始位置
            int start = intervals[i][0];
            // 当前区间的结束位置
            int end = intervals[i][1];

            // 如果结果列表为空，或当前区间的起始位置大于结果列表中最后一个区间的结束位置，则将当前区间加入结果列表
            if (merged.isEmpty() || start > merged.get(merged.size() - 1)[1]){
                merged.add(new int[]{start, end});
            }else {
                // 否则，将当前区间与结果列表中最后一个区间进行合并，并更新结果列表中最后一个区间的结束位置
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], end);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = merge(intervals);
        System.out.println("合并后的区间:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
