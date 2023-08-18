package com.ly.nk.binaryTree;

/**
 *  BM33 二叉树的镜像
 *
 *  描述：
 *  操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 *  数据范围：二叉树的节点数 0≤n≤1000 ， 二叉树每个节点的值  0≤val≤1000
 *  要求： 空间复杂度 O(n) 。本题也有原地操作，即空间复杂度 O(1) 的解法，时间复杂度 O(n)
 *
 * 输入：{8,6,10,5,7,9,11}
 * 返回值：{8,10,6,11,9,7,5}
 *
 * 输入：{}
 * 返回值：{}
 */
public class TreeMirror {

    public static class TreeNode {
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
     * 知识点：二叉树递归
     *
     * 思路：
     *
     * 步骤：
     *  1：先深度最左端的节点，遇到空树返回，处理最左端的两个子节点交换位置。
     *  2：然后进入右子树，继续按照先左后右再回中的方式访问。
     *  3：再返回到父问题，交换父问题两个子节点的值。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中 n 为二叉树的节点数，访问二叉树所有节点各一次
     * 空间复杂度：O(n)，最坏情况下，二叉树退化为链表，递归栈最大值为 n
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode mirror (TreeNode pRoot) {
        //
        if (pRoot == null)
            return null;

        //
        TreeNode left = mirror(pRoot.left);

        //
        TreeNode right = mirror(pRoot.right);

        //
        pRoot.left = right;
        pRoot.right = left;

        return pRoot;

    }

    /**
     * 方法2：栈
     *
     * 知识点：栈
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    //TODO
    public TreeNode mirror2 (TreeNode pRoot) {
        return null;

    }


    public static void main(String[] args) {
        // 创建二叉树
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeMirror solution = new TreeMirror();
        // 将二叉树变为其镜像
        TreeNode result = solution.mirror(root);
        // 打印镜像结果
        print(result);
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ",");
        print(root.left);
        print(root.right);
    }
}
