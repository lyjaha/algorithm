package com.ly.nk.dubbopointer;

import java.util.HashMap;
import java.util.Map;

/**
 *  BM90 最小覆盖子串
 *
 *  描述：
 *  给出两个字符串 s 和 t，要求在 s 中找出最短的包含 t 中所有字符的连续子串。
 *
 *  要求：
 *  进阶：空间复杂度 O(n) ， 时间复杂度 O(n)
 *
 *  "XDOYEZODEYXNZ","XYZ"
 *  "YXNZ"
 *
 *  "abcAbA","AA"
 *  "AbA"
 *
 *
 *
 */
public class MinSubString {

    /**
     * 方法1：哈希表匹配
     *
     * 知识点：滑动窗口
     * 滑动窗口是指在数组、字符串、链表等线性结构上的一段，类似一个窗口，而这个窗口可以依次在上述线性结构上
     * 从头到尾滑动，且窗口的首尾可以收缩。我们在处理滑动窗口的时候，常用双指针来解决，左指针维护窗口左界，
     * 右指针维护窗口右界，二者同方向不同速率移动维持窗口。
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param s string字符串
     * @param t string字符串
     * @return string字符串
     */
    public String minWindow (String s, String t) {
        // 初始化指针和窗口大小
        int left = 0, right = 0;
        //匹配字符的数量
        int match = 0;
        int minLen = Integer.MAX_VALUE; // 最小子的长度
        int start = 0; // 最小子串的起始位置
        // 初始化两个 HashMap
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 将 t 中的字符及其数量存入 need 中
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 移动 right 指针扩展窗口
        while (right < s.length()) {
            char c1 = s.charAt(right);
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            // 如果当前窗口中的字符满足需要的数量，则匹配数加一
            if (need.containsKey(c1) && window.get(c1).equals(need.get(c1))) {
                match++;
            }
            // 尝试移动 left 指针缩小窗口
            while (match == need.size()) {
                // 更新最小子串的长度和起始位置
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char c2 = s.charAt(left);
                window.put(c2, window.get(c2) - 1);
                // 如果窗口中删除一个匹配字符不满足需要的数量，则匹配数减一
                if (need.containsKey(c2) && window.get(c2) < need.get(c2)) {
                    match--;
                }
                // 移动 left 指针
                left++;
            }
            // 移动 right 指针
            right++;
        }
        // 如果找不到包含 t 的子串，则返回空字符串
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        // 返回最小子串
        return s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        MinSubString minSubString = new MinSubString();
        String s = "XDOYEZODEYXNZ";
        String t = "XYZ";
        String result = minSubString.minWindow(s, t);
        System.out.println(result);
        // 输出 "YXNZ"
    }
}
