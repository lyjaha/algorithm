package com.ly.nk.recursion;

import java.util.ArrayList;

/**
 *  BM60 括号生成
 *
 *  描述
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())"
 *
 * 数据范围：0≤n≤10
 * 要求：空间复杂度 O(n)，时间复杂度 O(2的n次方)
 *
 * 1
 * ["()"]
 *
 * 2
 * ["(())","()()"]
 *
 */
public class ParenthesesGener {

    /**
     * 方法1：
     *
     * 知识点：
     *
     * 思路：
     * 该问题可通过回溯算法解决。回溯算法通过递归的方式，枚举可能的解，然后用剪枝来提高效率。对于本问题，
     * 我们可以将其转化为在一个长度为2n的字符串中寻找合法的括号排列。每次递归时，我们在字符串的当前位置添加一个左括号或右括号，
     * 并进行下一次递归。当左括号的数量小于 n ，可以添加左括号；当右括号的数量小于左括号时，可以添加右括号。
     * 当左括号和右括号数量都等于 n 时，得到一个合法的解，将其添加到结果集中。在实现时，
     * 我们可以使用一个字符串和两个数器来分别记录当前已经添加的字符串、左括号和右括号的数量。
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> res = new ArrayList<>();
        // 从第 0 个字符开始搜索
        backtrack(0, 0, "", res, n);

        return res;
    }

    private void backtrack(int left, int right, String temp, ArrayList<String> res, int n) {

        //左右括号都用完了，就加入结果
        if(left == n && right == n){
            res.add(temp);
            return;
        }
        //使用一次左括号
        if(left < n){
            backtrack(left + 1, right, temp + "(", res, n);
        }
        //使用右括号个数必须少于左括号
        if(right < n && left > right){
            backtrack(left, right + 1, temp + ")", res, n);
        }
    }

    public static void main(String[] args) {
        ParenthesesGener parenthesesGener = new ParenthesesGener();
        int n = 3;
        ArrayList<String> res = parenthesesGener.generateParenthesis(n);
        System.out.println(res.toString()); // 打印结果
    }
}
