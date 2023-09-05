package com.ly.nk.recursion;

/**
 *  BM59 N皇后问题
 *
 *  描述：
 *  N 皇后问题是指在 n * n 的棋盘上要摆 n 个皇后，
 *  要求：任何两个皇后不同行，不同列也不在同一条斜线上，
 *  求给一个整数 n ，返回 n 皇后的摆法数。
 *
 * 数据范围:1≤n≤9
 * 要求：空间复杂度O(1) ，时间复杂度O(n!)
 *
 * 例如当输入4时，对应的返回值为2，
 * 对应的两种四皇后摆位如下图所示：
 *
 * 1
 * 1
 *
 * 8
 * 92
 *
 */
public class Nqueen {

    /**
     * 方法1：递归 + 回溯
     *
     * 知识点：
     *
     * 思路：
     * 该问题可使用回溯算法解决。回溯算法通过递归的方式，枚举可能的解，然后通过剪枝来提高效率。对于 N 皇后问题，
     * 我们可以将其看作是一个在棋盘上寻找可行解的过程。我们从第一行开始，逐个尝试在该行中合适的列，如果该列可以摆放皇后，
     * 则进行选择，并进入下一行，直到第 n 行找到了一个合法解。然后再回溯到上一层节点，进行下一次选择和剪枝操作，
     * 直到遍历完棋盘的所有节点，即可得到所有的合法解。
     * 其中，如果在某一行中找不到合适的列，就需要回溯到上一行，重新进行选择。对于皇后不能在同一行同一列的限制，
     * 我们可以用一个长度为 n 的一维数组来表示，数组中下标为 i 的值 k 表示 i 行的皇后在第 k 列。当从某一行开始搜索时，
     * 我们尝试在该行当前的每一个列中放置皇后，然后判断是否会和前面已经放置的皇后冲突。如果不冲突，则递归进入下一行寻找合适的列。
     * 如果冲突，则回溯到上一层节点，进行剪枝。
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param n int整型 the n
     * @return int整型
     */
    public int nQueen (int n) {
        // 定义一个一维数组表示皇后所在的位置，下标表示行号，值表示列号
        int[] cols = new int[n];
        int[] count = {0};
        // 从第 0 行开始搜索
        backtrack(0, n, cols, 0, count);
        return count[0];
    }

    private void backtrack(int row, int n, int[] cols, int count, int[] res) {
        // 如果已经找到了 n 个皇后，则增加计数器 count
        if (count == n) {
            res[0] ++;
            return;
        }
        // 逐列尝试
        for (int col = 0; col < n; col++) {
            // 判断当前位置是否合法
            if (isValid(cols, row, col)) {
                // 选择当前位置
                cols[row] = col;
                // 递归进入下一行查找
                backtrack(row + 1, n, cols, count + 1, res);
                // 撤销选择
                cols[row] = -1;
            }
        }
    }

    // 判断当前点是否合法
    private boolean isValid(int[] cols, int row, int col) {
        for (int i = 0; i < row; i++) {
            // 判断列和对角线是否冲突
            if (cols[i] == col || row - i == Math.abs(cols[i] - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Nqueen nqueen = new Nqueen();
        int n = 4;
        int res = nqueen.nQueen(n);
        System.out.println(res);
    }
}
