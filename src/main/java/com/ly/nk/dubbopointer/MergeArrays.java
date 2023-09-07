package com.ly.nk.dubbopointer;

/**
 *  BM87 合并两个有序的数组
 *
 *  描述：
 *  给出一个有序的整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组
 *
 *
 *  [4,5,6],[1,2,3]
 *  [1,2,3,4,5,6]
 * A数组为[4,5,6]，B数组为[1,2,3]，后台程序会预先将A扩容为[4,5,6,0,0,0]，B还是为[1,2,3]，m=3，n=3，
 * 传入到函数merge里面，然后请同学完成merge函数，将B的数据合并A里面，最后后台程序输出A数组
 */
public class MergeArrays {

    /**
     * 方法1：归并排序思想
     *
     * 知识点：双指针
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n+m)，其中 n分别为两个数组的长度，最坏情况遍历整个数组A和数组B
     * 空间复杂度：O(1)，常数级变量，无额外辅助空间
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int A[], int m, int B[], int n) {

        // 指向数组A的结尾
        int i = m - 1;
        // 指向数组B的结尾
        int j = n - 1;
        //指向数组A空间的结尾处
        int index = m + n - 1;

        // 从末尾开始合并，比较A[i]和B[j]的大小，并将较大值放入A的末尾
        while (i >= 0 && j >= 0) {
            //将较大的元素放到最后
            if (A[i] > B[j]) {
                A[index] = A[i];
                i--;
            }else {
                A[index] = B[j];
                j--;
            }
            index--;
        }
        // 将剩余的B数组元素放入A的前面
        while (j >= 0) {
            A[index] = B[j];
        }

    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 0, 0, 0}; // 数组A
        int m = 3; // A数组的长度
        int[] B = {2, 4, 6}; // 数组B
        int n = 3; // B数组的长度

        merge(A, m, B, n);

        System.out.println("合并后的数组A：");
        for (int num : A) {
            System.out.print(num + " ");
        }
    }

}
