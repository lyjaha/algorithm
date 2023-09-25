package com.ly.leetcode.hot100.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 *  3. 无重复字符的最长子串
 *  给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  输入: s = "abcabcbb"
 *  输出: 3
 *  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *  输入: s = "bbbbb"
 *  输出: 1
 *  解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *  输入: s = "pwwkew"
 *  输出: 3
 *  解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LongestSubString {

    /**
     * 方法1：滑动窗口
     *
     * 知识点：滑动窗口
     *
     * 思路：
     *
     * 步骤：
     * 1.使用滑动窗口来遍历字符串s，窗口的左边界由start表示，右边界由end表示。
     * 2.遍历过程中，使用HashMap来存储字符及其在字符串中的索引位置。
     * 3.如果当前字符已经在窗口中存在（即在HashMap中已经有对应的键值对），则更新窗口的起始位置start。
     *   更新规则为将start更新为当前重复字符的索引位置+1，以确保窗口内的字符都是不重复的。
     * 4.将当前字符及其索引位置加入到HashMap中。
     * 5.更新最长子串的长度maxLength，即取当前窗口的长度和之前的maxLength的最大值。
     * 6.循环结束后，返回最长不含重复字符的子串长度maxLength。
     *
     * 时空复杂度：
     * 时间复杂度：该算法的时间复杂度为O(n)，其中n为字符串s的长度。只需遍历一次字符串s，并通过HashMap来判断字符是否重复，
     * HashMap的操作的时间复杂度为O(1)。
     * 空间复杂度：该算法的空间复杂度为O(min(m, n))，其中n为字符串s的长度，m为字符集的大小。在最坏情况下，
     * 整个字符串s中的字符都不重复，此时HashMap需要存储n个字符及其索引位置，因此空间复杂度为O(n)。
     * 但由于字符集的大小通常是固定的，例如ASCII字符集有256个字符，因此我们可以将空间复杂度简化为O(1)。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        // 创建一个HashMap来存储字符和它们在字符串中的索引位置
        Map<Character, Integer> map = new HashMap<>();

        // 最长子串的长度
        int maxLength = 0;

        // 滑动窗口的起始位置
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            // 如果字符已经在窗口中存在，则更新窗口的起始位置
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }

            // 将字符及其索引位置加入到HashMap中
            map.put(c, end);

            // 更新最长子串的长度
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println("最长不含重复字符的子串长度为：" + length);
    }

    /**
     *  代码模板
     *
     * 当解决这个问题时，可以使用滑动窗口的方法来找出最长的不含重复字符的子串。下面是滑动窗口的代码模板：
     *
     * public int lengthOfLongestSubstring(String s) {
     *     int n = s.length();
     *     Set<Character> set = new HashSet<>();
     *     int maxLength = 0, start = 0, end = 0;
     *
     *     while (start < n && end < n) {
     *         char c = s.charAt(end);
     *         if (!set.contains(c)) {
     *             set.add(c);
     *             end++;
     *             maxLength = Math.max(maxLength, end - start);
     *         } else {
     *             set.remove(s.charAt(start));
     *             start++;
     *         }
     *     }
     *
     *     return maxLength;
     * }
     *
     * 这个代码模板使用了两个指针（start和end）和一个HashSet（set）。指针start和end表示滑动窗口的左边界和右边界，
     * HashSet用于存储窗口中的字符。
     *
     * 代码的执行过程如下：
     * 1. 初始化指针start和end为0，HashSet为空集，最大子串长度maxLength为0。
     * 2. 当end小于字符串长度n时，执行以下步骤：
     *    - 获取字符s[end]。
     *    - 如果字符s[end]不在HashSet中，表示当前窗口中没有重复字符，因此将字符加入HashSet，同时更新end和maxLength。
     *    - 如果字符s[end]在HashSet中，表示当前窗口中有重复字符，因此需要移动窗口的左边界。将字符s[start]从HashSet
     *      中移除，同时更新start。
     * 3. 返回最大子串长度maxLength。
     *
     * 这个代码模板的时间复杂度为O(n)，其中n为字符串s的长度。在最坏情况下，每个字符都需要被访问两次（start和end各一次），
     * 而HashSet的插入和删除操作的时间复杂度均为O(1)。
     *
     */
}
