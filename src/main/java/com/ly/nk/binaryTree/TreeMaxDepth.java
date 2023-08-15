package com.ly.nk.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  BM28 二叉树的最大深度
 *  描述：
 *  求给定二叉树的最大深度，
 *  深度是指树的根节点到任一叶子节点路径上节点的数量。
 *  最大深度是所有叶子节点的深度的最大值。（注：叶子节点是指没有子节点的节点。）
 *
 *  数据范围：0≤n≤100000，树上每个节点的val满足 ∣val∣≤100
 *  要求：空间复杂度 O(1),时间复杂度 O(n)
 *
 *  输入：{1,2}
 *  返回值：2
 *
 *  输入：{1,2,3,4,#,#,5}
 *  返回值：3
 */
public class TreeMaxDepth {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：递归
     *
     * 思路：
     *
     * 步骤：
     * 1：对于每个节点，若是不为空才能累计一次深度，若是为空，返回深度为0.
     * 2：递归分别计算左子树与右子树的深度。
     * 3：当前深度为两个子树深度较大值再加1。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为二叉树的节点数，遍历整棵二叉树
     * 空间复杂度：O(n)，最坏情况下，二叉树化为链表，递归栈深度最大为 n
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        //
        if (root == null) {
            return 0;
        }
        //
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 方法2：层次遍历（迭代）
     *
     * 知识点：队列
     *
     * 思路：
     * 利用队列进行实现，将二叉树按层次遍历，记录每一层的节点数，每遍历完一层，则深度加1。
     *
     * 步骤：
     *
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，时间复杂度取决于二叉树中的节点数n。在遍历二叉树时，每个节点都会被访问一次，因此时间复杂度为O(n)。
     * 空间复杂度：O(n)，空间复杂度由队列和遍历深度组成。队列的最大空间是二树中某一层节点数的最大值，因此空间复杂度为O(w)，
     * w是二叉树的最大宽度；遍历深度的大值取决于二叉树的最大深度，因此空间复杂度为O(h)，h是二叉树的最大深度。因为二叉树
     * 最大宽度不会超过二叉树中节点数n的一半，所以可以将空间复杂度近似为O(n)。
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth2 (TreeNode root) {
        // 如果根节点为空，返回深度为0
        if (root == null) {
            return 0;
        }

        // 初始化队列，将根节点入队
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        // 初始化深度为0
        int depth  = 0;

        // 循环遍历队列，直至队列为空
        while (!queue.isEmpty()) {
            int n = queue.size();
            // 每次遍历队列的所有节点
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                // 如果有左子节点，将左子节点入队
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 如果右子节点，将右子节点入队
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 遍历完一层，深度加1
            depth++;
        }
        return depth;
    }
}
