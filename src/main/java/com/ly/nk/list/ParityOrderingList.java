package com.ly.nk.list;

/**
 *  BM14 链表的奇偶重排
 *
 *  描述：
 *  给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 *  注意是节点的编号而非节点的数值。
 *
 * 数据范围：节点数量满足 0≤n≤10的5次方，节点中的值都满足 0≤val≤1000
 * 要求：空间复杂度 O(n)，时间复杂度 O(n)
 *
 *
 *  示例：
 *  输入：{1,2,3,4,5,6}
 *  返回值：{1,3,5,2,4,6}
 *
 *  输入：{1,4,6,3,7}
 *  返回值：{1,6,7,4,3}
 *
 */
public class ParityOrderingList {

    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：双指针
     *
     * 思路：
     *
     * 步骤：
     * 1：判断空链表的情况，如果链表为空，不用重排。
     * 2：使用双指针odd和even分别遍历奇数节点和偶数节点，并给偶数节点链表一个头。
     * 3：上述过程，每次遍历两个节点，且even在后面，因此每轮循环用even检查后两个元素是否为NULL，
     * 如果不为null再进入循环进行上述连接过程。
     * 4：将偶数节点头接在奇数最后一个节点后，再返回头部。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，遍历一次链表的所有节点
     * 空间复杂度：O(1)，常数级指针，无额外辅助空间
     *
     * @param head
     * @return
     */
    public static ListNode parityOrdering(ListNode head) {

        //如果链表为空，不用重排
        if(head == null) {
            return head;
        }
        //even开头指向第二个节点，可能为空
        ListNode even = head.next;
        //odd开头指向第一个节点
        ListNode odd = head;
        //指向even开头
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            //odd连接even的后一个，即奇数位
            odd.next = even.next;
            //odd进入后一个奇数位
            odd = odd.next;
            //even连接后一个奇数的后一位，即偶数位
            even.next = odd.next;
            //even进入后一个偶数位
            even = even.next;
        }
        //even整体接在odd后面
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        System.out.println(parityOrdering(node1));
    }
}
