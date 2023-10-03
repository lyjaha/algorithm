package com.ly.leetcode.hot100.list;

import java.util.HashSet;
import java.util.Set;

/**
 *  160. 相交链表
 *
 *  给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 *  题目数据 保证 整个链式结构中不存在环。
 *  注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 *  输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 *  输出：Intersected at '8'
 *  解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 *  从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 *  在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。
 *  换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向
 *  相同的位置。
 *
 *  输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 *  输出：Intersected at '2'
 *  解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 *  从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
 *  在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 *
 *  输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 *  输出：null
 *  解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 *  由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 *  这两个链表不相交，因此返回 null 。
 *
 *
 */
public class IntersectionLists {

     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
     }

    /**
     * 方法1：哈希集合
     *
     * 知识点：哈希
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(m+n)，其中 m 和 n 是分别是链表 headA 和 headB 的长度。需要遍历两个链表各一次。
     * 空间复杂度：O(m)，其中 m 是链表 headA 的长度。需要使用哈希集合存储链表 headA 中的全部节点。
     *
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> visited = new HashSet<>();

        ListNode temp = headA;

        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }

        temp = headB;

        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    /**
     * 方法2：双指针
     *
     * 知识点：双指针
     *
     * 思路：
     * 1.初始化两个指针 pA 和 pB 分别指向链表 headA 和 headB 的头节点。
     * 2.同时遍历两个链表，当遍历到链表末尾时，将指针重新指向另一个链表的头节点。
     * 3.重复上述步骤，直到两个指针相等，即找到相交节点或都为 null，即两个链表不相交。
     *
     * 步骤：
     * 1、初始化指针 pA 和 pB 分别指向链表 headA 和 headB 的头节点。
     * 2.进入循环：
     *   如果 pA 和 pB 相等，则找到了相交节点，返回该节点。
     *   否则，如果 pA 为空，则将 pA 指向链表 headB 的头节点；如果 pB 为空，则将 pB 指向链表 headA 的头节点。
     *   继续向后遍历节点，更新指针。
     * 3.循环结束后，没有找到相交节点，返回 null。
     *
     * 时空复杂度：
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        // 指针pA指向链表headA的头节点
        ListNode pA = headA;
        // 指针pB指向链表headB的头节点
        ListNode pB = headB;

        // 循环直到找到相交节点或都为null（两个链表不相交）
        while (pA != pB) {
            // 如果pA为空，则将其指向链表B的头节点；如果pB为空，则将其指向链表A的头节点
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        // 构造示例链表
        ListNode commonNode = new ListNode(8);
        commonNode.next = new ListNode(4);
        commonNode.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = commonNode;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = commonNode;

        // 调用函数找到相交节点
        ListNode result = getIntersectionNode2(headA, headB);
        if (result != null) {
            System.out.println("相交节点的值为：" + result.val);
        } else {
            System.out.println("链表不相交");
        }
    }
}
