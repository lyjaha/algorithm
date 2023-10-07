package com.ly.leetcode.hot100.list;

/**
 *  206. 反转链表
 *
 *  给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *  输入：head = [1,2,3,4,5]
 *  输出：[5,4,3,2,1]
 *
 *  输入：head = [1,2]
 *  输出：[2,1]
 *
 *  输入：head = []
 *  输出：[]
 *
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 方法1：迭代
     *
     * 知识点：
     *
     * 思路：
     * 1. 使用三个指针 `prev`、`curr` 和 `next` 来反转链表。
     * 2. 初始化 `prev` 为 null，将 `curr` 指向链表的头节点 `head`。
     * 3. 进入循环，循环条件为 `curr` 不为 null：
     *    - 在循环内，首先保存 `curr.next` 到 `next`，暂存下一个节点的地址。
     *    - 然后将 `curr` 的指针反向指向 `prev`。
     *    - 更新 `prev` 为 `curr`，`curr` 为 `next`，即向前移动指针。
     * 4. 循环结束后，返回 `prev`，该指针指向反转后的链表的头节点。
     *
     * 步骤：
     * 1. 初始化 `prev` 为 null，将 `curr` 指向链表的头节点 `head`。
     * 2. 进入循环，循环条件为 `curr` 不为 null：
     *    - 在循环内，首先保存 `curr.next` 到 `next`，暂存下一个节点的地址。
     *    - 然后将 `curr` 的指针反向指向 `prev`。
     *    - 更新 `prev` 为 `curr`，`curr` 为 `next`。
     * 3. 循环结束后，返回 `prev`。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
     * 空间复杂度：O(1)，只使用了常数个额外的指针变量。
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 反转后链表的头节点
        ListNode prev = null;
        // 当前节点
        ListNode curr = head;
        // 下一个节点
        ListNode next = null;

        // 循环直到当前节点为null
        while (curr != null) {
            // 保存下一个节点的地址
            next = curr.next;
            // 反向指向prev
            curr.next = prev;
            // 更新prev为当前节点
            prev = curr;
            // 更新curr为下一个节点
            curr = next;
        }
        // 返回反转后的链表的头节点
        return prev;
    }


    /**
     * 方法2：递归
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。
     * 空间复杂度：O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);

        head.next.next = head;

        head.next = null;

        return newHead;

    }



    /**
     * 方法3：
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        return null;

    }

    public static void main(String[] args) {
        // 构造示例链表：1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 反转链表
        ListNode reversedList = reverseList(head);

        // 输出反转后的链表：5 -> 4 -> 3 -> 2 -> 1
        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
    }
}
