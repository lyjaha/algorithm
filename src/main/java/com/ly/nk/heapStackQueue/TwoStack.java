package com.ly.nk.heapStackQueue;

import java.util.Stack;

/**
 *  BM42 用两个栈实现队列
 *
 *  描述：
 *  用两个栈来实现一个队列，使用n个元素来完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能。
 *  队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
 *
 *  数据范围： n ≤ 1000
 *  要求：存储n个元素的空间复杂度为 O(n) ，插入与删除的时间复杂度都是 O(1)
 *
 * 输入： ["PSH1","PSH2","POP","POP"]
 * 返回值：1,2
 * 说明：
 * "PSH1":代表将1插入队列尾部
 * "PSH2":代表将2插入队列尾部
 * "POP“:代表删除一个元素，先进先出=>返回1
 * "POP“:代表删除一个元素，先进先出=>返回2
 *
 *  ["PSH2","POP","PSH1","POP"]
 *  2,1
 *
 */
public class TwoStack {

    /**
     * 方法1：双栈法
     *
     * 知识点：
     * 栈：先进后出
     * 队列：先进先出
     *
     * 思路：
     * 元素进栈以后，只能优先弹出末尾元素，但是队列每次弹出的却是最先进去的元素，如果能够将栈中元素全部取出来，
     * 才能访问到最前面的元素，此时，可以用另一个栈来辅助取出。
     *
     * 步骤：
     *  1：push操作就正常push到第一个栈末尾。
     *  2：pop操作时，优先将第一个栈的元素弹出，并依次进入第二个栈中。
     *  3：第一个栈中最后取出的元素也就是最后进入第二个栈的元素就是队列首部元素，要弹出，此时在第二个栈中可以直接弹出。
     *  4：再将第二个中保存的内容，依次弹出，依次进入第一个栈中，这样第一个栈中虽然取出了最里面的元素，但是顺序并没有变。
     *
     * 时空复杂度：
     * 时间复杂度：push的时间复杂度为O(1)，pop的时间复杂度为O(n)，push是直接加到栈尾，相当于遍历了两次栈
     * 空间复杂度：O(n)，借助了另一个辅助栈空间
     *
     * @param node
     */
    // 入队栈
    private Stack<Integer> inStack;
    // 出队栈
    private Stack<Integer> outStack;

    public TwoStack() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // 入队操作，直接将元素压入入队栈
    public void push(int node) {
        inStack.push(node);
    }

    public int pop() {
        // 如果出队列栈为空，则将入队列栈中的元素全部倒入出队列栈中
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        // 将出队列栈顶元素弹出
        return outStack.pop();
    }

    public static void main(String[] args) {
        TwoStack queue = new TwoStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop()); // 输出1
        System.out.println(queue.pop()); // 输出2

        queue.push(4);

        System.out.println(queue.pop()); // 输出3
        System.out.println(queue.pop()); // 输出4
    }
}
