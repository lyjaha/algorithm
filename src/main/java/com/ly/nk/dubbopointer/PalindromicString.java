package com.ly.nk.dubbopointer;

/**
 *  BM88 判断是否为回文字符串
 *
 *  描述；
 *  给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
 * 字符串回文指该字符串正序与其逆序逐字符一致。
 *
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * "absba"
 * true
 *
 * "ranko"
 * false
 *
 * "yamatomaya"
 * false
 *
 * "a"
 * true
 *
 */
public class PalindromicString {

    /**
     * 方法1：首尾依次比较法
     *
     * 知识点：双指针
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean isPalindrome (String str) {

        // 转换为小写，去除非字母和数字的字符
//        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (str != null && str.length() != 0){
            return false;
        }
        // 首指针
        int left = 0;
        // 尾指针
        int right = str.length() - 1;

        //首尾往中间靠
        while (left < right) {
            //比较前后是否相同
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        PalindromicString test = new PalindromicString();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama")); // 输出true
        System.out.println(test.isPalindrome("race a")); // 输出false
    }

}
