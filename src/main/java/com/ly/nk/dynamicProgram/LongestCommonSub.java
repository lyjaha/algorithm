package com.ly.nk.dynamicProgram;

/**
 *  BM65 最长公共子序列(二)
 *
 *  描述：
 *   给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则返回"-1"。
 *   目前给出的数据，仅仅会存在一个最长的公共子序列
 *
 *  数据范围：0 ≤ ∣str1∣,∣str2∣ ≤ 2000
 *  要求：空间复杂度O(n的2次方) ，时间复杂度O(n的2次方)
 *
 *  "1A2C3D4B56","B1D23A456A"
 *  "123456"
 *
 *  "abc","def"
 *  "-1"
 *
 *  "abc","abc"
 *  "abc"
 *
 *  "ab",""
 *  "-1"
 *
 *
 */
public class LongestCommonSub {

    /**
     * 方法1：动态规划+递归获取
     *
     * 知识点：动态规划
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    private String x = "";
    private String y = "";

    public String longestCommonSub (String s1, String s2) {
        //特殊情况
        if (s1.length() == 0 || s2.length() == 0){
            return "-1";
        }

        int len1 = s1.length();
        int len2 = s2.length();

        x = s1;
        y = s2;

        //dp[i][j]表示第一个字符串到第i位，第二个字符串到第j位为止的最长公共子序列长度
        int[][] dp = new int[len1 + 1][len2 + 1];

        //动态规划数组相加的方向
        int[][] b = new int[len1 + 1][len2 + 1];

        //遍历两个字符串每个位置求的最长长度
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++){
                //遇到两个字符相等
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //考虑由二者都向前一位
                    dp[i][j] = dp[i -1][j - 1] + 1;
                    //来自于左上方
                    b[i][j] = 1;
                //遇到的两个字符不同
                }else {
                    //左边的选择更大，即第一个字符串后退一位
                    if (dp[i - 1][j] > dp[i][j - 1]){
                        dp[i][j] = dp[i - 1][j];
                        //来自于左方
                        b[i][j] = 2;
                    //右边的选择更大，即第二个字符串后退一位
                    }else {
                        dp[i][j] = dp[i][j - 1];
                        //来自于上方
                        b[i][j] = 3;
                    }
                }
            }
        }
        //获取答案字符串
        String res = getLongestCommonSub(len1, len2, b);
        //检查答案是否位空
        if (res.isEmpty()){
            return "-1";
        }else {
            return res;
        }
    }

    //获取最长公共子序列
    private String getLongestCommonSub(int i, int j, int[][] b) {

        String res = "";
        //递归终止条件
        if (i == 0 || j == 0){
            return res;
        }

        //根据方向，往前递归，然后添加本级字符
        if (b[i][j] == 1) {
            res += getLongestCommonSub(i - 1, j - 1, b);
            res += x.charAt(i - 1);
        } else if (b[i][j] == 2) {
            res += getLongestCommonSub(i - 1, j, b);
        } else if (b[i][j] == 3) {
            res += getLongestCommonSub(i, j - 1, b);
        }
        return res;
    }

    /**
     * 方法2：动态归划+栈获取
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String longestCommonSub2 (String s1, String s2) {
        //TODO
        return "";
    }
}
