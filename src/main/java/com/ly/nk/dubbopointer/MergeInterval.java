package com.ly.nk.dubbopointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *  BM89 合并区间
 *
 *  描述：
 *  给出一组区间，请合并所有重叠的区间。
 * 请保证合并后的区间按区间起点升序排列。
 *
 * 要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
 * 进阶：空间复杂度 O(val)，时间复杂度 O(val)
 *
 * [[10,30],[20,60],[80,100],[150,180]]
 * [[10,60],[80,100],[150,180]]
 *
 * [[0,10],[10,20]]
 * [[0,20]]
 *
 */
public class MergeInterval {

     public class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
          this.start = start;
          this.end = end;
        }
      }

    /**
     * 方法1：排序+贪心
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(nlogn)，其中n为区间个数，因为要先进行排序（时间复杂度O(nlogn)），然再遍历所有区间（时间复杂度O(n)），所以总的时间复杂度是O(nlogn)。
     * 空间杂度：O(1)，虽然算法使用了递归调用，但由于快速排序是原排序，所以不需要额外的空间。
     *
     *
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     */
    public ArrayList<Interval> merge (ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }

        // 先将所有区间按照左端点的大小进行排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start){
                    return o1.start - o2.start;
                }else {
                    return o1.end - o2.end;
                }
            }
        });

        // 初始化结果集res，将第一个区间放入结果集中
        ArrayList<Interval> res = new ArrayList<>();
//        res.add(intervals.get(0));
//        //初始化已经合并区间的结尾位置
//        int idx = intervals.get(0).end;

        // 初始化当前区间为第一个区间
        Interval curInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {

            Interval interval  = intervals.get(i);
            // 当前区间和下一个区间有重叠，合并区间
            if (curInterval.end >= interval.start) {
                curInterval.end = Math.max(curInterval.end, interval.end);
            }else {
                // 当前区间和下一个区间不重叠，将当前间加入结果集，并将当前区间更新为下一个区间
                res.add(curInterval);
                curInterval = interval;
            }
        }
        // 将最后一个区间加入结果集
        res.add(curInterval);
        return res;
    }

    /**
     * 方法2：
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
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     */
    public ArrayList<Interval> merge2 (ArrayList<Interval> intervals) {
        //todo
        return null;
    }
}
