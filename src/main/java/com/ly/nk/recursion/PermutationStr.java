package com.ly.nk.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  BM58 字符串的排列
 *
 *  描述：
 *  输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
 * 例如输入字符串ABC,则输出由字符A,B,C所能排列出来的所有字符串ABC,ACB,BAC,BCA,CBA和CAB。
 *
 *  数据范围：n<10
 * 要求：空间复杂度 O(n!)，时间复杂度 O(n!)
 *
 * "ab"
 * ["ab","ba"]
 *
 * "aab"
 * ["aab","aba","baa"]
 *
 * "abc"
 * ["abc","acb","bac","bca","cab","cba"]
 *
 * ""
 * [""]
 *
 */
public class PermutationStr {

    /**
     * 方法1：递归+回溯
     *
     * 知识点：
     *
     * 思路：
     * 该问题可使用回溯算法解决。回溯算法通过递归的方式，枚举出可能的解，然后通过剪枝来提高效率。对于字符串的全排列问题，
     * 我们可以将其看作是一个树形结构，树的每个节点表示当前已经选择的字符。我们从根节点开始，依次选择剩余未被选择的字符，
     * 直到选择的字符个数与字符串长度相等，即得到一个字符串的排列。然后再回溯到上一层节点，进行下一次选择和剪枝操作，
     * 直到遍历完树的所有节点，即可得到所有的字符串排列。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n∗n!)，全排列的全部情况为n!，每次递归过程都是遍历字符串查找元素，这里是O(n)
     * 空间复杂度：O(n)，递归栈的最大深度为字符串长度n，临时字符串temp的空间也为 O(n)，res属于返回必要空间
     *
     *
     * @param str string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> permutationStr (String str) {

        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        int len = str.length();
        //转字符数组
        char[] charArray = str.toCharArray();
        // 按字典序排序
        Arrays.sort(charArray);
        //标记每个位置的字符是否被使用过
        boolean[] used = new boolean[len];
        //递归获取
        backtrack(charArray, used, new StringBuilder(), res);
        return res;
    }

    private void backtrack(char[] charArray, boolean[] used, StringBuilder path, ArrayList<String> res) {
        // 递归终止条件
        if (path.length() == charArray.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            // 如果该字符已选择过，进行剪枝
            if (used[i]) {
                continue;
            }

            if (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1]){
                continue;
            }
            // 进行选择
            used[i] = true;
            // 加入临时字符串
            path.append(charArray[i]);
            // 递归
            backtrack(charArray, used, path, res);
            // 恢复状态
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationStr permutationStr = new PermutationStr();
        String s ="ABC";
        ArrayList<String> res = permutationStr.permutationStr(s);
        System.out.println(res);
    }
}
