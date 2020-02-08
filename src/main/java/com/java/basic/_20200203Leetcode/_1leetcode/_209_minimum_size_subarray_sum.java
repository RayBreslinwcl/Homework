package com.java.basic._20200203Leetcode._1leetcode;

import java.util.MissingFormatArgumentException;

/**
 * Created by Administrator on 2020/2/8.
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

 示例: 
 输入: s = 7, nums = [2,3,1,2,4,3]
 输出: 2
 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

 进阶:
 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _209_minimum_size_subarray_sum {
    /**
     * 受到 76 题 Minimum Window Substring 的启示，找一个范围使得其值满足某个条件，然后就会想到滑动窗口，也就是用双指针的方法。和这道题本质是一样的。

     用双指针 left 和 right 表示一个窗口。
     1.right 向右移增大窗口，直到窗口内的数字和大于等于了 s。进行第 2 步。
     2.记录此时的长度，left 向右移动，开始减少长度，每减少一次，就更新最小长度。直到当前窗口内的数字和小于了 s，回到第 1 步。

     举个例子，模拟下滑动窗口的过程吧。
     作者：windliang
     链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-43/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int left=0;
        int right=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while (right<n){
            sum=sum+nums[right];
            right++;
            while (sum>=s){
                min= Math.min(min,right-left);
                sum-=nums[left];
                left++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;

    }
}
