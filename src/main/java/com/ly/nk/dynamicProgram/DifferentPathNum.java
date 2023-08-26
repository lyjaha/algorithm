package com.ly.nk.dynamicProgram;

/**
 *  BM67 不同路径的数目(一)
 *
 *  描述：
 *  一个机器人在m×n大小的地图的左上角（起点）。
 *  机器人每次可以向下或向右移动。机器人要到达地图的右下角（终点）。
 *  可以有多少种不同的路径从起点走到终点？
 *
 *  数据范围：0 < n, m ≤ 100，保证计算结果在32位整型范围内
 *
 * 要求：空间复杂度 O(nm)，时间复杂度 O(nm)
 * 进阶：空间复杂度 O(1)，时间复杂度 O(min(n,m))
 *
 * 2,1
 * 1
 *
 * 2,2
 * 2
 *
 *
 */
public class DifferentPathNum {


    /**
     * 方法1：动态规划
     *
     * 知识点：动态规划
     *
     * 思路：
     *
     *  dp[i][j] = dp[i-1][j] + dp[i][j-1]。
     *
     * 步骤：
     *  1：用dp[i][j]表示大小为i∗j的矩阵的路径数量，下标从1开始。
     *  2：（初始条件） 当i或者j为1的时候，代表矩阵只有一行或者一列，因此只有一种路径。
     *  3：（转移方程） 每个格子的路径数只会来自它左边的格子数和上边的格子数，因此状态转移为
     * dp[i][j]=dp[i−1][j]+dp[i][j−1]。
     *
     * 时空复杂度：
     * 时间复杂度：O(nm)，其中n和m分别为地图的行数和列数。
     * 空间复杂度：O(nm),辅助空间dp数组为二维数组
     *
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public static int uniquePaths (int m, int n) {

        // 定义DP二维数组
        int[][] dp = new int[m][n];

        //初始化
        for (int i = 0; i < m; i++){
            // 第一列上所有位置的路径总数为1
            dp[i][0] = 1;
        }

        //初始化
        for (int j = 0; j < n; j++){
            // 第一行上所有位置的路径总数为1
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                // 转移方程
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // 返回终点的路径总数
        return dp[m - 1][n - 1];
    }

    /**
     * 方法2：递归
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(mn)，其中m、n分别为矩阵的两边长，递归过程对于每个m最多都要经过每一种n
     * 空间复杂度：O(m+n)，递归栈的最大深度为矩阵两边从 m、n都到了1
     *
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public static int uniquePaths2 (int m, int n) {
        if (m == 1 || n == 1){
            return 1;
        }
        return uniquePaths2(m - 1,n) + uniquePaths2(m, n - 1);

    }

    /**
     * 方法3：组合数学
     *
     * 知识点：
     *
     * 思路：
     * 即利用组合数式C(m+n-2,n-1)或C(m+n-2,m-1)来计算从起点到终点的路径总数。
     * 假设从起点到终点的路径总数为f(m,n)，由于机器人每次只能向下或向右移动，因此到达终点必须向右走n-1步，向下走m-1步，
     * 共需要走m+n-2步。而问题可以转化为，从这些步中选择n-1步向右走，或者选择m-1步向下走，共有多少种选择方式。因此，
     * 该问题的解即为 C(m+n-2,n-1)或C(m+n-2,m-1)。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，计算过程需要从1遍历到n
     * 空间复杂度：O(1)，常数级变量，无额外辅助空间
     *
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public static int uniquePaths3 (int m, int n) {

        // 注意结果可能溢出，需要使用long类型
        long res = 1;
        for(int i = 1; i < n; i++)
            //根据公式计算
            res = res * (m + i - 1) / i;
//            res = res * (m-i) / (i+1);
        return (int)res;
    }



    public static void main(String[] args) {
        DifferentPathNum s = new DifferentPathNum();
        int m = 3, n = 7;
        System.out.println(s.uniquePaths(m, n)); // 预期输出：28
    }

}
