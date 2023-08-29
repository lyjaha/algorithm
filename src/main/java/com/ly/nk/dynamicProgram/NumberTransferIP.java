package com.ly.nk.dynamicProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * BM74 数字字符串转化成IP地址
 *
 * 描述
 * 现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
 * 例如：
 * 给出的字符串为"25525522135",
 * 返回["255.255.22.135", "255.255.221.35"]. (顺序没有关系)
 *
 * 数据范围：字符串长度 0≤n≤12
 * 要求：空间复杂度 O(n!),时间复杂度 O(n!)
 *
 * 注意：ip地址是由四段数字组成的数字序列，格式如 "x.x.x.x"，其中 x 的范围应当是 [0,255]。
 *
 *  "25525522135"
 *  ["255.255.22.135","255.255.221.35"]
 *
 *  "1111"
 *  ["1.1.1.1"]
 *
 *  "000256"
 *  []
 *
 */
public class NumberTransferIP {

    /**
     * 方法1：枚举
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public List<String> restoreIpAddresses (String s) {

        List<String> res = new ArrayList<>();

        int n = s.length();

        //遍历IP的点可能的位置（第一个点）
        for (int i = 1; i < 4 && i < n -2; i++){
            //第二个点的位置
            for (int j = i + 1; j < i + 4 && j < n - 1; j++){
                //第三个点的位置
                for (int k = j + 1; k < j + 4 && k < n; k++){
                    if (n - k >= 4) {
                        continue;
                    }
                    //从点的位置分段截取
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k);
                    //IP每个数字不大于255
                    if (Integer.parseInt(a) > 255 || Integer.parseInt(b) > 255 ||
                            Integer.parseInt(c) > 255 || Integer.parseInt(d) > 255){
                        continue;
                    }
                    //排除前导0的情况
                    if ((a.length() != 1 && a.charAt(0) == '0') ||
                            (b.length() != 1 && b.charAt(0) == '0') ||
                            (c.length() != 1 && c.charAt(0) == '0') ||
                            (d.length() != 1 && d.charAt(0) == '0')) {
                        continue;
                    }
                    //组装IP地址
                    String temp = a + "." + b + "." + c + "." + d;
                    res.add(temp);
                }
            }
        }
        return res;
    }

    //另外一个
//    public List<String> restoreIpAddresses(String s) {
//        List<String> result = new ArrayList<>();
//        if (s == null || s.length() <4) {
//            return result;
//        }
//        Stack<Integer> stack = new Stack<>();
//        Stack<Integer> index = new Stack<>();
//        int start = 0, count = 0;
//        while (start < s.length() || !stack.isEmpty()) {
//            if (count == 4) { // 已经切割出四段数字
//                if (stack.peek() != -1) { // 判断栈是否已经结束
//                    result.add(format(stack));
//                }
//                stack.pop();
//                count--;
//                start = index.pop() + 1;
//                continue;
//            }
//            if (start >= s.length()) { // 当前位置已经超过字符串长度
//                if (!stack.isEmpty()) { // 弹出栈中数字
//                    start = index.pop() + 1;
//                    count--;
//                } else { // 栈已经为空，退出循环处理
//                    break;
//                }
//            } else {
//                int num = 0;
//                boolean flag = false; // 判断当前位置能否切割出数字
//                for (int i = start; i < start + 3 && i < s.length(); i++) { // 切割数字
//                    num = num * 10 + (s.charAt(i) - '0');
//                    if (num > 255) {
//                        break;
//                    }
//                    stack.push(num);
//                    count++;
//                    index.push(i);
//                    start = i + 1;
//                    flag = true;
//                }
//                if (!flag) { // 当前位置不能切割数字，回滚到上一次
//                    start = index.pop() + 1;
//                    count--;
//                }
//            }
//        }
//        return result;
//    }
//    private String format(Stack<Integer> stack) { // 格式化ip地址
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 4; i++) {
//            sb.append(stack.pop());
//            if (i != 3) {
//                sb.append(".");
//            }
//        }
//        return sb.reverse().toString();
//    }
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String s1 = "25525511135";
//        List<String> result1 = solution.restoreIpAddresses(s1);
//        System.out.println("测试用例1的结果：");
//        for (String ip : result1) {
//            System.out.println(ip);
//        }
//        String s2 = "0000";
//        List<String> result2 = solution.restoreIpAddresses(s2);
//        System.out.println("测试用例2的结果：");
//        for (String ip : result2) {
//            System.out.println(ip);
//        }
//        String s3 = "1111";
//        List<String> result3 = solution.restoreIpAddresses(s3);
//        System.out.println("测试用例3的结果：");
//        for (String ip : result3) {
//            System.out.println(ip);
//        }
//        String s4 = "010010";
//        List<String> result4 = solution.restoreIpAddresses(s4);
//        System.out.println("测试用例4的结果：");
//        for (String ip : result4) {
//            System.out.println(ip);
//        }
//    }


    /**
     * 方法2：递归+回溯
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public List<String> restoreIpAddresses2 (String s) {
        // write code here
        return null;
    }

}
