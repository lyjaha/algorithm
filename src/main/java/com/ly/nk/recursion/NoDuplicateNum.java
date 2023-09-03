package com.ly.nk.recursion;

import java.util.ArrayList;

/**
 *  BM55 没有重复项数字的全排列
 *
 *  描述：
 *  给出一组数字，返回该组数字的所有排列
 *
 * 例如：
 * [1,2,3]的所有排列如下
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
 * （以数字在数组中的位置靠前为优先级，按字典序排列输出。）
 *
 * 数据范围：数字个数 0<n≤6
 * 要求：空间复杂度 O(n!) ，时间复杂度  O(n!）
 *
 * [1,2,3]
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * [1]
 * [[1]]
 *
 */
public class NoDuplicateNum {

    /**
     * 方法1：递归+回溯
     *
     * 知识点：递归与回溯
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     * 时间复杂度：O(N!)，其中N为数组长度。因为排列的数量为N!，每个排列平均需要O(N)的时间复杂度。
     * 空间复杂度：O(N)，存储结果所需的空间为O(N)。递归调用栈的深度为O(N)。
     *
     *
     * @param nums int整型一维数组
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> permute (int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // 记录数字是否已被使用
        boolean[] used = new boolean[nums.length];
        // 使用回溯法生成排列
        backtrack(nums, new ArrayList<>(), used, res);

        return res;

    }


    private void backtrack(int[] nums, ArrayList<Integer> permutation, boolean[] used, ArrayList<ArrayList<Integer>> res) {
        // 当排列长度等于数组长度时，将该排列加入结果
        if (permutation.size() == nums.length){
            res.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果数字已被使用，跳过
            if (used[i]) {
                continue;
            }
            // 标记数字为已使用
            used[i] = true;
            // 将数字添加到当前排列
            permutation.add(nums[i]);
            // 递归调用，添加下一个数字
            backtrack(nums, permutation, used, res);
            // 重置数字为未使用
            used[i] = false;
            // 从当前排列中移除该数字
            permutation.remove(permutation.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        NoDuplicateNum permutations = new NoDuplicateNum();
        ArrayList<ArrayList<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }
}
