package com.ly.nk.recursion;

/**
 *  BM61 矩阵最长递增路径
 *  描述
 * 给定一个 n 行 m 列矩阵 matrix ，矩阵内所有数均为非负整数。 你需要在矩阵中找到一条最长路径，使这条路径上的元素是递增的。并输出这条最长路径的长度。
 * 这个路径必须满足以下条件：
 *
 * 1. 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外。
 * 2. 你不能走重复的单元格。即每个格子最多只能走一次。
 *
 * 数据范围：1≤n,m≤1000，0≤matrix[i][j]≤1000
 * 进阶：空间复杂度O(nm) ，时间复杂度O(nm)
 *
 * 例如：当输入为[[1,2,3],[4,5,6],[7,8,9]]时，对应的输出为5，
 *
 *
 */
public class MatrixIncrementPath {

    /**
     * 方法1：深度优先搜索
     *
     * 知识点：深度优先搜索（dfs）
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * 递增路径的最大长度
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    public int solve (int[][] matrix) {
        // todo
        return 0;
    }


    /**
     * 方法2：广度优先搜索
     *
     * 知识点：广度优先搜索（bfs）
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * 递增路径的最大长度
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    public int solve2 (int[][] matrix) {
        // todo
        return 0;
    }


    /**
     * 方法3：动态规划
     *
     * 知识点：
     *
     * 思路：
     * 这道题可以使用动态规划来解决。我们可以定义一个二维数组dp来记录从(i,j)出发所能走到的最长路径长度。
     * 递推式为：dp[i][j] = max(dp[i][j], dp[x][y] + 1)，其中(x,y)表示可以到达(i,j)的邻接点，
     * 且matrix[x][y] <[i][j]。因为我们是在递增的路径上寻找最长路径，因此只需要比较(x,y)和(i,j)的大小关系
     * 即可判断是否能到达。
     * 在计算dp数组的时候，我们可以使用深度优先搜索，对于每个节点的邻接点进行递归搜索，同时把每个节点的最长路径长度保存在
     * 数组dp中。最终dp数组中最大值即为所求最长递增路径长度。
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * 递增路径的最大长度
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; // 定义四个方向数组

    public int solve3 (int[][] matrix) {

        // 特判如果矩阵为空，则返回0
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        // 获取矩阵的行数和列数
        int m = matrix.length, n = matrix[0].length;
        // 定义dp数组，初始值为0
        int[][] dp = new int[m][n];
        // 定义最长递增路径长度，初始值为0
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // 通过dfs更新dp数组，同时记录最大值
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }
        // 返回最递增路径长度
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {

        // 如果dp[i][j]已经计算出来了，则直接返回
        if(dp[i][j] != 0)
            return dp[i][j];

        // 最长路径初始值为1（即从自己出发，长度为1）
        int max = 1;

        // 遍历四个方向
        for(int[] dir : dirs){
            int x = i + dir[0], y = j + dir[1];
            // 如果超出边界或者邻点的值不大于当前节点，则跳过
            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])
                continue;

            // 对邻接点进行递归搜索，更新最长路径长度
            int len = 1 + dfs(matrix, x, y, dp);
            // 取当前节点所有邻接点中的最大值
            max = Math.max(max, len);
        }
        // 将当前节点的最长路径长度保存在dp数组中
        dp[i][j] = max;

        return max;
    }
}
