package com.ly.leetcode.hot100.matrix;

import java.util.Arrays;

/**
 *  73. 矩阵置零
 *
 *  给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 *  输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 *  输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 *  输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 *  输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 */
public class SizeZero {

    /**
     * 方法1：使用两个标记变量
     *
     * 知识点：
     *
     * 思路：
     * 1.对于原矩阵的每个元素，如果它为0，则将对应的行和列的首位元素设为0，作为标记。
     * 2.第一次遍历矩阵，将为0的元素所在行和列的首位元素设置为0。
     * 3.第二次遍历矩阵，根据行和列的首位元素是否为0，将对应位置的元素设为0。
     * 4.根据标记，将第一行和第一列是否为0的情况单独处理。
     *
     * 步骤：
     * 1.定义两个变量rowFlag和colFlag，用来标记第一行和第一列是否为0。
     * 2.第一次遍历矩阵，如果元素为0，则将对应的行和列的首位元素设为0，同时更新rowFlag和colFlag。
     * 3.第二次遍历矩阵，如果行或列的首位元素为0，则将对应位置的元素设为0。
     * 4.根据rowFlag和colFlag的值来处理第一行和第一列。如果它们为0，则将第一行和第一列的元素都设为0。
     * 5.返回原矩阵。
     *
     * 时空复杂度：
     * 时间复杂度：该算法的时间复杂度为 O(m * n)，其中 m 是矩阵的行数，n 是矩阵的列数。需要遍历两次矩阵。
     * 空间复杂度：该算法的空间复杂度为 O(1)，使用常数个额外变量进行标记。
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // 标记第一行和第一列是否为0
        boolean rowFlag = false;
        boolean colFlag = false;

        // 第一遍遍历，将为0的元素所在行和列的首位元素设为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 标记第一行和第一列是否为0
                    if (i == 0) {
                        rowFlag = true;
                    }
                    if (j == 0) {
                        colFlag = true;
                    }
                    // 将对应行和列的首位元素设为0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 第二遍遍历，根据首位元素是否为0，将对应位置的元素设为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowFlag) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (colFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
        System.out.println("处理后的矩阵：");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

}
