package com.java.basic._20200203Leetcode._1leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2020/2/3.
 * 【三数之和】
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 示例：
 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/3sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _15_3_sum {
    /**
     * 思路
、
     1.首先对数组进行排序，排序后固定一个数 nums[i]，
     2.再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，
     计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集

     (1)如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
     (2)如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     (3)当 sum = 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
     (4)当 sum == 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
     时间复杂度：O(n^2)


     作者：guanpengchn
     链接：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        int len=nums.length;
        //1.前提
        if(nums==null||len<3){
            return res;//返回空
        }

        //2.排序
        Arrays.sort(nums);
        //3.迭代
        for (int i=0;i<len;i++){

            if(nums[i]>0) break;
            if(i>0&&nums[i]==nums[i-1]) continue;//去重
            int L=i+1;
            int R=len-1;
            //当L小于R时
            while (L<R){

                int sum=nums[i]+nums[L]+nums[R];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //去重
                    //限制L<R，是因为有可能在L++过程中可能出现L>=R的情况
                    while (L<R && nums[L]==nums[L+1]){
                        L++;
                    }
                    while (L<R && nums[R]==nums[R-1]){
                        R--;
                    }
                    //去完重后，因为L++会增大，所以肯定要R--，取更小的数取匹配，所以一起操作
                    L++;
                    R--;
                }else if(sum<0){//需要找更大的数
                    L++;
                }else if(sum>0){//需要找更小的数
                    R--;
                }
            }
        }

        return res;

    }
}
