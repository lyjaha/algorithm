package com.ly.nk.list;

/**
 * BM10 两个链表的第一个公共结点
 *
 * 描述：
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * 数据范围：n≤1000
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * 示例
 * 输入：{1,2,3},{4,5},{6,7}
 * 返回值：{6,7}
 * 说明：第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，最后的{6,7}表示的是2个链表
 * 的公共部分这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的
 *
 */
public class FindFirstNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     *  方法1：双指针长度比较法
     *
     *  思路：
     *
     *  步骤：
     *  1：单独的遍历两个链表，得到各自的长度。
     *  2：求得两链表的长度差 n，其中较长的链表的指针从头先走n步。
     *  3：两链表指针同步向后遍历，遇到第一个相同的节点就是第一个公共节点。
     *
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为两链表较长者的长度，虽是多次循环，但都为单循环，取最大值即为O(n)
     * 空间复杂度：O(1)，常数级指针，无额外辅助空间使用
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        int p1 = calcListLength(pHead1);
        int p2 = calcListLength(pHead2);

        // p1 链表更长时，提前走n步
        if (p1 >= p2) {
            int n = p1 - p2;
            for (int i = 0; i < n; i++) {
                pHead1 = pHead1.next;
            }
            //
            while ((pHead1 != null) && (pHead2 != null) && (pHead1 != pHead2)) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }else {
            int n = p2 - p1;
            for (int i = 0; i < n; i++) {
                pHead2 = pHead2.next;
            }
            while ((pHead1 != null) && (pHead2 != null) && (pHead1 != pHead2)) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return pHead1;
//        return pHead2;
    }


    /**
     *  计算列表长度
     * @param node
     * @return
     */
    private int calcListLength (ListNode node) {

        ListNode p = node;
        int n = 0;
        while (node != null) {
            p = p.next;
            n++;
        }
        return n;
    }

    /**
     * 方法2：双指针连接法
     *
     * 思路：
     *
     * 步骤：
     * 1：判断链表情况，其中有一个为空，则不能有公共节点，返回null。
     * 2：两个链表都从表头开始同步依次遍历。
     * 3：不需要物理上将两个链表连在一起，仅需指针在一个链表的尾部时直接跳到另一个链表的头部。
     * 4：根据上述说法，第一个相同的节点便是第一个公共节点。
     *
     * 时空复杂度：
     * 时间复杂度：O(n+m)，其中m与n分别为两链表的长度，因一次遍历两链表，所以为O(n+m)，也可以看成是O(n)级别的
     * 空间复杂度：O(1)，常数级指针，无额外辅助空间使用
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {

        //
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        //相当于遍历两次两个链表所有值
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }

}
