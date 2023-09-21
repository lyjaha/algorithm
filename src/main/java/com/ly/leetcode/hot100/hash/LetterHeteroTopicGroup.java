package com.ly.leetcode.hot100.hash;

import java.util.*;

/**
 *  49. 字母异位词分组
 *
 *  给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *  字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *  strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 *  [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 *  strs = [""]
 *  [[""]]
 *
 *  strs = ["a"]
 *  [["a"]]
 *
 */
public class LetterHeteroTopicGroup {

    /**
     * 方法1：排序
     *
     * 知识点：
     *
     * 思路：
     * 1.创建一个HashMap，用于将排序后的异位后的异位词作为键，将原始字符串作为值。
     * 2.遍历字符串数组，对于每个字符串，将其转换为字符数组并进行排序，得到排序后的字符串。
     * 3.检查HashMap中是否存在排序后的字符串作为键，如果存在，则将原始字符串添加到对应的值列表中；
     * 如果不存在，则创建一个新的键值对。
     * 4.最后，遍历HashMap的值集合，将每个值列表添加到结果列表中。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(nklogk)，其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度。
     * 需要遍历 n 个字符串，对于每个字符串，需要 O(klogk) 的时间进行排序以及 O(1) 的时间更新哈希表，
     * 因此总时间复杂度是 O(nklogk)。
     *
     * 空间复杂度：O(nk)，其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度。
     * 需要用哈希表存储全部字符串。
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 将字符串转换为字符数组
            char[] array = str.toCharArray();
            // 对字符数组进行排序
            Arrays.sort(array);
            // 将排序后的字符数组转换为字符串，作为哈希表的键
            String key = new String(array);
            // 获取键对应的列表，如果键不存在，则创建一个新的列表
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            // 将当前字符串添加到列表中
            list.add(str);
            // 更新哈希表中的键值对
            map.put(key, list);
        }
        // 将哈希表中的值转换为列表并返回
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
