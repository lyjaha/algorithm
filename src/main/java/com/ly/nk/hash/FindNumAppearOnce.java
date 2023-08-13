package com.ly.nk.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  BM52 数组中只出现一次的两个数字
 *
 *  描述：
 *  一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 *  数据范围：数组长度 2≤n≤1000，数组中每个数的大小 0<val≤1000000
 *
 *  要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 *  提示：输出时按非降序排列。
 *
 *  示例：
 *  [1,4,1,6]
 *  [4,6]
 *  返回的结果中较小的数排在前面
 *
 *  [1,2,3,3,2,9]
 *  [1,9]
 *
 *
 */
public class FindNumAppearOnce {

    /**
     * 方法1：哈希表
     *
     * 思路：
     *
     * 步骤：
     *  1：遍历数组，用哈希表统计每个数字出现的频率。
     *  2：然后再遍历一次数组，对比哈希表，找到出现频率为1的两个数字。
     *  3：最后整理次序输出。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为数组长度，两次单独的遍历数组每个元素
     * 空间复杂度：O(n)，哈希表的长度应该为(n−2)/2
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] findNumsAppearOnce (int[] array) {
        Map<Integer, Integer> mp = new HashMap<>();

        List<Integer> res = new ArrayList<>();

        //遍历数组
        for(int i = 0; i < array.length; i++)
            //统计每个数出现的频率
            if(!mp.containsKey(array[i]))
                mp.put(array[i], 1);
            else
                mp.put(array[i], mp.get(array[i]) + 1);

        //再次遍历数组
        for(int i = 0; i < array.length; i++)
            //找到频率为1的两个数
            if(mp.get(array[i]) == 1)
                res.add(array[i]);

        //整理次序
        if(res.get(0) < res.get(1))
            return new int[] {res.get(0), res.get(1)};
        else
            return new int[] {res.get(1), res.get(0)};

    }


    /**
     * 方法2：异或运算
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，遍历两次数组，找到两个数不相同的第一位循环为常数次
     * 空间复杂度：O(1)，常数级变量使用，无额外辅助空间
     */
}
