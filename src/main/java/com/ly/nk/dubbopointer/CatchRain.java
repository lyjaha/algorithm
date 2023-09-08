package com.ly.nk.dubbopointer;

/**
 *  BM94 接雨水问题
 *
 *  描述：
 *  给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个柱子高度图，计算按此排列的柱子，
 *  下雨之后能接多少雨水。(数组以外的区域高度视为0)
 *
 *  [3,1,2,5,2,4]
 *  5
 *
 *  [4,5,1,3,2]
 *  2
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
     * 1.创建一个双指针，left 指向数组的起始位置，right 指向数组的末尾。
     * 2.创建两个变量 leftMax 和 rightMax，分别记录 left 指针左侧的最大值和 right 指针右侧的最大值。
     * 3.创建一个变量 maxWater 记录最大的存水量，初始化为 0。
     * 4.当 left 小于 right 时，判断 height[left] 和 height[right] 中的最小值是否大于等 leftMax 和 rightMax 中的最小值。
     * 5.若满足条件，则计当前位置可存储的水量，并更新 maxWater。同时更新 leftMax 和 rightMax。
     * 6.若 height[left] 小于 height[right]，则移动 left 指针，否则移动 right 指针。
     * 7.重复步骤 4 ~ 6，直到 left 和 right 指针相遇。
     *
     * 时空复杂度：
     *
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public int maxWater (int[] arr) {

        // 数组长度
        int n = arr.length;

        //排除空数组
        if(n == 0) {
            return 0;
        }

        // 双指针
        int left = 0;
        int right = n - 1;

        // 左侧和右侧的最大值
        int leftMax = 0;
        int rightMax = 0;

        // 最大存储水量
        int maxWater = 0;

        while (left < right){
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax){
                    leftMax = arr[left];
                }else {
                    maxWater += leftMax - arr[left];
                }
                //
                left++;
            }else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                }else {
                    maxWater += rightMax - arr[right];
                }
                //
                right--;
            }
        }
//        //直到左右指针相遇
//        while(left < right){
//            //每次维护往中间的最大边界
//            maxL = Math.max(maxL, arr[left]);
//            maxR = Math.max(maxR, arr[right]);
//            //较短的边界确定该格子的水量
//            if(maxR > maxL)
//                res += maxL - arr[left++];
//            else
//                res += maxR - arr[right--];
//        }
        return maxWater;
    }

    public static void main(String[] args) {
        CatchRain catchRain = new CatchRain();
        int[] height = {3, 1, 2, 5, 2, 4};
        int result = catchRain.maxWater(height);
        System.out.println(result); // 输出 5
    }
}
