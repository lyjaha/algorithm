package com.ly.nk.list;

/**
 * BM3.链表中的节点每 k 个一组翻转  LC.25
 *
 * 描述：
 * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 *
 * 数据范围：0 ≤ n ≤ 2000 ，1 ≤ k ≤ 2000 ，链表中每个元素都满足 0 ≤ val ≤ 1000
 * 要求 空间复杂度 O(1)，时间复杂度 O(n)
 *
 * 例如：
 * 给定的链表是 1 → 2 → 3 → 4 → 5
 * 对于 k = 2 , 你应该返回 2 → 1 → 4 → 3 → 5
 * 对于 k = 3 , 你应该返回 3 → 2 → 1 → 4 → 5
 *
 * 举一反三：
 * 学习完本题的思路你可以解决如下题目：
 *
 * BM1.反转链表
 * BM2.链表内指定区间反转
 */
public class ReverseKGroup {

     public class ListNode {
       int val;
       ListNode next = null;
       public ListNode(int val) {
         this.val = val;
       }
     }

    /**
     * 方法1 模拟
     *
     * 思路：
     *
     *
     * 步骤：
     * 1.把链表节点按照 k 个一组分组，使用一个指针 head 依次指向每组的头节点。
     * 2.指针每次向前移动 k 步，直至链表结尾。
     * 3.对于每个分组，我们先判断它的长度是否大于等于 k。若是，我们就翻转这部分链表，否则不需要翻转。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中 n 为链表的长度。
     * 空间复杂度：O(1)，只需要建立常数个变量。
     *
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2 (ListNode head, int k) {
        // 不需要反转的情况
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }
        // 定义虚拟节点
        ListNode dummy = new ListNode(0);
        // 虚拟节点的next指向 head
        dummy.next = head;
        //
        ListNode pre = dummy;

        //求链表长度
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }

        for(int i = 0; i < len / k; i++) {
            ListNode groupHead = head;
            ListNode groupTail = null;
            for(int j = 0; j < k; j++) {
                ListNode next = head.next;
                head.next = groupTail;
                groupTail = head;
                head = next;
            }
            pre.next = groupTail;
            groupHead.next = head;
            pre = groupHead;
        }
        return dummy.next;

    }

    /**
     * 方式2：递归
     *
     * 思路：
     *
     *
     * 步骤：
     *  1：每次从进入函数的头节点优先遍历链表k次，分出一组，若是后续不足k个节点，不用反转直接返回头。
     *  2：从进入函数的头节点开始，依次反转接下来的一组链表，反转过程同BM1.反转链表。
     *  3：这一组经过反转后，原来的头变成了尾，后面接下一组的反转结果，下一组采用上述递归继续。
     *
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，一共遍历链表 n 个节点
     * 空间复杂度：O(n)，递归栈最大深度 为n/k
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup (ListNode head, int k) {

        //找到每次翻转的尾部
        ListNode tail = head;
        //遍历k次到尾部
        for(int i = 0; i < k; i++){
            //如果不足k到了链表尾，直接返回，不翻转
            if(tail == null)
                return head;
            tail = tail.next;
        }
        //翻转时需要的前序和当前节点
        ListNode pre = null;
        ListNode cur = head;
        //在到达当前段尾节点前
        while(cur != tail){
            //翻转
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        //当前尾指向下一段要翻转的链表
        head.next = reverseKGroup(tail, k);
        return pre;
    }

    /**
     *  方法3 栈
     *
     */
}
