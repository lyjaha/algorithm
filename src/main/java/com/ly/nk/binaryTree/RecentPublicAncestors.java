package com.ly.nk.binaryTree;

/**
 *  BM37 二叉搜索树的最近公共祖先
 *
 *  描述：
 *  给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *  1.对于该题的最近的公共祖先定义:对于有根树T的两个节点p、q，最近公共祖先LCA(T,p,q)表示一个节点x，
 *  满足x是p和q的祖先且x的深度尽可能大。在这里，一个节点也可以是它自己的祖先.
 *  2.二叉搜索树若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，
 *  则右子树上所有节点的值均大于它的根节点的值
 *  3.所有节点的值都是唯一的。
 *  4.p、q 为不同节点且均存在于给定的二叉搜索树中。
 * 数据范围:
 *  3<=节点总数<=10000
 *  0<=节点值<=10000
 *
 * 输入：{7,1,12,0,4,11,14,#,#,3,5},1,12
 * 返回值：7
 * 说明：节点1 和 节点12的最近公共祖先是7
 *
 * 输入：{7,1,12,0,4,11,14,#,#,3,5},12,11
 * 返回值：12
 * 说明：因为一个节点也可以是它自己的祖先.所以输出12
 *
 */
public class RecentPublicAncestors {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 方法1：搜索路径比较
     *
     * 知识点：二叉搜索树
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param root TreeNode类
     * @param p int整型
     * @param q int整型
     * @return int整型
     */
    public static int lowestCommonAncestor (TreeNode root, int p, int q) {
        return 0;
    }


    /**
     * 方法2：一次遍历
     *
     * 知识点：二叉树递归
     *
     * 思路：
     *
     * 步骤：
     *  1：首先检查空节点，空树没有公共祖先。
     *  2：对于某个节点，比较与p、q的大小，若p、q在该节点两边说明这就是最近公共祖先。
     *  3：如果p、q都在该节点的左边，则递归进入左子树。
     *  4：如果p、q都在该节点的右边，则递归进入右子树。
     *
     * 时空复杂度：
     *
     * @param root TreeNode类
     * @param p int整型
     * @param q int整型
     * @return int整型
     */
    public static int lowestCommonAncestor2 (TreeNode root, int p, int q) {
        //空树找不到公共祖先
        if(root == null)
            return -1;
        //如果根节点的值在p和q的值之间，那么它就是最近公共祖先
        if ((p >= root.val && q <= root.val) || (p <= root.val && q >= root.val)) {
            return root.val;
        }
        // 如果根节点的值大于q的值，那么p和q都在左子树中搜索
        if (p <= root.val && q <= root.val) {
            return lowestCommonAncestor2(root.left, p, q);
        }else {
            return lowestCommonAncestor2(root.right, p, q);
        }

//        if (root.val > q.val) {     // 如果根节点的值大于q的值，那么p和q都在左子树中搜索
//            return lowestCommonAncestor(root.left, p, q);
//        } else if (root.val < p.val) {     // 如果根节点的值小于p的值，么p和q都在右子树中搜索
//            return lowestCommonAncestor(root.right, p, q);
//        }
    }

    public static void main(String[] args) {
//        // 构造一棵二叉搜索树
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(7);
//        root.right.right = new TreeNode(9);
//        root.left.right.left = new TreeNode();
//        root.left.right.right = new TreeNode(5);
//
//        TreeNode p = root.left;
//        TreeNode q = root.right;
//        RecentPublicAncestors ancestors = new RecentPublicAncestors();
//        int res = ancestors.lowestCommonAncestor2(root, p, q);
//        System.out.println(res.val);   // 输出结果为6
//
//        p = root.left.right.left;
//        q = root.left.right.right;
//        res = ancestors.lowestCommonAncestor2(root, p, q);
//        System.out.println(res.val);   // 输出结果为4
    }





}
