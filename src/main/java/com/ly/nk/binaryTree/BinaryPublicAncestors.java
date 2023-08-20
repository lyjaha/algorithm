package com.ly.nk.binaryTree;

/**
 *  BM38 在二叉树中找到两个节点的最近公共祖先
 *
 *  描述：
 *  给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 *
 * 数据范围：树上节点数满足 1≤n≤10的5次方, 节点值val满足区间 [0,n)
 * 要求：时间复杂度O(n)
 *
 * 注：本题保证二叉树中每个节点的val值均不相同。
 *
 * 输入：{3,5,1,6,2,0,8,#,#,7,4},5,1
 * 返回值：3
 *
 * 输入：{3,5,1,6,2,0,8,#,#,7,4},2,7
 * 返回值：2
 *
 *
 */
public class BinaryPublicAncestors {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：路径比较法
     *
     * 知识点：深度优先搜索（dfs）
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return 0;
    }


    /**
     * 方法2：递归
     *
     * 知识点：二叉树递归
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor2 (TreeNode root, int o1, int o2) {
        //该子树没找到，返回-1
        if(root == null)
            return -1;

        //该节点是其中某一个节点
        if(root.val == o1 || root.val == o2)
            return root.val;

        //左子树寻找公共祖先
        int left = lowestCommonAncestor(root.left, o1, o2);

        //右子树寻找公共祖先
        int right = lowestCommonAncestor(root.right, o1, o2);

        //左子树为没找到，则在右子树中
        if(left == -1)
            return right;
        //右子树没找到，则在左子树中
        if(right == -1)
            return left;
        //否则是当前节点
        return root.val;
    }

    // 测试代码
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        BinaryPublicAncestors binaryPublicAncestors = new BinaryPublicAncestors();
        // 测试用例1：节点7和8
        int o1 = 7, o2 = 8;
        int lca1 = binaryPublicAncestors.lowestCommonAncestor2(root, o1, o2);
        System.out.println("测试用例1，最近共祖先的值为：" + lca1); // 3
        // 测试用例2：节点5和1
        o1 = 5; o2 = 1;
        int lca2 = binaryPublicAncestors.lowestCommonAncestor2(root, o1, o2);
        System.out.println("测试用例2，最近公共先的值为：" + lca2); // 3
        // 测试用3：节点6和4
        o1 = 6; o2 = 4;
        int lca3 = binaryPublicAncestors.lowestCommonAncestor2(root, o1, o2);
        System.out.println("测试用例3，最近公共祖的值为：" + lca3); // 5
    }

}
