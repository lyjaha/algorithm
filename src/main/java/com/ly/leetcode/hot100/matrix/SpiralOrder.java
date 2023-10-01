package com.ly.leetcode.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 *  54. 螺旋矩阵
 *
 *  给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *  输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *  输出：[1,2,3,6,9,8,7,4,5]
 *
 *  输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 *  输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class SpiralOrder {

    /**
     * 方法1：模拟
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(mn)，其中 m 和 n 分别是输入矩阵的行数和列数。矩阵中的每个元素都要被访问一次。
     *
     * 空间复杂度：O(mn)。需要创建一个大小为 m×n 的矩阵 visited 记录每个位置是否被访问过。
     *
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {

        // 结果列表
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return res;
        }
        return null;
    }


    /**
     * 方法2：按层模拟
     *
     * 知识点：
     *
     * 思路：
     * 1. 顺时针螺旋顺序意味着我们首先从矩阵的左上角开始，按顺序遍历第一行，然后依次遍历最后一列、最后一行和第一列，每次遍历后缩小矩阵的边界。
     * 2. 定义四个变量 `top`、`bottom`、`left`、`right` 表示当前遍历范围的上、下、左、右边界。
     * 3. 使用一个结果列表 `res`，按顺序存储遍历到的每个元素。
     * 4. 按照顺时针螺旋的顺序进行遍历，直到上边界小于等于下边界并且左边界小于等于右边界为止。
     *
     * 步骤：
     * 1. 初始化上、下、左、右边界的变量 `top`、`bottom`、`left`、`right`。
     * 2. 使用一个循环进行顺时针螺旋遍历：
     *    - 遍历矩阵的上边界，从左到右，将元素加入结果列表 `res`。
     *    - 上边界下移一位，更新 `top`。
     *    - 判断是否遍历到下边界并且与上边界交叉，若是，则停止遍历。
     *    - 遍历矩阵的右边界，从上到下，将元素加入结果列表 `res`。
     *    - 右边界左移一位，更新 `right`。
     *    - 判断是否遍历到左边界并且与右边界交叉，若是，则停止遍历。
     *    - 遍历矩阵的下边界，从右到左，将元素加入结果列表 `res`。
     *    - 下边界上移一位，更新 `bottom`。
     *    - 判断是否遍历到上边界并且与下边界交叉，若是，则停止遍历。
     *    - 遍历矩阵的左边界，从下到上，将元素加入结果列表 `res`。
     *    - 左边界右移一位，更新 `left`。
     *    - 判断是否遍历到右边界并且与左边界交叉，若是，则停止遍历。
     * 3. 返回结果列表 `res`。
     *
     * 时空复杂度：
     * - 时间复杂度：该算法的时间复杂度为 O(m * n)，其中 m 是矩阵的行数，n 是矩阵的列数。我们需要遍历整个矩阵。
     * - 空间复杂度：该算法的空间复杂度为 O(1)，不使用额外的空间。
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder2(int[][] matrix) {

        // 结果列表
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return res;
        }

        // 矩阵的行数
        int m = matrix.length;
        //
        int n = matrix[0].length;

        // 上边界
        int top = 0;
        // 下边界
        int bottom = m - 1;
        // 左边界
        int left = 0;
        // 右边界
        int right = n - 1;

        while (top <= bottom && left <= right) {
            // 遍历上边界
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            // 上边界下移一位
            top++;

            // 遍历右边界
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            // 右边界左移一位
            right--;

            // 判断是否遍历到下边界并且与上边界交叉
            if (top <= bottom) {
                // 遍历下边界
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                // 下边界上移一位
                bottom--;
            }

            // 判断是否遍历到左边界并且与右边界交叉
            if (left <= right){
                // 遍历左边界
                for (int i = bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
                // 左边界右移一位
                left++;
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = spiralOrder2(matrix);
        System.out.println("顺时针螺旋遍历结果: " + result);
    }
}
