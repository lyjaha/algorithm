package com.ly.nk.binaryTree;

/**
 *  BM31 对称的二叉树
 *
 *  描述：
 *  给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 *
 *  数据范围：节点数满足 0≤n≤1000，节点上的值满足 ∣val∣≤1000
 *
 *  要求：空间复杂度 O(n)，时间复杂度 O(n)
 *
 *  备注：
 *  你可以用递归和迭代两种方法解决这个问题
 *
 *  输入：{1,2,2,3,4,4,3}
 *  返回值：true
 *
 *  输入：{8,6,9,5,7,7,5}
 *  返回值：false
 *
 */
public class SymmetryTree {

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
     *  1：两种方向的前序遍历，同步过程中的当前两个节点，同为空，属于对称的范畴。
     *  2：当前两个节点只有一个为空或者节点值不相等，已经不是对称的二叉树了。
     *  3：第一个节点的左子树与第二个节点的右子树同步递归对比，第一个节点的右子树与第二个节点的左子树同步递归比较。
     *
     * 时空复杂度：
     * 空间复杂度：O(n)，最坏情况二叉树退化为链表，递归栈深度为 n
     * 时间复杂度：O(n)，其中n为二叉树的节点数，相当于遍历整个二叉树两次
     *
     * @param pRoot TreeNode类
     * @return bool布尔型
     */

    public boolean isSymmetrical (TreeNode pRoot) {
        return recursion(pRoot, pRoot);
    }

    private boolean recursion (TreeNode root1, TreeNode root2) {
        //
        if (root1 == null && root2 == null){
            return true;
        }

        //
        if (root1 == null || root2 == null || root1.val != root2.val){
            return false;
        }

        return recursion(root1.left, root2.right) && recursion(root1.right, root2.left);

    }

    /**
     * 方法2：层次遍历
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param pRoot TreeNode类
     * @return bool布尔型
     */
    public boolean isSymmetrical2 (TreeNode pRoot) {

        return true;
    }
}
