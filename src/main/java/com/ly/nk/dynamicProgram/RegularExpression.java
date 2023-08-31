package com.ly.nk.dynamicProgram;

/**
 * BM76 正则表达式匹配
 *
 * 描述：
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 1.模式中的字符'.'表示任意一个字符
 * 2.模式中的字符'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配
 *
 * 数据范围:
 * 1.str 只包含从 a-z 的小写字母。
 * 2.pattern 只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 * 3.0≤str.length≤26
 * 4.0≤pattern.length≤26
 *
 *  "aaa","a*a"
 *  true
 *  中间的*可以出现任意次的a，所以可以出现1次a，能匹配上
 *
 *  "aad","c*a*d"
 *  true
 *  因为这里 c 为 0 个，a被重复一次， * 表示零个或多个a。因此可以匹配字符串 "aad"。
 *
 *  "a",".*"
 *  true
 *  ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）
 *
 *  "aaab","a*a*a*c"
 *  false
 */
public class RegularExpression {

    /**
     * 方法1：动态规划
     *
     * 知识点：
     *
     * 思路：
     * 这是一道典型的动态规划问题，我们可以用 dp[i][j] 表示模式串 p 的前 i 个字符与文本串 s 的前 j 个字符是否能匹配。
     *
     * 状态转移方程如下：
     *
     * 当 p[i-1] == s[j-1] 或 p[i-1] == '.' 时，dp[i][j] dp[i-1][j-1]；
     *
     * 当 p[i-1] == '*' 时，需要分两种情况：
     *
     * 匹配 0 次，即忽略 p[i-2] 和 '*'，dp[i][j] = dp[i-2][j]；
     *
     * 匹配 1 次或多次，即 p[i-2] 匹配 s[j-1]，然后 p[i-2] 和 '*' 继续匹配，dp[i][j] = dp[i][j-1]；
     *
     * 其余情况下 dp[i][j] = false；
     *
     * 最终返回 dp[p.length()][s.length()] 即可。
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param str string字符串
     * @param pattern string字符串
     * @return bool布尔型
     */
    public static boolean match (String str, String pattern) {

        int n1 = str.length();
        int n2 = pattern.length();
        //dp[i][j]表示str前i个字符和pattern前j个字符是否匹配
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        // 遍历str
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                // 正则为空
                if (j == 0){
                    dp[i][j] = (i == 0);
                }else {
                    if (pattern.charAt(j - 1) != '*') {
                        //当前字符不为*，用.去匹配或者字符直接相同
                        if(i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')){
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }else {
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j -2];
                        }
                        //若是前一位为.或者前一位可以与这个数字匹配
                        if(i >= 1 && j >= 2 && (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')){
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "aaab";
        String str2 = "a*a*b";
        boolean res = match(str1, str2);
        System.out.println(res); // output: true
    }
}
