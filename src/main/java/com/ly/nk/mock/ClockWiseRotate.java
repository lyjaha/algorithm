package com.ly.nk.mock;

/**
 *  BM99 顺时针旋转矩阵
 *
 *  描述：
 *  有一个 NxN 整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
 *  给定一个 NxN 的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵。
 *
 *  要求：空间复杂度 O(N的2次方)，时间复杂度 O(N 的2次方)
 *  进阶：空间复杂度 O(1)，时间复杂度 O(N 的2次方)
 *
 *  [[1,2,3],[4,5,6],[7,8,9]],3
 *  [[7,4,1],[8,5,2],[9,6,3]]
 *
 *
 */
public class ClockWiseRotate {

    /**
     * 方法1：倒置翻转
     *
     * 知识点：矩阵转置
     * 矩阵转置是将上三角矩阵元素与下三角矩阵元素依据对角线位置对称互换，且该过程是可逆的。
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n 的2次方)，转置需要遍历矩阵，逐行翻转也是O的2次方)
     * 空间复杂度：O(1)，常数级变量，没有使用额外辅助空间
     *
     *
     * @param mat int整型二维数组
     * @param n int整型
     * @return int整型二维数组
     */
    public int[][] rotateMatrix (int[][] mat, int n) {

        int length = mat.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0;j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][length - j - 1];
                mat[i][length - j - 1] = temp;
            }
        }

        return mat;
    }

}
