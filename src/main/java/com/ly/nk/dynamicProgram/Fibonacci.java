package com.ly.nk.dynamicProgram;

/**
 *  BM62 斐波那契数列
 *
 *  描述：
 *  大家都知道斐波那契数列，现在要求输入一个正整数 n ，请你输出斐波那契数列的第 n 项。
 *
 *  数据范围：1 ≤ n ≤ 40
 *  要求：空间复杂度 O(1)，时间复杂度 O(n) ，本题也有时间复杂度 O(logn) 的解法
 *
 *  输入：4
 *  返回值：3
 *  说明：根据斐波那契数列的定义可知，fib(1)=1,fib(2)=1,fib(3)=fib(3-1)+fib(3-2)=2,
 *  fib(4)=fib(4-1)+fib(4-2)=3，所以答案为3。
 *
 */
public class Fibonacci {

    /**
     * 方法1：迭代相加
     *
     * 知识点：动态规划
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param n int整型
     * @return int整型
     */
    public int fibonacci (int n) {

        if (n <= 1){
            return n;
        }
        int pre1 = 0, pre2 = 1, cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
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
     *
     *
     * @param n int整型
     * @return int整型
     */
    public int fibonacci2 (int n) {
        if (n <= 1){
            return n;
        }
        return fibonacci2(n - 1) + fibonacci(n - 2);
    }

    /**
     * 方法3：动态规划优化
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param n int整型
     * @return int整型
     */
    public int fibonacci3 (int n) {
        if (n <= 1){
            return n;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
