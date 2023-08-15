package com.ly.nk.binaryTree;

/**
 *  BM30 二叉搜索树与双向链表
 *
 *  描述：
 *  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *
 *  数据范围：输入二叉树的节点数 0≤n≤1000，二叉树中每个节点的值 0≤val≤1000
 *
 * 要求：空间复杂度O(1)（即在原树上操作），时间复杂度 O(n)
 *
 * 注意:
 * 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针
 * 需要指向后继
 * 2.返回链表中的第一个节点的指针
 * 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
 * 4.你不用输出双向链表，程序会根据你的返回值自动打印输出
 *
 * 输入：{10,6,14,4,8,12,16}
 * 返回值：From left to right are:4,6,8,10,12,14,16;From right to left are:16,14,12,10,8,6,4;
 *
 * 输入：{5,4,#,3,#,2,#,1}
 * 返回值：From left to right are:1,2,3,4,5;From right to left are:5,4,3,2,1;
 *
 */
public class TreeReverseList {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：递归中序遍历
     *
     * 知识点：
     * 二叉树递归：
     *
     * 二叉搜索树：
     * 二叉搜索树是一种特殊的二叉树，它的每个节点值大于它的左子节点，且大于全部左子树的节点值；
     * 每个节点值小于它右子节点，且小于全部右子树的节点值。因此二叉搜索树一定程度上算是一种排序结构。
     *
     * 思路：
     * 二叉搜索树最左端的元素一定最小，最右端的元素一定最大，符合“左中右”的特性，因此二叉搜索树的中序遍历就是一个递增序列，
     * 我们只要对它中序遍历就可以组装称为递增双向链表。
     *
     * 步骤：
     *  1：创建两个指针，一个指向题目中要求的链表头（head），一个指向当前遍历的前一节点（pre)。
     *  2：首先递归到最左，初始化head与pre。
     *  3：然后处理中间根节点，依次连接pre与当前节点，连接后更新pre为当前节点。
     *  4：最后递归进入右子树，继续处理。
     *  5：递归出口即是节点为空则返回。
     *
     * 时空复杂度：
     *
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode convert(TreeNode pRootOfTree) {

        return null;
    }

    /**
     * 方法2：非递归中序遍历
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * @param pRootOfTree
     * @return
     */
    public TreeNode convert2(TreeNode pRootOfTree) {

        return null;
    }
}
