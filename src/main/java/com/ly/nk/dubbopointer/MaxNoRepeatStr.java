package com.ly.nk.dubbopointer;

import java.util.HashSet;
import java.util.Set;

/**
 *  BM92 最长无重复子数组
 *
 *  描述：
 *  给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 *
 * [2,3,4,5]
 * 4
 *
 * [2,2,3,4,3]
 * 3
 *[2,3,4]是最长子数组
 *
 * [9]
 * 1
 *
 */
public class MaxNoRepeatStr {

    /**
     * 方法1：滑动窗口
     *
     * 知识点：
     * 滑动窗口
     *
     * 哈希表
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，外循环窗口右界从数组首右移到数组尾，内循环窗口左界同样如此，因此复杂度为 O(n+n)=O(n)
     * 空间复杂度：O(n)，最坏情况下整个数组都是不重复的，哈希表长度就为数组长度 n
     *
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        int length = arr.length;

        int left = 0;
        int right = 0;
        Set<Integer> hashSet = new HashSet<>();

        int maxLen = 0;

        while (right < length) {
            if (!hashSet.contains(arr[right])) {
                // 将新元素添加到 set 中，并更新最大长度
                hashSet.add(arr[right]);
                maxLen = Math.max(maxLen, right - left + 1);
                // 移动 right 指针扩展子数组
                right++;
            }else {
                //子数组中出现重复元素，则移动 left 指针
                hashSet.remove(arr[left]);
                left++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaxNoRepeatStr maxNoRepeatStr = new MaxNoRepeatStr();
        int[] arr = {1, 2, 3, 2, 1, 4, 5, 6, 7};
        int result = maxNoRepeatStr.maxLength(arr);
        System.out.println(result); // 输出 "7"
    }
}
