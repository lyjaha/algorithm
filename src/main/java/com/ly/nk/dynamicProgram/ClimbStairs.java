package com.ly.nk.dynamicProgram;

import java.util.Arrays;

/**
 *  BM63 跳台阶
 *
 *  描述：
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 *  数据范围：1≤n≤40
 *  要求：时间复杂度：O(n) ，空间复杂度： O(1)
 *
 *  输入：2
 *  返回值：2
 *  说明：青蛙要跳上两级台阶有两种跳法，分别是：先跳一级，再跳一级或者直接跳两级。因此答案为2
 *
 *  输入：7
 *  返回值：21
 *  说明：青蛙要跳上两级台阶有两种跳法，分别是：先跳一级，再跳一级或者直接跳两级。因此答案为21
 *
 */
public class ClimbStairs {


    /**
     * 方法1：迭代相加
     *
     * 知识点：动态规划
     *  动态规划算法的基本思想是：将待求解的问题分解成若干个相互联系的子问题，先求解子问题，然后从这些子问题的解得到原问题的解；
     *  对于重复出现的子问题，只在第一次遇到的时候对它进行求解，并把答案保存起来，让以后再次遇到时直接引用答案，不必重新求解。
     *  动态规划算法将问题的解决方案视为一系列决策的结果。本解法属于动态规划空间优化方法
     *
     * 思路：它可以选择跳1阶到 n−1，也可以选择跳2阶到 n−2，f(n) = f(n−1)+f(n−2)，这就变成了斐波那契数列。
     *
     * 步骤：
     *  1：低于2项的数列，直接返回n。
     *  2：初始化第0项，与第1项分别为0，1.
     *  3：从第2项开始，逐渐按照公式累加，并更新相加数始终为下一项的前两项。
     *
     * 时空复杂度：
     *
     * 时间复杂度：O(n)，其中 n为输入的数
     * 空间复杂度：O(1)，常数级变量，没有其他额外辅助空间
     *
     *
     * @param target int整型
     * @return int整型
     */
    public static int jumpFloor (int target) {

        // 状态转移方程的基础情况
        // 当台阶数小于等于2时，直接返回对应值
        if (target <= 2){
            return target;
        }
        // 初始化三个量，pre1和pre2分别代表f(n-1)和f(n-2)，cur表示f(n)
        int pre1 = 1, pre2 = 2, cur = 0;

        for (int i = 3; i <= target; i++) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }

    /**
     * 方法2：递归
     *
     * 知识点：递归
     * 递归是一个过程或函数在其定义或说明中有直接或间接调用自身的一种方法，它通常把一个大型复杂的问题层层转化为一个
     * 与原问题相似的规模较小的问题来求解。因此递归过程，最重要的就是查看能不能将原本的问题分解为更小的子问题，
     * 这是使用递归的关键。
     *
     * 思路：它可以选择跳1阶到 n−1，也可以选择跳2阶到 n−2，f(n) = f(n−1)+f(n−2)，这就变成了斐波那契数列。
     * 终止条件：当递归到数列第0项或是第1项的时候，可以直接返回数字。
     * 返回值： 返回这一级子问题的数列值。
     * 本级任务：获取本级数列值：即前两项相加。
     *
     * 步骤：
     * step 1：低于2项的数列，直接返回目标值。
     * step 2：对于当前n，递归调用函数计算两个子问题相加。
     *
     * 时空复杂度：
     * 时间复杂度：O(2的n次方)，每个递归会调用两个递归，因此呈现2的指数增长
     * 空间复杂度：O(n), 栈空间最大深度为 n
     *
     * 递归方式虽然简单，但在处理大的输入时可能会致性能问题，具体情况根据实际需求来选择使用动态规划还是递归。，
     *
     *
     * @param target
     * @return
     */
    public static int jumpFloor2 (int target) {

        // 递归终止条件
        if (target <= 2){
            return target;
        }

        // 递归求解子问题，并将结果相加
        return jumpFloor2(target - 1) + jumpFloor2(target - 2);

    }

    /**
     *  递归优化
     *  在递归过程中，会计算一些重复的子问题，为了避免这类重复计算，我们使用备忘录法进行优化。
     *  备忘录法的核心思想是，在每次递归时，先在备忘录中查找当前阶数的值是否已经被计算过，如果有直接返回，
     *  否则继续计算存入备忘录中。
     *
     *  时空复杂度：
     *  时间复杂度：每个数字只算了一次，故为O(n)
     *  空间复杂度：O(n)，栈空间最大深度
     *
     * @param target
     * @return
     */
    private static int[] memo;
    public static int jumpFloor3 (int target) {
        // 初始化备忘录，全部设为-1
        memo = new int[target + 1];
        Arrays.fill(memo, -1);

        return helper(target);

    }

    public static int helper(int n) {
        // 在备忘录中查找当前阶数是否被计算过
        if(memo[n] != -1) {
            return memo[n];
        }
        // 终止条件
        if(n <= 2) {
            return n;
        }
        // 递归操作，记录子问题结果到备忘录中
        return memo[n] = helper(n-1) + helper(n-2);
    }

    /**
     *  动态规划优化
     *
     *
     *  时空复杂度：
     *  时间复杂度：O(n)，遍历了一次长度为n的数组
     *  空间复杂度：O(n)，建立了一个数组辅助
     *
     * @param target
     * @return
     */
    public static int jumpFloor4 (int target) {
        if (target <= 1)
            return 1;

        int[] dp = new int[target + 1];
        //
        dp[0] = 1;
        dp[1] = 1;
        //
        for (int i = 2; i < target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }



    public static void main(String[] args) {
        int n = 6;
        System.out.println(jumpFloor(n)); // 输出：13

        int n2 = 7;
        System.out.println(jumpFloor2(n2)); // 输出：21

        int n3 = 7;
        System.out.println(jumpFloor3(n3)); // 输出：21

        int n4 = 7;
        System.out.println(jumpFloor3(n4)); // 输出：21
    }


}
