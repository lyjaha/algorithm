package com.ly.leetcode.hot100.matrix;

/**
 *  240. 搜索二维矩阵 II
 *
 *  编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *  每行的元素从左到右升序排列。
 *  每列的元素从上到下升序排列。
 *
 *  输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 *  输出：true
 *
 *  输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 *  输出：false
 *
 */
public class SearchMatrix {

    /**
     * 方法1：直接查找
     *
     * 知识点：
     *
     * 思路：
     * 我们直接遍历整个矩阵 matrix\textit{matrix}matrix，判断 target\textit{target}target 是否出现即可。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(mn)。
     * 空间复杂度：O(1)。
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int[] row : matrix) {
            for (int element : row) {
                if (element == target) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 方法2：二分查找
     *
     * 知识点：
     *
     * 思路：
     * 由于矩阵 matrix 中每一行的元素都是升序排列的，因此我们可以对每一行都使用一次二分查找，
     * 判断 target 是否在该行中，从而判断 target 是否出现。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(mlogn)。对一行使用二分查找的时间复杂度为 O(logn)，最多需要进行 m 次二分查找。
     * 空间复杂度：O(1)。
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {

        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    private static int search(int[] rows, int target) {
        int low = 0, high = rows.length;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int row = rows[mid];
            if (row == target) {
                return mid;
            }else if (row > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 方法3：Z 字形查找
     *
     * 知识点：
     *
     * 思路：
     * 1.由于矩阵的每行和每列均按升序排列，我们可以从矩阵的右上角开始搜索，这样可以通过比较 target 与当前元素的大小来缩小搜索
     *   范围。
     * 2.如果当前元素比 target 大，则可以排除当前元素所在的列；如果当前元素比 target 小，则可以排除当前元素所在的行。
     * 3.重复上述步骤，直到找到 target 或搜索范围为空。
     *
     * 步骤：
     * 1.获取矩阵的行数 m 和列数 n。
     * 2.初始化搜索的起始点为右上角元素，即坐标为 (0, n-1)。
     * 3.进入循环，直到搜索的起始点越界：
     *   如果当前元素等于 target，则返回 true。
     *   如果当前元素大于 target，则排除所在列，将搜索的起始点向左移动一列。
     *   如果当前元素小于 target，则排除所在行，将搜索的起始点向下移动一行。
     * 4.如果循环结束仍未找到 target，则返回 false。
     *
     * 时空复杂度：
     * 时间复杂度：该算法的时间复杂度为 O(m + n)，其中 m 是矩阵的行数，n 是矩阵的列数。最多进行 m+n 步搜索。
     * 空间复杂度：该算法的空间复杂度为 O(1)，不使用额外的空间。
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix3(int[][] matrix, int target) {

        // 矩阵的行数
        int m = matrix.length;
        // 矩阵的列数
        int n = matrix[0].length;

        // 搜索的起始行
        int row = 0;
        // 搜索的起始列
        int col = n - 1;

        while (row < m && col >= 0) {
            // 当前元素
            int num = matrix[row][col];
            // 找到目标值
            if (num == target) {
                return true;
            }
            // 当前元素大于目标值，排除所在列，向左移动一列
            if (num > target) {
                col--;
            }else {
                // 当前元素小于目标值，排除所在行，向下移动一行
                row++;
            }
        }
        // 循环结束未找到目标值
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 9;
        boolean result = searchMatrix(matrix, target);
        System.out.println("目标值是否存在于矩阵中：" + result);
    }
}
