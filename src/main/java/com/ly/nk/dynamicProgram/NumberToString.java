package com.ly.nk.dynamicProgram;

/**
 *  BM69 把数字翻译成字符串
 *
 *  描述：
 *  有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 *
 *  现在给一串数字，返回有多少种可能的译码结果
 *
 *  数据范围：字符串长度满足 0<n≤90
 *  进阶：空间复杂度 O(n)，时间复杂度 O(n)
 *
 *  "12"
 *  2
 *
 *  "31717126241541717"
 *  192
 *
 */
public class NumberToString {

    /**
     * 方法1：动态规划
     *
     * 知识点：动态规划
     *
     * 思路：
     * 我们可以定义 dp[i],表示前 i 位数字共有多少种译法,接下来，我们考虑如何转移。
     *
     * 当前字符是0（且不是字符串s的第1位）时，必须要和前面一位组合在一起考虑（
     * 因为0只能与1或者2组成一个有效的字母，其它组合都不合法，因为无有效字母来表示），此时:
     * dp[i] =  dp[i-2]
     *
     * 当前字符不是0（且不是字符串s的第1位）时，如果前一位是0，那么当前数字无法单独表示一个字符无法增加序列总和，此时:
     * dp[i] =  dp[i-1]
     *
     * 如果前一位不是0，并且组成的两位数在[1,26]之间，那么当前数字可以参与两种方案的解码总数，分别是：
     * dp[i] = dp[i-1] + dp[i-2]
     * 其中，dp[i-1]表示当前字符独解码，dp[i-2]表示该字符与前一个字符组成一个字母解码。
     *
     * 最终的答案是 d[p]，其中 n 是给定字符串的长度。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，两次遍历都是单层
     * 空间复杂度：O(n)，辅助数组dp
     *
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    public static int solve (String nums) {

        // 判断字符串nums是否null或长度为0
        if(nums == null || nums.length() == 0){
            return 0;
        }

        int n = nums.length();
        int[] dp = new int[n + 1];

        // 边界为1
        // 初始化为1，表示空字符串有1种解码方式（因为假设给出的字符串只包含数字，因此0不可以单独解码为一个字符）
        dp[0] = 1;
        // 边界为字符串中第一位
        // 初始化为1，表示只有1个字符“0”时没有解码方式，否则有1种解码方式
        dp[1] = nums.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            // 取出当前字符和前一个字符连起来组成的字符串，转化整数
            int one = Integer.valueOf(nums.substring(i - 1,i));

            // 当前位不为0时可以单独解码成一个字母
            if (one != 0) {
                dp[i] += dp[i - 1];
            }

            // 取出当前位和前位
            int two = Integer.valueOf(nums.substring(i - 2, i));

            // 判断前面2个字符是否可以组成一个合法的2位数
            if (two >= 10 && two <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumberToString numberToString = new NumberToString();
        String s1 = "12";
        System.out.println(numberToString.solve(s1));


    }
}
