package com.ly.nk.heapStackQueue;

import java.util.*;

/**
 *  BM45 滑动窗口的最大值
 *
 *  描述：
 *  给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
 *
 *  例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *  针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 *  {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * 窗口大于数组长度或窗口长度为0的时候，返回空。
 *
 * 数据范围： 1≤n≤10000，0≤size≤10000，数组中每个元素的值满足∣val∣≤10000
 * 要求：空间复杂度O(n)，时间复杂度O(n)
 *
 * 输入：[2,3,4,2,6,2,5,1],3
 * 返回值：[4,4,6,6,6,5]
 *
 * 输入：[9,10,9,-7,-3,8,2,-6],5
 * 返回值：[10,10,9,8]
 *
 * 输入：[1,2,3,4],5
 * 返回值：[]
 */
public class MaxInWindow {

    /**
     * 方法1：双向队列
     *
     * 知识点：双向队列
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param nums int整型一维数组
     * @param size int整型
     * @return int整型ArrayList
     */
    public static List<Integer> maxInWindows (int[] nums, int size) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || size > nums.length) {
            return result;
        }

        int n = nums.length;

        // 双端队列
        Deque<Integer> deque = new LinkedList<>();

        //
        for (int i = 0; i < n; i++){

            // 如果队头元素的索引超出了当前窗口的范围（即i - size），则将队头元素出队，因为它不再成为最大值。
            if (!deque.isEmpty() && deque.peekFirst() < i - size + 1) {
                deque.pollFirst();
            }

            // 如果deque不为空且队尾元素小于当前元素，将队尾元素出队，因为当前元素更大，所以队尾元素不可能成为最大值。
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                 deque.pollLast();
            }

            // 将当前元素的索引加入 deque 的队尾
            deque.offerLast(i);

            // 当i大于等于窗口长度 size-1 时，将deque的队头元素索引对应的值加入结果列表result中。
            if (i >= size - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }

        return result;

    }

    /**
     * 方法2：
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param num int整型一维数组
     * @param size int整型
     * @return int整型ArrayList
     */
    public static List<Integer> maxInWindows2 (int[] num, int size) {
        return null;
    }



    public static void main(String[] args) {
        MaxInWindow solution = new MaxInWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        List<Integer> result = solution.maxInWindows(nums, k);
        System.out.println(result); // [3, 3, 5, 5, 6, 7]
    }
}

