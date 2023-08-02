package com.ly.nk.list;

/**
 *  BM9 删除链表的倒数第n个节点
 *  描述
 * 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
 * 例如，
 * 给出的链表为: 1→2→3→4→5, n=2.
 * 删除了链表的倒数第 n 个节点之后,链表变为1→2→3→5.
 *
 * 数据范围： 链表长度0≤n≤1000，链表中任意节点的值满足0≤val≤100
 * 要求：空间复杂度O(1)，时间复杂度O(n)
 *
 * 示例
 * 输入：{1,2},2
 * 返回值：{2}
 *
 * 举一反三：
 * 学习完本题的思路你可以解决如下题目：
 * BM4.合并有序链表
 * BM5.合并k个已排序的链表
 * BM6.判断链表中是否有环
 * BM7.链表中环的入口节点
 * BM8.链表中倒数最后k个节点
 * BM10.两个链表的第一个公共节点
 * BM13.判断一个链表是否为回文结构
 * BM14.链表的奇偶重排
 */
public class RemoveListTailList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 方法1：双指针（推荐使用）
     *
     * 思路：
     *
     * 步骤：
     * 1：给链表添加一个表头，处理删掉第一个元素时比较方便。
     * 2：准备一个快指针，在链表上先走n步。
     * 3：准备慢指针指向原始链表头，代表当前元素，前序节点指向添加的表头，这样两个指针之间相距就是一直都是n。
     * 4：快慢指针同步移动，当快指针到达链表尾部的时候，慢指针正好到了倒数n个元素的位置。
     * 5：最后将该节点前序节点的指针指向该节点后一个节点，删掉这个节点。
     *
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        //添加表头
        ListNode res = new ListNode(-1);
        res.next = head;
        //当前节点
        ListNode cur = head;
        //前序节点
        ListNode pre = res;
        ListNode fast = head;
        //快指针先行n步
        while(n != 0){
            fast = fast.next;
            n--;
        }
        //快慢指针同步，快指针到达末尾，慢指针就到了倒数第n个位置
        while(fast != null){
            fast = fast.next;
            pre = cur;
            cur = cur.next;
        }
        //删除该位置的节点
        pre.next = cur.next;
        //返回去掉头
        return res.next;
    }

}
