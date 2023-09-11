package com.ly.nk.mock;

/**
 *  BM97 旋转数组
 *
 *  描述：
 *  一个数组A中存有 n 个整数，在不允许使用另外数组的前提下，将每个整数循环向右移 M（ M >=0）个位置，
 *  即将A中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）
 *  （最后 M 个数循环移至最前面的 M 个位置）。如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 *
 * 进阶：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * 6,2,[1,2,3,4,5,6]
 * [5,6,1,2,3,4]
 *
 * 4,0,[1,2,3,4]
 * [1,2,3,4]
 *
 */
public class RotateArray {

    /**
     * 方法1：三次翻转
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     * 1、确定实际需要移动的位置数：由于题目要求循环移动，当M大于数组长度n时，实际需要移动的位置数为M % n，即M对n取余。
     * 2、反转整个数组：将整个数组A进行反转，可以使用双指针法，一个指针指向数组的起始位置，一个指针指向数组的末尾位置，
     * 交换两个指针指向的元素，并向中间移动指针，直到两个指针相遇。这样可以将原始数组的顺序反转。
     * 3、反转前M个元素：将前M个元素进行反转，同样可以使用双指针法。
     * 4、反转剩余的元素：将剩余的n-M个元素进行反转。
     * 5、最后得到的数组即为循环右移M个位置后的结果。
     *
     * 时空复杂度：
     *
     * 旋转数组
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public int[] solve (int n, int m, int[] a) {
        if (m == 0) {
            return a;
        }
        m = m % n;
        // 反转整个数组
        reverse(a, 0, n - 1);

        // 只逆转开头m个
        reverse(a, 0, m - 1);

        // 只逆转结尾m个
        reverse(a, m, n - 1);

        return a;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // 交换两个位置上的元素
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            // 移动指针
            start++;
            end--;
        }
    }
}
