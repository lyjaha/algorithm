package com.ly.leetcode.hot100.subString;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  239. 滑动窗口最大值
 *
 *  给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 *  滑动窗口每次只向右移动一位。
 *  返回 滑动窗口中的最大值 。
 *
 *  输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 *  输出：[3,3,5,5,6,7]
 *  解释：
 *  滑动窗口的位置                最大值
 *  ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  输入：nums = [1], k = 1
 *  输出：[1]
 *
 */
public class MaxSlidingWindow {

    /**
     * 方法1：优先队列
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
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //todo
        return null;
    }

    /**
     * 方法2：单调队列（双端队列）
     *
     * 知识点：
     * 单调队列：
     * 为了可以同时弹出队首和队尾的元素，我们需要使用双端队列。满足这种单调性的双端队列一般称作「单调队列」。
     *
     * 思路：
     * 1.可以使用双端队列来解决这个问题。双端队列可以在O(1)的时间复杂度内获取队列两端的元素。
     *   可以在双端队列中存储当前滑动窗口中的元素，并保持队列头部的元素为窗口中的最大值。
     * 2.使用双端队列来存储元素在数组nums中的索引。
     *   当前元素加入队列时，可以将队列中比当前元素小的元素全部出队，以确保队列头部的元素为窗口中的最大值。
     *   滑动窗口向右移动时，需要判断队列头部的元素是否已经不在窗口内，如果不在窗口内则将其出队。
     * 3.设置一个结果数组result来保存每个滑动窗口的最大值。
     * 4.在遍历数组nums时，按照上述步骤来维护双端队列，并将队列头部的元素作为当前窗口的最大值，将其加入结果数组result。
     * 5.遍历结束后，返回结果数组result。
     *
     * 步骤：
     * 1.创建一个双端队列deq来存储数组nums中的索引。
     * 2.创建一个结果数组result，以及窗口的左边界left和右边界right，初始值分别为0和k-1。
     * 3.遍历数组nums，执行以下步骤：
     *   如果队列头部的元素已经不在当前窗口内（即索引小于窗口左边界left），则将其出队。
     *   将队列尾部小于当前元素nums[right]的元素全部出队，以确保队列头部的元素为当前窗口的最大值。
     *   将当前元素的索引nums[right]加入队列deq末尾。
     *   如果当前窗口的大小大于等于k，则将队列头部的元素加入结果数组result中（即当前窗口的最大值）。
     *   将窗口左边界left和右边界right都向右移动一位。
     * 4.返回结果数组result。
     *
     * 时空复杂度：
     * 时间复杂度：该算法的时间复杂度为O(n)，其中n是数组nums的长度。我们只需遍历一次数组，并在双端队列中维护固定数量的元素。
     * 空间复杂度：该算法的空间复杂度为O(k)，其中k是滑动窗口的大小。我们使用双端队列来存储窗口内的元素索引，
     *   窗口的大小最多为k，因此额外空间复杂度为O(k)。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;

        int[] result = new int[n - k + 1];

        int resultIndex = 0;

        Deque<Integer> deq = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {
            // 如果队列头部的元素已经不在当前窗口内，则将其出队
            if (!deq.isEmpty() && deq.peekFirst() < right - k + 1) {
                deq.pollFirst();
            }
            // 将队列尾部小于当前元素的元素全部出队
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[right]) {
                deq.pollLast();
            }

            // 将当前元素的索引加入队列deq的末尾
            deq.offerLast(right);

            // 当前窗口的大小大于等于k时，队列头部的元素即为当前窗口的最大值
            if (right >= k - 1) {
                result[resultIndex] = nums[deq.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow2(nums, k);
        System.out.print("滑动窗口中的最大值: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
