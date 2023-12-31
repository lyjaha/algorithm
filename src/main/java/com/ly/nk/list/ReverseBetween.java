package com.ly.nk.list;

/**
 * BM2.链表内指定区间反转
 *
 * 描述：
 * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。
 *
 * 例如：
 * 给出的链表为 1 → 2 → 3 → 4 → 5 → NULL, m=2,n=4,
 * 返回 1 → 4 → 3 → 2 → 5 → NULL.
 *
 * 数据范围：
 * 链表长度 0 < size ≤ 1000，0 < m ≤ n ≤ size，链表中每个节点的值满足 ∣val∣ ≤ 1000
 *
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

    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：头插法迭代
     *
     * 思路：
     *
     *
     * 步骤：
     *  1：在链表前加一个表头，后续返回时去掉，因为如果要从链表头的位置开始反转，在多了一个表头的情况下就能保证第一个节点
     * 永远不会反转，不会到后面去。
     *  2：使用两个指针，一个指向当前节点，一个指向前序节点。
     *  3：依次遍历链表，到第m个的位置。
     *  4：对于从m到n这些个位置的节点，依次断掉指向后续的指针，反转指针方向。
     *  5：返回时去掉添加的表头。
     *
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，最坏情况下需要遍历全部链表节点，比如m为链表最后一个位置，或者n为链表最后一个位置时
     * 空间复杂度：O(1)，常数级指针变量，无额外辅助空间使用
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */

    public static ListNode reverseBetween (ListNode head, int m, int n) {

        // 空表头 （用于在链表的头部添加元素时作为哨兵节点（sentinel））
        ListNode res = new ListNode(-1);
        res.next = head;

        // 指向哨兵节点(前驱节点)
        ListNode pre = res;
        // 指向头节点
        ListNode cur = head;

        // 找到m
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        // 从m反转到n
        for (int i = m; i < n; i++) {
            // 创建一个指针，指向当前节点的下一个节点。
            ListNode temp = cur.next;
            // 将当前节点 cur 的 next 指针指向 temp 的下一个节点。
            cur.next = temp.next;
            // 将 temp 的 next 指针指向 pre 的下一个节点。
            temp.next = pre.next;
            // 将 pre 的 next 指针指向 temp。
            pre.next = temp;
        }
        //返回哨兵节点的下一个节点，跳过哨兵节点，即为反转后的链表。
        return res.next;
    }

    /**
     * 方法2：递归
     *
     * 思路：
     *
     *
     * 步骤：
     * 1：准备全局变量temp，最初等于null，找到递归到第n个节点时，指向其后一个位置，要将反转部分的起点
     * （即反转后的尾）连接到这个指针。
     * 2：按照第一个递归的思路缩短子问题找到反转区间的起点，将反转后的部分拼接到前面正常的后面。
     * 3：按照第二个递归的思路缩短终点的子问题，从第n个位置开始反转，反转过程中每个子问题作为反转后的尾，都要指向temp。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，最坏情况下递归遍历全部链表节点，比如m为链表最后一个位置，或者n为链表最后一个位置时
     * 空间复杂度：O(n)，遍历全部节点时递归栈深度最坏为n
     *
     */
    ListNode temp = null;
    public ListNode reverse(ListNode head, int n){
        //只颠倒第一个节点，后续不管
        if(n == 1){
            temp = head.next;
            return head;
        }
        //进入子问题
        ListNode node = reverse(head.next, n - 1);
        //反转
        head.next.next = head;
        //每个子问题反转后的尾拼接第n个位置后的节点
        head.next = temp;
        return node;
    }
    public ListNode reverseBetween2 (ListNode head, int m, int n) {
        //从第一个节点开始
        if(m == 1)
            return reverse(head, n);
        //缩减子问题
        ListNode node = reverseBetween2(head.next, m - 1, n - 1);
        //拼接已翻转
        head.next = node;
        return head;
    }


    public static void main(String[] args) {
        // 创建测试链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        //转链表区间
        ListNode reversedHead = reverseBetween(head, 2, 4);

        // 打印反转后的链表
        ListNode node = reversedHead;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
