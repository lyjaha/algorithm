package com.ly.nk.binaryTree;

/**
 *  BM32 合并二叉树
 *
 *  描述：
 *  已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
 *
 *  数据范围：树上节点数量满足 0≤n≤500，树上节点的值一定在32位整型范围内。
 *  进阶：空间复杂度 O(1) ，时间复杂度 O(n)
 *
 * 输入：{1,3,2,5},{2,1,3,#,4,#,7}
 * 返回值：{3,4,5,5,4,#,7}
 *
 * 输入：{1},{}
 * 返回值：{1}
 *
 *
 */
public class MergeTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 方法1：递归前序遍历
     *
     * 知识点：二叉树递归
     *
     * 思路：
     * 可以采用递归的方式进行处理.
     *
     * 步骤：
     *  1：首先判断t1与t2是否为空，若为空则用另一个代替，若都为空，返回的值也是空。
     *  2：然后依据前序遍历的特点，优先访问根节点，将两个根点的值相加创建到新树中。
     *  3：两棵树再依次同步进入左子树和右子树。
     *
     * 时空复杂度：
     * 时间复杂度：O(min(n,m))，m和n分别为两棵树的节点树，当一个树访问完时，自然就连接上另一个树的节点，故只访问了小树的节点数。
     * 空间复杂度：O(min(n,m))，递归栈深度也同时间，只访问了小树的节点数。
     *
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        //
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;

        TreeNode head = new TreeNode(t1.val + t2.val);

        head.left = mergeTrees(t1.left, t2.left);

        head.right = mergeTrees(t1.right, t2.right);

        return head;
    }

    /**
     * 方法2：非递归层次遍历
     *
     * 知识点：队列
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    //TODO
    public TreeNode mergeTrees2 (TreeNode t1, TreeNode t2) {


        return null;
    }


    public static void main(String[] args) {
        // 已知两个二叉树
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        MergeTree solution = new MergeTree();

        // 合并两棵二叉树
        TreeNode result = solution.mergeTrees(root1, root2);

        // 打印结果
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
