package com.ly.nk.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  BM13 判断一个链表是否为回文结构
 *
 *  描述：
 *  给定一个链表，请判断该链表是否为回文结构。
 *  回文是指该字符串正序逆序完全一致。
 *  数据范围： 链表节点数 0 ≤ n ≤10的5次方，链表中每个节点的值满足∣val∣≤10的7次方
 *
 *  示例：
 *  输入：{1}
 *  返回值：true
 *
 *  输入：{2,1}
 *  返回值：false
 *
 *  输入：{1,2,2,1}
 *  返回值：true
 *
 */
public class ListIsPail {

    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：数组复制反转法
     *
     * 思路：
     *
     * 步骤：
     * 1：遍历一次链表，将元素取出放入辅助数组中。
     * 2：准备另一个辅助数组，录入第一个数组的全部元素，再将其反转。
     * 3：依次遍历原数组与反转后的数组，若是元素都相等则是回文结构，只要遇到一个不同的就不是回文结构。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为链表的长度，遍历链表转化数组为O(n)，反转数组为O(n)，后续遍历两个数组为O(n)
     * 空间复杂度：O(n)，记录链表元素的辅助数组，及记录反转后数组
     *
     * @param head
     * @return
     */
    public boolean isPail (ListNode head) {

        if (head == null) {
            return true;
        }
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        List<Integer> temp = (List<Integer>) ((ArrayList<Integer>) nums).clone();

        //准备一个数组承接翻转之后的数组
        Collections.reverse(temp);

        for (int i = 0; i < nums.size(); i++) {
            int x = nums.get(i);
            int y = temp.get(i);
            //正向遍历与反向遍历相同
            if(x != y) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法2：数组复制双指针
     *
     * 思路：
     *
     * 步骤：
     * 1：遍历一次链表，将元素取出放入辅助数组中。
     * 2：使用下标访问，两个下标代表两个指针，两个指针分别从数组首尾开始遍历，左指针指向开头，从左到右，右指针指向数组末尾，
     * 从右到左，依次比较元素是否相同。
     * 3：如果有不一样，则不是回文结构。否则遍历到两个指针相遇就好了，因为左指针到了右半部分都是右指针走过的路，
     * 比较的值也是与之前相同的。
     *
     * 时空复杂度：
     * 时间复杂度：O(n)，其中n为链表的长度，遍历链表转化数组为O(n)，双指针遍历半个数组为O(n)
     * 空间复杂度：O(n)，记录链表元素的辅助数组
     *
     * @param head
     * @return
     */
    public boolean isPail2 (ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        //双指针指向首尾
        int left = 0;
        int right = nums.size() - 1;
        //分别从首尾遍历，代表正序和逆序
        while (left <= right) {
            int x = nums.get(left);
            int y = nums.get(right);
            //如果不一致就是不为回文
            if (x != y) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 方法3：长度法找中点
     *
     * 思路：
     *
     * 步骤：
     *
     *
     *
     * @param head
     * @return
     */
    public boolean isPail3 (ListNode head) {

        //TODO
        return true;
    }




}
