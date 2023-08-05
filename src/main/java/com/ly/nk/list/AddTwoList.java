package com.ly.nk.list;

/**
 * BM11 链表相加(二)
 *
 * 描述
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 *
 * 数据范围：0 ≤n,m ≤ 1000000，链表任意值 0 ≤ val ≤ 9
 *
 * 要求：空间复杂度 O(n)，时间复杂度 O(n)
 *
 * 示例
 * 输入：[9,3,7],[6,3]
 * 返回值：{1,0,0,0}
 *
 */
public class AddTwoList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }


    /**
     *  方法1：反转链表法
     *
     *  思路：
     *
     *  步骤：
     *  1：任意一个链表为空，返回另一个链表就行了，因为链表为空相当于0，0加任何数为0，包括另一个加数为0的情况。
     *  2：相继反转两个待相加的链表，反转过程可以参考反转链表。
     *  3：设置返回链表的链表头，设置进位carry=0.
     *  4：从头开始遍历两个链表，直到两个链表节点都为空且carry也不为1. 每次取出不为空的链表节点值，为空就设置为0，
     *  将两个数字与carry相加，然后查看是否进位，将进位后的结果（对10取模）加入新的链表节点，连接在返回链表后面，并继续往后遍历。
     *  5：返回前将结果链表再反转回来。
     *
     * 时空复杂度
     * 时间复杂度：O(max(m,n))，其中m与n分别为两个链表的长度，翻转链表三次，复杂度分别是O(n)、O(m)、O(max(m,n))，
     * 相加过程也是遍历较长的链表
     * 空间复杂度：O(1)，常数级指针，没有额外辅助空间，返回的新链表属于必要空间
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode addList (ListNode head1, ListNode head2) {
        //任意一个链表为空，返回另一个
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        //反转两个链表
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        //添加表头
        ListNode res = new ListNode(-1);
        ListNode head = res;
        //进位符号
        int carry = 0;
        //只要某个链表还有或者进位还有
        while (head1 != null || head2 != null || carry != 0) {
            //链表不为空则取其值
            int value1 = head1 == null ? 0 : head1.val;
            int value2 = head2 == null ? 0 : head2.val;
            //相加
            int temp = value1 + value2 + carry;
            //获取进位
            carry = temp / 10;
            temp %= 10;
            //添加元素
            head.next = new ListNode(temp);
            head = head.next;
            //移动下一个
            if(head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        return reverseList(res.next);
    }

    /**
     *  反转链表
     * @param pHead
     * @return
     */
    private ListNode reverseList (ListNode pHead) {
        if (pHead == null){
            return null;
        }
        ListNode cur = pHead;
        ListNode pre = null;
        while (cur != null) {
            //断开链表，要记录后续一个
            ListNode temp = cur.next;
            //当前的next指向前一个
            cur.next = pre;
            //前一个更新为当前
            pre = cur;
            //当前更新为刚刚记录的后一个
            cur = temp;
        }
        return pre;
    }
}
