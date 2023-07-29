package com.ly.nk.list;

/**
 * BM5 合并k个已排序的链表  LC.23
 *
 * 描述
 * 合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
 * 数据范围：
 * 节点总数 0 ≤ n ≤ 5000，每个节点的val满足 ∣val∣ <= 1000
 *
 * 要求：
 * 时间复杂度 O(nlogn)
 *
 * 示例：
 * 输入：[{1,2,3},{4,5,6,7}]
 * 返回值：{1,2,3,4,5,6,7}
 *
 * 举一反三：
 * 学习完本题的思路你可以解决如下题目：
 * BM4.合并有序链表
 * BM6.判断链表中是否有环
 * BM7.链表中环的入口节点
 * BM8.链表中倒数最后k个节点
 * BM9.删除链表的倒数第n个节点
 * BM10.两个链表的第一个公共节点
 * BM13.判断一个链表是否为回文结构
 * BM14.链表的奇偶重排
 *
 */
public class MergeKList {

    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *  方法1：归并排序思想（推荐使用）
     *
     *  知识点：
     *  1.双指针
     *  2.分治
     *
     *  思路：
     *  如果是两个有序链表合并，我们可能会利用归并排序合并阶段的思想：准备双指针分别放在两个链表头，每次取出较小的一个元素
     *  加入新的大链表，将其指针后移，继续比较，这样我们出去的都是最小的元素，自然就完成了排序。
     *
     *  归并排序是什么？简单来说就是将一个数组每次划分成等长的两部分，对两部分进行排序即是子问题。对子问题继续划分，直到子问题
     *  只有1个元素。还原的时候呢，将每个子问题和它相邻的另一个子问题利用上述双指针的方式，1个与1个合并成2个，2个与2个合并成4个，
     *  因为这每个单独的子问题合并好的都是有序的，直到合并成原本长度的数组。
     *
     * 对于这k个链表，就相当于上述合并阶段的k个子问题，需要划分为链表数量更少的子问题，直到每一组合并时是两两合并，然后继续往上
     * 合并，这个过程基于递归：
     *
     * 终止条件： 划分的时候直到左右区间相等或左边大于右边。
     * 返回值： 每级返回已经合并好的子问题链表。
     * 本级任务： 对半划分，将划分后的子问题合并成新的链表。
     *
     *
     * 步骤：
     * 1：从链表数组的首和尾开始，每次划分从中间开始划分，划分成两半，得到左边 n/2 个链表和右边 n/2 个链表。
     * 2：继续不断递归划分，直到每部分链表数为1.
     * 3：将划分好的相邻两部分链表，按照两个有序链表合并的方式合并，合并好的两部分继续往上合并，直到最终合并成一个链表。
     *
     * 时空复杂度：
     *时间复杂度：O(nlog2k)，其中n为所有链表的总节点数，分治为二叉树型递归，最坏情况下二叉树每层合并都是O(n)个节点，
     * 因为分治一共有O(log2k)层
     * 空间复杂度：O(log2k)，最坏情况下递归log2k层，需要log2k的递归栈
     */

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {

        //一个已经为空了，直接返回另一个
        if (l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }

        //加一个表头(-1 / 0)
        ListNode head = new ListNode(0);
        ListNode tail = head, l1Ptr = l1, l2Ptr = l2;

        while (l1Ptr != null && l2Ptr != null) {
            if (l1Ptr.val < l2Ptr.val) {
                tail.next = l1Ptr;
                l1Ptr = l1Ptr.next;
            } else {
                tail.next = l2Ptr;
                l2Ptr = l2Ptr.next;
            }
            tail = tail.next;
        }
        tail.next = (l1Ptr != null ? l1Ptr : l2Ptr);
        return head.next;
    }


    /**
     * 方法2：优先队列
     *
     */

}
