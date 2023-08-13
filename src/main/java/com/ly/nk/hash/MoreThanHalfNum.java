package com.ly.nk.hash;

import java.util.HashMap;
import java.util.Map;

/**
 *  BM51 数组中出现次数超过一半的数字
 *
 *  描述：
 *  给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *  例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *
 *  数据范围：n≤50000，数组中元素的值 0≤val≤10000
 *  要求：空间复杂度：O(1)，时间复杂度 O(n)
 *
 *
 *
 */
public class MoreThanHalfNum {

    /**
     * 方法1：哈希表
     *
     * 思路：
     *
     * 步骤：
     *  1：构建一个哈希表，统计数组元素各自出现了多少次，即key值为数组元素，value值为其出现次数。
     *  2：遍历数组，每遇到一个元素就把哈希表中相应key值的value值加1，用来统计出现次数。
     *  3：本来可以统计完了之后统一遍历哈希表找到频次大于数组长度一半的key值，但是根据我们上面加粗的点，
     *  只要它出现超过了一半，不管后面还有没有，必定就是这个元素了，因此每次统计后，我们都可以检查value值
     *  是否大于数组长度的一半，如果大于则找到了。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，遍历一次数组，哈希表每次操作的复杂度都是O(1)
     * 空间复杂度：O(n)，最坏情况下n/2+1个相同的数字，其他都不同，则共有n/2个不同的数字，哈希表长度需要达n/2
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public static int moreThanHalfNumSolution (int[] numbers) {
        int numLength = numbers.length;
        if (numLength == 1){
            return 0;
        }
        int result = numLength / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numLength; i++) {
            if (map.containsKey(numbers[i])) {
                map.put(numbers[i], map.get(numbers[i]) + 1);
            }else {
                map.put(numbers[i], 1);
            }
            if (map.get(numbers[i]) > result) {
                return numbers[i];
            }
        }
        return 0;
    }

    /**
     * 方法2：排序法
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * 时间复杂度：O(nlongn)
     * 空间复杂度：O(1)
     *
     * @param args
     */
    //TODO


    /**
     * 方法3：候选法（最优解）---投票算法
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param numbers
     */
    public static int moreThanHalfNumSolution3 (int[] numbers) {
        int candidate = numbers[0];
        int vote  = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == candidate){
                vote++;
            }else {
                vote--;
            }
            if (vote  == 0){
                candidate = numbers[i];
                vote  = 1;
            }
        }

        int count = 0;
        for (int num : numbers){
            if (num == candidate){
                count++;
            }
        }
        return count > numbers.length / 2 ? candidate : 0;
    }


    public static void main(String[] args) {
        int[] ints = {1};
//        System.out.println(moreThanHalfNumSolution(ints));
        System.out.println(moreThanHalfNumSolution3(ints));
    }

}
