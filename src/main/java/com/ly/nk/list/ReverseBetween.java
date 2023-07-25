package com.ly.nk.list;

/**
 * 2.链表内指定区间反转
 *
 * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)。
 * 例如：
 * 给出的链表为 1 → 2 → 3 → 4 → 5 → NULL, m=2,n=4,
 * 返回 1 → 4 → 3 → 2 → 5 → NULL.
 *
 * 数据范围： 链表长度 0 < size ≤ 1000，0 < m ≤ n ≤ size，链表中每个节点的值满足 ∣val∣ ≤ 1000
 * 要求：时间复杂度 O(n)，空间复杂度 O(n)
 * 进阶：时间复杂度 O(n)，空间复杂度 O(1)
 *
 * 输入：{1,2,3,4,5},2,4
 * 返回值：{1,4,3,2,5}
 *
 * 举一反三
 * BM1.反转链表
 * BM3.链表中的节点每k个一组翻转
 */
public class ReverseBetween {

    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**

     */

    /**
     * 步骤：
     * step 1：在链表前加一个表头，后续返回时去掉，因为如果要从链表头的位置开始反转，在多了一个表头的情况下就能保证第一个节点
     * 永远不会反转，不会到后面去。
     * step 2：使用两个指针，一个指向当前节点，一个指向前序节点。
     * step 3：依次遍历链表，到第m个的位置。
     * step 4：对于从m到n这些个位置的节点，依次断掉指向后续的指针，反转指针方向。
     * step 5：返回时去掉添加的表头。
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */

    public ListNode reverseBetween (ListNode head, int m, int n) {

        // 表头
        ListNode res = new ListNode(-1);
        res.next = head;

        // 前序节点
        ListNode pre = res;
        // 当前节点
        ListNode cur = head;

        // 找到m
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        // 从m反转到n
        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        //返回去掉表头
        return res.next;
    }
}
