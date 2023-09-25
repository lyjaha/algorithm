package com.ly.leetcode.hot100.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  438. 找到字符串中所有字母异位词
 *
 *  给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *  异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *  输入: s = "cbaebabacd", p = "abc"
 *  输出: [0,6]
 *  解释:
 *  起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 *  起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  输入: s = "abab", p = "ab"
 *  输出: [0,1,2]
 *  解释:
 *  起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 *  起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 *  起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 */
public class FindAnagrams {

    /**
     * 方法1：滑动窗口
     *
     * 知识点：
     *
     * 思路：
     * 1.首先需要确定什么是异位词。异位词是指两个字符串中字符相同，但排列顺序不同的字符串。
     * 2.可以使用滑动窗口的方法来解决这个问题。滑动窗口的大小与p的长度相同，通过移动窗口在s上遍历，判断窗口内的字符串
     *   是否是p的异位词。
     * 3.使用两个数组来记录窗口和目标字符串p中每个字符的出现次数，通过比较这两个数组来确定窗口内的字符串是否是p的异位词。
     *
     * 步骤：
     * 1.创建一个HashMap来记录目标字符串p中每个字符的出现次数，键为字符，值为出现次数。
     * 2.初始化窗口的左边界start和右边界end为0，计数器count为p的长度。
     * 3.遍历字符串s，使用end指针向右扩展窗口：
     *   如果当前字符s.charAt(end)存在于HashMap中，则将其出现次数减1，如果减至0，则count减1。
     *   将end指针向右移动一位。
     *   如果count等于0，说明窗口内的字符串是p的异位词，将start添加到结果列表中。
     * 4.当end - start等于p的长度时，说明窗口大小已经达到p的长度，需要移动窗口的左边界：
     *   如果左边界字符存在于HashMap中，则将其出现次数加1，如果加至1，则count加1。
     *   将start指针向右移动一位。
     * 5.重复步骤3和4，直到end遍历完字符串s。
     * 6.返回结果列表。
     *
     * 时空复杂度：
     * 时间复杂度：该算法的时间复杂度为O(n)，其中n为字符串s的长度。在主循环中，我们只遍历了一次字符串s。
     * 空间复杂度：该算法的空间复杂度为O(1)，因为使用了固定大小的HashMap来记录目标字符串p中每个字符的出现次数，
     * 所需的额外空间与p的长度相关。
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> charCounts = new HashMap<>();

        // 记录目标字符串p中每个字符的出现次数
        for (char c : p.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int count = p.length();
        while (end < s.length()) {

            char endChar = s.charAt(end);

            // 如果当前字符存在于HashMap中，则将其出现次数减1，如果减至0，则count减1
            if (charCounts.containsKey(endChar)) {
                charCounts.put(endChar, charCounts.get(endChar) - 1);
                if (charCounts.get(endChar) >= 0) {
                    count--;
                }
            }
            end++;

            // 如果count等于0，说明窗口内的字符串是p的异位词，将start添加到结果列表中
            if (count == 0) {
                result.add(start);
            }

            // 当窗口大小等于p的长度时，移动窗口的左边界
            if (end - start == p.length()) {
                char startChar = s.charAt(start);

                // 如果左边界字符存在于HashMap中，则将其出现次数加1，如果加至1，则count加1
                if (charCounts.containsKey(startChar)) {
                    charCounts.put(startChar, charCounts.get(startChar) + 1);
                    if (charCounts.get(startChar) > 0) {
                        count++;
                    }
                }
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println("Anagram Substring Indices: " + result);
    }
}
