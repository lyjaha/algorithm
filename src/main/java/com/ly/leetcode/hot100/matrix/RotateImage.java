package com.ly.leetcode.hot100.matrix;

import java.util.Arrays;

/**
 *  48. 旋转图像
 *
 *  给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *  你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *  输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *  输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 *  输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 *  输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 */
public class RotateImage {


    /**
     * 方法1：使用辅助数组
     *
     * 知识点：
     *
     * 对于矩阵中第 i 行的第 j 个元素，在旋转后，它出现在倒数第 i 列的第 j 个位置。
     *
     * 思路：
     * 1.要将图像顺时针旋转90度，可以看作是先对矩阵进行转置（行变列，列变行），然后再每一行按照中点对称交换元素。
     * 2.首先，对矩阵进行转置操作，即将matrix[i][j]与matrix[j][i]进行交换。
     * 3.然后，对每一行按照中点对称交换元素，即将matrix[i][j]与matrix[i][n-1-j]进行交换。
     * 4.最终得到的矩阵即为顺时针旋转90度后的结果。
     *
     * 步骤：
     * 1.获取二维矩阵的行数和列数，记为n。
     * 2.对矩阵进行转置操作：
     *   遍历矩阵的上三角区域（i从0到n-1，j从i+1到n-1），
     *   将matrix[i][j]与matrix[j][i]进行交换。
     * 3.对每一行按照中点对称交换元素：
     *   遍历矩阵的每一行（i从0到n-1），
     *   交换matrix[i][j]与matrix[i][n-1-j]，其中j从0到(n-1)/2。
     * 4.矩阵顺时针旋转90度完成。
     *
     *
     * 时空复杂度：
     * 时间复杂度：该算法的时间复杂度为 O(n^2)，其中 n 是二维矩阵的行数（也是列数）。我们需要遍历整个矩阵进行转置和元素交换操作。
     * 空间复杂度：该算法的空间复杂度为 O(1)，不使用额外的空间。
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {

        // 矩阵的行数
        int n = matrix.length;

        // 1. 矩阵转置
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 每一行按中点对称交换元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("原始矩阵：");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        rotate(matrix);
        System.out.println("旋转后矩阵：");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
