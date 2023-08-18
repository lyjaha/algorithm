package com.ly.nk.binaryTree;

/**
 *  BM34 判断是不是二叉搜索树
 *
 *  描述：
 *  给定一个二叉树根节点，请你判断这棵树是不是二叉搜索树。
 *
 *  二叉搜索树满足每个节点的左子树上的所有节点均小于当前节点且右子树上的所有节点均大于当前节点。
 *
 *  二叉搜索树每个左子树元素小于根节点，每个右子树元素大于根节点，中序遍历为递增序
 *
 *
 * 输入：{1,2,3}
 * 返回值：false
 *
 * 输入：{2,1,3}
 * 返回值：true
 *
 */
public class WhetherBST {

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
     * 知识点：
     *
     * 二叉树递归
     *
     * 二叉搜索树
     *
     * 思路：
     * 二叉搜索树的特性就是中序遍历是递增序。
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为二叉树的节点数，最坏遍历整个二叉树所有节点
     * 空间复杂度：O(n)，最坏情况二叉树退化为链表，递归栈深度为 n
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isValidBST (TreeNode root) {
        //
        if(root == null)
            return true;

        //先进入左子树
        if (!isValidBST(root.left)){
            return false;
        }

        int pre = Integer.MIN_VALUE;

        if (root.val < pre){
            return false;
        }

        pre = root.val;
        //再进入右子树
        return isValidBST(root.right);
    }

    /**
     * 方法2：非递归
     *
     * 知识点：栈
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isValidBST2 (TreeNode root) {

        return true;

    }
}
