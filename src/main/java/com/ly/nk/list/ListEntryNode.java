package com.ly.nk.list;

/**
 * BM7 链表中环的入口结点
 *
 * 描述：
 * 给一个长度为 n 链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 *
 * 数据范围： n ≤ 10000，1<=结点值<=10000
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * 示例
 * 输入：{1,2},{3,4,5}
 * 返回值：3
 * 说明：返回环形链表入口结点，我们后台程序会打印该环形链表入口结点对应的结点值，即3
 * 输入：{1},{}
 * 返回值："null"
 * 说明：没有环，返回对应编程语言的空结点，后台程序会打印"null"
 *
 * 输入： {},{2}
 * 返回值：2
 */
public class ListEntryNode {

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
     * 知识点：双指针
     *
     * 思路：
     * 1.判断链表是否有环。
     * 2.在有环的链表中找到环的入口。
     *
     * 步骤：
     * 1：使用BM6.判断链表中是否有环中的方法判断链表是否有环，并找到相遇的节点。
     * 2：慢指针继续在相遇节点，快指针回到链表头，两个指针同步逐个元素逐个元素开始遍历链表。
     * 3：再次相遇的地方就是环的入口。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，最坏情况下遍历链表两次
     * 空间复杂度：O(1)，使用了常数个指针，没有额外辅助空间
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = hasCycle(pHead);

        if (slow == null) {
            return null;
        }

        // 快指针回到表头
        ListNode fast = pHead;

        //再次相遇就是环的入口
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode hasCycle (ListNode head) {

        //
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return slow;
            }
        }
        return null;
    }
}

