package com.ly.nk.heapStackQueue;

import java.util.Stack;

/**
 *  BM44 有效括号序列
 *
 *  描述：
 *  给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 *  括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 *
 * 数据范围：字符串长度 0≤n≤10000
 * 要求：空间复杂度 O(n)，时间复杂度 O(n)
 *
 *  输入："["
 *  返回值：false
 *
 *  输入："[]"
 *  返回值：true
 *
 */
public class ValidSequence {


    /**
     * 方法1：栈
     *
     * 知识点：栈
     *
     * 思路：
     * 利用栈来匹配括号序列，遍历字符串，当遇到左括号时入栈，当遇到右括号时判断栈顶元素是否与当前右括匹配，匹配则出栈，
     * 不匹配则括号序列不合法。最后如果栈为空，则括号序列合法，否则不合法.
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中 n为字符串长度，遍历整个字符串
     * 空间复杂度：O(n)，最坏情况下需要存储所有的左括号。
     *
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        // 辅助栈
        Stack<Character> stack = new Stack<>();

        // 遍历字符串
//        for (int i = 0; i < s.length(); i++) {
//
//            if (s.charAt(i) == '(') {
//                stack.push(')');
//            } else if (s.charAt(i) == '[') {
//                stack.push(']');
//            } else if (s.charAt(i) == '{') {
//                stack.push('}');
//            } else if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
//                return false;
//            }
//        }
        //
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty() || isMatch(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(char left, char right) {
        return (left == '(' && right == ')') || (left == '{' && right == '}')
                || (left == '[' && right == ']');
    }


    public static void main(String[] args) {
        ValidSequence solution = new ValidSequence();
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        System.out.println(solution.isValid(s1)); // true
        System.out.println(solution.isValid(s2)); // true
        System.out.println(solution.isValid(s3));// false
        System.out.println(solution.isValid(s4)); // false
    }
}
