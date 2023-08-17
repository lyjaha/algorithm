package com.ly.nk.heapStackQueue;

import java.util.Stack;

/**
 *  BM43 包含min函数的栈
 *
 *  描述：
 *  定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，输入操作时保证 pop、top 和 min 函数操作时，
 *  栈中一定有元素。
 *
 * 此栈包含的方法有：
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 *
 * 数据范围：操作数量满足 0 ≤ n ≤ 300  ，输入的元素满足 ∣val∣ ≤ 10000
 * 进阶：栈的各个操作的时间复杂度是 O(1)  ，空间复杂度是 O(n)
 *
 * 输入: ["PSH-1","PSH2","MIN","TOP","POP","PSH1","TOP","MIN"]
 * 输出: -1,2,1,-1
 * 解析:
 * "PSH-1"表示将-1压入栈中，栈中元素为-1
 * "PSH2"表示将2压入栈中，栈中元素为2，-1
 * “MIN”表示获取此时栈中最小元素==>返回-1
 * "TOP"表示获取栈顶元素==>返回2
 * "POP"表示弹出栈顶元素，弹出2，栈中元素为-1
 * "PSH1"表示将1压入栈中，栈中元素为1，-1
 * "TOP"表示获取栈顶元素==>返回1
 * “MIN”表示获取此时栈中最小元素==>返回-1
 * 
 */
public class IncludeMin {

    // 用于栈的push 与 pop
    private Stack<Integer> stack;
    // 用于存储最小min
    private Stack<Integer> minStack;

    public IncludeMin() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }


    public void push(int node) {
        // 入栈
        stack.push(node);

        if (minStack.isEmpty() || minStack.peek() > node) {
            // 如果辅助栈为空或当前值小于等于辅助栈栈顶，则将其压入辅助栈中
            minStack.push(node);
        }else {
            // 否则将辅助栈栈顶元素再次压入辅助栈中
            minStack.push(minStack.peek());
        }

    }

    public void pop() {
        if (!stack.isEmpty() && !minStack.isEmpty()) {
            stack.pop(); // 出栈
            minStack.pop();
        }
    }

    public int top() {
        // 获取栈顶元素
        return stack.peek();
    }

    public int getMin() {
        // 获取最小值
        return minStack.peek();
    }

    public static void main(String[] args) {
        IncludeMin stack = new IncludeMin();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.getMin()); // 应该输出1
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin()); // 应该输出3
    }
}
