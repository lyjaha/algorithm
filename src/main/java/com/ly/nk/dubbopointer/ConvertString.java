package com.ly.nk.dubbopointer;

/**
 *  BM91 反转字符串
 *
 *  描述：
 *  写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 *  要求：空间复杂度 O(n)，时间复杂度 O(n)
 *
 *  "abcd"
 *  "dcba"
 *
 *  ""
 *  ""
 *
 */
public class ConvertString {

    /**
     * 方法1：双指针交换
     *
     * 知识点：双指针
     *
     * 思路：
     * 字符串反转即逆序，前后顺序是反的，也就是前面的字符换到了后面，后面的字符换到了前面，
     * 那既然这样我们就将前后的顺序依次对称交换，这时候就需要使用到了对撞双指针，从前后同时遍历。
     *
     * 步骤：
     *  1：准备两个指针，从字符串一首一尾同时出发。
     *  2：每次交换二者指向的字符，直到二者相遇，这样刚好可以将字符串首尾交换，完成反转。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，n为字符串长度，一共循环n/2次
     * 空间复杂度：O(1)，常数级变量，没有使用额外辅助空间
     *
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String reverseString (String str) {
        //将字符串转化为字符数组
        char[] s = str.toCharArray();

        //初始化双指针
        int left = 0;
        int right = str.length() - 1;

        // 当左指针小于右指针时
        while (left < right) {
            char temp = s[left];
            //交换位置
            s[left] = s[right];
            s[right] = temp;
            // 左指针向右移动
            left++;
            // 右指针向左移动
            right--;
        }
        return new String(s);
    }


    /**
     * 方法2：逆序拼接
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，n为字符串的长度，一次遍历
     * 空间复杂度：O(n)，stringBuilder 对象来存储反转后的字符串.
     *
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String reverseString2 (String str) {

        StringBuilder stringBuilder = new StringBuilder();

        // 从字符串的最后一个字符开始遍历
        for (int i = str.length() - 1; i > 0 ; i--) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ConvertString convertString = new ConvertString();
        String s = "Hello, World!";
        String result = convertString.reverseString(s);
        System.out.println(result);
        // 输出 "!dlroW ,olleH"
    }
}
