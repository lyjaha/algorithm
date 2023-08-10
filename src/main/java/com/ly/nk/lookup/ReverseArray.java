package com.ly.nk.lookup;

/**
 *  BM20 数组中的逆序对
 *
 *  描述：
 *  在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 *  并将P对1000000007取模的结果输出。 即输出P mod 1000000007
 *
 *  输入描述：题目保证输入的数组中没有的相同的数字
 *
 *  数据范围：
 *  对于 50% 的数据,size ≤ 10的4次方
 *  对于 100% 的数据,size ≤ 10的5次方
 *  数组中所有数字的值满足 0 ≤ val ≤ 10的9次方
 *
 *  要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
 *
 * 示例
 * 输入：[1,2,3,4,5,6,7,0]
 * 返回值：7
 *
 * 输入：[1,2,3]
 * 返回值：0
 */
public class ReverseArray {


    /**
     *  方法1：归并排序
     *
     *  思路：
     *
     *  步骤：
     *  1： 划分阶段：将待划分区间从中点划分成两部分，两部分进入递归继续划分，直到子数组长度为1.
     *  2： 排序阶段：使用归并排序递归地处理子序列，同时统计逆序对，因为在归并排序中，我们会依次比较相邻两组子数组
     *  各个元素的大小，并累计遇到的逆序情况。而对排好序的两组，右边大于左边时，它大于了左边的所有子序列，基于这个性质
     *  我们可以不用每次加1来统计，减少运算次数。
     *  3： 合并阶段：将排好序的子序列合并，同时累加逆序对。
     *
     *
     *   时空复杂度：
     *   时间复杂度：O(nlog2n)，归并排序利用分治思想，树型递归每次二分，总共能分为 log2n层，每层合并都需要遍历数组所有元素即
     *   O(n)
     *   空间复杂度：O(n)，辅助数组temp长度为n及递归栈最大深度不会超过n
     *
     * @param nums
     * @return
     */

    public int reversePairs (int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        return mergeSort(0, n - 1, nums, res);
    }

    private int mod = 1000000007;

    /**
     *  完全不懂。。。。。
     *
     * @param left
     * @param right
     * @param data
     * @param temp
     * @return
     */
    private int mergeSort(int left, int right, int [] data, int [] temp){
        if (left >= right) {
            return 0;
        }
        //取中间
        int mid = (left + right) / 2;
        //左右划分合并
        int res = mergeSort(left, mid, data, temp) + mergeSort(mid + 1, right, data, temp);

        //防止溢出
        res %= mod;

        int i = left, j = mid + 1;

        for (int k = left; k <= right; k++) {
            temp[k] = data[k];
        }

        for (int k = left; k <= right; k++) {
            if (i == mid + 1){
                data[k] = temp[j++];
            } else if (j == right + 1 || temp[i] <= temp[i]) {
                data[k] = temp[i++];
            } else {
                data[k] = temp[j++];
                res += mid - i + 1;
            }
        }
        return res % mod;
    }

    /**
     *  方法2：树状数组
     *
     *
     */
}
