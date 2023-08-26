package com.ly.nk.dynamicProgram;

/**
 *  BM68 矩阵的最小路径和
 *
 *  描述：
 *  给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，
 *  输出所有的路径中最小的路径和。
 *
 * 数据范围: 1 ≤ n,m ≤500，矩阵中任意值都满足 0 ≤ai,j ≤100
 * 要求：时间复杂度O(nm)
 *
 * [[1,3,5,9],[8,1,3,4],[5,0,6,1],[8,8,4,0]]
 * 12
 *
 * [[1,2,3],[1,2,3]]
 * 7
 *
 */
public class MinPathSumMatrix {

    /**
     * 方法1：动态规划
     *
     * 知识点：动态规划
     *
     * 思路：
     *
     * dp[i][j]=min(dp[i-1][j]+dp[i][j-1])+grid[i][j];
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(mn)，单独遍历矩阵的一行一列，然后遍历整个矩阵
     * 空间复杂度：O(mn)，辅助矩阵dp为二维数组
     *
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        // 矩阵行数
        int n = matrix.length;
        // 矩阵列数
        int m = matrix[0].length;
        // 定义二维数组，dp[i][j]表示以当前i，j位置为终点的最短路径长度
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = matrix[0][0];
        // 处理第一列
        for (int i = 1; i < n; i++){
            dp[i][0] = matrix[i][0] + dp[i - 1][0];
        }
        // 处理第一行
        for (int j = 1; j < m; j++){
            dp[0][j] = matrix[0][j] + dp[0][j - 1];
        }
        // 其余是公式
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++){
                dp[i][j] = matrix[i][j] + (dp[i - 1][j] > dp[i][j - 1] ? dp[i][j - 1] : dp[i - 1][j]);
            }
        }
        return dp[n - 1][m - 1];
    }
}
