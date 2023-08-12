package com.ly.nk.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 *  BM26 求二叉树的层序遍历
 *
 *  描述：给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 *
 *  数据范围：0 <= 二叉树的结点数 <= 1500
 *
 * 示例
 * 输入：{1,2}
 * 返回值：[[1],[2]]
 *
 * 输入：{1,2,3,4,#,#,5}
 * 返回值：[[1],[2,3],[4,5]]
 */
public class levelOrder {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 方法1：队列
     *
     * 思路：
     * 二叉树的层次遍历就是按照从上到下每行，然后每行中从左到右依次遍历，得到的二叉树的元素值。对于层次遍历，
     * 我们通常会使用队列来辅助：
     *
     * 因为队列是一种先进先出的数据结构，我们依照它的性质，如果从左到右访问完一行节点，并在访问的时候依次把它们的子节点加入队列，
     * 那么它们的子节点也是从左到右的次序，且排在本行节点的后面，因此队列中出现的顺序正好也是从左到右，正好符合层次遍历的特点。
     *
     * 步骤：
     *  1：首先判断二叉树是否为空，空树没有遍历结果。
     *  2：建立辅助队列，根节点首先进入队列。不管层次怎么访问，根节点一定是第一个，那它肯定排在队伍的最前面。
     *  3：每次进入一层，统计队列中元素的个数。因为每当访问完一层，下一层作为这一层的子节点，一定都加入队列，
     *  而再下一层还没有加入，因此此时队列中的元素个数就是这一层的元素个数。
     *  4：每次遍历这一层这么多的节点数，将其依次从队列中弹出，然后加入这一行的一维数组中，如果它们有子节点，
     *  依次加入队列排队等待访问。
     *  5：访问完这一层的元素后，将这个一维数组加入二维数组中，再访问下一层。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为二叉树的节点数，每个节点访问一次
     * 空间复杂度：O(n)，队列的空间为二叉树的一层的节点数，最坏情况二叉树的一层为O(n)级
     *
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer> > res = new ArrayList();

        //如果是空，则直接返回空数组
        if(root == null)
            return res;

        //队列存储，进行层次遍历
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            //记录二叉树的某一行
            ArrayList<Integer> row = new ArrayList();
            int n = q.size();
            //因先进入的是根节点，故每层节点多少，队列大小就是多少
            for(int i = 0; i < n; i++){
                TreeNode cur = q.poll();
                row.add(cur.val);
                //若是左右孩子存在，则存入左右孩子作为下一个层次
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            res.add(row);
        }
        return res;
    }

    /**
     * 方法2：递归
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     */
}
