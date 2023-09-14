package com.ly.nk.list;

/**
 * BM1.反转链表  LC.206
 *
 * 问题描述：
 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的
 * 数据范围： 0 ≤ n ≤ 1000
 *
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
 *
 * 举一反三：
 * 解决：
 * JZ6. 从尾到头打印链表
 *
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *  方式1：双指针迭代
     *
     * 思路：
     * 将链表反转，就是将每个表元的指针从向后变成向前，那我们可以遍历原始链表，将遇到的节点一一指针逆向即可。
     * 指针怎么逆向？不过就是断掉当前节点向后的指针，改为向前罢了。
     *
     * 步骤：
     * 1：先处理空链表，空链表不需要反转。
     * 2：设置两个指针，一个当前节点的指针，一个上一个节点的指针（初始为空）。
     * 3：遍历整个链表，每到一个节点，断开当前节点与后面节点的指针，并用临时变量记录后一个节点，
     * 然后当前节点指向上一个节点，即可以将指针逆向。
     * 4：再轮换当前指针与上一个指针，让它们进入下一个节点及下一个节点的前序节点。
     *
     *
     * 时空复杂度：
     *  时间复杂度：O(n),其中n为链表的长度。需要遍历整个链表才能完成反转操作。
     *  空间复杂度：O(1),只需要常量级别的额外空间用于指针操作。
     *
     * @param head
     * @return
     */
    public static ListNode reverseList (ListNode head) {
        // 处理空链表
        if (null == head) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;

        while (null != cur) {
            // 先保存访问的节点的下一个节点
            ListNode temp = cur.next;
            // 反转指针
            cur.next = pre;
            // pre指针向后移动
            pre = cur;
            // cur指针向后移动
            cur = temp;
        }
        return pre;
    }

    /**
     * 方法2：递归
     *
     * 思路：
     * 终止条件：当到达链表尾，要么当前指针是空，要么下一个指针是空，就返回。
     * 返回值：每一级返回反转后的子问题的头节点。
     * 本级任务：先进入后一个节点作为子问题。等到子问题都反转完成，再将本级节点与后一个的指针反转。
     *
     * 步骤：
     * 1：对于每个节点我们递归向下遍历到最后的尾节点。
     * 2：然后往上依次逆转两个节点。
     * 3：将逆转后的本层节点，即反转后这后半段子链表的尾，指向null，返回最底层上来的头部节点。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，相当于递归遍历一次链表
     * 空间复杂度：O(n)，递归栈深度为链表长度n
     */
    public ListNode reverseList2(ListNode head) {
        //递归结束条件
        if(head == null || head.next == null)
            return head;
        //反转下一个
        ListNode newHead = reverseList2(head.next);
        //逆转本级节点
        head.next.next = head;
        //尾部设置空节点
        head.next = null;
        return newHead;
    }

    // 测试方法
    public static void main(String[] args) {
        // 创建测试链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 反转链表
        ListNode reversedHead = reverseList(head);

        // 打印反转后的链表
        ListNode node = reversedHead;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }


}
