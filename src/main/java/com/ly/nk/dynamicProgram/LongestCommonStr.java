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
     * 该法使用动态规划（DP）来解决。我们使用一个二维数组 dp，其中 dp[i][j] 表示以 str1[i-1] 和 str2[j-1]
     * 为结尾的最长公共子串的长度。
     * 当 str1[i-1] == str2[j-1] 时，dp[i][j] = dp[i-1][j-1] + 1。这是由于以 str[i-1] 和 str2[j-1]
     * 为结尾最长公共子串，应该是由 str1[i-2] 和 str[j-2] 结尾的最长公共子串加上 str1[i-1] (或 str2[j-1]) 构成的。
     * 当 str1[i-1] != str2[j-1] 时，dp[i][j] = 0，因为此时以 str[i-1] 和 str2[j-1] 为结尾的最长公共子串不存在。
     * 我们记录最长公共子串的开始下标start和结束下标end，当 dp[i][j] > end-start+1 时，更新start和end。
     * 最后，我们依据start和end可以求出最长公共子串。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(mn)，其中m是str1的长度，n是str2的长度，遍历两个字符串所有字符
     * 空间复杂度：O(mn)，dp数组大小为 m∗n
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String longestCommonStr (String str1, String str2) {

        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return "-1";
        }

        int len1 = str1.length();
        int len2 = str2.length();

        /**
         * 在动态规划中通常会将数组下标偏移一位，这是因为我们需要在dp数组中存储一些初始状态，例如dp[0][0]表示两个空串
         * 的最长公共子串的长度，dp[i][0]和dp[0][j]表示一个字符串空串的最长公共子串的长度。因此，为了让dp数组的下标
         * 能够准确表示相应的字符串中的位置，我们需要将数组下标向右和向下移动一位，这样dp[i][j]就表示以
         * str1[i-1]和str2[j-1]为结尾的最长公共子串的长度。
         *
         * 所以在创建dp数组时，我们需要在原来长度的基础上加1。例如，如果str1的长度为len1，那么我们需要新建长度为
         * len1+1的二维数组dp。
         *
         * 如果不进行偏移，可能会导致数组下标越界或者某些状态无法表示。
         *
         */
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
