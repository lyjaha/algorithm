package com.ly.leetcode.hot100.dublePointer;

/**
 *  42. 接雨水
 *
 *  给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 *  输出：6
 *  解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 *
 *  输入：height = [4,2,0,3,2,5]
 *  输出：9
 *
 */
public class CatchRain {

    /**
     * 方法1：双指针
     *
     * 知识点：双指针
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {

        // 最左端指针   最右端指针
        int left = 0, right = height.length - 1;

        // 左边的最大高度   右边的最大高度
        int leftMax = 0, rightMax = 0;
        // 接到的雨水量
        int ans = 0;

        // 从两端向中间遍历
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            }else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
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
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        return 0;
    }


    /**
     * 方法3：
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        return 0;
    }


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trappedWater = trap(height);
        System.out.println("Trapped water: " + trappedWater);
    }
}
