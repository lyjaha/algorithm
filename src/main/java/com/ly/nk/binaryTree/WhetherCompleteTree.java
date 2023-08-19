package com.ly.nk.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  BM35 判断是不是完全二叉树
 *
 *  描述：
 *  给定一个二叉树，确定他是否是一个完全二叉树。
 *
 *  完全二叉树的定义：若二叉树的深度为 h，除第 h 层外，其它各层的结点数都达到最大个数，第 h 层所有的叶子结点都连续集中在最左边，
 *  这就是完全二叉树。（第 h 层可能包含 [1~2h] 个节点）
 *
 *  数据范围：节点数满足 1≤n≤100
 *
 *  满二叉树肯定是完全二叉树，而完全二叉树不一定是满二叉树。
 *
 * 输入：{1,2,3,4,5,6}
 * 返回值：true
 *
 * 输入：{1,2,3,4,5,6,7}
 * 返回值：true
 *
 * 输入：{1,2,3,4,5,#,6}
 * 返回值：false
 */
public class WhetherCompleteTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：层次遍历
     *
     * 知识点：队列
     *
     * 思路：
     *
     * 步骤：
     *  1：先判断空树一定是完全二叉树。
     *  2：初始化一个队列辅助层次遍历，将根节点加入。
     *  3：逐渐从队列中弹出元素访问节点，如果遇到某个节点为空，进行标记，代表到了完全二叉树的最下层，若是后续还有访问，
     *  则说明提前出现了叶子节点，不符合完全二叉树的性质。
     *  4：否则，继续加入左右子节点进入队列排队，等待访问。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为二叉树节点数，层次遍历最坏情况下遍历每一个节点
     * 空间复杂度：O(n)，最坏情况下，层次队列的最大空间为 O(n)
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree (TreeNode root) {
        //空树一定是完全二叉树
        if(root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        //定义一个首次出现的标记位
        boolean notComplete = false;

        while (!queue.isEmpty()) {
            cur = queue.poll();

            //标记第一次遇到空节点
            if (cur == null) {
                notComplete = true;
                continue;
            }

            //后续访问已经遇到空节点了，说明经过了叶子
            if (notComplete){
                return false;
            }

            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }

}
