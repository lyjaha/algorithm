package com.ly.nk.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 *  BM23 二叉树的前序遍历
 *
 *  描述：给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *  数据范围：二叉树的节点数量满足 1≤n≤100  ，二叉树节点的值满足 1≤val≤100 ，树的各节点的值各不相同
 *
 * 示例
 * 输入：{1,#,2,3}
 * 返回值：[1,2,3]
 */
public class PreOrderTraversal {

    public class TreeNode {
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
     * 前序遍历？“根左右”，先访问根，然后访问左树完毕后再访问右子树。
     *
     * 终止条件： 当子问题到达叶子节点后，后一个不管左右都是空，因此遇到空节点就返回。
     * 返回值： 每次处理完子问题后，就是将子问题访问过的元素返回，依次存入了数组中。
     * 本级任务： 每个子问题优先访问这棵子树的根节点，然后递归进入左子树和右子树。
     *
     * 步骤：
     *  1：准备用数组记录遍历到的节点值，Java可以用List，C++可以直接用vector。
     *  2：从根节点开始进入递归，遇到空节点就返回，否则将该节点值加入数组。
     *  3：依次进入左右子树进行递归。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为二叉树的节点数，遍历二叉树所有节点
     * 空间复杂度：O(n)，最坏情况下二叉树化为链表，递归栈深度为 n
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] preorderTraversal (TreeNode root) {

        //添加遍历结果的数组
        List<Integer> list = new ArrayList();
        //递归前序遍历
        preorder(list, root);
        int listSize = list.size();
        //返回的结果
        int[] res = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void preorder(List<Integer> list, TreeNode root) {

        //遇到空节点则返回
        if(root == null)
            return;

        //先遍历根节点
        list.add(root.val);

        //再去左子树
        preorder(list, root.left);

        //最后去右子树
        preorder(list, root.right);
    }

    /**
     * 方法2：栈
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     */
    public int[] preorderTraversal2 (TreeNode root) {
        int[] res = new int[0];

        return res;
    }

}
