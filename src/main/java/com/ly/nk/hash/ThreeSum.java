package com.ly.nk.hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  BM54 三数之和
 *
 *  描述：
 *  给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 *
 *  数据范围：0≤n≤1000，数组中各个元素值满足∣val∣≤100
 *
 *  空间复杂度：O(n2)，时间复杂度O(n2)
 *
 *  注意：
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 * 解集中不能包含重复的三元组。
 *
 *  示例：
 *  输入：[0]
 *  返回值：[]
 *
 *  输入：[-2,0,1,1,2]
 *  返回值：[[-2,0,2],[-2,1,1]]
 *
 *  输入：[-10,0,10,20,-10,-40]
 *  返回值：[[-10,-10,20],[-10,0,10]]
 *
 */
public class ThreeSum {

    /**
     * 方法2：哈希表 + 双指针
     *
     * 思路：
     * 如果找到了某个数a，要找到与之对应的另外两个数，因为三数之和为0，那岂不是只要找到另外两个数之和为−a
     *
     * 步骤：
     *  1：排除边界特殊情况。
     *  2：数组改成有序，使用sort函数优先对其排序。
     *  3：得到有序数组后，遍历该数组，对于每个遍历到的元素假设它是三元组中最小的一个，那么另外两个一定在后面。
     *  4：需要三个数相加为0，则另外两个数相加应该为上述第一个数的相反数，我们可以利用双指针在剩余的子数组中找有没有这样的数对。
     *  双指针指向剩余子数组的首尾，如果二者相加为目标值，那么可以记录，而且二者中间的数字相加可能还会有。
     *  5：如果二者相加大于目标值，说明右指针太大了，那就将其左移缩小，相反如果二者相加小于目标值，说明左指针太小了，
     *  将其右移扩大，直到两指针相遇，剩余子数组找完了。
     *
     * 时空复杂度：
     * 时间复杂度：O(n2)，排序的复杂度为O(nlog2n)，查找三元组的复杂度为O(n2)
     * 空间复杂度：O(1)，res属于必要空间，不属于额外空间，无其他辅助空间
     *
     * @param nums int整型一维数组
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> threeSum (int[] nums) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        int n = nums.length;

        //不够三元组
        if(n < 3)
            return res;

        //排序
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //后续的收尾双指针
            int left = i + 1;
            int right = n - 1;
            //设置当前数的负值为目标
            int target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    while (left + 1 < right && nums[left] == nums[left + 1]){
                        //
                        left++;
                    }
                    while (left - 1 > left && nums[right] == nums[right - 1]){
                        //
                        right--;
                    }
                    //
                } else if (nums[left] + nums[right] > target) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return res;
    }
}
