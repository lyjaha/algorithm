package com.ly.nk.binaryTree;

/**
 *  BM36 判断是不是平衡二叉树
 *
 *  描述：
 *  输入一棵节点数为 n 二叉树，判断该二叉树是否是平衡二叉树。
 *  在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 *
 *  平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
 *  并且左右两个子树都是一棵平衡二叉树。
 *
 *  数据范围：n≤100,树上节点的val值满足0≤n≤1000
 *  要求：空间复杂度O(1)，时间复杂度O(n)
 *
 * 输入：{1,2,3,4,5,6,7}
 * 返回值：true
 *
 * 输入：{}
 * 返回值：true
 */
public class WhetherBalance {

    public static class TreeNode {
        int val = 0;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：自顶向下
     *
     * 知识点：二叉树递归
     *
     * 思路：
     *
     * 步骤：
     *  1：第一个函数递归遍历二叉树所有节点。
     *  2：对于每个节点判断，调用第二个函数获取子树深度。
     *  3：第二个函数递归获取子树深度，只需要不断往子节点深度遍历，累加左右深度的较大值。
     *  4：根据深度判断该节点下的子树是否为平衡二叉树。
     *
     * 时空复杂度：
     *
     * 时间复杂度：O(n2)，其中n为二叉树的节点数，第一个递归遍历二叉树所有节点，第二个递归查找深度最坏情况下
     * （二叉树退化为链表）需要遍历二叉树所有节点
     * 空间复杂度：O(n)，递归栈最大深度为 n
     *
     * @param pRoot TreeNode类
     * @return bool布尔型
     */
    public static boolean isBalanced (TreeNode pRoot) {

        if(pRoot == null) {
            return true;
        }

        int left = deep(pRoot.left);
        int right = deep(pRoot.right);

        //左子树深度减去右子树相差绝对值大于1
        if (left - right > 1 || left - right < -1){
            return false;
        }

//        int heightDiff = Math.abs(left - right);
//        if (heightDiff > 1) {
//            return false;
//        }

        //同时，左右子树还必须是平衡的
        return isBalanced(pRoot.left) && isBalanced(pRoot.right);

    }

    private static int deep(TreeNode root) {
        //空节点深度为0
        if (root == null){
            return 0;
        }
        //递归算左右子树的深度
        int left = deep(root.left);
        int right = deep(root.right);

        //子树最大深度加上自己
        return left > right ? left + 1 : right + 1;

        // 返回值是加1后的左右树高度的最大值
//        return Math.max(left, right) + 1;

    }

    /**
     * 方法2：自底向上
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * @param pRoot TreeNode类
     * @return bool布尔型
     */
    public static boolean isBalanced2 (TreeNode pRoot) {

        //TODO
        return true;
    }


    public static void main(String[] args) {
        // 构造一个平衡二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // 输出结果为true
        System.out.println(isBalanced(root));
        // 构造一个不平衡的二叉树
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        //输出结果为false
        System.out.println(isBalanced(root2));
    }
}
