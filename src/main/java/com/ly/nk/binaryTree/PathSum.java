package com.ly.nk.binaryTree;

/**
 *  BM29 二叉树中和为某一值的路径(一)
 *
 *  描述：
 *  给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
 *  1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
 *  2.叶子节点是指没有子节点的节点
 *  3.路径只能从父节点到子节点，不能从子节点到父节点
 *  4.总节点数目为n
 *
 *  数据范围：
 *  1.树上的节点数满足 0≤n≤10000
 *  2.每 个节点的值都满足 ∣val∣≤1000
 *
 *  要求：空间复杂度 O(n)，时间复杂度 O(n)
 *  进阶：空间复杂度O(树的高度)，时间复杂度O(n)
 *
 *  输入：{5,4,8,1,11,#,9,#,#,2,7},22
 *  返回值：true
 *
 *  输入：{1,2},0
 *  返回值：false
 *
 *  输入：{1,2},3
 *  返回值：true
 *
 *  输入：{},0
 *  返回值：false
 *
 */
public class PathSum {

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
     * 知识点：二叉树递归
     * 二叉树的递归，则是将某个节点的左子树、右子树看成一颗完整的树，那么对于子树的访问或者操作就是对于原树的访问或者操作
     * 的子问题，因此可以自我调用函数不断进入子树。
     *
     * 思路：
     *
     * 步骤：
     *  1：每次检查遍历到的节点是否为空节点，空节点就没有路径。
     *  2：再检查遍历到是否为叶子节点，且当前sum值等于节点值，说明可以刚好找到。
     *  3：检查左右子节点是否可以有完成路径的，如果任意一条路径可以都返回true，因此这里选用两个子节点递归的或。
     *
     * 时空复杂度：
     * 空间复杂度：O(n)，最坏情况二叉树化为链表，递归栈空间最大为n
     * 时间复杂度：O(n)，其中n为二叉树所有节点，前序遍历二叉树所有节点
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        //
        if (root == null) {
            return false;
        }

        //
        if (root.left == null && root.right == null && sum - root.val == 0){
            return true;
        }

        //
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    /**
     * 方法2：非递归
     *
     * 知识点：
     * 栈：
     * 深度优先搜索：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    public boolean hasPathSum2 (TreeNode root, int sum) {
        //
        if (root == null) {
            return false;
        }
        return true;
    }
}
