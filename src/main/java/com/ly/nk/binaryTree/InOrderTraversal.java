package com.ly.nk.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 *  BM24 二叉树的中序遍历
 *
 *  描述：给定一个二叉树的根节点root，返回它的 中序遍历 结果。
 *
 *  数据范围：树上节点数满足 0 ≤ n ≤ 1000  ，树上每个节点的值满足 -1000 ≤ val ≤ 1000
 *
 *  进阶：空间复杂度 O(n)，时间复杂度 O(n)
 *
 * 示例
 * 输入：{1,2,#,#,3}
 * 返回值：[2,3,1]
 *
 */
public class InOrderTraversal {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 方法1：递归
     *
     * 思路：
     * 中序遍历？“左根右”，先访左子树，然后访问根节点完毕后再访问右子树。
     *
     * 终止条件：当子问题到达叶子节点后，后一个不管左右都是空，因此遇到空节点就返回。
     * 返回值： 每次处理完子问题后，就是将子问题访问过的元素返回，依次存入了数组中。
     * 本级任务：每个子问题优先访问左子树的子问题，等到左子树的结果返回后，再访问自己的根节点，然后进入右子树。
     *
     * 步骤：
     *   1：准备用数组记录遍历到的节点值，Java可以用List，C++可以直接用vector。
     *   2：从根节点开始进入递归，遇到空节点就返回，否则优先进入左子树进行递归访问。
     *   3：左子树访问完毕再回到根节点访问。
     *   4：最后进入根节点的右子树进行递归。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为二叉树的节点数，遍历二叉树所有节点
     * 空间复杂度：O(n)，最坏情况下二叉树化为链表，递归栈深度为n
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public static int[] inorderTraversal (TreeNode root) {

        //添加遍历结果的数组
        List<Integer> list = new ArrayList();

        //递归中序遍历
        inorder(list, root);

        int listSize = list.size();
        //返回的结果
        int[] res = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static void inorder(List<Integer> list, TreeNode root) {

        //遇到空节点则返回
        if(root == null)
            return;

        //先去左子树
        inorder(list, root.left);

        //再访问根节点
        list.add(root.val);

        //最后去右子树
        inorder(list, root.right);
    }

    /**
     * 方法2：栈
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为二叉树的节点数，遍历二叉树所有节点
     * 空间复杂度：O(n)，辅助栈空间最大为链表所有节点数
     *
     */
    public int[] inorderTraversal2 (TreeNode root) {
        int[] res = new int[0];

        return res;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        inorderTraversal(root);
    }


}
