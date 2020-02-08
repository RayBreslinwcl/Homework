package com.java.basic._20200203Leetcode._1leetcode;

/**
 * Created by Administrator on 2020/2/8.
 */
public class _283_move_zeroes {
    /**
     * idea1
     将左右的非零元素向前移动，最后把所有的零元素放到末尾。
     https://leetcode-cn.com/problems/move-zeroes/solution/movezero-0msnei-cun-xiao-hao-zui-shao-362m-by-java/
     * @param nums
     */
    public void moveZeroes(int[] nums) {
//        int start=0,end=nums.length-1;
//        int zeroNum=0;
//
//        for (start=0;start<end;start++){
//            if(nums[start]==0){
//
//                nums[start]=nums[start+1];
//                zeroNum++;
//                start++;
//            }
////            start++;
//        }
//        for (int i =0;i<zeroNum;i++){
//            nums[nums.length-1-i]=0;
//        }
//
////        while (start<end){
////
////        }
        //以计数非0元素的个数
        int nonZeroCount=0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]!=0){
                nums[nonZeroCount++]=nums[i];
            }
        }
        while (nonZeroCount<nums.length){
            nums[nonZeroCount++]=0;
        }

    }
}
