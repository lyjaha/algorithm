package com.ly.nk.list;

public class ReverseList {

    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 问题描述：
     * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的
     * 数据范围： 0 ≤ n ≤ 1000
     *
     * 要求：空间复杂度 O(1)，时间复杂度 O(n)
     *
     * 如当输入链表{1,2,3}时，
     * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
     */

    /**
     *  方式一 迭代
     *  步骤：
     *  1.空链表直接返回，不需要反转
     *  2.设置2个指针，1个当前节点，1个上1个节点
     *  3.遍历链表，每到1个节点，断开当前节点与后面节点的指针，并用临时变量记录后1个节点，
     *  然后当前节点指向上1个节点，即可将指针逆向
     *  4.再轮换当前指针与上1个指针，让他们进入下1个节点及下1个节点的前序节点
     *
     *  时间复杂度：O(n),一次循环，只遍历链表一次
     *  空间复杂度：O(1),常数级变量，无需额外辅助空间使用
     *
     * @param head
     * @return
     */
    public ListNode ReverseList (ListNode head) {
        // 处理空链表
        if (null == head) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (null != cur) {
            // 断开链表，记录后续1个
            ListNode temp = cur.next;
            // 当前next指向前1个
            cur.next = pre;
            // 前1个更新为当前
            pre = cur;
            // 当前更新为刚刚记录的最后1个
            cur = temp;
        }
        return pre;
    }

    /**
     * 方法二：递归
     * 终止条件：当到达链表尾，要么当前指针是空，要么下一个指针是空，就返回。
     * 返回值：每一级返回反转后的子问题的头节点。
     * 本级任务：先进入后一个节点作为子问题。等到子问题都反转完成，再将本级节点与后一个的指针反转。
     *
     * 步骤：
     * 1：对于每个节点我们递归向下遍历到最后的尾节点。
     * 2：然后往上依次逆转两个节点。
     * 3：将逆转后的本层节点，即反转后这后半段子链表的尾，指向null，返回最底层上来的头部节点。
     *
     * 时间复杂度：O(n)，相当于递归遍历一次链表
     * 空间复杂度：O(n)，递归栈深度为链表长度n
     */
    public ListNode ReverseList2 (ListNode head) {
        //递归结束条件
        if(head == null || head.next == null)
            return head;
        //反转下一个
        ListNode newHead = ReverseList(head.next);
        //逆转本级节点
        head.next.next = head;
        //尾部设置空节点
        head.next = null;
        return newHead;
    }
}
