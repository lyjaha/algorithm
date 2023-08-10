package com.ly.nk.lookup;

/**
 * BM21 旋转数组的最小数字
 *
 * 描述：
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，
 * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。
 *
 * 数据范围：1≤n≤10000，数组中任意元素的值:0≤val≤10000
 *
 * 要求：
 * 空间复杂度：O(1)
 * 时间复杂度：O(logn)
 *
 * 示例
 * 输入：[3,4,5,1,2]
 * 返回值：1
 *
 * 输入：[3,100,200,3]
 * 返回值：3
 *
 */
public class RevolveArray {


    /**
     * 方法1：二分法
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public static int minNumberInRotateArray (int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            //最小的数字在mid右边
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            //无法判断，一个一个试
            } else if (nums[mid] == nums[right]) {
                right--;
            //最小数字要么是mid要么在mid左边
            }else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
//        int[] ints = {4,5,1,2,3};
        int[] ints = {3,100,200,3};

        minNumberInRotateArray(ints);
    }
}
