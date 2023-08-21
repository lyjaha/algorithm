package com.ly.nk.binaryTree;

/**
 *  BM39 序列化二叉树
 *
 *  描述：
 *  请实现两个函数，分别用来序列化和反序列化二叉树，不对序列化之后的字符串进行约束，但要求能够根据序列化之后的字符串重新构造出
 *  一棵与原二叉树相同的树。
 *
 *  二叉树的序列化(Serialize)是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树
 *  可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树等遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过
 *  某种符号表示空节点（#）
 *
 * 二叉树的反序列化(Deserialize)是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 层序序列化(即用函数Serialize转化)如上的二叉树转为"{1,2,3,#,#,6,7}"，再能够调用反序列化(Deserialize)
 * 将"{1,2,3,#,#,6,7}"构造成如上的二叉树。
 *
 * 当然你也可以根据满二叉树结点位置的标号规律来序列化，还可以根据先序遍历和中序遍历的结果来序列化。不对序列化之后的字符串
 * 进行约束，所以欢迎各种奇思妙想。
 *
 * 数据范围：节点数 n≤100，树上每个节点的值满足 0≤val≤150
 * 要求：序列化和反序列化都是空间复杂度 O(n)，时间复杂度O(n)
 *
 *  输入：{1,2,3,#,#,6,7}
 *  返回值：{1,2,3,#,#,6,7}
 *
 *
 *
 */
public class SerializeTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：前序遍历
     *
     * 知识点：二叉树递归
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为二叉树节点数，前序遍历，每个节点遍历一遍
     * 空间复杂度：O(n)，最坏情况下，二叉树退化为链表，递归栈最大深度为 n
     *
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        //处理空树
        if(root == null)
            return "#";

        StringBuilder res = new StringBuilder();

        serializeFunction(root, res);

        //把str转换成char
        return res.toString();
    }

    //序列的下标
    public int index = 0;
    //处理序列化的功能函数（递归）
    private void serializeFunction(TreeNode root, StringBuilder str){
        //如果节点为空，表示左子节点或右子节点为空，用#表示
        if(root == null){
            str.append('#');
            return;
        }
        //根节点
        str.append(root.val).append('!');
        //左子树
        serializeFunction(root.left, str);
        //右子树
        serializeFunction(root.right, str);
    }


    TreeNode Deserialize(String str) {
        //空序列对应空树
        if(str == "#")
            return null;
        TreeNode res = deserializeFunction(str);
        return res;
    }


    //处理反序列化的功能函数（递归）
    private TreeNode deserializeFunction(String str){
        //到达叶节点时，构建完毕，返回继续构建父节点
        //空节点
        if(str.charAt(index) == '#'){
            index++;
            return null;
        }
        //数字转换
        int val = 0;
        //遇到分隔符或者结尾
        while(str.charAt(index) != '!' && index != str.length()){
            val = val * 10 + ((str.charAt(index)) - '0');
            index++;
        }
        TreeNode root = new TreeNode(val);
        //序列到底了，构建完成
        if(index == str.length())
            return root;
        else
            index++;
        //反序列化与序列化一致，都是前序
        root.left = deserializeFunction(str);
        root.right = deserializeFunction(str);
        return root;
    }

}
