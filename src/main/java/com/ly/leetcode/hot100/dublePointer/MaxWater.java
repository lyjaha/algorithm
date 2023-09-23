package com.ly.leetcode.hot100.dublePointer;

/**
 *  11. 盛最多水的容器
 *
 *  描述；
 *  给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *  找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *  返回容器可以储存的最大水量。
 *  说明：你不能倾斜容器。
 *
 *  输入：[1,8,6,2,5,4,8,3,7]
 *  输出：49
 *  解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  输入：height = [1,1]
 *  输出：1
 *
 */
public class MaxWater {

    /**
     * 方法1：双指针
     *
     * 知识点：双指针
     *
     * 思路：
     * 使用双指针的方法来解决问题。初始时，左指针指向数组的起始位置，右指针指向数组的末尾位置。
     * 计算当前指针所形成的容器的容量，并更新最大容量值。然后，根据两条边的高度，移动指针的位置，
     * 以期望找到更高的边来形成更大的容器。
     *
     * 步骤：
     * 1. 初始化左指针 `left` 为 0，右指针 `right` 为 `height` 数组的长度减1。
     * 2. 初始化最大容量 `maxArea` 为 0。
     * 3. 使用循环，直到左指针与右指针相遇：
     *    - 计算当前容器的容量，即 `min(height[left], height[right]) * (right - left)`，并将其与 `maxArea`
     *      进行比较，更新最大容量。
     *    - 移动指针的位置：
     *      - 若 `height[left] < height[right]`，则左指针右移一位。
     *      - 否则，右指针左移一位。
     * 4. 循环结束后，返回最大容量 `maxArea`。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，使用了双指针遍历一次数组，其中 n 是数组的长度。
     * 空间复杂度：O(1)，使用了常数个额外变量。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        // 左指针
        int left = 0;
        // 右指针
        int right = height.length - 1;
        // 最大容量
        int maxArea = 0;
        while (left < right) {
            /**
             * height[left] 表示左边界的高度，height[right] 表示右边界的高度。
             * (right - left) 表示矩形的宽度，即右边界与左边界之间的距离。
             * Math.min(height[left], height[right]) 表示取左边界高度和右边界高度的较小值。
             */
            int area = Math.min(height[left], height[right]) * (right - left);
            // 计算当前容器的容量，并更新最大容量
            maxArea = Math.max(maxArea, area);

            // 移动指针的位置
            if (height[left] < height[right]) {
                // 左指针右移一位
                left++;
            }else {
                // 右指针左移一位
                right--;
            }
        }
        return maxArea;
    }

    /**
     * int a = 5;
     * int b = ++a;  // 先自增a，然后将自增后的值赋给b，此时a和b的值都为6
     *
     * int c = 5;
     * int d = c++;  // 先将c的值赋给d，然后再自增c，此时c的值为6，d的值为5
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxWater maxWater = new MaxWater();
        int maxArea = maxWater.maxArea(height);
        System.out.println("Max Area: " + maxArea);
    }

}
