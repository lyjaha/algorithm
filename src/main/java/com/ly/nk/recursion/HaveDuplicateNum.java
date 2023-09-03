package com.ly.nk.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  BM56 有重复项数字的全排列
 *
 *  描述：
 *  给出一组可能包含重复项的数字，返回该组数字的所有排列。结果以字典序升序排列。
 *
 * 数据范围：0<n≤8 ，数组中的值满足 −1≤val≤5
 * 要求：空间复杂度 O(n!)，时间复杂度 O(n!)
 *
 *  [1,1,2]
 *  [[1,1,2],[1,2,1],[2,1,1]]
 *
 *  [0,1]
 *  [[0,1],[1,0]]
 *
 *
 */
public class HaveDuplicateNum {

    /**
     * 方法1：递归与回溯
     *
     * 知识点：
     *
     * 思路：
     *
     * 步骤：
     *
     * 时空复杂度：
     *
     *
     * @param nums int整型一维数组
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> permuteUnique (int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // 记录数字是否已被使用
        boolean[] used = new boolean[nums.length];
        // 排序，方便后续剪枝
        Arrays.sort(nums);
        // 使用回溯法生成排列
        backtrack(nums, new ArrayList<>(), used, res);

        return res;
    }

    private void backtrack(int[] nums, ArrayList<Integer> permutation, boolean[] used, ArrayList<ArrayList<Integer>> res) {

        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝：如果该数字与前一个数字相同且前一个数字已使用，则跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            permutation.add(nums[i]);
            used[i] = true;
            backtrack(nums, permutation, used, res);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        HaveDuplicateNum test = new HaveDuplicateNum();
        int[] nums = {1,1,2}; // 测试用例
        System.out.println(test.permuteUnique(nums).toString());
    }
}
