package com.ly.nk.greedy;

import java.util.Arrays;

/**
 *  BM96 主持人调度（二）
 *
 *  描述：
 *  有 n 个活动即将举办，每个活动都有开始时间与活动的结束时间，第 i 个活动的开始时间是 start i ,
 *  第 i 个活动的结束时间是 end i ,举办某个活动就需要为该活动准备一个活动主持人。
 *
 * 一位活动主持人在同一时间只能参与一个活动。并且活动主持人需要全程参与活动，换句话说，
 * 一个主持人参与了第 i 个活动，那么该主持人在 (start i,end i) 这个时间段不能参与其他任何活动。
 * 求为了成功举办这 n 个活动，最少需要多少名主持人。
 *
 * 复杂度要求：时间复杂度 O(nlogn) ，空间复杂度 O(n)
 *
 * 2,[[1,2],[2,3]]
 * 1
 * 说明：只需要一个主持人就能成功举办这两个活动
 *
 * 2,[[1,3],[2,4]]
 * 2
 *
 *
 */
public class HootSchedul {


    /**
     * 方法1：排序+遍历比较
     *
     * 知识点：贪心思想
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * 计算成功举办活动需要多少名主持人
     * @param n int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }

        Arrays.sort(start, 0, start.length);
        Arrays.sort(end, 0, end.length);

        int res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] >= end[j]){
                j++;
            }else {
                res++;
            }
        }
        return res;
    }
}
