package com.ly.nk.dubbopointer;

/**
 *  BM93 盛水最多的容器
 *
 *  描述：
 *  给定一个数组height，长度为n，每个数代表坐标轴中的一个点的高度，height[i]是在第i点的高度，请问，
 *  从中选2个高度与x轴组成的容器最多能容纳多少水
 *  1.你不能倾斜容器
 *  2.当n小于2时，视为不能形成容器，请返回0
 *  3.数据保证能容纳最多的水不会超过整形范围，即不会超过2的31次方 - 1
 *
 *
 *  [1,7,3,2,4,5,8,2,7]
 *  49
 *
 *  [2,2]
 *  2
 *
 *  [5,4,3,2,1,5]
 *  25
 *
 *
 */
public class HoldWater {

    /**
     * 方法1：贪心法
     *
     * 知识点：双指针
     *
     * 思路：
     *
     * 步骤：
     * 1.创建两个指针 left 和 right，分别指向容器两端。
     * 2.初始化容器的面积为0。
     * 3.计算当前容器的面积，即 height[left] 和 height[right] 形成的面积，取两者的最小值，乘以两者之间的距离。
     * 4.若当前容器面积大于前面的最大面积，则更新最大面积。
     * 5.若 height[left] 小于 height[right]，则移动 left 指针；否则移动 right 指针。
     * 6.重复步骤 3 ~ 5，直到 left 指针与 right 指针相遇。
     * 7.返回最大面积
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，双指针共同遍历一次数组
     * 空间复杂度：O(1)，常数级变量，没有额外辅助空间
     *
     *
     * @param height int整型一维数组
     * @return int整型
     */
    public int maxArea (int[] height) {

        // 数组长度
        int n = height.length;

        if(n < 2) {
            return 0;
        }

        int left = 0;
        int right = n - 1;

        // 最大面积
        int maxArea = 0;

        while (left < right) {
            // 当前容器面积
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        HoldWater holdWater = new HoldWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = holdWater.maxArea(height);
        System.out.println(result); // 输出 "49"
    }
}
