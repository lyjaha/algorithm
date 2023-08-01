package com.ly.nk.list;

/**
 * BM8 链表中倒数最后k个结点
 *
 * 描述：
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 *
 * 数据范围：
 * 0 ≤ n ≤ 10的5次方，0 ≤ ai ≤ 10的9次方，0 ≤ k ≤ 10的9次方
 *
 * 要求：空间复杂度O(n)，时间复杂度 O(n)
 * 进阶：空间复杂度O(1)，时间复杂度O(n)
 *
 * 示例
 * 输入：{1,2,3,4,5},2
 * 返回值：{4,5}
 * 说明：返回倒数第2个节点4，系统会打印后面所有的节点来比较。
 *
 * 输入：{2},8
 * 返回值：{}
 *
 * 举一反三：
 * 学习完本题的思路你可以解决如下题目：
 * BM4.合并有序链表
 * BM5.合并k个已排序的链表
 * BM6.判断链表中是否有环
 * BM7.链表中环的入口节点
 * BM9.删除链表的倒数第n个节点
 * BM10.两个链表的第一个公共节点
 * BM13.判断一个链表是否为回文结构
 * BM14.链表的奇偶重排
 *
 */
public class FindToKTailList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     *
     * 方法1：快慢双指针
     *
     * 知识点：双指针
     *
     * 思路：
     *
     *
     * 步骤：
     * 1：准备一个快指针，从链表头开始，在链表上先走k步。
     * 2：准备慢指针指向原始链表头，代表当前元素，则慢指针与快指针之间的距离一直都是k。
     * 3：快慢指针同步移动，当快指针到达链表尾部的时候，慢指针正好到了倒数k个元素的位置。
     *
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，总共遍历n个链表元素
     * 空间复杂度：O(1)，常数级指针变量，无额外辅助空间使用
     *
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {

        ListNode fast = pHead;
        ListNode slow = pHead;

        // 快指针先行 k 步
        for (int i = 0; i < k; i++) {
            if(fast != null){
                fast = fast.next;
            } else {
                //链表过短，没有倒数k
                return slow = null;
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 方法2：先找长度再找最后k
     *
     * 思路：
     *
     * 步骤：
     * 1：可以先遍历一次链表找到链表的长度。
     * 2：然后比较链表长度是否比k小，如果比k小返回一个空节点。
     * 3：如果链表足够长，则我们从头节点往后遍历n−k次即可找到所求。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，最坏情况下两次遍历链表n个元素
     * 空间复杂度：O(1)，常数级指针变量，无额外辅助空间使用
     *
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail2 (ListNode pHead, int k) {

        int n = 0;
        ListNode p = pHead;

        // 统计链表长度
        while (p != null) {
            n++;
            p = p.next;
        }

        //
        if (n < k) {
            return null;
        }

        p = pHead;
        //
        for (int i = 0; i < n - k; i++) {
            p = p.next;
        }
        return p;
    }
}
