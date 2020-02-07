package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/7.
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

 说明:

 返回的下标值（index1 和 index2）不是从零开始的。
 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

 示例:
 输入: numbers = [2, 7, 11, 15], target = 9
 输出: [1,2]
 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class _167_two_sum_ii_input_array_is_sorted {

    /**
     * 思路：
     - （1）如果 numbers[left] 与 numbers[right] 的和 tmp 小于 target ，说明应该增加 tmp ，因此 left 右移指向一个较大的值。
     - （2）如果 tmp大于 target ，说明应该减小 tmp ，因此 right 左移指向一个较小的值。
     - （3）tmp 等于 target ，则找到，返回 left + 1 和 right + 1。（注意以 1 为起始下标）

     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
//        int sum=0;
        int[] res=new int[2];
        while(left<target){
            int sum=numbers[left]+numbers[right];
            if(sum<target){
                left++;
            }else if(sum>target){
                right--;
            }else{//相等
                res[0]=left++;
                res[1]=right++;
                return res;
            }
        }
        return null;


    }
}
