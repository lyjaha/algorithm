package com.ly.nk.binaryTree;

/**
 *  BM41 输出二叉树的右视图
 *
 *  描述：
 *  请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
 *
 * 数据范围： 0≤n≤10000
 * 要求： 空间复杂度 O(n)，时间复杂度 O(n)
 *
 * 如输入[1,2,4,5,3],[4,2,5,1,3]时，通过前序遍历的结果[1,2,4,5,3]和中序遍历的结果[4,2,5,1,3]可重建出以下二叉树：
 *
 *  输入：[1,2,4,5,3],[4,2,5,1,3]
 *  返回值：[1,3,5]
 */
public class PrintRightView {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 方法1：递归建树+深度优先搜索
     *
     * 知识点：二叉树递归
     *
     * 知识点：深度优先搜索（dfs）
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * 求二叉树的右视图
     *
     * @param preOrder int整型一维数组 先序遍历
     * @param inOrder int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    //TODO
    public int[] solve (int[] preOrder, int[] inOrder) {
        return null;
    }

    /**
     * 方法2：哈希表优化的递归建树+层次遍历
     *
     * 知识点：队列
     *
     * 知识点：哈希表
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * 求二叉树的右视图
     *
     * @param preOrder int整型一维数组 先序遍历
     * @param inOrder int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    //TODO
    public int[] solve2 (int[] preOrder, int[] inOrder) {
        return null;
    }



}
