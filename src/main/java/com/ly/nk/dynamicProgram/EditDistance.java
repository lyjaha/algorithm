package com.ly.nk.dynamicProgram;

/**
 *  BM75 编辑距离(一)
 *
 *  描述：
 *  给定两个字符串 str1 和 str2 ，请你算出将 str1 转为 str2 的最少操作数。
 *  你可以对字符串进行3种操作：
 *  1.插入一个字符
 *  2.删除一个字符
 *  3.修改一个字符。
 *
 *  字符串长度满足 1≤n≤1000  ，保证字符串中只出现小写英文字母。
 *
 *  "nowcoder","new"
 *  6
 *  "nowcoder" => "newcoder"(将'o'替换为'e')，修改操作1次
 *  "nowcoder" => "new"(删除"coder")，删除操作5次
 *
 *  "intention","execution"
 *  5
 *  一种方案为:
 * 因为2个长度都是9，后面的4个后缀的长度都为"tion"，于是从"inten"到"execu"逐个修改即可
 *
 * "now","nowcoder"
 *  5
 *
 */
public class EditDistance {

    /**
     * 方法1：动态规划
     *
     * 知识点：
     *
     * 思路：
     * 题目要求将 str1 转换成 str2 的最少操作数，可以使用动态规划求解。设 dp[i][j] 表示将 str1 中前 i 个字符
     * 转换成 str2 中前 j 个字符的最少操作数。则可根据 str1[i-1] 和 str2[j-1] 的关系，分三种情况讨论：
     *
     * 如果 str1[i-1] == str2[j-1]，则不需要进行任何操作，即 dp[i][j] = dp[i-1][j-1]。
     *
     * 如果 str1[i-1] != str2[j-1]，则需要进行至少一次操作，可以选择以下三种操作之一：
     *
     * a. 插入一个字符：需要将 str1 中前 i 个字符转换成 str2 中前 j-1 个字符，然后再插入一个字符，
     * 即 dp[i][j] = dp[i][j-1] + 1。
     *
     * b. 删除一个字符：需要将 str1 中前 i-1 个字符转换成 str2 中前 j 个字符，然后再删除一个字符，
     * 即 dp[i][j] = dp[i-1][j] + 1。
     *
     * c. 修改一个字符：需要将 str1 中前 i-1 个字符转换成 str2 中前 j-1 个字符，然后将 str1[i-1] 修改为 str2[j-1]，
     * 即 dp[i][j] = dp[i-1][j-1] + 1。
     *
     * 对于三种操作中的最小值，即 dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1。
     *
     * 最后的答案为 dp[m][n]，其中 m 和 n 分别为 str1 和 str2 的长度。可以通过填充 dp 数组，从 dp[0][0] 转移而来，
     * 一直到 dp[m][n]，得到最少操作数。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度为 O(mn)，空间复杂度为 O(mn)，其中，m 和 n 分别为 str1 和 str2 的长度。
     *
     *
     * @param str1 string字符串
     * @param str2 string字符串
     * @return int整型
     */
    public static int editDistance (String str1, String str2) {

        int m = str1.length();
        int n = str2.length();
        //初始化dp数组,多一行多一列作为边界条件
        int[][] dp = new int[m + 1][n + 1];

        // 注意：i从0开始，dp[i][0]表示将str1中前i个字符变为空字符串的最小操作数，即删除i个字符
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // 同理，dp[0][j]表示将str2中前j个字符变为空字符串的最小操作数，即插入j个字符
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 填充dp数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++){
                // 当前字符相同，不需要操作
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    // 当前字符不同，需要进行“插入”、“删除”或“修改”操作，取最小值
                    dp[i][j] = Math.min(dp[i][j - 1],Math.min(dp[i - 1][j],dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        int res = editDistance(str1, str2);
        System.out.println(res); // output: 5
    }
}
