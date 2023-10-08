package com.ly.leetcode.hot100.list;

/**
 * 234. 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 输入：head = [1,2]
 * 输出：false
 *
 */
public class Palindrome {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 方法1：快慢指针
     *
     * 知识点：
     *
     * 思路：
     * 1.使用快慢指针法找到链表的中间节点。
     * 2.反转链表的后半部分。
     * 3.比较前半部分和反转后的后半部分的节点值是否相等。
     * 4.如果所有节点的值都相等，则链表是回文链表，返回 true；否则，返回 false。
     *
     * 步骤：
     * 1.使用快慢指针法找到链表的中间节点：利用快指针每次移动两步，慢指针每次移动一步，当快指针到达链表末尾时，慢指针指向的节点
     *   就是中间节点。
     * 2.反转链表的后半部分：从中间节点开始，依次将后续节点插入到中间节点的前面，实现链表的反转。
     * 3.遍历前半部分和反转后的后半部分，比较节点值是否相等。
     * 4.如果遍历过程中存在节点值不相等的情况，则链表不是回文链表，返回 false；否则，链表是回文链表，返回 true。
     *
     * 时空复杂度：
     * 时间复杂度：该算法的时间复杂度为 O(n)，其中 n 是链表的长度。遍历链表的两个步骤都需要 O(n) 的时间。
     * 空间复杂度：该算法的空间复杂度为 O(1)，只使用了常数个额外的指针变量。
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        // 寻找链表的中间节点
        ListNode middle = findMiddle(head);

        // 反转链表的后半部分
        ListNode reversedHalf = reverseList(middle);

        // 比较前半部分和反转后的后半部分的节点值
        while (head != null && reversedHalf != null) {
            if (head.val != reversedHalf.val) {
                // 节点值不相等，不是回文链表
                return false;
            }
            head = head.next;
            reversedHalf = reversedHalf.next;
        }
        // 所有节点的值都相等，是回文链表
        return true;
    }

    private static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        //TODO
        return true;

    }

    public static void main(String[] args) {
        // 构造示例链表：1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        // 调用isPalindrome函数判断链表是否是回文链表
        boolean result = isPalindrome(head);
        System.out.println("该链表是否是回文链表：" + result);
    }
}
