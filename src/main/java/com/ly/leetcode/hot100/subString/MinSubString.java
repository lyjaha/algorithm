package com.ly.leetcode.hot100.subString;

import java.util.HashMap;
import java.util.Map;

/**
 *  76. 最小覆盖子串
 *
 *  给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  注意：
 *  对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *  如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *  输入：s = "ADOBECODEBANC", t = "ABC"
 *  输出："BANC"
 *  解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 *  输入：s = "a", t = "a"
 *  输出："a"
 *  解释：整个字符串 s 是最小覆盖子串。
 *
 *  输入: s = "a", t = "aa"
 *  输出: ""
 *  解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 *  因此没有符合条件的子字符串，返回空字符串。
 *
 */
public class MinSubString {

    /**
     * 方法1：滑动窗口
     *
     * 知识点：滑动窗口
     *
     * 思路：
     * 1. 我们可以使用滑动窗口的方法来找到满足条件的最小子串。滑动窗口包含两个指针，即窗口的左边界和右边界。
     * 2. 首先，我们需要统计目标字符串t中每个字符的出现次数，并使用一个哈希表来存储。
     * 3. 接下来，我们遍历字符串s，并使用右边界指针end来扩展窗口。扩展窗口的同时，我们将遇到的字符和其出现次数加入到窗口中的哈希表中。
     * 4. 当窗口中包含了目标字符串t的所有字符（即窗口中的字符出现次数满足要求）时，我们尝试收缩窗口，即移动左边界指针start
     *    来尽量减小窗口的长度且仍满足要求。
     * 5. 在收缩窗口的过程中，我们不断更新最小子串的起始位置和长度。
     * 6. 重复步骤3和4，直到遍历完整个字符串s。
     * 7. 返回最小子串。
     *
     *
     * 步骤：
     * 1. 创建一个哈希表targetMap来统计目标字符串t中每个字符的出现次数。
     * 2. 初始化窗口的左边界start和右边界end为0。
     * 3. 初始化最小子串的起始位置minStart和长度minLen为0和Integer.MAX_VALUE。
     * 4. 初始化计数器count为目标字符串t的长度，表示还需要找到的字符的个数。
     * 5. 遍历字符串s，执行以下步骤：
     *    - 将当前字符s.charAt(end)添加到窗口的哈希表中，并更新哈希表中对应字符的出现次数。
     *    - 如果哈希表中当前字符的出现次数大于等于目标字符串t中对应字符的出现次数，则计数器count减1。
     *    - 当count为0时，表示窗口中包含了目标字符串t的所有字符，尝试收缩窗口。
     *      - 移动左边界指针start，收缩窗口，直到窗口中不再包含目标字符串t的所有字符。
     *      - 在每次收缩窗口时，更新最小子串的起始位置和长度。
     *    - 更新右边界指针end，继续扩展窗口。
     * 6. 返回最小子串，如果未找到满足条件的子串，则返回空字符串。
     *
     * 时空复杂度：
     * - 时间复杂度：该算法的时间复杂度取决于字符串s的长度和字符串t的长度，即O(m+n)，其中m是字符串s的长度，n是字符串t的长度。
     * - 空间复杂度：该算法的空间复杂度为O(n)，其中n是字符串t的长度。我们需要使用哈希表来记录字符串t中每个字符的出现次数，
     *             哈希表的大小与字符串t的长度相关。
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {

        if(s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        // 统计目标字符串t中每个字符的出现次数
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // 窗口的左右边界
        int start = 0, end = 0;
        // 最小子串的起始位置和长度
        int minStart = 0, minLen = Integer.MAX_VALUE;
        // 计数器，表示还需要找到的字符的个数
        int count = t.length();

        while (end < s.length()) {
            char endChar = s.charAt(end);
            // 如果当前字符在目标字符串t的哈希表中出现过，则将其出现次数减1
            if (targetMap.containsKey(endChar)) {
                if (targetMap.get(endChar) > 0) {
                    count--;
                }
                targetMap.put(endChar, targetMap.get(endChar) - 1);
            }
            end++;

            // 当窗口中包含了目标字符串t的所有字符时，尝试收缩窗口
            while (count == 0) {
                // 更新最小子串的起始位置和长度
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }

                char startChar = s.charAt(start);

                // 如果当前字符是目标字符串t中的字符，则将计数器count加1
                if (targetMap.containsKey(startChar)) {
                    targetMap.put(startChar, targetMap.get(startChar) + 1);
                    if (targetMap.get(startChar) > 0) {
                        count++;
                    }
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minSubstring = minWindow(s, t);
        System.out.println("最小子串：" + minSubstring);
    }
}
