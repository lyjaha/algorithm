package com.ly.nk.list;

/**
 * BM4 合并两个排序的链表 （LC 21）
 *
 * 描述：
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 数据范围：0 ≤ n ≤ 1000，−1000 ≤ 节点值 ≤ 1000
 *
 * 要求 空间复杂度 O(1)，时间复杂度 O(n)
 *
 * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}
 * 或输入{-1,2,4},{1,3,4}时，合并后的链表为{-1,1,2,3,4,4}，所以对应的输出为{-1,1,2,3,4,4}
 *
 *
 *
 */
public class MergeList {

    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 方式一：递归
     *
     * 步骤：
     *
     *
     * 时间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。
     * 空间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


}
