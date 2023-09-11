package com.ly.nk.mock;

import java.util.ArrayList;

/**
 *  BM98 螺旋矩阵
 *
 *  描述:
 *  给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 *  要求：空间复杂度 O(nm) ，时间复杂度 O(nm)
 *
 *
 *  [[1,2,3],[4,5,6],[7,8,9]]
 *  [1,2,3,6,9,8,7,4,5]
 *
 *  []
 *  []
 *
 */
public class HelixMatrix {

    /**
     * 方法1：边界模拟法
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(mn)，相当于遍历整个矩阵
     * 空间复杂度：O(1)，res属于必要空间，没有使用额外辅助空间
     *
     *
     * @param matrix int整型二维数组
     * @return int整型ArrayList
     */
    public ArrayList<Integer> spiralOrder (int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        // 左边界
        int left = 0;
        // 右边界
        int right = matrix[0].length - 1;
        // 上边界
        int up = 0;
        // 下边界
        int down = matrix.length - 1;

        //直到边界重合
        while (left <= right && up <= down) {
            //上边界的从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            //上边界向下
            up++;
            if (up > down) {
                break;
            }

            //右边界的从上到下
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            //右边界向左
            right--;

            if (left > right) {
                break;
            }

            //下边界的从右到左
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            //下边界向上
            down--;
            if (up > down) {
                break;
            }

            //左边界的从下到上
            for (int i = down; i >= up; i--){
                res.add(matrix[down][i]);
            }
            //左边界向右
            left++;
            if (left > right){
                break;
            }
        }
        return res;
    }
}
