package com.ly.nk.binaryTree;

import java.util.Arrays;

/**
 *  BM40 重建二叉树
 *
 *  描述：
 *  给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
 *
 *  提示:
 *  1.vin.length == pre.length
 *  2.pre 和 vin 均无重复元素
 *  3.vin出现的元素均出现在 pre里
 *  4.只需要返回根结点，系统会自动输出整颗树做答案对比
 *  数据范围：n≤2000，节点的值−10000≤val≤10000
 *
 *  要求：空间复杂度O(n)，时间复杂度O(n)
 *
 */
public class ReConstructTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为数组长度，即二叉树的节点数，构建每个节点进一次递归，递归中所有的循环加起来一共 n 次
     * 空间复杂度：O(n)，递归栈最大深度不超过 n，辅助数组长度也不超过 n，重建的二叉树空间属于必要空间，不属于辅助空间
     *
     * @param pre int整型一维数组
     * @param vin int整型一维数组
     * @return TreeNode类
     */
    public TreeNode reConstructBinaryTree (int[] pre, int[] vin) {

        int n = pre.length;
        int m = vin.length;

        //每个遍历都不能为0
        if(pre == null || n == 0 || vin == null || m == 0)
            return null;

        //构建根节点
        TreeNode root = new TreeNode(pre[0]);

        for(int i = 0; i < vin.length; i++){
            //找到中序遍历中的前序第一个元素
            if(pre[0] == vin[i]){
                //构建左子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(vin, 0, i));
                //构建右子树
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(vin, i + 1, vin.length));
                break;
            }
        }
        return root;
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
     *
     * @param preOrder int整型一维数组
     * @param vinOrder int整型一维数组
     * @return TreeNode类
     */
    public TreeNode reConstructBinaryTree2 (int[] preOrder, int[] vinOrder) {
        return null;
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        ReConstructTree constructTree = new ReConstructTree();
        TreeNode root = constructTree.reConstructBinaryTree(preorder, inorder);
        // 输出3
        System.out.println(root.val);
    }
}

