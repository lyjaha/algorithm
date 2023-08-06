package com.ly.nk.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BM12 单链表的排序
 *
 * 描述
 * 给定一个节点数为n的无序单链表，对其按升序排序。
 *
 * 数据范围：0<n≤100000，保证节点权值在 [−10的9次方到10的9次方] 之内。
 *
 * 要求：
 * 空间复杂度O(n)，
 * 时间复杂度O(nlogn)
 *
 * 示例
 * 输入：[1,3,2,4,5]
 * 返回值：{1,2,3,4,5}
 *
 * 输入：[-1,0,-2]
 * 返回值：{-2,-1,0}
 *
 * 举一反三：
 * 学习完本题的思路你可以解决如下题目：
 * BM5.合并k个已排序的链表
 * BM20.数组中的逆序对
 *
 */
public class SortOneList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 方法1：归并排序
     *
     * 知识点：
     * 分治
     * 双指针
     *
     * 思路：
     *
     * 步骤：
     * 1：首先判断链表为空或者只有一个元素，直接就是有序的。
     * 2：准备三个指针，快指针right每次走两步，慢指针mid每次走一步，前序指针left每次跟在mid前一个位置。三个指针遍历链表，
     * 当快指针到达链表尾部的时候，慢指针mid刚好走了链表的一半，正好是中间位置。
     * 3：从left位置将链表断开，刚好分成两个子问题开始递归。
     * 4：将子问题得到的链表合并，参考合并两个有序链表。
     *
     * 时空复杂度：
     * 空间复杂度：O(log2n)，递归栈的深度最坏为树型递归的深度，log2n层
     * 时间复杂度：O(nlog2n)，每级划分最坏需要遍历链表全部元素，因此为O(n)，每级合并都是将同级的子问题链表遍历合并，
     * 因此也为O(n)，分治划分为二叉树型，一共有O(log2n)层，因此复杂度为O((n+n) ∗ log2n)=O(nlog2n)
     *
     * @param head
     * @return
     */
    public ListNode sortInList (ListNode head) {
        //链表为空或者只有一个元素，直接就是有序的
        if (head == null || head.next == null) {
            return null;
        }

        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;

        //右边的指针到达末尾时，中间的指针指向该段链表的中间
        while (right != null && right.next != null){
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        //左边指针指向左段的左右一个节点，从这里断开
        left.next = null;
        //分成两段排序，合并排好序的两段
        return merge(sortInList(head), sortInList(mid));
    }

    //合并两段有序链表
    private ListNode merge(ListNode pHead1, ListNode pHead2) {
        //一个已经为空了，直接返回另一个
        if(pHead1 == null)
            return pHead2;
        if(pHead2 == null)
            return pHead1;
        //加一个表头
        ListNode head = new ListNode(0);
        ListNode cur = head;
        //两个链表都要不为空
        while(pHead1 != null && pHead2 != null){
            //取较小值的节点
            if(pHead1.val <= pHead2.val){
                cur.next = pHead1;
                //只移动取值的指针
                pHead1 = pHead1.next;
            }else{
                cur.next = pHead2;
                //只移动取值的指针
                pHead2 = pHead2.next;
            }
            //指针后移
            cur = cur.next;
        }
        //哪个链表还有剩，直接连在后面
        if(pHead1 != null)
            cur.next = pHead1;
        else
            cur.next = pHead2;
        //返回值去掉表头
        return head.next;
    }

    /**
     * 方法2：数组排序
     *
     * 思路：
     *
     * 步骤：
     * 1：遍历链表，将节点值加入数组。
     * 2：使用内置的排序函数对数组进行排序。
     * 3：依次遍历数组和链表，按照位置将链表中的节点值修改为排序后的数组值。
     *
     * 时空复杂度：
     * 空间复杂度：O(n)，存储链表元素值的辅助数组长度n
     * 时间复杂度：O(nlog2n)，sort函数一般为优化后的快速排序，复杂度为O(nlog2n)
     */
    public ListNode sortInList2 (ListNode head) {
        //链表为空或者只有一个元素，直接就是有序的
        if (head == null || head.next == null) {
            return null;
        }
        List<Integer> nums = new ArrayList();
        ListNode p = head;
        //遍历链表，将节点值加入数组
        while(p != null){
            nums.add(p.val);
            p = p.next;
        }
        p = head;
        //对数组元素排序
        Collections.sort(nums);
        //遍历数组
        for(int i = 0; i < nums.size(); i++){
            //将数组元素依次加入链表
            p.val = nums.get(i);
            p = p.next;
        }
        return head;
    }
}
