package com.ly.nk.list;

/**
 *  BM15 删除有序链表中重复的元素-I
 *
 *  描述：
 *  删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 *  例如：
 *  给出的链表为 1→1→2,返回1→2.
 *  给出的链表为 1→1→2→3→3,返回1→2→3.
 *
 *  数据范围：链表长度满足 0≤n≤100，链表中任意节点的值满足 ∣val∣≤100
 *
 *  进阶：空间复杂度O(1)，时间复杂度O(n)
 *
 *
 */
public class DeleteDuplicateList {

    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *  方法1：遍历
     *
     *  思路：
     *
     *  步骤：
     *  1：判断链表是否为空链表，空链表不处理直接返回。
     *  2：使用一个指针遍历链表，如果指针当前节点与下一个节点的值相同，我们就跳过下一个节点，当前节点直接连接下个节点的后一位。
     *  3：如果当前节点与下一个节点值不同，继续往后遍历。
     *  4：循环过程中每次用到了两个节点值，要检查连续两个节点是否为空。
     *
     *  时空复杂度：
     *  时间复杂度：O(n)，其中n为链表长度，遍历一次链表
     *  空间复杂度：O(1)，常数级指针变量使用，没有使用额外的辅助空间
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates (ListNode head) {
        //空链表
        if(head == null)
            return null;
        //遍历指针
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                //否则指针正常遍历
                cur = cur.next;
            }
        }
        return head;
    }
}
