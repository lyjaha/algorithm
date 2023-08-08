package com.ly.nk.list;

import java.util.HashMap;
import java.util.Map;

/**
 *  BM16 删除有序链表中重复的元素-II
 *
 *  描述：
 *  给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 *  例如：
 *  给出的链表为 1→2→3→3→4→4→5, 返回 1→2→5.
 *  给出的链表为 1→1→1→2→3, 返回 2→3.
 *
 *  数据范围：链表长度 0≤n≤10000，链表中任意节点的值满足 ∣val∣≤1000
 *
 *  要求：空间复杂度 O(n)，时间复杂度 O(n)
 *  进阶：空间复杂度 O(1)，时间复杂度 O(n)
 *
 *
 */
public class DeleteDuplicateList2 {

    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *  方法1：遍历比较删除
     *
     *  思路：
     *
     *  步骤：
     *  1：给链表前加上表头，方便可能删除第一个节点。
     *  2：遍历链表，每次比较相邻两个节点，如果遇到了两个相邻节点相同，则新开内循环将这一段所有的相同都遍历过去。
     *  3：在2中这一连串相同的节点前的节点直接连上后续第一个不相同值的节点。
     *  4：返回时去掉添加的表头。
     *
     *  时空复杂度：
     *  时间复杂度：O(n)，其中n为链表节点数，只有一次遍历
     *  空间复杂度：O(1)，只开辟了临时指针，常数级空间
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates (ListNode head) {
        //空链表
        if(head == null)
            return null;
        ListNode res = new ListNode(0);

        res.next = head;
        ListNode cur = res;

        while (cur.next != null && cur.next.next != null) {
            //遇到相邻两个节点值相同
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                //将所有相同的都跳过
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        //返回时去掉表头
        return res.next;
    }

    /**
     *  方法2：哈希表
     *
     *  思路：
     *
     *  步骤：
     *  1：遍历一次链表用哈希表记录每个节点值出现的次数。
     *  2：在链表前加一个节点值为0的表头，方便可能的话删除表头元素。
     *  3：再次遍历该链表，对于每个节点值检查哈希表中的计数，只留下计数为1的，其他情况都删除。
     *  4：返回时去掉增加的表头。
     *
     *  时空复杂度：
     *  时间复杂度：O(n)，其中n为链表节点数，一共遍历两次，哈希表每次计数、每次查询都是O(1)
     *  空间复杂度：O(n)，最坏情况下 n 个节点都不相同，哈希表长度为 n
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2 (ListNode head) {

        //空链表
        if(head == null)
            return null;

        Map<Integer,Integer> mp = new HashMap<>();
        ListNode cur = head;
        //遍历链表统计每个节点值出现的次数
        while(cur != null){
            if (mp.containsKey(cur.val)) {
                mp.put(cur.val, mp.get(cur.val) + 1);
            } else {
                mp.put(cur.val,1);
            }
            cur = cur.next;
        }
        ListNode res = new ListNode(0);
        //在链表前加一个表头
        res.next = head;
        cur = res;
        //再次遍历链表
        while (cur.next != null) {
            //如果节点值计数不为1
            if (mp.get(cur.next.val) != 1) {
                //删去该节点
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return res.next;
    }

}
