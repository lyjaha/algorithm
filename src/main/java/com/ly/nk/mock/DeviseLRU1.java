package com.ly.nk.mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  BM100 设计LRU缓存结构
 *
 *  描述：
 *  设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为 capacity ，操作次数是 n ，并有如下功能:
 *  1. Solution(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 *  2. get(key)：如果关键字 key 存在于缓存中，则返回key对应的value值，否则返回 -1 。
 *  3. set(key, value)：将记录(key, value)插入该结构，如果关键字 key 已经存在，则变更其数据值 value，
 *  如果不存在，则向缓存中插入该组 key-value ，如果key-value的数量超过capacity，弹出最久未使用的key-value
 *
 * 提示:
 *  1.某个key的set或get操作一旦发生，则认为这个key的记录成了最常使用的，然后都会刷新缓存。
 *  2.当缓存的大小超过capacity时，移除最不经常使用的记录。
 *  3.返回的value都以字符串形式表达，如果是set，则会输出"null"来表示(不需要用户返回，系统会自动输出)，方便观察
 *  4.函数set和get必须以O(1)的方式运行
 *  5.为了方便区分缓存里key与value，下面说明的缓存里key用""号包裹
 *
 *  ["set","set","get","set","get","set","get","get","get"],
 *  [[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]],2
 *
 *  ["null","null","1","null","-1","null","-1","3","4"]
 *
 *  我们将缓存看成一个队列，最后一个参数为2代表capacity，所以
 *  Solution s = new Solution(2);
 *  s.set(1,1); //将(1,1)插入缓存，缓存是{"1"=1}，set操作返回"null"
 *  s.set(2,2); //将(2,2)插入缓存，缓存是{"2"=2，"1"=1}，set操作返回"null"
 *  output=s.get(1);// 因为get(1)操作，缓存更新，缓存是{"1"=1，"2"=2}，get操作返回"1"
 *  s.set(3,3); //将(3,3)插入缓存，缓存容量是2，故去掉某尾的key-value，缓存是{"3"=3，"1"=1}，set操作返回"null"
 *  output=s.get(2);// 因为get(2)操作，不存在对应的key，故get操作返回"-1"
 *  s.set(4,4); //将(4,4)插入缓存，缓存容量是2，故去掉某尾的key-value，缓存是{"4"=4，"3"=3}，set操作返回"null"
 *  output=s.get(1);// 因为get(1)操作，不存在对应的key，故get操作返回"-1"
 *  output=s.get(3);//因为get(3)操作，缓存更新，缓存是{"3"=3，"4"=4}，get操作返回"3"
 *  output=s.get(4);//因为get(4)操作，缓存更新，缓存是{"4"=4，"3"=3}，get操作返回"4"
 *
 *
 */
public class DeviseLRU1 {

    //设置双向链表结构
    static class Node{
        int key;
        int val;
        Node pre;
        Node next;
        //初始化
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    private Map<Integer, Node> mp = new HashMap<>();

    private Node head = new Node(-1, -1);

    private Node tail = new Node(-1, -1);

    private int size = 0;

    public int[] LRU (int[][] operators, int k) {
        //构建初始化连接
        //链表剩余大小
        this.size = k;
        this.head.next = this.tail;
        this.tail.pre = this.head;
        //获取操作数
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        //遍历所有操作
        for(int i = 0, j = 0; i < operators.length; i++){
            if(operators[i][0] == 1)
                //set操作
                set(operators[i][1], operators[i][2]);
            else
                //get操作
                res[j++] = get(operators[i][1]);
        }
        return res;
    }
    /**
     * 方法1：哈希表+双向链表
     *
     * 知识点：哈希表
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     * @param capacity
     */

    public DeviseLRU1(int capacity) {
        // write code here
    }

    public int get(int key) {
        int res = -1;
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            res = node.val;
            moveToHead(node);
        }
        return res;
    }

    //移到表头函数
    private void moveToHead(Node node){
        //已经到了表头
        if(node.pre == head)
            return;
        //将节点断开，取出来
        node.pre.next = node.next;
        node.next.pre = node.pre;
        //插入第一个前面
        insertFirst(node);
    }
    //将节点插入表头函数
    private void insertFirst(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    //删去表尾函数，最近最少使用
    private void removeLast(){
        //哈希表去掉key
        mp.remove(tail.pre.key);
        //断连该节点
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
    }

    public void set(int key, int val) {
        //没有见过这个key，新值加入
        if(!mp.containsKey(key)){
            Node node = new Node(key, val);
            mp.put(key, node);
            //超出大小，移除最后一个
            if(size <= 0)
                removeLast();
                //大小还有剩余
            else
                //大小减1
                size--;
            //加到链表头
            insertFirst(node);
        }
        //哈希表中已经有了，即链表里也已经有了
        else{
            mp.get(key).val = val;
            //访问过后，移到表头
            moveToHead(mp.get(key));
        }
    }
}
