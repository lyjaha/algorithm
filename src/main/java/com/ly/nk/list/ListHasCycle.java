package com.ly.nk.list;

/**
 * BM6 判断链表中是否有环 LC.141
 *
 * 描述：
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 *
 * 数据范围：
 * 链表长度 0 ≤n ≤ 10000，链表中任意节点的值满足 ∣val∣ <= 100000
 *
 * 要求：
 * 空间复杂度 O(1)，时间复杂度 O(n)
 *
 * 输入分为两部分，第一部分为链表，第二部分代表是否有环，然后将组成的head头结点传入到函数里面。-1代表无环，
 * 其它的数字代表有环。
 *
 * 举一反三：
 * 学习完本题的思路你可以解决如下题目：
 * BM4.合并有序链表
 * BM5.合并k个已排序的链表
 * BM7.链表中环的入口节点
 * BM8.链表中倒数最后k个节点
 * BM9.删除链表的倒数第n个节点
 * BM10.两个链表的第一个公共节点
 * BM13.判断一个链表是否为回文结构
 * BM14.链表的奇偶重排
 *
 * 总结：
 * 获取倒数第k个元素，获取中间位置的元素，判断链表是否存在环，判断环的长度等，这些长度与位置有关的问题。
 * 都可以通过灵活运用双指针来解决。
 *
 */
public class ListHasCycle {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    /**
     * 方法1：双指针（快慢指针）
     *
     * 知识点：双指针
     *
     * 思路：需要了解 Floyd判圈算法（龟兔赛跑算法）。
     *
     * 步骤：
     * 1：设置快慢两个指针，初始都指向链表头。
     * 2：遍历链表，快指针每次走两步，慢指针每次走一步。
     * 3：如果快指针到了链表末尾，说明没有环，因为它每次走两步，所以要验证连续两步是否为NULL。
     * 4：如果链表有环，那快慢双指针会在环内循环，因为快指针每次走两步，因此快指针会在环内追到慢指针，二者相遇就代表有环。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，最坏情况下遍历链表n个节点
     * 空间复杂度：O(1)，仅使用了两个指针，没有额外辅助空间
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        //
        if(head == null){
            return false;
        }
        //
        ListNode fast = head;
        ListNode slow = head;

        //
        while (fast != null && fast.next != null) {
            //
            fast = fast.next.next;
            //
            slow = slow.next;
            // 相遇则有环
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
