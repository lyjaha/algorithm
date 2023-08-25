package com.ly.nk.dynamicProgram;

/**
 *  BM66 最长公共子串
 *  给定两个字符串str1和str2,输出两个字符串的最长公共子串
 *  题目保证str1和str2的最长公共子串存在且唯一。
 *
 *  数据范围：1 ≤ ∣str1∣,∣str2∣ ≤ 5000
 *
 *  要求：空间复杂度O(n的2次方) ，时间复杂度O(n的2次方)
 *
 *  "1AB2345CD","12345EF"
 *  "2345"
 *
 *
 */
public class LongestCommonStr {

    /**
     * 方法1：动态规划
     *
     * 知识点：动态规划
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String longestCommonStr (String str1, String str2) {

        int len1 = str1.length();
        int len2 = str2.length();

        //定义dp数组(+1是为了防止边界条件判断 和 减少初始化当 i 或 j 等于 0 时，初始化子串就是为0，初始化数组也是为0)
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化最长公共子串的起点和终点
        int start = 0, end = 0;

        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++) {
                // 当前字符相等
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    // 更新状态
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // 更新最长公共子串的起点和终点
                    if (dp[i][j] > end - start + 1){
                        start = i - dp[i][j];
                        end = i - 1;
                    }
                }else {
                    // 长度清0，表示不存在公共子串
                    dp[i][j] = 0;
                }
            }
        }
        // 最长公共子串为空
        if (end < start) {
            return "-1";
        }
        return str1.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LongestCommonStr s = new LongestCommonStr();
        String str1 = "AB2345CD", str2 = "12345EF";
        System.out.println(s.longestCommonStr(str1, str2)); // 预期输出："2345"
    }

}
