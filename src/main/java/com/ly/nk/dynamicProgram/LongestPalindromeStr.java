package com.ly.nk.dynamicProgram;

/**
 *  BM73 最长回文子串
 *
 *  描述：
 *  对于长度为n的一个字符串A（仅包含数字，大小写英文字母），请设计一个高效算法，计算其中最长回文子串的长度。
 *
 *
 * 数据范围： 1≤n≤1000
 * 要求:空间复杂度 O(1)，时间复杂度 O(n的2次方)
 * 进阶:空间复杂度 O(n)，时间复杂度 O(n)
 *
 * "ababc"
 *  3
 * 最长的回文子串为"aba"与"bab"，长度都为3
 *
 * "abbba"
 *  5
 *
 * "b"
 *  1
 */
public class LongestPalindromeStr {

    /**
     * 方法1：中心扩展法
     *
     * 知识点：贪心思想
     *
     * 思路：
     * 回文串，有左右对称的特征，从首尾一起访问，遇到的元素都是相同的。但是我们这里正是要找最长的回文串，
     * 并不事先知道长度，怎么办？判断回文的过程是从首尾到中间，那我们找最长回文串可以逆着来，从中间延伸到首尾，这就是中心扩展法。
     *
     * 步骤：
     *  1：遍历字符串每个字符。
     *  2：以每次遍历到的字符为中心（分奇数长度和偶数长度两种情况），不断向两边扩展。
     *  3：如果两边都是相同的就是回文，不断扩大到最大长度即是以这个字符（或偶数两个）为中心的最长回文子串。
     *  4：我们比较完每个字符为中心的最长回文子串，取最大值即可。
     *
     * 时空复杂度：
     *
     *
     * @param s string字符串
     * @return int整型
     */
    public static int getLongestPalindrome (String s) {
        int n = s.length();
        if(n < 2) {
            return n;
        }

        // 记录最长回文子串长度
        int maxLen = 1;

        // 枚举所有中心点
        for (int i = 0; i < n - 1; i++){
            //分奇数长度和偶数长度向两边扩展
            maxLen = Math.max(maxLen, Math.max(fun(s, i, i), fun(s, i, i + 1)));
        }
        return maxLen;
    }

    private static int fun(String s, int begin, int end){
        //每个中心点开始扩展
        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        //返回长度
        return end - begin - 1;
    }

    /**
     * 方法2：
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
     * @param str string字符串
     * @return int整型
     */
    public static int getLongestPalindrome2 (String str) {
        //todo
        return 1;
    }
}
