package com.ly.nk.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  BM27 按之字形顺序打印二叉树
 *
 *  描述：
 *  给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 *
 *  数据范围：0≤n≤1500,树上每个节点的val满足∣val∣<=1500
 *  要求：空间复杂度：O(n)，时间复杂度：O(n)
 *
 * 示例
 * 输入：{1,2,3,#,#,4,5}
 * 返回值：[[1],[3,2],[4,5]]
 * 说明：如题面解释，第一层是根节点，从左到右打印结果，第二层从右到左，第三层从左到右。
 *
 * 输入：{8,6,10,5,7,9,11}
 * 返回值：[[8],[10,6],[5,7,9,11]]
 *
 * 输入：{1,2,3,4,5}
 * 返回值：[[1],[3,2],[4,5]]
 */
public class Print {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 方法1：非递归层次遍历
     *
     * 知识点：队列
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，每个节点访问一次，因为reverse的时间复杂度为O(n)，按每层元素reverse也相当于O(n)
     * 空间复杂度：O(n)，队列的空间最长为 O(n)
     *
     * @param pRoot TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> print (TreeNode pRoot) {
        TreeNode head = pRoot;
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();

        if (head == null){
            return res;
        }
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(head);
        TreeNode p;
        boolean flag = true;

        while (!temp.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<>();
            int n = temp.size();
            //奇数行反转，偶数行不反转
            flag = !flag;
            for (int i = 0; i < n; i++) {
                p = temp.poll();
                row.add(p.val);
                //
                if (p.left != null) {
                    temp.offer(p.left);
                }
                if (p.right != null) {
                    temp.offer(p.right);
                }
            }
            //
            if (flag) {
                Collections.reverse(row);
            }
            res.add(row);
        }
        return res;
    }

    /**
     * 方法2：双栈法
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为二叉树的节点数，遍历二叉树的每个节点
     * 空间复杂度：O(n)，两个栈的空间最坏情况为 n
     *
     */
    public ArrayList<ArrayList<Integer>> print2 (TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();

        return res;
    }

}
