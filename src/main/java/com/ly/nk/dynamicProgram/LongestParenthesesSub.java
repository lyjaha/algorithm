package com.ly.nk.dynamicProgram;

/**
 *  BM77 最长的括号子串
 *
 *  描述：
 *  给出一个长度为 n 的，仅包含字符 '(' 和 ')' 的字符串，计算最长的格式正确的括号子串的长度。
 *
 * 例1: 对于字符串 "(()" 来说，最长的格式正确的子串是 "()" ，长度为 2 .
 * 例2：对于字符串 ")()())" , 来说, 最长的格式正确的子串是 "()()" ，长度为 4 .
 *
 * 字符串长度：0 ≤ n ≤ 5∗10的5次方
 * 要求：时间复杂度 O(n) ,空间复杂度 O(n).
 *
 * "(()"
 * 2
 *
 * "(())"
 * 4
 */
public class LongestParenthesesSub {

    /**
     * 方法1：栈
     *
     * 知识点：栈
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为字符串长度，遍历整个字符串
     * 空间复杂度：O(n)，最坏全是左括号，栈的大小为 n
     *
     *
     * @param s string字符串
     * @return int整型
     */
    public int longestValidParentheses (String s) {

        // 定义最大长度为 0，表示目前还未找到符合条件的子串
        int maxLen = 0;
        //长度为0的串或者空串，返回0
        if (s == null || s.length() == 0) {
            return maxLen;
        }
        int n = s.length();
        //TODO
        return 1;
    }

    /**
     * 方法2：动态规划
     *
     * 知识点：动态规划
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为字符串长度，遍历一次字符串
     * 空间复杂度：O(n)，动态规划辅助数组的长度为n
     *
     *
     * @param s string字符串
     * @return int整型
     */
    public int longestValidParentheses2 (String s) {
        // 定义最大长度为 0，表示目前还未找到符合条件的子串
        int maxLen = 0;
        //长度为0的串或者空串，返回0
        if (s == null || s.length() == 0) {
            return maxLen;
        }
        int n = s.length();
        //dp[i]表示以下标为i的字符为结束点的最长合法括号长度
        int[] dp = new int[n];
        //第一位不管是左括号还是右括号都是0，因此不用管
        for (int i = 1; i < n; i++){
            //取到左括号记为0，有右括号才合法
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '(') {
                    // i >= 2 是为了保证 dp[i-2] 有效
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = (i - dp[i - 1] > 1 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;

                    // ((i - dp[i - 1]) >= 2) 是为了保证 dp[i - dp[i - 1] - 2] 有效
//                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
